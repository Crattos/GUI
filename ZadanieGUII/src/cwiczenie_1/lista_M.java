package cwiczenie_1;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

/** 
* Klasa lista_M definiuje metody listy abstrakcyjnej
* @author Patryk Miler	 	
* @version 1.0	16/05/2016
* -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
*/

public class lista_M extends AbstractListModel{
	List<String> abcd = new ArrayList<String>();
	
	
	/**
	 * Konstruktor parametrowy
	 * @param dodanie typu List<String> jest odpowiedzalny za 
	 * dodanie wszystkich elementów do listy klasy
	 */
	public lista_M(List<String> dodanie)
	{
		abcd.addAll(dodanie);
	}
	
	
	/**
	 * Metoda odpowiedzalna za zwrócenie elementu z listy
	 * @param index typu int jest odpowiedzalny za przekazanie wybranego nr indeksu
	 * @return zwraca warto¶æ listy jako typ Object
	 */
	public Object getElementAt(int index) 
	{
		// TODO Auto-generated method stub
		return abcd.get(index);
	}

	
	/**
	 * Metoda odpowiedzalna za zwrócenie rozmiaru listy
	 * @return zwraca rozmiar listy jako typ int
	 */
	@Override
	public int getSize() 
	{
		// TODO Auto-generated method stub
		return abcd.size();
	}
	
	/**
	 * Metoda odpowiedzalna za dodanie elementu do listy
	 * @param podany_element typu String jest odpowiedzalny za 
	 * dodanie tego elementu do listy
	 */
	public void addElement(String podany_element)
	{
		abcd.add(podany_element);
		fireContentsChanged(this, 0, abcd.size());
	}

}
