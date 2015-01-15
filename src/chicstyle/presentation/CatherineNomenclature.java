package chicstyle.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.controle.ControlJComboBoxCatherineClient;
import chicstyle.controle.ControlJComboBoxClients;
import chicstyle.controle.ControlJComboBoxModeles;
import chicstyle.controle.ControlJComboBoxTissus;
import chicstyle.tableaux.TabNomenclature2;
import chicstyle.tableaux.TabNomenclature1;

public class CatherineNomenclature extends JFrame{

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private TabNomenclature2 modele = new TabNomenclature2(); //tableau
	private JTable tableau; //tableau
	private ChicEtStyle cets;
	
	
	    public CatherineNomenclature(Frame mere, ChicEtStyle cets, boolean creation) {
	        super();
	        this.cets=cets; //Victor
	        setTitle("Chic & Style");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
			this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
			this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
	        
	        Container conteneur = this.getContentPane();
			conteneur.setLayout(new BorderLayout());
			conteneur.add(creerHaut(), BorderLayout.NORTH);
			
			tableau = new JTable(modele); //tableau
	        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER); //tableau
	        JPanel boutons = new JPanel(); //tableau
	        JButton prec = new JButton("Précédent");
	        ControlJButtonNext precedent = new ControlJButtonNext(this, mere); //BOUTON
			prec.addActionListener(precedent); //BOUTON
			JButton validate = new JButton("Valider");
	        boutons.add(prec);
	        boutons.add(new JButton(new AddAction())); //tableau
	        boutons.add(new JButton(new RemoveAction())); //tableau
	        boutons.add(validate);
	        getContentPane().add(boutons, BorderLayout.SOUTH); //tableau
	    }
	    
		public JPanel creerHaut() { //Victor
			
			//DEF PANNEAUX
			JPanel panneauHaut = new JPanel();
			JPanel panneauHautDroite = new JPanel();
			JPanel panneauHautGauche = new JPanel();
			
			//DEF PANNEAU HAUT GAUCHE
			panneauHautGauche.setLayout(new BoxLayout(panneauHautGauche, BoxLayout.Y_AXIS));
			JLabel titre = new JLabel("Chic & Style");
			JLabel fonction = new JLabel("Nomenclature");
			titre.setFont(new Font(titre.getFont().getName(), Font.BOLD, LABEL_SIZE));
			fonction.setFont(new Font(fonction.getFont().getName(), Font.BOLD, LABEL_SIZE));
			panneauHautGauche.add(titre);
			panneauHautGauche.add(fonction);	
			
			//DEF PANNEAU HAUT DROITE - JCOMBOBOXS
			panneauHautDroite.setLayout(new BoxLayout(panneauHautDroite, BoxLayout.X_AXIS));
				//DEF JCOMBOBOXS
					//CLIENTS
			Vector<String> vecteurClients = cets.findAllClients();
			JComboBox<String> comboClients = new JComboBox<String>(vecteurClients);
			comboClients.setSelectedItem(cets.getPieceCourante().getModele());
			comboClients.setEditable(false);
			panneauHautDroite.add(comboClients);
					//MODELES
			Vector<String> vecteurModelesClient = cets.findAllModelesClient(cets.getPieceCourante().getClient());
			JComboBox<String> comboModelesClient = new JComboBox<String>(vecteurModelesClient);
			comboModelesClient.setSelectedItem(cets.getPieceCourante().getModele());
			comboModelesClient.setEditable(false);
			panneauHautDroite.add(comboModelesClient);
					//TISSUS
			Vector<String> vecteurTissusModele = cets.findAllModelesClient(cets.getPieceCourante().getClient());
			JComboBox<String> comboTissusModele = new JComboBox<String>(vecteurTissusModele);
			comboTissusModele.setSelectedItem(cets.getPieceCourante().getTissu());
			comboTissusModele.setEditable(false);
			panneauHautDroite.add(comboTissusModele);
					
			Vector<String> vecteurCouleurTissu = cets.findAllModelesClient(cets.getPieceCourante().getClient());
			JComboBox<String> comboCouleursTissu = new JComboBox<String>(vecteurCouleurTissu);
			comboCouleursTissu.setSelectedItem(cets.getPieceCourante().getCouleur());
			comboCouleursTissu.setEditable(false);
			panneauHautDroite.add(comboCouleursTissu);
			
				//CONTROLES
			comboClients.addActionListener(new ControlJComboBoxClients
					  (cets, comboModelesClient));
			comboModelesClient.addActionListener(new ControlJComboBoxModeles
					  (cets, comboTissusModele));
			comboTissusModele.addActionListener(new ControlJComboBoxTissus
					  (cets, comboCouleursTissu));
			
			
					
			panneauHaut.add(panneauHautGauche,BorderLayout.WEST);
			panneauHaut.add(panneauHautDroite,BorderLayout.CENTER);
			
			return panneauHaut;
		}

//POUR LES TABLEAUX
	    public static void main(String[] args) {
	    	ChicEtStyle cets = new ChicEtStyleJDBC();
	    	Principal principal = new Principal();
			MainWindow grandmere = new MainWindow(principal);
			CatherineAccueil mere = new CatherineAccueil(grandmere,cets, true);
	        new CatherineNomenclature(mere, cets, true).setVisible(true);
	    }
	 
	    private class AddAction extends AbstractAction {
	        private AddAction() {
	            super("Ajouter");
	        }
	 
	        public void actionPerformed(ActionEvent e) {
	            modele.addAmi(new TabNomenclature1("", "", "", false,false));
	        }
	    }
	 
	    private class RemoveAction extends AbstractAction {
	        private RemoveAction() {
	            super("Supprimmer");
	        }
	 
	        public void actionPerformed(ActionEvent e) {
	            int[] selection = tableau.getSelectedRows();
	 
	            for(int i = selection.length - 1; i >= 0; i--){
	                modele.removeAmi(selection[i]);
	            }
	        }
	    }
}
