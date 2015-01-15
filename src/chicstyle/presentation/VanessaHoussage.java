package chicstyle.presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

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
import chicstyle.tableaux.TabDirectionProduitsFinis2;
import chicstyle.tableaux.TabVanessaHoussage2;

public class VanessaHoussage extends JFrame{
	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private TabVanessaHoussage2 modele = new TabVanessaHoussage2(); //tableau
	private JTable tableau; //tableau
	
	public VanessaHoussage(Frame mere, ChicEtStyle cets, boolean creation) {
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
        JButton validate = new JButton("Valider");
        boutons.add(validate);
        
        JButton precedent = new JButton("Précédent");
        ControlJButtonNext prec = new ControlJButtonNext(this, mere); //BOUTON
		precedent.addActionListener(prec); //BOUTON
		boutons.add(precedent);
        
        getContentPane().add(boutons, BorderLayout.SOUTH); //tableau
	}
	
	public JPanel creerHaut() {
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Chic & Style");
		JLabel fonction = new JLabel("Houssage");
		titre.setFont(new Font(titre.getFont().getName(), Font.BOLD, LABEL_SIZE));
		fonction.setFont(new Font(fonction.getFont().getName(), Font.BOLD, LABEL_SIZE));
		panneauHaut.add(titre);
		panneauHaut.add(fonction);
		
		JPanel nomClient = new JPanel();
		JLabel client = new JLabel("Client: ");
		String[] clients = {"", "Céline", "Balenciaga", "Louis Vuitton", "Agniès b.", "Nouveau client"};
		JComboBox<String> comboClients=new JComboBox<String>(clients);
		nomClient.add(client);
		nomClient.add(comboClients);
		
		JPanel nomModele = new JPanel();
		JLabel modele = new JLabel("Modèle: ");
		String[] modelesProposes = {"", "T37", "M2O7"};
		JComboBox<String> comboModeles = new JComboBox<String>(modelesProposes);
		nomModele.add(modele);
		nomModele.add(comboModeles);
		
		JPanel nomTissu = new JPanel();
		JLabel tissu = new JLabel("Tissu: ");
		String[] tissusProposes = {"", "456", "123"};
		JComboBox<String> comboTissus = new JComboBox<String>(tissusProposes);
		nomTissu.add(tissu);
		nomTissu.add(comboTissus);
		
		JPanel nomCouleur = new JPanel();
		JLabel couleur = new JLabel("Couleur: ");
		String[] couleursProposees = {"", "321", "654"};
		JComboBox<String> comboCouleurs = new JComboBox<String>(couleursProposees);
		nomCouleur.add(couleur);
		nomCouleur.add(comboCouleurs);
		
		JPanel nomType = new JPanel();
		JLabel type = new JLabel("Type: ");
		JTextField textetype = new JTextField("Ici il faut aller chercher la chaine de caractère du type");
		textetype.setEditable(false);
		nomType.add(type);
		nomType.add(textetype);
		
		JPanel nomDate = new JPanel();
		JLabel date = new JLabel("Date début de production: ");
		JTextField textedate = new JTextField("Ici il faut aller chercher la date dans la BD"); // Ã©couteurs !
		textedate.setEditable(false);
		nomDate.add(date);
		nomDate.add(textedate);
		
		panneauHaut.add(nomClient);
		panneauHaut.add(nomModele);
		panneauHaut.add(nomTissu);
		panneauHaut.add(nomCouleur);
		panneauHaut.add(nomType);
		panneauHaut.add(nomDate);
		return panneauHaut;	
	}	

	public static void main(String[] args) {
		ChicEtStyle cets = new ChicEtStyleJDBC();
		Principal principal = new Principal();
		MainWindow grandmere = new MainWindow(principal);
		VanessaAccueil mere = new VanessaAccueil(grandmere, cets, true);
		new VanessaHoussage(mere, cets, true).setVisible(true);
	}
}
