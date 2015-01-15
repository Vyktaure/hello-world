package chicstyle.presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.tableaux.TabBoite1;
import chicstyle.tableaux.TabStockVanessa2;
import chicstyle.tableaux.TabStockVanessa1;


public class VanessaStock extends JFrame{

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;

	private TabStockVanessa2 modele = new TabStockVanessa2(); //
	private JTable tableau; //

	public VanessaStock(Frame mere, ChicEtStyle cets, boolean creation) {
		super("Chic & Style");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		conteneur.add(creerHaut(), BorderLayout.NORTH);
		conteneur.add(creerCentre(), BorderLayout.CENTER);

		tableau = new JTable(modele); //
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER); //
		JPanel boutons = new JPanel(); //
		JButton precedent = new JButton("Précédent");
		boutons.add(precedent);
		ControlJButtonNext prec = new ControlJButtonNext(this, mere); //BOUTON
		precedent.addActionListener(prec); //BOUTON
		getContentPane().add(boutons, BorderLayout.SOUTH); //
	}

	public JPanel creerHaut() {
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Chic & Style");
		JLabel fonction = new JLabel("Stock");
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

		panneauHaut.add(nomClient);

		return panneauHaut;
	}

	public JPanel creerCentre() {
		JPanel panneauCentre = new JPanel();
		panneauCentre.setLayout(new BoxLayout(panneauCentre, BoxLayout.Y_AXIS));



		return panneauCentre;
	}

	public static void main(String[] args) {
		ChicEtStyle cets = new ChicEtStyleJDBC();
		Principal principal = new Principal();
		MainWindow grandmere = new MainWindow(principal);
		VanessaAccueil mere = new VanessaAccueil(grandmere, cets, true);
		new VanessaStock(mere, cets, true).setVisible(true);
		
	}
}
