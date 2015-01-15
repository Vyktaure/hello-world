package chicstyle.presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.tableaux.TabBoite1;
import chicstyle.tableaux.TabBoite2;

public class VanessaRealisationBoite extends JFrame{

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private TabBoite2 modele = new TabBoite2(); //
	private JTable tableau; //

	public VanessaRealisationBoite(Frame mere, ChicEtStyle cets, boolean creation) {
		super("Chic & Style");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		conteneur.add(creerHaut(), BorderLayout.NORTH);

		tableau = new JTable(modele); //
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER); //
		JPanel boutons = new JPanel(); //
		JButton validate = new JButton("Valider");
		boutons.add(validate);
		boutons.add(new JButton(new AddAction())); //
		boutons.add(new JButton(new RemoveAction())); //
		JButton precedent = new JButton("Précédent");
		ControlJButtonNext prec = new ControlJButtonNext(this, mere); //BOUTON
		precedent.addActionListener(prec); //BOUTON
        boutons.add(precedent);
		getContentPane().add(boutons, BorderLayout.SOUTH); //
	}

	public JPanel creerHaut() {

		JPanel superieur = new JPanel();
		superieur.setLayout(new BoxLayout(superieur, BoxLayout.Y_AXIS));

		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Chic & Style");
		JLabel fonction = new JLabel("Réalisation Boîte");
		titre.setFont(new Font(titre.getFont().getName(), Font.BOLD, LABEL_SIZE));
		fonction.setFont(new Font(fonction.getFont().getName(), Font.BOLD, LABEL_SIZE));
		panneauHaut.add(titre);
		panneauHaut.add(fonction);
		superieur.add(panneauHaut);

		JPanel panneauCentre = new JPanel();
		panneauCentre.setLayout(new BoxLayout(panneauCentre, BoxLayout.Y_AXIS));
		//CLient
		JPanel nomClient = new JPanel();
		JLabel client = new JLabel("Client: ");
		String[] clients = {"", "Céline", "Balenciaga", "Louis Vuitton", "Agnès b.", "Nouveau client"};
		JComboBox<String> comboClients=new JComboBox<String>(clients);
		nomClient.add(client);
		nomClient.add(comboClients);
		//ModÃ¨le
		JPanel nomModele = new JPanel();
		JLabel modele = new JLabel("Modèle: ");
		String[] modelesProposes = {"", "T37", "M2O7"};
		JComboBox<String> comboModeles = new JComboBox<String>(modelesProposes);
		nomModele.add(modele);
		nomModele.add(comboModeles);
		//Tissu
		JPanel nomTissu = new JPanel();
		JLabel tissu = new JLabel("Tissu: ");
		String[] tissusProposes = {"", "456", "123"};
		JComboBox<String> comboTissus = new JComboBox<String>(tissusProposes);
		nomTissu.add(tissu);
		nomTissu.add(comboTissus);	
		//Date
		JPanel nomDate = new JPanel();
		JLabel date = new JLabel("Date début de production: ");
		JTextField textedate = new JTextField("Ici il faut aller chercher la date dans la BD"); // Ã©couteurs !
		textedate.setEditable(false);
		nomDate.add(date);
		nomDate.add(textedate);

		panneauCentre.add(nomClient);
		panneauCentre.add(nomModele);
		panneauCentre.add(nomTissu);
		panneauCentre.add(nomDate);
		superieur.add(panneauCentre);
		
		return superieur;
	}

	public JPanel creerCentre() {
		JPanel panneauCentre = new JPanel();
		panneauCentre.setLayout(new BoxLayout(panneauCentre, BoxLayout.Y_AXIS));
		//CLient
		JPanel nomClient = new JPanel();
		JLabel client = new JLabel("Client: ");
		String[] clients = {"", "Céline", "Balenciaga", "Louis Vuitton", "Agnès b.", "Nouveau client"};
		JComboBox<String> comboClients=new JComboBox<String>(clients);
		nomClient.add(client);
		nomClient.add(comboClients);
		//ModÃ¨le
		JPanel nomModele = new JPanel();
		JLabel modele = new JLabel("Modèle: ");
		String[] modelesProposes = {"", "T37", "M2O7"};
		JComboBox<String> comboModeles = new JComboBox<String>(modelesProposes);
		nomModele.add(modele);
		nomModele.add(comboModeles);
		//Tissu
		JPanel nomTissu = new JPanel();
		JLabel tissu = new JLabel("Tissu: ");
		String[] tissusProposes = {"", "456", "123"};
		JComboBox<String> comboTissus = new JComboBox<String>(tissusProposes);
		nomTissu.add(tissu);
		nomTissu.add(comboTissus);	
		//Date
		JPanel nomDate = new JPanel();
		JLabel date = new JLabel("Date début de production: ");
		JTextField textedate = new JTextField("Ici il faut aller chercher la date dans la BD"); // Ã©couteurs !
		textedate.setEditable(false);
		nomDate.add(date);
		nomDate.add(textedate);

		panneauCentre.add(nomClient);
		panneauCentre.add(nomModele);
		panneauCentre.add(nomTissu);
		panneauCentre.add(nomDate);
		return panneauCentre;
	}
	
	public static void main(String[] args) {
		ChicEtStyle cets = new ChicEtStyleJDBC();
		Principal principal = new Principal();
		MainWindow grandmere = new MainWindow(principal);
		VanessaAccueil mere = new VanessaAccueil(grandmere, cets, true);
		new VanessaRealisationBoite(mere, cets, true).setVisible(true);
	}
	
	  private class AddAction extends AbstractAction {
	        private AddAction() {
	            super("Ajouter");
	        }
	 
	        public void actionPerformed(ActionEvent e) {
	            modele.addAmi(new TabBoite1("", "", "", ""));
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
