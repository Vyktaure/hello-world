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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.tableaux.TabPret2;

public class CatherinePret extends JFrame {

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private TabPret2 modele = new TabPret2(); //tableau
	private JTable tableau; //tableau
	
	public CatherinePret(Frame mere, ChicEtStyle cets, boolean creation) {
        super();
 
        setTitle("Chic & Style");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
        
        Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		conteneur.add(creerHaut(), BorderLayout.NORTH);
		
		tableau = new JTable(modele); //tableau
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER); //tableau
        JPanel boutons = new JPanel(); //tableau
        
        JButton expe = new JButton("Expédier");
        ControlJButtonNext control = new ControlJButtonNext(this,new CatherineExpedition(mere, cets,true)); //BOUTON
		expe.addActionListener(control); //BOUTON
		
		JButton prec = new JButton("Précédent");
		ControlJButtonNext precedent = new ControlJButtonNext(this, mere); //BOUTON
		prec.addActionListener(precedent); //BOUTON
		
		boutons.add(prec);
		boutons.add(expe);
        getContentPane().add(boutons, BorderLayout.SOUTH); //tableau
    }
    
	public JPanel creerHaut() {
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Chic & Style");
		JLabel fonction = new JLabel("PRET A PARTIR");
		titre.setFont(new Font(titre.getFont().getName(), Font.BOLD, LABEL_SIZE));
		fonction.setFont(new Font(fonction.getFont().getName(), Font.BOLD, LABEL_SIZE));
		panneauHaut.add(titre);
		panneauHaut.add(fonction);
		return panneauHaut;	
	}
 
//POUR LES TABLEAUX
    public static void main(String[] args) {
    	ChicEtStyle cets = new ChicEtStyleJDBC();
    	Principal principal = new Principal();
		MainWindow grandmere = new MainWindow(principal);
		CatherineAccueil mere = new CatherineAccueil(grandmere, cets, true);
        new CatherinePret(mere, cets, true).setVisible(true);
    }
}
