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
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonEnregistrerCommande;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.controle.ControlJButtonValiderCommande;

public class CatherineNouvelleCommande extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private ImageChicEtStyle imageCetS;
	private JComboBox<String> comboClients;
	private JTextField nom;
	private JTextField tis;
	private JTextField cou;
	private JTextField ty;
	
	public JComboBox<String> getComboClients() {
		return comboClients;
	}

	public void setComboClients(JComboBox<String> comboClients) {
		this.comboClients = comboClients;
	}

	public JTextField getNom() {
		return nom;
	}

	public void setNom(JTextField nom) {
		this.nom = nom;
	}

	public JTextField getTis() {
		return tis;
	}

	public void setTis(JTextField tis) {
		this.tis = tis;
	}

	public JTextField getCou() {
		return cou;
	}

	public void setCou(JTextField cou) {
		this.cou = cou;
	}

	public JTextField getTy() {
		return ty;
	}

	public void setTy(JTextField ty) {
		this.ty = ty;
	}

	public CatherineNouvelleCommande(Frame mere, ChicEtStyle cets, boolean creation) {
		super("Chic & Style");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		
		JPanel util = new JPanel();
		util.setLayout(new BorderLayout());
		util.add(creerHaut(), BorderLayout.NORTH);
		util.add(creerCentre(mere, cets), BorderLayout.CENTER);
		util.add(creerBas(mere), BorderLayout.SOUTH);
		
		conteneur.add(creerWest(), BorderLayout.WEST);
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
		JLabel fonction = new JLabel("Nouvelle Commande");
		fonction.setFont(new Font("Helvetica",Font.ITALIC, 48));
		fonction.setAlignmentX(CENTER_ALIGNMENT);
		panneauHaut.add(fonction);
		return panneauHaut;	
	}
	
	public JPanel creerCentre(Frame mere, ChicEtStyle cets) {
		JPanel panneauCentre = new JPanel();
		panneauCentre.setLayout(new BoxLayout(panneauCentre, BoxLayout.Y_AXIS));
		
		JPanel nomClient = new JPanel();
		JLabel client = new JLabel("Client: ");
		Vector<String> clients = cets.findAllClients();
		comboClients=new JComboBox<String>(clients);
		comboClients.setEditable(true);
		comboClients.setSelectedItem(cets.getPieceCourante().getClient());
		nomClient.add(client);
		nomClient.add(comboClients);
		
		JPanel nomModele = new JPanel();
		JLabel modele = new JLabel("Modèle: ");
		nom = new JTextField(15);
		nomModele.add(modele);
		nomModele.add(nom);
		
		JPanel nomTissu = new JPanel();
		JLabel tissu = new JLabel("Tissu: ");
		tis = new JTextField(15);
		nomTissu.add(tissu);
		nomTissu.add(tis);
		
		JPanel nomCouleur = new JPanel();
		JLabel couleur = new JLabel("Couleur: ");
		cou = new JTextField(15);
		nomCouleur.add(couleur);
		nomCouleur.add(cou);
		
		JPanel nomType = new JPanel();
		JLabel type = new JLabel("Type: ");
		ty = new JTextField(15);
		nomType.add(type);
		nomType.add(ty);
		
		JButton valider = new JButton("VALIDER");
//		ControlJButtonValiderCommande controlValiderCommande = new ControlJButtonValiderCommande(this, mere); //BOUTON
//		valider.addActionListener(controlValiderCommande); //BOUTON
		ControlJButtonEnregistrerCommande controlvalid = new ControlJButtonEnregistrerCommande(cets, this, mere);
		valider.addActionListener(controlvalid);
		
		panneauCentre.add(nomClient);
		panneauCentre.add(nomModele);
		panneauCentre.add(nomTissu);
		panneauCentre.add(nomCouleur);
		panneauCentre.add(nomType);
		panneauCentre.add(valider);
		return panneauCentre;
	}
	
	public JPanel creerBas(Frame mere){
		JPanel panneauBas = new JPanel();
		panneauBas.setLayout(new BoxLayout(panneauBas, BoxLayout.X_AXIS));
		
		JButton precedent = new JButton("Précédent");
		ControlJButtonNext controlprec = new ControlJButtonNext(this, mere); //BOUTON
		precedent.addActionListener(controlprec); //BOUTON
		
		panneauBas.add(precedent);
		return panneauBas;
	}
	
	public static void main(String[] args) {
		ChicEtStyle cets = new ChicEtStyleJDBC();
		Principal principal = new Principal();
		MainWindow grandmere = new MainWindow(principal);
		CatherineAccueil mere = new CatherineAccueil(grandmere, cets, true);
		new CatherineNouvelleCommande(mere, cets, true).setVisible(true);
//		System.out.println(cets.getPieceCourante().getClient());
	}
}
