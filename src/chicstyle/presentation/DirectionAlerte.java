package chicstyle.presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.*;

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.abstraction.ChicEtStyleJDBC;
import chicstyle.abstraction.Principal;
import chicstyle.controle.ControlJButtonNext;
import chicstyle.tableaux.TabDirectionAlerte2;
import chicstyle.tableaux.TabDirectionStock2;


public class DirectionAlerte extends JFrame {

	private static final long serialVersionUID = 1L;
	static final int LABEL_SIZE = 18;
	private TabDirectionAlerte2 modele = new TabDirectionAlerte2(); //tableau
	private JTable tableau; //tableau

	public DirectionAlerte(Frame mere, ChicEtStyle cets, boolean creation) {
		super("Chic & Style");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth()*3/4),(int)(tailleEcran.getHeight()*3/4));
		this.setLocation((int)(tailleEcran.getWidth()/8),(int)(tailleEcran.getHeight()/8));
		Container conteneur = this.getContentPane();
		conteneur.setLayout(new BorderLayout());
		conteneur.add(creerHaut(), BorderLayout.NORTH);
		
		tableau = new JTable(modele); //tableau
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER); //tableau
        
        JPanel boutons = new JPanel(); //tableau
        JButton prec = new JButton("Accueil");
        ControlJButtonNext precedent = new ControlJButtonNext(this, mere); //BOUTON
		prec.addActionListener(precedent); //BOUTON
        boutons.add(prec);
//        boutons.add(new JButton(new AddAction())); //tableau
        boutons.add(new JButton(new RemoveAction())); //tableau
        getContentPane().add(boutons, BorderLayout.SOUTH); //tableau
	} 

	public JPanel creerHaut() {
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new BoxLayout(panneauHaut, BoxLayout.Y_AXIS));
		JLabel titre = new JLabel("Chic & Style");
		JLabel fonction = new JLabel("Alertes");
		titre.setFont(new Font(titre.getFont().getName(), Font.BOLD, LABEL_SIZE));
		fonction.setFont(new Font(fonction.getFont().getName(), Font.BOLD, LABEL_SIZE));
		panneauHaut.add(titre);
		panneauHaut.add(fonction);
		return panneauHaut;	
	}

	
	public static void main(String[] args) {
		ChicEtStyle cets = new ChicEtStyleJDBC();
		Principal modele = new Principal();
    	MainWindow grandmere = new MainWindow(modele);
		DirectionAccueil mere = new DirectionAccueil(grandmere, cets, true);
        new DirectionAlerte(mere, cets, true).setVisible(true);
	}
	
  private class RemoveAction extends AbstractAction {
  private RemoveAction() {
      super("Supprimmer");
  }

  public void actionPerformed(ActionEvent e) {
      int[] selection = tableau.getSelectedRows();

      for(int i = selection.length - 1; i >= 0; i--){
          modele.removeAmi(selection[i]);
      }
  }
}

}
