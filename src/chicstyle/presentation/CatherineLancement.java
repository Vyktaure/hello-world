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

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.tableaux.TabLancement2;

public class CatherineLancement extends JFrame{

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private TabLancement2 modele = new TabLancement2(); //tableau
	private JTable tableau; //tableau
	private ImageChicEtStyle imageCetS;

	
	public CatherineLancement(Frame mere, ChicEtStyle cets, boolean creation) {
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
		
		conteneur.add(creerWest(), BorderLayout.WEST);
		
		tableau = new JTable(modele); //tableau
        util.add(new JScrollPane(tableau), BorderLayout.CENTER); //tableau
        JPanel boutons = new JPanel(); //tableau
//        boutons.add(new JButton(new AddAction())); //tableau
//        boutons.add(new JButton(new RemoveAction())); //tableau
        JButton prec = new JButton("Précédent");
        ControlJButtonNext precedent = new ControlJButtonNext(this, mere); //BOUTON
		prec.addActionListener(precedent); //BOUTON
        boutons.add(prec);
        JButton validate = new JButton("Valider");
        boutons.add(validate);
        util.add(boutons, BorderLayout.SOUTH); //tableau;
        
        conteneur.add(util,BorderLayout.CENTER);
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
		
		JLabel fonction = new JLabel("LANCEMENT");
		fonction.setFont(new Font("Helvetica",Font.ITALIC, 48));
		fonction.setAlignmentX(CENTER_ALIGNMENT);
		panneauHaut.add(fonction);

		return panneauHaut;	
	}
	
	//POUR LES TABLEAUX
    public static void main(String[] args) {
    	ChicEtStyle cets = new ChicEtStyleJDBC();
    	Principal principal = new Principal();
		MainWindow grandmere = new MainWindow(principal);
		CatherineAccueil mere = new CatherineAccueil(grandmere, cets, true);
        new CatherineLancement(mere, cets, true).setVisible(true);
    }
}
