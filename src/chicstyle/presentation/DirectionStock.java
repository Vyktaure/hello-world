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

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.tableaux.TabDirectionStock1;
import chicstyle.tableaux.TabDirectionStock2;


public class DirectionStock extends JFrame{

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private TabDirectionStock2 modele = new TabDirectionStock2(); //tableau
	private JTable tableau; //tableau

	public DirectionStock(Frame mere, ChicEtStyle cets, boolean creation) {
		super("Chic & Style");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		conteneur.add(creerHaut(), BorderLayout.NORTH);
		
		tableau = new JTable(modele); //tableau
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER); //tableau
        
        JPanel sudHaut = new JPanel();
        sudHaut.setLayout(new BoxLayout(sudHaut, BoxLayout.Y_AXIS));
        JButton ok = new JButton("OK Prod");
		sudHaut.add(ok);
		JPanel dateProd = new JPanel();
		JLabel dateP = new JLabel("Date de lancement de la production: ");
		JTextField date = new JTextField(15);
		dateProd.add(dateP);
		dateProd.add(date);
		sudHaut.add(dateProd);
		JButton valider = new JButton("Valider");
		sudHaut.add(valider);
        
        JPanel boutons = new JPanel(); //tableau
        JButton prec = new JButton("Accueil");
        ControlJButtonNext precedent = new ControlJButtonNext(this, mere); //BOUTON
		prec.addActionListener(precedent); //BOUTON
        boutons.add(prec);
//        boutons.add(new JButton(new AddAction())); //tableau
//        boutons.add(new JButton(new RemoveAction())); //tableau
        
        JPanel panneauBas = new JPanel();
        panneauBas.setLayout(new BoxLayout(panneauBas, BoxLayout.Y_AXIS));
        panneauBas.add(sudHaut);
        panneauBas.add(boutons);

        conteneur.add(panneauBas, BorderLayout.SOUTH);    
	}

	public JPanel creerHaut() {
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Chic & Style");
		JLabel fonction = new JLabel("Stocks");
		titre.setFont(new Font(titre.getFont().getName(), Font.BOLD, LABEL_SIZE));
		fonction.setFont(new Font(fonction.getFont().getName(), Font.BOLD, LABEL_SIZE));
		panneauHaut.add(titre);
		panneauHaut.add(fonction);
		
		JPanel nomClient = new JPanel();
		JLabel client = new JLabel("Client: ");
		String[] clients = {"", "Céline", "Balenciaga", "Louis Vuitton", "Agnès b."};
		JComboBox<String> comboClients=new JComboBox<String>(clients);
		comboClients.setEditable(false);
		nomClient.add(client);
		nomClient.add(comboClients);
		panneauHaut.add(nomClient);
		
		JPanel nomModele = new JPanel();
		JLabel modele = new JLabel("Modele: ");
		String[] modeles = {"-", "2M37", "67H21"};
		JComboBox<String> comboModeles=new JComboBox<String>(modeles);
		comboModeles.setEditable(false);
		nomModele.add(modele);
		nomModele.add(comboModeles);
		panneauHaut.add(nomModele);

		JPanel nomTissu = new JPanel();
		JLabel tissu = new JLabel("Tissu: ");
		String[] tissus = {"-", "6139", "4675"};
		JComboBox<String> comboTissus=new JComboBox<String>(tissus);
		comboTissus.setEditable(false);
		nomTissu.add(tissu);
		nomTissu.add(comboTissus);
		panneauHaut.add(nomTissu);
		
		return panneauHaut;	
	}
	
	//POUR LES TABLEAUX
    public static void main(String[] args) {
    	ChicEtStyle cets = new ChicEtStyleJDBC();
    	Principal modele = new Principal();
    	MainWindow grandmere = new MainWindow(modele);
		DirectionAccueil mere = new DirectionAccueil(grandmere, cets, true);
        new DirectionStock(mere, cets, true).setVisible(true);
    }
 
//    private class AddAction extends AbstractAction {
//        private AddAction() {
//            super("Ajouter");
//        }
// 
//        public void actionPerformed(ActionEvent e) {
//            modele.addAmi(new TabDirectionStock1("", "", "", "",""));
//        }
//    }
 
//    private class RemoveAction extends AbstractAction {
//        private RemoveAction() {
//            super("Supprimmer");
//        }
// 
//        public void actionPerformed(ActionEvent e) {
//            int[] selection = tableau.getSelectedRows();
// 
//            for(int i = selection.length - 1; i >= 0; i--){
//                modele.removeAmi(selection[i]);
//            }
//        }
//    }
}
