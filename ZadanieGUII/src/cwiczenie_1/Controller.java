package cwiczenie_1;

import javax.swing.DefaultComboBoxModel;
/**
 * Klasa Controller jest odpowiedzialna, za kontroler komponentu JComboBox
 * @author Patryk
 * @version 1.0	16/05/2016
 * -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
 */
public class Controller {


	private final GUI frame = new GUI(new TableModel());
    private final DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
		 
    /**
     * Konstruktor bez paramentru, dodaje elemnty do JComboBox
     */
    public Controller() {
	  
	    comboBoxModel.addElement("Wybierz opcjê");  
		comboBoxModel.addElement("Suma elementów");
	    comboBoxModel.addElement("¦rednia elementów");
	    comboBoxModel.addElement("Warto¶æ max");
	    comboBoxModel.addElement("Warto¶æ min");
	    frame.setMyListModel(comboBoxModel);
	}

}
