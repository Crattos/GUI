package cwiczenie_1;

import javax.swing.table.AbstractTableModel;


/** 
* Klasa TableModel definiuje metody tabeli abstrakcyjnej
* @author Patryk Miler	 	
* @version 1.0	16/05/2016
* -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
*/

public class TableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] cols = {"1","2","3","4","5"};
	private Object[][] rows = {
							{1,2,3,4,5},
							{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,0}
							};
	/**
	 * Konstruktor domy¶lny
	 */
	public TableModel()//konstruktor
	{

	}
	
	
	/**
	 * Metoda odpowiedzalna za zwrócenie elementu z obiektu rows dwuelementowego
	 * @param r typu int jest odpowiedzalny za wyznaczenie wiersza
	 * @param c typu int jest odpowiedzalny za wyznaczenie kolumny
	 * @return zwraca warto¶æ obiektu rows jako typ Object
	 */
	public Object getValueAt(int r, int c)
	{
		//System.out.println("Wynik: "+rows[r][c].toString());
		return rows[r][c];
	}
	
	
	/**
	 * Metoda odpowiedzalna za zwrócenie ilo¶ci kolumn w tabeli
	 * @return zwraca warto¶æ typu int
	 */
	public int getColumnCount()
	{
		return cols.length;
	}
	
	
	/**
	 * Metoda odpowiedzalna za zwrócenie ilo¶ci wierszy w tabeli
	 * @return zwraca warto¶æ typu int
	 */
	public int getRowCount()
	{
		return rows.length;
	}

	
	/**
	 * Metoda odpowiedzalna za zwrócenie nazwy kolumny
	 * @param c typu int jest odpowiedzalny za wyznaczenie numeru kolumny
	 * @return zwraca warto¶æ typu String
	 */
	public String getColumnName(int c)
	{
		return cols[c];
	}

	
	/**
	 * Metoda odpowiedzalna za ustawienie warto¶ci w tabeli
	 * @param value obiekt typu Object oznacza warto¶æ
	 * @param r typu int oznacza numer wiersza
	 * @param c typu int oznacza numer kolumny
	 */
	public void setValueAt(Object value, int r, int c)
	{
		rows[r][c] = value.toString();
		fireTableCellUpdated(r, c);
	}
	
	
	/**
	 * Metoda odpowiedzalna za zwrócenie warto¶ci czy podany element jest edytowalny
	 * @param r typu int oznacza numer wiersza
	 * @param c typu int oznacza numer kolumny
	 * @return zwraca warto¶æ typu boolean
	 */
	public boolean isCellEditable(int r, int c)
	{
		//r - row
		//c - column
		return false;
	}
	
	
}
