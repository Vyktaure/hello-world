package chicstyle.controle;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import chicstyle.abstraction.ChicEtStyle;
import chicstyle.presentation.CatherineNouvelleCommande;

public class ControlJButtonValiderCommande implements ActionListener {

	private CatherineNouvelleCommande mere;
	private Frame fille;
	private ChicEtStyle modele;
	

	public ControlJButtonValiderCommande(CatherineNouvelleCommande mere, Frame fille) {
		this.mere = mere;
		this.fille = fille;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int choix = JOptionPane.showConfirmDialog(mere, "Confirmez-vous la commande ?", "Validation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		switch (choix){
		case JOptionPane.YES_OPTION :
				JOptionPane.showMessageDialog(mere, "Commande Enregistrée", "info", JOptionPane.PLAIN_MESSAGE); 
				fille.setVisible(true) ;
				mere.setVisible(false);
				break;
		}
	}
}
