package cwiczenie_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import org.apache.log4j.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/** 
* Klasa lista_M definiuje Listenery czyli tzw "s³uchacze"
* @author Patryk Miler	 	
* @version 1.0	16/05/2016
* -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
*/

public class tabelka_C{
	GUI VIEW;
	tabelka_M MODEL;
	Logger logger = Logger.getLogger("cwiczenie_1.tabelka_C");
	
	/**
	 * Konstruktor parametrowy jest odpowiedzalny za dodanie kontrolek do tabeli
	 * @param VIEW obiekt klasy GUI 
	 * @param MODEL obiekt klasy tabelka_M
	 */
	public tabelka_C(final GUI VIEW, final tabelka_M MODEL)
	{
		this.VIEW = VIEW;
		this.MODEL = MODEL;
		
		
		this.VIEW.dodaj_do_tabeli_jbn(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				
				int odczyt_kolumny;
				int odczyt_wiersza;
				Integer liczba;
				odczyt_kolumny = VIEW.nr_kolumny_sp.getValue();
				odczyt_wiersza = VIEW.nr_wiersza_sp.getValue();

				try
				{
					liczba = Integer.parseInt(VIEW.wprowadz_liczbe.getText());
					MODEL.setValueAt(liczba.toString(), odczyt_wiersza, odczyt_kolumny-1);
				}
				catch(Exception ex)
				{
					
					logger.error("Blad podczas wprowadzania liczby do tabeli");
					//MojLoger.writeLog("ERROR", "Blad podczas wprowadzania liczby do tabeli");
					JOptionPane.showMessageDialog(VIEW, ex, "Ups", JOptionPane.OK_OPTION);
				}
			}
		});
		
		this.VIEW.wyzeruj_do_tabeli_jbn(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				for(int i =1; i < MODEL.getRowCount(); i++)
				{
					for(int j = 0; j < MODEL.getColumnCount(); j++)
					{
						MODEL.setValueAt("0", Integer.valueOf(i), Integer.valueOf(j));
					}
				}
				
			}
		});

		this.VIEW.wypelnij_do_tabeli_jbn(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					for(int i =1; i < MODEL.getRowCount(); i++)
					{
						for(int j = 0; j < MODEL.getColumnCount(); j++)
						{
							MODEL.setValueAt(Integer.parseInt(VIEW.wprowadz_liczbe.getText()), Integer.valueOf(i), Integer.valueOf(j));
						}
						
					}
				}
				catch(Exception ex)
				{
					logger.error("Blad podczas wype³niania tabeli podan¹ warto¶ci±");
					//MojLoger.writeLog("ERROR", "Blad podczas wype³niania tabeli");
					JOptionPane.showMessageDialog(VIEW, ex, "Ups", JOptionPane.OK_OPTION);
					
				}
				
			}
		});
		
		this.VIEW.zapis_do_tabeli_jbn(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("pliki txt(*.txt)", "txt");
				fileChooser.addChoosableFileFilter(txtFilter);
				fileChooser.setFileFilter(txtFilter);
				
				if (fileChooser.showSaveDialog(VIEW) == JFileChooser.APPROVE_OPTION) 
				{
				//  File file = fileChooser.getSelectedFile();
				  String sciezka_pliku = fileChooser.getSelectedFile().getAbsolutePath();
				  if(!(sciezka_pliku.contains(".txt")))
				  {
					  sciezka_pliku=sciezka_pliku+".txt";
				  }
				  else
				  {
					  //nic nie rób
				  }
				  
				  try
					{
					  
						BufferedWriter out = new BufferedWriter(new FileWriter(sciezka_pliku));
						for(int i =1; i < 6; i++)
						{
							for(int j=0;j<5;j++)
							{
								out.write(MODEL.getValueAt(i, j).toString());
								out.newLine();
							}
						}
			            out.close();

			            JOptionPane.showMessageDialog(VIEW, "Dane zosta³y zapisane do pliku pod nazw±½ "+sciezka_pliku, "Zapisz", JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception ex)
					{
						logger.error("B³±d podczas zapisu warto¶ci tabeli do pliku typu .txt");
						JOptionPane.showMessageDialog(VIEW, ex, "Ups", JOptionPane.OK_OPTION);
					}
				}
				
			}
		});

	}
}
