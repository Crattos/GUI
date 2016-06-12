package cwiczenie_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Klasa Combo do zastosowania modelu MVC
 * @author Patryk Miler
 *
 */

public class Combo implements ActionListener{

	  // Obs³uga akcji: gdy pole edytowalne i wprowadzono
	  // nowy element - dodaæ go do listy
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 JComboBox  cb = (JComboBox) e.getSource();
		    if (cb.isEditable()) {
		      Object o = cb.getSelectedItem();
		      int i = ((DefaultComboBoxModel) cb.getModel()).getIndexOf(o);
		      if (i == -1) cb.addItem(o);
		      }
	}

}
