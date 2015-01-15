package chicstyle.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import chicstyle.tableaux.TabMarleneAlerte2;

public class MarleneAlerte extends JFrame {

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private ImageChicEtStyle imageCetS;
	private TabMarleneAlerte2 modele = new TabMarleneAlerte2(); //tableau
	private JTable tableau; //tableau

	public MarleneAlerte(Frame mere, ChicEtStyle cets, boolean creation) {
		super("Chic & Style");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		
		conteneur.add(creerWest(), BorderLayout.WEST);
		
		JPanel util = new JPanel();
		util.setLayout(new BorderLayout());
		
		util.add(creerHaut(), BorderLayout.NORTH);
		conteneur.add(util);
		
		tableau = new JTable(modele); //tableau
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER); //tableau
        
		JPanel boutons = new JPanel();
		JButton valider = new JButton("Valider");
		boutons.add(valider);
		
		JButton precedent = new JButton("Retour");
		ControlJButtonNext controlDeconnexion = new ControlJButtonNext(this, mere); //BOUTON
		precedent.addActionListener(controlDeconnexion); //BOUTON
		boutons.add(precedent);
        
        getContentPane().add(boutons, BorderLayout.SOUTH); //tableau
		

	} 
	
	public JPanel creerWest(){

		JPanel panneauImage = new JPanel();
		panneauImage.setBackground(Color.BLACK);
		panneauImage.setLayout(new BoxLayout(panneauImage, BoxLayout.Y_AXIS));
		panneauImage.add(Box.createRigidArea(new Dimension(0,120)));

		ImageIcon icon = new ImageIcon("images"+File.separator+"logo_C&S.jpg");
		//Image zoom = scaleImage(icon.getImage(), 0.5d);//facteur
		Image zoom = imageCetS.scaleImage(icon.getImage(), 600);//taille en pixels
		Icon iconScaled = new ImageIcon(zoom);
		JLabel image = new JLabel(iconScaled);

		panneauImage.add(image, BorderLayout.CENTER);
		return panneauImage;
	}

	public JPanel creerHaut() {
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		
		JPanel nomClient = new JPanel();
		JLabel client = new JLabel("Client: ");
		String[] clients = {"", "Céline", "Balenciaga", "Louis Vuitton", "Agnès b.", "Nouveau client"};
		JComboBox<String> comboClients=new JComboBox<String>(clients);
		comboClients.setEditable(false);
		nomClient.add(client);
		nomClient.add(comboClients);

		JPanel nomModele = new JPanel();
		JLabel modele = new JLabel("Modèle: ");
		String[] modeles = {"","J212", "V2101", "R233", "V1001", "R9082"};
		JComboBox<String> comboModeles = new JComboBox<String>(modeles);
		comboModeles.setEditable(false);
		nomModele.add(modele);
		nomModele.add(comboModeles);

		JPanel nomTissu= new JPanel();
		JLabel tissu = new JLabel("Tissu: ");
		String[] tissus = {"lin","synthetique", "laine", "T323"};
		JComboBox<String> comboTissus = new JComboBox<String>(tissus);
		comboTissus.setEditable(false);
		nomTissu.add(tissu);
		nomTissu.add(comboTissus);

		panneauHaut.add(nomClient);
		panneauHaut.add(nomModele);
		panneauHaut.add(nomTissu);
		
		return panneauHaut;	
	}

	public static void main(String[] args) {
		ChicEtStyle cets = new ChicEtStyleJDBC();
		Principal principal = new Principal();
		MainWindow grandmere = new MainWindow(principal);
		MarleneAccueil mere = new MarleneAccueil(grandmere, cets, true);
		new MarleneAlerte(mere, cets, true).setVisible(true);
	}
}
