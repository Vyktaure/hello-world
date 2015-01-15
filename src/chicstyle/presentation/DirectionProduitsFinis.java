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
import chicstyle.tableaux.TabDirectionProduitsFinis1;
import chicstyle.tableaux.TabDirectionProduitsFinis2;


public class DirectionProduitsFinis extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private TabDirectionProduitsFinis2 modele = new TabDirectionProduitsFinis2(); //tableau
	private JTable tableau; //tableau
	
	public DirectionProduitsFinis(Frame mere, ChicEtStyle cets, boolean creation) {
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
        
        JPanel boutons = new JPanel(); //tableau
        JButton prec = new JButton("Accueil");
        ControlJButtonNext precedent = new ControlJButtonNext(this, mere); //BOUTON
		prec.addActionListener(precedent); //BOUTON
        boutons.add(prec);
        getContentPane().add(boutons, BorderLayout.SOUTH); //tableau
	} 
	
	public JPanel creerHaut() {
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Chic & Style");
		JLabel fonction = new JLabel("Produits Finis");
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
		
		JPanel nomCouleur = new JPanel();
		JLabel couleur = new JLabel("Couleur: ");
		String[] couleurs = {"-", "bleu", "rouge"};
		JComboBox<String> comboCouleurs=new JComboBox<String>(couleurs);
		comboCouleurs.setEditable(false);
		nomCouleur.add(couleur);
		nomCouleur.add(comboCouleurs);
		panneauHaut.add(nomCouleur);
		
		return panneauHaut;	
	}
	
	//POUR LES TABLEAUX
    public static void main(String[] args) {
    	ChicEtStyle cets = new ChicEtStyleJDBC();
    	Principal principal = new Principal();
    	MainWindow grandmere = new MainWindow(principal);
		DirectionAccueil mere = new DirectionAccueil(grandmere, cets, true);
        new DirectionProduitsFinis(mere, cets, true).setVisible(true);
    }
}
