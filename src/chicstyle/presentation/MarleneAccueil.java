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
import chicstyle.tableaux.TabMarlene2;

public class MarleneAccueil extends JFrame{

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private TabMarlene2 modele = new TabMarlene2(); //tableau
	private JTable tableau; //tableau

	public MarleneAccueil(Frame mere, ChicEtStyle cets, boolean creation) {
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
        
        JButton alerte = new JButton("ALERTE");
        ControlJButtonNext controlFournitures = new ControlJButtonNext(this, new MarleneAlerte(this, cets, true));
		alerte.addActionListener(controlFournitures);
        boutons.add(alerte);
        
        JButton precedent = new JButton("Déconnexion");
        ControlJButtonNext prec = new ControlJButtonNext(this, mere); //BOUTON
		precedent.addActionListener(prec); //BOUTON
		boutons.add(precedent);
        
        getContentPane().add(boutons, BorderLayout.SOUTH); //tableau
	}

	public JPanel creerHaut() {
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Chic & Style");
		JLabel fonction = new JLabel("Patronnage");
		titre.setFont(new Font(titre.getFont().getName(), Font.BOLD, LABEL_SIZE));
		fonction.setFont(new Font(fonction.getFont().getName(), Font.BOLD, LABEL_SIZE));
		panneauHaut.add(titre);
		panneauHaut.add(fonction);
		
		JPanel nomClient = new JPanel();
		JLabel client = new JLabel("Client: ");
		String[] clients = {"", "Céline", "Balenciaga", "Louis Vuitton", "Agnès b.", "Nouveau client"};
		JComboBox<String> comboClients=new JComboBox<String>(clients);
		nomClient.add(client);
		nomClient.add(comboClients);

		JPanel nomModele = new JPanel();
		JLabel modele = new JLabel("Modèle: ");
		String[] modelesProposes = {"", "T37", "M2O7"};
		JComboBox<String> comboModeles = new JComboBox<String>(modelesProposes);
		nomModele.add(modele);
		nomModele.add(comboModeles);

		JPanel nomType = new JPanel();
		JLabel type = new JLabel("Type: ");
		JTextField textetype = new JTextField("Ici il faut aller chercher la chaine de caractÃ¨re du type");
		textetype.setEditable(false);
		nomType.add(type);
		nomType.add(textetype);
		
		JPanel laize = new JPanel();
		JLabel labLaize = new JLabel("Laize: ");
		JTextField textelaize = new JTextField("          ");
		textelaize.setEditable(true);
		laize.add(labLaize);
		laize.add(textelaize);

		panneauHaut.add(nomClient);
		panneauHaut.add(nomModele);
		panneauHaut.add(nomType);
		panneauHaut.add(laize);
		
		return panneauHaut;	
	}

	public static void main(String[] args) {
		ChicEtStyle cets = new ChicEtStyleJDBC();
		Principal principal = new Principal();
		MainWindow mere = new MainWindow(principal);
		new MarleneAccueil(mere, cets, true).setVisible(true);
	}

}
