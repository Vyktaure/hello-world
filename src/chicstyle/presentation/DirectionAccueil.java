package chicstyle.presentation;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.*;

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonNext;


public class DirectionAccueil extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int LABEL_SIZE = 18;
	
	private ImageChicEtStyle imageCetS;
		
	public DirectionAccueil(Frame mere, ChicEtStyle cets, boolean creation){
		super("Chic & Style Direction");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		conteneur.add(creerWest(), BorderLayout.WEST);
		conteneur.add(creerCentre(mere, cets), BorderLayout.CENTER);
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
		panneauCentre.add(Box.createRigidArea(new Dimension(0,120)));
		
		JLabel fonction = new JLabel("DIRECTION");
		fonction.setFont(new Font("Helvetica",Font.ITALIC, 48));
		fonction.setAlignmentX(CENTER_ALIGNMENT);
		panneauCentre.add(fonction);
		
		panneauCentre.add(Box.createRigidArea(new Dimension(0,30)));

		
		JButton suiviC = new JButton("Suivi client");
		suiviC.setMaximumSize(new Dimension(150,30));
		suiviC.setAlignmentX(CENTER_ALIGNMENT);
		ControlJButtonNext control = new ControlJButtonNext(this, new DirectionProduitsFinis(this, cets, true)); //BOUTON
		suiviC.addActionListener(control); //BOUTON
		panneauCentre.add(suiviC);
		
		panneauCentre.add(Box.createRigidArea(new Dimension(0,10)));

		JButton stocks = new JButton("Stocks");
		stocks.setMaximumSize(new Dimension(150,30));
		stocks.setAlignmentX(CENTER_ALIGNMENT);
		ControlJButtonNext controlstocks = new ControlJButtonNext(this, new DirectionStock(this, cets, true)); //BOUTON
		stocks.addActionListener(controlstocks); //BOUTON
		panneauCentre.add(stocks);
		
		panneauCentre.add(Box.createRigidArea(new Dimension(0,10)));

		JButton alertes = new JButton("ALERTES  (0)");
		alertes.setMaximumSize(new Dimension(150,30));
		alertes.setAlignmentX(CENTER_ALIGNMENT);
		ControlJButtonNext controlalertes = new ControlJButtonNext(this, new DirectionAlerte(this, cets, true)); //BOUTON
		alertes.addActionListener(controlalertes); //BOUTON
		panneauCentre.add(alertes);
		
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
		new DirectionAccueil(mere, cets, true).setVisible(true);
	}
}
