package chicstyle.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
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
import chicstyle.tableaux.TabExpedition1;
import chicstyle.tableaux.TabExpedition2;

public class CatherineExpedition extends JFrame{

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private TabExpedition2 modele = new TabExpedition2(); //tableau
	private JTable tableau; //tableau
	private ImageChicEtStyle imageCetS;


	public CatherineExpedition(Frame mere, ChicEtStyle cets, boolean creation) {
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

		tableau = new JTable(modele); //tableau
		util.add(new JScrollPane(tableau), BorderLayout.CENTER); //tableau
		JPanel boutons = new JPanel(); //tableau

		JButton accueil = new JButton("Accueil");
		ControlJButtonNext controlacc = new ControlJButtonNext(this, mere); //BOUTON
		accueil.addActionListener(controlacc); //BOUTON

		boutons.add(accueil);
		JButton envoyer = new JButton("Envoyer");
		boutons.add(envoyer);
		util.add(boutons, BorderLayout.SOUTH); //tableau
		
		conteneur.add(util, BorderLayout.CENTER);
		
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
		JLabel fonction = new JLabel("Expédition");
		fonction.setFont(new Font("Helvetica",Font.ITALIC, 48));
		fonction.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel cl = new JPanel();
		JLabel client = new JLabel("Client: ");
		String[] clients = {"", "Céline", "Balenciaga", "Louis Vuitton", "Nouveau client"};
		JComboBox<String> comboClients=new JComboBox<String>(clients);
		comboClients.setMaximumSize(new Dimension(150,10));
		comboClients.setEditable(false);
		cl.add(client);
		cl.add(comboClients);

		JPanel mo = new JPanel();
		JLabel modele = new JLabel("Modèle: ");
		String[] modeles = {"", "T15", "R47"};
		JComboBox<String> comboModeles=new JComboBox<String>(modeles);
		comboModeles.setEditable(false);
		mo.add(modele);
		mo.add(comboModeles);

		JPanel ti = new JPanel();
		JLabel tissu = new JLabel("Tissu: ");
		String[] tissus = {"", "456", "754"};
		JComboBox<String> comboTissus=new JComboBox<String>(tissus);
		comboTissus.setEditable(false);
		ti.add(tissu);
		ti.add(comboTissus);

		JPanel co = new JPanel();
		JLabel couleur = new JLabel("Couleur: ");
		String[] couleurs = {"", "Rouge", "Bleu"};
		JComboBox<String> comboCouleurs=new JComboBox<String>(couleurs);
		comboCouleurs.setEditable(false);
		co.add(couleur);
		co.add(comboCouleurs);

		panneauHaut.add(fonction);
		panneauHaut.add(cl);
		panneauHaut.add(mo);
		panneauHaut.add(ti);
		panneauHaut.add(co);
		return panneauHaut;	
	}

	//POUR LES TABLEAUX
	public static void main(String[] args) {
		ChicEtStyle cets = new ChicEtStyleJDBC();
		Principal principal = new Principal();
		MainWindow grandmere = new MainWindow(principal);
		CatherineAccueil mere = new CatherineAccueil(grandmere,cets, true);
		new CatherineExpedition(mere, cets, true).setVisible(true);
	}
}
