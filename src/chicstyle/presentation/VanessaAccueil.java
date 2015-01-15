/**
 * 
 */
/**
 * @author marius
 *
 */
package chicstyle.presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonNext;

public class VanessaAccueil extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	
	public VanessaAccueil(Frame mere, ChicEtStyle cets, boolean creation){
		super("Chic&Style");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.addWindowListener(new ControlJFrameMainWindow(principal));
		
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		conteneur.add(creerHaut(cets), BorderLayout.NORTH);
		conteneur.add(creerBas(mere, cets), BorderLayout.SOUTH);
	}
	
	public JPanel creerHaut(ChicEtStyle cets){
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Fournitures et Houssage");
		titre.setFont(new Font(panneauHaut.getFont().getName(), Font.BOLD, LABEL_SIZE));
		panneauHaut.add(titre);
		
		JButton houssage = new JButton("HOUSSAGE");
		ControlJButtonNext controlHoussage = new ControlJButtonNext(this, new VanessaHoussage(this, cets, true));
		houssage.addActionListener(controlHoussage);

		JButton fournitures = new JButton("FOURNITURES");
		ControlJButtonNext controlFournitures = new ControlJButtonNext(this, new VanessaReceptionFournitures(this, cets, true));
		fournitures.addActionListener(controlFournitures);
		
		JButton boite = new JButton("BOITE");
		ControlJButtonNext controlBoite = new ControlJButtonNext(this, new VanessaRealisationBoite(this, cets, true));
		boite.addActionListener(controlBoite);
		
		JButton stock = new JButton("STOCK");
		ControlJButtonNext controlStock = new ControlJButtonNext(this, new VanessaStock(this, cets, true));
		stock.addActionListener(controlStock);
		
		panneauHaut.add(houssage); // TODO ajouter un action listener
		panneauHaut.add(fournitures); // TODO ajouter un action listener
		panneauHaut.add(boite); // TODO ajouter un action listener
		panneauHaut.add(stock); // TODO ajouter un action listener
		
		return panneauHaut;
	}
	
	
	public JPanel creerBas(Frame mere, ChicEtStyle cets){
		JPanel panneauBas = new JPanel();
		JButton deconnexion = new JButton("Déconnexion");
		deconnexion.setMaximumSize(new Dimension(150,30));
		deconnexion.setAlignmentX(CENTER_ALIGNMENT);
		ControlJButtonNext controlDeconnexion = new ControlJButtonNext(this, mere); //BOUTON
		deconnexion.addActionListener(controlDeconnexion); //BOUTON
		panneauBas.add(deconnexion);
		
		return panneauBas;
	}
	
	
	public static void main(String[] args) {
		ChicEtStyle cets = new ChicEtStyleJDBC();
		Principal principal = new Principal();
		MainWindow mere = new MainWindow(principal);
		new VanessaAccueil(mere, cets, true).setVisible(true);
	}
	
}