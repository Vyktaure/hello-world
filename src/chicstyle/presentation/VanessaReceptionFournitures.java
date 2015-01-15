package chicstyle.presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.controle.ControlJButtonValiderCommande;
import chicstyle.controle.ControlJButtonValiderNouvelleFourniture;

public class VanessaReceptionFournitures extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	
	public VanessaReceptionFournitures(Frame mere, ChicEtStyle cets, boolean creation) {
		super("Chic & Style");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		
		
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		conteneur.add(creerHaut(), BorderLayout.NORTH);
		conteneur.add(creerCentre(), BorderLayout.CENTER);
		
		JPanel boutons = new JPanel(); //
		
		JButton validate = new JButton("Valider");
		ControlJButtonValiderNouvelleFourniture controlValiderNouvelleFourniture = new ControlJButtonValiderNouvelleFourniture(this, mere); //BOUTON
		validate.addActionListener(controlValiderNouvelleFourniture); //BOUTON
		boutons.add(validate);
		
		JButton retour = new JButton("Retour");
		ControlJButtonNext ret = new ControlJButtonNext(this, mere); //BOUTON
		retour.addActionListener(ret); //BOUTON
		boutons.add(retour);

		getContentPane().add(boutons, BorderLayout.SOUTH); //
	}
	
	public JPanel creerHaut() {
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Chic & Style");
		JLabel fonction = new JLabel("Reception Fourniture");
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
		
		JPanel panneauBas = new JPanel();
		panneauBas.setLayout(new BoxLayout(panneauBas, BoxLayout.X_AXIS));		
		JPanel panelRef = new JPanel();
//		panelRef.setLayout(new BoxLayout(panelRef, BoxLayout.Y_AXIS));
		JLabel nomRef = new JLabel("Référence");
		String[] references = {"M2343", "TI2343", "G3432", "M45345"};
		JComboBox<String> comboRef=new JComboBox<String>(references);
		// Mettre un listener qui retient la rÃ©fÃ©rence choisie
		comboRef.setEditable(false);
		panelRef.add(nomRef);
		panelRef.add(comboRef);
		//Type
		JPanel panelType = new JPanel();
//		panelType.setLayout(new BoxLayout(panelType, BoxLayout.Y_AXIS));
		JLabel nomType = new JLabel("Type");
		JTextField textetype = new JTextField("Ici il faut aller chercher la chaine de caractère du type");
		textetype.setEditable(false);
		panelType.add(nomType);
		panelType.add(textetype);
		//QuantitÃ©
		JPanel panelQuantite = new JPanel();
//		panelQuantite.setLayout(new BoxLayout(panelQuantite, BoxLayout.Y_AXIS));
		JLabel nomQuantite = new JLabel("Quantité reçue");
		JTextField texteQuantite = new JTextField("Saisir la quantité");
			// Besoin d'un ecouteur de la quantitÃ© saisie
		texteQuantite.setEnabled(true);
		panelQuantite.add(nomQuantite);
		panelQuantite.add(texteQuantite);
		//Mise Ã  jour stock
		JPanel panelStock = new JPanel();
//		panelStock.setLayout(new BoxLayout(panelStock, BoxLayout.Y_AXIS));
		JLabel nomStock = new JLabel("Stock");
		JTextField texteStock = new JTextField("Stock actuel"); // ici besoin d'un Ã©couteur qui va chercher le stock
		texteStock.setEditable(false);
		panelStock.add(nomStock);
		panelStock.add(texteStock);
		
		panneauBas.add(panelRef);
		panneauBas.add(panelType);
		panneauBas.add(panelQuantite);
		panneauBas.add(panelStock);

		panneauCentre.add(panneauBas);
		return panneauCentre;
		
	}
		public static void main(String[] args) {
			ChicEtStyle cets = new ChicEtStyleJDBC();
			Principal principal = new Principal();
			MainWindow grandmere = new MainWindow(principal);
			VanessaAccueil mere = new VanessaAccueil(grandmere, cets, true);
			new VanessaReceptionFournitures(mere, cets, true).setVisible(true);
		}
		
}
	
	
