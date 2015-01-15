package chicstyle.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;

import chicstyle.abstraction.ChicEtStyle;

public class ControlJComboBoxModeles implements ActionListener{

	private ChicEtStyle cets;
	private JComboBox<String> suivant;

	public ControlJComboBoxModeles(ChicEtStyle cets,JComboBox<String> suivant) {
		super();
		this.cets = cets;
		this.suivant = suivant;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> comboModeles = (JComboBox<String>)(e.getSource());
		String modeleCourant = comboModeles.getSelectedItem().toString();
		Vector<String> tissus = cets.findAllTissusModele(modeleCourant);
		suivant.removeAllItems();
		suivant.addItem("-");
		for (int i=0; i<tissus.size(); i++){
			suivant.addItem(tissus.get(i));
		}
	}
	
}
