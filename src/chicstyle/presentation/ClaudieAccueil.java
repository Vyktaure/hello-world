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

public class ClaudieAccueil extends JFrame {

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	
	public ClaudieAccueil(Frame mere, ChicEtStyle cets, boolean creation){
		super("Chic&Style");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		conteneur.add(creerHaut(cets), BorderLayout.NORTH);
		conteneur.add(creerBas(mere), BorderLayout.SOUTH);
	}
	
	public JPanel creerHaut(ChicEtStyle cets){
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Réception tissus");
		titre.setFont(new Font(panneauHaut.getFont().getName(), Font.BOLD, LABEL_SIZE));
		panneauHaut.add(titre);
		
		JButton houssage = new JButton("RECEPTION TISSUS");
		ControlJButtonNext controlHoussage = new ControlJButtonNext(this, new ClaudieReception(this, cets, true));
		houssage.addActionListener(controlHoussage);

		JButton fournitures = new JButton("ALERTE");
		ControlJButtonNext controlFournitures = new ControlJButtonNext(this, new ClaudieAlerte(this, cets,true));
		fournitures.addActionListener(controlFournitures);
		
		panneauHaut.add(houssage);
		panneauHaut.add(fournitures);
		
		return panneauHaut;
	}
	
	
	public JPanel creerBas(Frame mere){
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
		new ClaudieAccueil(mere, cets, true).setVisible(true);
	}
}
