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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.tableaux.TabNomenclature1;

public class CatherineAccueil extends JFrame {

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private TabNomenclature1 modele;
	private ImageChicEtStyle imageCetS;
	
	public CatherineAccueil(Frame mere, ChicEtStyle cets, boolean creation) {
		super("Chic & Style");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		conteneur.add(creerCentre(mere,cets), BorderLayout.CENTER);
		conteneur.add(creerWest(), BorderLayout.WEST);
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
	
	public JPanel creerCentre(Frame mere, ChicEtStyle cets) {
		JPanel panneauCentre = new JPanel();
		panneauCentre.setLayout(new BoxLayout(panneauCentre, BoxLayout.Y_AXIS));
		
		JLabel fonction = new JLabel("CATHERINE");
		fonction.setFont(new Font("Helvetica",Font.ITALIC, 48));
		fonction.setAlignmentX(CENTER_ALIGNMENT);
		panneauCentre.add(fonction);
		
		JButton newCommande = new JButton("NOUVELLE COMMANDE");
		newCommande.setAlignmentX(CENTER_ALIGNMENT);
		newCommande.setAlignmentY(CENTER_ALIGNMENT);
		newCommande.setToolTipText("entrer une nouvelle commande");
		ControlJButtonNext control = new ControlJButtonNext(this, new CatherineNouvelleCommande(this, cets, true)); //BOUTON
		newCommande.addActionListener(control); //BOUTON
		panneauCentre.add(newCommande);
		
		JButton expe = new JButton("PRODUITS FINIS");
		expe.setAlignmentX(CENTER_ALIGNMENT);
		expe.setAlignmentY(CENTER_ALIGNMENT);
		expe.setToolTipText("controler ce qui est pret a etre expedie");
		ControlJButtonNext controlexpe = new ControlJButtonNext(this, new CatherinePret(this, cets, true)); //BOUTON
		expe.addActionListener(controlexpe); //BOUTON
		panneauCentre.add(expe);
		
		JButton nomenclature = new JButton("NOMENCLATURE");
		expe.setAlignmentX(CENTER_ALIGNMENT);
		expe.setAlignmentY(CENTER_ALIGNMENT);
		expe.setToolTipText("entrer la nomenclature pour un produit");
		ControlJButtonNext controlnom = new ControlJButtonNext(this, new CatherineNomenclature(this, cets, true)); //BOUTON
		nomenclature.addActionListener(controlnom); //BOUTON
		panneauCentre.add(nomenclature);
		
		JButton lancement = new JButton("LANCEMENT");
		expe.setAlignmentX(CENTER_ALIGNMENT);
		expe.setAlignmentY(CENTER_ALIGNMENT);
		expe.setToolTipText("entrer un lancement");
		ControlJButtonNext controllanc = new ControlJButtonNext(this, new CatherineLancement(this,cets,true)); //BOUTON
		lancement.addActionListener(controllanc); //BOUTON
		panneauCentre.add(lancement);
		
		JButton deconnexion = new JButton("Déconnexion");
		deconnexion.setMaximumSize(new Dimension(150,30));
		deconnexion.setAlignmentX(CENTER_ALIGNMENT);
		ControlJButtonNext controlDeconnexion = new ControlJButtonNext(this, mere); //BOUTON
		deconnexion.addActionListener(controlDeconnexion); //BOUTON
		panneauCentre.add(deconnexion);
		
		
		
		return panneauCentre;
	}
	
	public static void main(String[] args) {
		ChicEtStyle cets = new ChicEtStyleJDBC();
		Principal modele = new Principal();
		MainWindow mere = new MainWindow(modele);
		new CatherineAccueil(mere, cets, true).setVisible(true);
	}
}
