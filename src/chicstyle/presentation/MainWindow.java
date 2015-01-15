package chicstyle.presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import chicstyle.abstraction.Principal;


public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int LABEL_SIZE = 18;
		
	public MainWindow(Principal modele) {
		super("Chic & Style");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		conteneur.add(creerHaut(), BorderLayout.NORTH);
		conteneur.add(creerCentre(), BorderLayout.CENTER);
	} 
	
	public JLabel creerHaut() {
		JLabel panneauHaut = new JLabel("Chic & Style");
//		panneauHaut.setPreferredSize(new Dimension(100,100));
		panneauHaut.setFont(new Font(panneauHaut.getFont().getName(), Font.BOLD, LABEL_SIZE));
		return panneauHaut;
		
	}
	
	public JPanel creerCentre() {
		JPanel panneauCentre = new JPanel();
		panneauCentre.setLayout(new BoxLayout(panneauCentre, BoxLayout.Y_AXIS));
		
		JPanel log = new JPanel();
		JLabel identifiant = new JLabel("Identifiant: ");
		JTextField login = new JTextField(15);
		log.add(identifiant);
		log.add(login);
		
		JPanel pass = new JPanel();
		JLabel mdp = new JLabel("Mot de passe: ");
		JPasswordField password = new JPasswordField(15);
		pass.add(mdp);
		pass.add(password);
		
		JButton ok = new JButton("OK");
		
		panneauCentre.add(log);
		panneauCentre.add(pass);
		panneauCentre.add(ok); // TODO ajouter un action listener
		return panneauCentre;
	}
	
	public static void main(String[] args) {
		Principal modele = new Principal();
		MainWindow fen = new MainWindow(modele);
		fen.setVisible(true);
	}
}
