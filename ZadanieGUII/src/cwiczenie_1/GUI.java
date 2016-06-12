package cwiczenie_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendarCombo;

import com.l2fprod.common.swing.JButtonBar;
import com.l2fprod.common.swing.JTipOfTheDay;
import com.l2fprod.common.swing.tips.DefaultTip;
import com.l2fprod.common.swing.tips.DefaultTipModel;

//Testowanie GITa

/** 
* Klasa GUI definiujaca centralny i dolny panel 
* aplikacji zawierajacy takie funkcje aplikacji jak:
* -dodawanie
* -udejmowanie
* -mno¿enie
* -dzielenie
* @author Patryk Miler	 	
* @version 1.0	16/05/2016
* -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
*/


public class GUI extends JFrame
{
	
	JPanel contenerPanel;
	JMenuBar menubar;
	JMenu Plik_JMenu, Edytuj_JMenu, Widok_JMenu, Obliczenia_JMenu, Pomoc_JMenu;
	
	JMenuItem zapisz_JMenuItem, wczytaj_JMenuItem, wyjdz_JMenuItem;
	JMenuItem dodaj_JMenuItem, wyzeruj_JMenuItem, wypelnij_JMenuItem;
	JMenuItem suma_JMenuItem, srednia_JMenuItem, max_JMenuItem, min_JMenuItem;
	JMenuItem pomoc_JMenuItem, o_autorze_JMenuItem;
	JToolBar Ikonki_Menu;
	
	JPanel info_Panel;
	JLabel info,status;
	JTextField status_aplikacji, status_uruchomienia;

	
	JTable tabelka;
	JDialog O_Autorze;
	JTextArea uzyskany_rezultat_ta;
	JSpinner nr_wiersza_sp;
	JSpinner nr_kolumny_sp;
	JTextField wprowadz_liczbe;
	JDialog Pomoc;
	
	
	JButton dodaj_btn;
	JButton wyzeruj_btn;
	JButton wypelnij_btn;
	JButton zapisz_btn;
	
	JList opcje_list;
	JList lista;
	
	
	JPanel widok_tabeli;
	JPanel widok_kalendarza;
	
	JCalendarCombo kalendarz;
	JButton oblicz_btn;
	lista_M list_m ;
	
	
	Logger logger = Logger.getLogger(GUI.class.getName());
	FileAppender logs = null;
	ConsoleAppender consLogs = new ConsoleAppender(new SimpleLayout());
	
	

	

	//static tabelka_M m;
	//Powiadomienie przy zamykaniu okna "Czy zamkn¹æ½ program?"
	
	/**
	 * Metoda odpowiedzalna za wyœwietlenie komunikatu dotycz¹cego zamkniêcia aplikacji
	 */
	private void Zamykanie_Okna()//zrobione
	{
		Object[] Przyciski_wyboru = {"Tak","Nie"};
		
		int value = JOptionPane.showOptionDialog(this, "Czy zamkn¹æ?", "Potwierdz zamkniêcie",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, Przyciski_wyboru, Przyciski_wyboru[0]);
		if(value == JOptionPane.YES_OPTION)
		{

			
			dispose();
			System.exit(0);
			
		}
		else
		{
			//nic nie rób
		}
	}
	
	
	/**
	 * Metoda ustawiaj¹ca napis "ON" w obiekcie typu JTextField
	 * @param status zmienna typu JTextField
	 */
	private void StatusON(JTextField status)
	{
		status.setText("ON");
	}
	
	
	/**
	 * Metoda ustawiaj¹ca napis "OFF" w obiekcie typu JTextField
	 * @param status zmienna typu JTextField
	 */
	private void StatusOFF(JTextField status)
	{
		status.setText("OFF");
	}
	
	
	/**
	 * Metoda ustawiaj¹ca napis "Pytanie o zamkniecie" w obiekcie typu JTextField
	 * @param info zmienna typu JTextField
	 */
	private void InfoClosing(JTextField info)
	{
		info.setText("Pytanie o zamkniecie");
	}
	
	
	/**
	 * Metoda ustawiaj¹ca napis "Start Aplikacji" w obiekcie typu JTextField
	 * @param info zmienna typu JTextField
	 */
	private void InfoOpen(JTextField info)
	{
		info.setText("Start Aplikacji");
		
		
	}
	
	
	/**
	 * Metoda ustawiaj¹ca napis "Aktywne okienko" w obiekcie typu JTextField
	 * @param info zmienna typu JTextField
	 */
	private void InfoActive(JTextField info)
	{
		info.setText("Aktywne okienko");
	}
	
	
	/**
	 * Metoda ustawiaj¹ca napis "Nie aktywne okienko" w obiekcie typu JTextField
	 * @param info zmienna typu JTextField
	 */
	private void InfoDeactive(JTextField info)
	{
		info.setText("Nie aktywne okienko");
	}
	
	
	/**
	 * Metoda ustawiaj¹ca napis "Okno zminimalizowane w obiekcie typu JTextField
	 * @param info zmienna typu JTextField
	 */
	private void InfoIconified(JTextField info)
	{
		info.setText("Okno zminimalizowane");
	}
	
	
	/**
	 * Metoda tworz¹ca obiekt typu JMenu
	 * @param nazwa zmienna okreœlaj¹ca nazwê 
	 * @param skrot_klawiszowy zmienna okreœlaj¹ca klawisz skrótu
	 * @return zwraca obiekt typu JMenu
	 */
	private JMenu Tworzenie_JMenu(String nazwa, int skrot_klawiszowy)
	{
		JMenu menu = new JMenu(nazwa);
		menu.setMnemonic(skrot_klawiszowy);
		return menu;
	}

	
	/**
	 * Metoda tworz¹ca obiekt typu JMenuItem
	 * @param nazwa zmienna okreœlaj¹ca nazwê 
	 * @return zwraca obiekt typu JMenuItem
	 */
	private JMenuItem Tworzenie_JMenuItem(String nazwa)
	{
		JMenuItem menuitem = new JMenuItem(nazwa);
		return menuitem;
	}
	
	
	/**
	 * Metoda odpowiedzalna za nadanie s³uchaczy dla wszystkich obiektów JMenuItem 
	 * które s¹ dodane do obiektu JMenu "Plik"
	 */
	private void JMenuItem_Plik()//zrobione
	{
		zapisz_JMenuItem = Tworzenie_JMenuItem("Zapisz");
		zapisz_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				zapis_pliku();
				
			}
		});
		
		wczytaj_JMenuItem = Tworzenie_JMenuItem("Otwórz");//Otwórz/Wczytaj
		wczytaj_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				odczyt_pliku();
				
			}
		});
		
		wyjdz_JMenuItem = Tworzenie_JMenuItem("Wyjdz");
		wyjdz_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Zamykanie_Okna();
				
			}
		});
		
		Plik_JMenu.add(wczytaj_JMenuItem);
		Plik_JMenu.add(zapisz_JMenuItem);
		Plik_JMenu.add(wyjdz_JMenuItem);
	}
	
	
	/**
	 * Metoda odpowiedzalna za nadanie s³uchaczy dla wszystkich obiektów JMenuItem 
	 * które bêd¹ dodane do obiektu JMenu "Edytuj"
	 */
	private void JMenuItem_Edytuj()//zrobione
	{
		dodaj_JMenuItem = Tworzenie_JMenuItem("Dodaj");
		dodaj_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
				dodaj(nr_kolumny_sp, nr_wiersza_sp, wprowadz_liczbe);
				
			}
		});
		
		
		wyzeruj_JMenuItem = Tworzenie_JMenuItem("Wyzeruj");
		wyzeruj_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
				wyzeruj(tabelka);
				
			}
		});

		
		wypelnij_JMenuItem = Tworzenie_JMenuItem("Wype³nij");
		wypelnij_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				wypelnij(tabelka, wprowadz_liczbe);
				
			}
		});
		
		
		Edytuj_JMenu.add(dodaj_JMenuItem);
		Edytuj_JMenu.add(wyzeruj_JMenuItem);
		Edytuj_JMenu.add(wypelnij_JMenuItem);
		
	}
	
	
	/**
	 * Metoda odpowiedzalna za nadanie s³uchaczy dla wszystkich obiektów w JMenuItem 
	 * które bêd¹ dodane do obiektu JMenu "Obliczenia"
	 */
	private void JMenuItem_Obliczenia()//zrobione
	{
		suma_JMenuItem = Tworzenie_JMenuItem("Suma liczb");
		suma_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				suma_elementow(tabelka);
				
			}
		});
		
		
		srednia_JMenuItem = Tworzenie_JMenuItem("Œrednia liczb");
		srednia_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				srednia_elementow(tabelka, uzyskany_rezultat_ta);
				
			}
		});
		
		
		min_JMenuItem = Tworzenie_JMenuItem("Minimalna liczba ze zbioru liczb");
		min_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				minimum(tabelka, uzyskany_rezultat_ta);
				
			}
		});
		
		
		max_JMenuItem = Tworzenie_JMenuItem("Maksymalna liczba ze zbioru liczb");
		max_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				maksimum(tabelka, uzyskany_rezultat_ta);
				
			}
		});

		
		Obliczenia_JMenu.add(suma_JMenuItem);
		Obliczenia_JMenu.add(srednia_JMenuItem);
		Obliczenia_JMenu.add(min_JMenuItem);
		Obliczenia_JMenu.add(max_JMenuItem);
	}
	
	
	/**
	 * Metoda odpowiedzalna za nadanie s³uchaczy dla wszystkich obiektów w JMenuItem 
	 * które bêd¹ dodane do obiektu JMenu "Pomoc"
	 */
	private void JMenuItem_Pomoc()
	{
		o_autorze_JMenuItem = Tworzenie_JMenuItem("O Autorze");
		o_autorze_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				O_Autorze.setVisible(true);
				
			}
			
		});
		pomoc_JMenuItem = Tworzenie_JMenuItem("Pomoc");
		pomoc_JMenuItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Pomoc.setVisible(true);
				
			}
		});
		Pomoc_JMenu.add(o_autorze_JMenuItem);
		Pomoc_JMenu.add(pomoc_JMenuItem);
		//sluchacz();
	}
	
	
	/**
	 * Metoda tworz¹ca obiekt typu JButtonBar i JToggleButton. 
	 * @return zwraca obiekt typu JButtonBar
	 */
	private JButtonBar panel_nawigacyjny_jbb()
	{
		JButtonBar btnBar = new JButtonBar();
		ButtonGroup btnGroup = new ButtonGroup();
		JToggleButton kaneldarz_btn = new JToggleButton("Kaneldarz",new ImageIcon("kalendarz.png"));
		//ikonki kalendarz: https://www.iconfinder.com/icons/173169/calendar_icon#size=64
		JToggleButton tabela_btn = new JToggleButton("Tabela",new ImageIcon("tabelka.png"));
		// ikonki tabela: https://www.iconfinder.com/icons/8898/document_excel_spreadsheet_table_icon#size=64

		tabela_btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				widok_tabeli.setVisible(true);
				widok_kalendarza.setVisible(false);

			}
		});
		
		kaneldarz_btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				widok_tabeli.setVisible(false);
				widok_kalendarza.setVisible(true);

			}
		});
		
		btnBar.setBounds(13, 10, 100, 210);
		btnBar.setOrientation(JButtonBar.VERTICAL);
		

		btnBar.add(tabela_btn);
		btnGroup.add(tabela_btn);

		btnBar.add(kaneldarz_btn);
		btnGroup.add(kaneldarz_btn);
		
		btnBar.setVisible(true);
		return btnBar;
	}
	
	
	/**
	 * Metoda tworz¹ca obiekt typu JCalendarCombo. 
	 * @param zapisz_do_jta do zmiennej bêd¹ wyœwietlane komunikaty podczas zmiany daty
	 * @return zwraca obiekt typu JCalendarCombo
	 */
	private JCalendarCombo utworz_kalendarz(final JTextArea zapisz_do_jta)
	{
		kalendarz = new JCalendarCombo();
		kalendarz.addDateListener(new DateListener() 
		{
			public void dateChanged(DateEvent arg0) 
			{
				
				Calendar cal = kalendarz.getCalendar();
				String data = ""+cal.get(Calendar.YEAR)+"-";
				int miesiac = cal.get(Calendar.MONTH)+1;
				
				if(miesiac <= 9) data = data+"0"+String.valueOf(miesiac)+"-"; 
					else data = data+String.valueOf(miesiac)+"-";	
				int dzien = cal.get(Calendar.DAY_OF_MONTH);
				
				if(dzien <= 9) data = data+"0"+String.valueOf(dzien);
					else data = data+String.valueOf(dzien);
				
				// zapisanie danych w polu TextArea
				
				zapisz_do_jta.append("Data: "+data+"\n");
				
			}
		});
		kalendarz.setBounds(265, 105, 90, 20);
		kalendarz.setVisible(true);
		kalendarz.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
	
		return kalendarz;
	}
	
	
	/**
	 * Metoda tworz¹ca porady dnia.
	 */
	private void porady_dnia()
	{

		DefaultTipModel spis_porad = new DefaultTipModel();
		//aby dodaæ poradê robimy tak
		spis_porad.add(new DefaultTip("Porada 1","Porada nr 1"));
		spis_porad.add(new DefaultTip("Porada 2","Porada nr 2"));
		spis_porad.add(new DefaultTip("Porada 3","Porada nr 3"));
		//i tak do n-porad, potem musimy spis podaæ jako parametr w tworzonym obiekcie
		JTipOfTheDay porady = new JTipOfTheDay(spis_porad);
		//potem pozostaje nam pokazanie tego obiektu
		porady.showDialog(this);
	}
	
	
	/**
	 * Metoda tworz¹ca obiekt typu JButton oraz zadanie jemu s³uchacza. 
	 * @return zwraca obiekt typu JButton
	 */
	private JButton obliczenia()
	{
		oblicz_btn = new JButton();
		oblicz_btn.setText("Oblicz");
		Icon oblicz = new ImageIcon("ikonka8.jpg");
		oblicz_btn.setIcon(oblicz);
		oblicz_btn.setBounds(300, 180, 110, 25);
		try
		{
			oblicz_btn.addMouseListener(new MouseAdapter() 
			{	
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					
					int wybor;

						wybor = opcje_list.getSelectedIndex();
						
						switch (wybor) 
						{		                
			            case 1: 
			            	suma_elementow(tabelka);
			            	//uzyskany_rezultat_ta.append("Suma elementów wynosi: "+suma_elementow(tabelka)+"\n");
			                break;
			                     
			            case 2:
			            	srednia_elementow(tabelka,uzyskany_rezultat_ta);
			            	//uzyskany_rezultat_ta.append("Œrednia elementów wynosi: "+srednia_elementow(tabelka)+"\n");
			                break;
			                
			            case 3:
			            	maksimum(tabelka, uzyskany_rezultat_ta);
			            	//uzyskany_rezultat_ta.append("Najwiêksza wartoœæ wynosi: "++"\n");
			                break;
			                
			            case 4:
			            	minimum(tabelka, uzyskany_rezultat_ta);
			            	//uzyskany_rezultat_ta.append("Najmniejsza wartoœæ wynosi: "+minimum(tabelka)+"\n");
			                break;
			                     
			            default: 
			            //	JOptionPane.showMessageDialog(this, "Nie ma takiej opcji", "Ups", JOptionPane.INFORMATION_MESSAGE);
			                break;
						}
					

					
					
				}
			});
		}
		catch(Exception ex)
		{
		
			
			JOptionPane.showMessageDialog(this, ex, "Ups", JOptionPane.OK_OPTION);
		}
		
		return oblicz_btn;
	}
	
	
	/**
	 * Metoda tworz¹ca GUI ca³ej aplikacji. 
	 * @param m obiekt który przechowuje funkcje tabeli utworzonej w aplkacji.
	 */
	private void utworz(tabelka_M m)//zrobione
	{
	
		
		menubar = new JMenuBar();		
		this.setJMenuBar(menubar);
		
		Plik_JMenu = Tworzenie_JMenu("Plik",80);
		menubar.add(Plik_JMenu);
		JMenuItem_Plik();
		
		Edytuj_JMenu = Tworzenie_JMenu("Edytuj", 69);//wywo³uje metode która uwtorzy obiekt JMenu pod nazw¹ "Edytuj" ze skrótem klawiszowym ca³oœæ zapisuje w obiekcie "Edytuj_JMenu"
		menubar.add(Edytuj_JMenu);//dodaje do "JMenuBar" obiekt "Edytuj_JMenu"
		JMenuItem_Edytuj();
		
		
		Obliczenia_JMenu = Tworzenie_JMenu("Obliczenia", 79);//wywo³uje metode która uwtorzy obiekt JMenu pod nazw¹ "Edytuj" ze skrótem klawiszowym ca³oœæ zapisuje w obiekcie "Edytuj_JMenu"
		menubar.add(Obliczenia_JMenu);//dodaje do "JMenuBar" obiekt "Edytuj_JMenu"
		JMenuItem_Obliczenia();
		
		Pomoc_JMenu = Tworzenie_JMenu("Pomoc", 67);
		menubar.add(Pomoc_JMenu);
		JMenuItem_Pomoc();
		
		
		O_Autorze();
		Pomoc = new JDialog();
		Pomoc.setTitle("Pomoc");
		Pomoc.setLocationRelativeTo(null);
		Pomoc.setSize(390, 360);
		JPanel aaa = new JPanel();
		aaa = (JPanel)Pomoc.getContentPane();
		aaa.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(160, 10, 200, 300);
		final JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setLineWrap(true);
		scrollPane_2.setViewportView(text);
		aaa.add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 150, 300);
	//	String Opcje[] = {"Suma", Œrednia", "Min", "Max"};
		List<String> dane_do_listyy = new ArrayList<String>();
		dane_do_listyy.add("Suma");
		dane_do_listyy.add("Œrednia");
		dane_do_listyy.add("Min");
		dane_do_listyy.add("Max");
		
		list_m = new lista_M(dane_do_listyy);
		lista = new JList(list_m);
		//lista.setSelectedIndex(0);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(lista);
		
		lista.addMouseListener(new MouseAdapter() 
		{
						
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{System.out.println(" "+lista.getSelectedIndex());
			
				if(lista.getSelectedIndex() == 0)
				{
					
					text.setText("Suma dodaje do siebie 25 elementów");
				}
				else if(lista.getSelectedIndex() == 1)
				{
					text.setText("Œrednia dodaje do siebie 25 elementów i dzieli przez iloœæ liczb");
				}
				else if(lista.getSelectedIndex() == 2)
				{
					text.setText("Min przeszukuje zbiór w celu znalezienai najmniejszej wartoœci");
				}
				else if(lista.getSelectedIndex() == 3)
				{
					text.setText("Max przeszukuje zbiór w celu znalezienai najwiêkszej wartoœci");
				}
				
			}
		});
		aaa.add(scrollPane_1);
		
		porady_dnia();

		
		Ikonki_Menu = new JToolBar("Pasek narzêdziowy");
		
		
		
		GUI_ikonki_toolbar();//metoda tworz¹ca ikonki w toolbarze
		
		contenerPanel.add(Ikonki_Menu,BorderLayout.NORTH);
		
		JPanel srodkowy_layout = new JPanel();
		srodkowy_layout.setLayout(null);
	
		
		srodkowy_layout.add(panel_nawigacyjny_jbb());
		
		JLabel qwerty = new JLabel();
		qwerty.setText("Wprowadz liczbê");
		qwerty.setBounds(10, 20, 100, 20);//lewo, góra
		//srodkowy_layout.add(qwerty);
		
		
		
		
		
		wprowadz_liczbe = new JTextField();
		wprowadz_liczbe.setBounds(115, 20, 90, 20);
		wprowadz_liczbe.setText("0");
		//srodkowy_layout.add(wprowadz_liczbe);		xqw
		
		JLabel nr_wiersza_lbl = new JLabel();
		nr_wiersza_lbl.setText("Numer wiersza");
		nr_wiersza_lbl.setBounds(240, 20, 90, 20);
		//srodkowy_layout.add(nr_wiersza_lbl);	xqw
		
		nr_wiersza_sp = new JSpinner();
		nr_wiersza_sp.setValue(1);
		nr_wiersza_sp.setBounds(330, 20, 70, 20);
		nr_wiersza_sp.addChangeListener(new ChangeListener() 
		{
			@Override
			public void stateChanged(ChangeEvent arg0) 
			{
				//aby u¿ytkownik nie móg³½ wpisaæ wartoœci do wiersza 0 i mniejszej
				int liczba = Integer.parseInt(nr_wiersza_sp.getValue().toString());
				if(liczba <= 0)
				{
					nr_wiersza_sp.setValue(1);
				}
				else if(liczba >5)
				{
					nr_wiersza_sp.setValue(5);
				}
				
			}
		});
		//srodkowy_layout.add(nr_wiersza_sp);	xqw
		
		JLabel nr_kolumny_lbl = new JLabel();
		nr_kolumny_lbl.setText("Numer kolumny");
		nr_kolumny_lbl.setBounds(430, 20, 90, 20);
		//srodkowy_layout.add(nr_kolumny_lbl);	xqw
		
		nr_kolumny_sp = new JSpinner();
		nr_kolumny_sp.setValue(1);
		nr_kolumny_sp.setBounds(525, 20, 70, 20);
		nr_kolumny_sp.addChangeListener(new ChangeListener() 
		{
			@Override
			public void stateChanged(ChangeEvent arg0) 
			{
				//aby u¿ytkownik nie móg³ wpisaæ wartoœci do kolumny 0 i mniejszej
				int liczba = Integer.parseInt(nr_kolumny_sp.getValue().toString());
				if(liczba <= 0)
				{
					nr_kolumny_sp.setValue(1);
				}
				else if(liczba >5)
				{
					nr_kolumny_sp.setValue(5);
				}
				
			}
		});
		//srodkowy_layout.add(nr_kolumny_sp);	xqw
		
		tabelka = new JTable(m);
		tabelka.setPreferredScrollableViewportSize(new Dimension(300, 200));
		tabelka.setBounds(10, 60, 480, 100);
		//JScrollPane jscrlp = new JScrollPane(tabelka);
		tabelka.setBorder(BorderFactory.createLineBorder(Color.gray));
		//srodkowy_layout.add(tabelka);	xqw
		
		//btn dodaj z ikonk¹
		//JButton dodaj_btn = new JButton();
		dodaj_btn = new JButton();
		dodaj_btn.setText("Dodaj");
		Icon dodaj = new ImageIcon("ikonka4.jpg");
		dodaj_btn.setIcon(dodaj);//ikonka 
		dodaj_btn.setBounds(500, 60, 105, 25);
		//srodkowy_layout.add(dodaj_btn);	xqw
		
		
		
		
		//btn wyzeruj z ikonk¹
		wyzeruj_btn = new JButton();
		wyzeruj_btn.setText("Wyzeruj");
		Icon wyzeruj = new ImageIcon("ikonka5.jpg");
		wyzeruj_btn.setIcon(wyzeruj);//ikonka 
		wyzeruj_btn.setBounds(500, 90, 105, 25);
		//srodkowy_layout.add(wyzeruj_btn);	xqw
		
		
		
		
		//btn wype³nij z ikonk¹
		wypelnij_btn = new JButton();
		wypelnij_btn.setText("Wype³nij");
		Icon wypelnij = new ImageIcon("ikonka6.jpg");
		wypelnij_btn.setIcon(wypelnij);//ikonka 
		wypelnij_btn.setBounds(500, 120, 105, 25);
		//srodkowy_layout.add(wypelnij_btn);	xqw
		
		//btn zapisz z ikonk¹
		zapisz_btn = new JButton();
		zapisz_btn.setText("Zapisz");
		Icon zapisz = new ImageIcon("ikonka1.jpg");
		zapisz_btn.setIcon(zapisz);//ikonka 
		zapisz_btn.setBounds(500, 150, 105, 25);
		//srodkowy_layout.add(zapisz_btn);	xqw
		
		//lbl oblicz
		JLabel obliczenia_lbl = new JLabel();
		obliczenia_lbl.setText("Obliczenia");
		obliczenia_lbl.setBounds(20, 180, 100, 20);
		//srodkowy_layout.add(obliczenia_lbl);	xqw
		
		JScrollPane opcja_scrlp = new JScrollPane();
		/*String[] nazwy = {"Wybierz opcjê",
				"Suma elementów",
				"Œrednia elementów",
				"Wartoœæ max",
				"Wartoœæ min"};*/
		
		List<String> dane_do_listy = new ArrayList<String>();
		dane_do_listy.add("Wybierz opcjê");
		dane_do_listy.add("Suma elementów");
		dane_do_listy.add("Œrednia elementów");
		dane_do_listy.add("Wartoœæ max");
		dane_do_listy.add("Wartoœæ min");
		
		lista_M listm = new lista_M(dane_do_listy);
		opcje_list = new JList(listm);
		
		opcje_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		opcje_list.setSelectedIndex(0);
		opcja_scrlp.setViewportView(opcje_list);
		opcja_scrlp.setBounds(90, 180, 200, 25);
		//srodkowy_layout.add(opcja_scrlp);		xqw
		
		
		JScrollPane uzyskany_rezultat_scrlp = new JScrollPane();
		//final JTextArea uzyskany_rezultat_ta = new JTextArea();
		uzyskany_rezultat_ta = new JTextArea();
		uzyskany_rezultat_scrlp.setViewportView(uzyskany_rezultat_ta);
		//uzyskany_rezultat_ta.setBounds(10, 220, 595, 100);
		uzyskany_rezultat_scrlp.setBounds(10, 220, 730, 150);
		Border lineborder;
		TitledBorder title;
		lineborder = BorderFactory.createLineBorder(Color.gray);
		title = BorderFactory.createTitledBorder(lineborder, "Uzyskany rezultat");
		title.setTitleJustification(TitledBorder.CENTER);
		//uzyskany_rezultat_ta.setBorder(title);
		uzyskany_rezultat_scrlp.setBorder(title);
		//abc.add(uzyskany_rezultat_ta);
		srodkowy_layout.add(uzyskany_rezultat_scrlp);		
		
		
		
		
		//srodkowy_layout.add(oblicz_btn);		xqw
		
		widok_tabeli = new JPanel();
		widok_tabeli.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		widok_tabeli.setBounds(120, 10, 620, 210);
		widok_tabeli.setLayout(null);
		widok_tabeli.setVisible(true);
		widok_tabeli.add(qwerty);
		widok_tabeli.add(nr_wiersza_lbl);
		widok_tabeli.add(nr_wiersza_sp);
		widok_tabeli.add(nr_kolumny_lbl);
		widok_tabeli.add(nr_kolumny_sp);
		widok_tabeli.add(tabelka);
		widok_tabeli.add(dodaj_btn);
		widok_tabeli.add(wyzeruj_btn);
		widok_tabeli.add(wypelnij_btn);
		widok_tabeli.add(zapisz_btn);
		widok_tabeli.add(obliczenia_lbl);
		widok_tabeli.add(opcja_scrlp);
		widok_tabeli.add(wprowadz_liczbe);	
		//widok_tabeli.add(uzyskany_rezultat_scrlp);
		widok_tabeli.add(obliczenia());
		srodkowy_layout.add(widok_tabeli);
		
		
		widok_kalendarza = new JPanel();
		widok_kalendarza.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		widok_kalendarza.setBounds(120, 10, 620, 210);
		widok_kalendarza.setLayout(null);
		widok_kalendarza.setVisible(false);
		widok_kalendarza.add(utworz_kalendarz(uzyskany_rezultat_ta));
		srodkowy_layout.add(widok_kalendarza);
		
		contenerPanel.add(srodkowy_layout, BorderLayout.CENTER);
		
	}
	
	
	/**
	 * Metoda tworz¹ca dolny panel aplikacji.
	 */
	private void info_panel()//zrobione
	{
		info_Panel = new JPanel();		
		info_Panel.setBackground(Color.GRAY);
		//layout default czyli flowlayout
		info = new JLabel("Info");
		status = new JLabel("Status");
		
		contenerPanel.add(info_Panel,BorderLayout.SOUTH);//dodanie obiektu 'przycisk1' do kontenera na dole okienka
														//tutaj bêdzie 'INFO PROGRAMU'
		status_aplikacji = new JTextField();
		status_aplikacji.setSize(300, 25);
		status_aplikacji.setColumns(20);
		status_aplikacji.setEditable(false);
		
		status_uruchomienia = new JTextField();
		status_uruchomienia.setSize(300, 25);
		status_uruchomienia.setColumns(20);
		status_uruchomienia.setEditable(false);
		
		info_Panel.add(info);
		info_Panel.add(status_aplikacji);
		info_Panel.add(status);
		info_Panel.add(status_uruchomienia);
		
		
	}
	
	
	/**
	 * Metoda tworz¹ca toolbar 
	 */
	private void GUI_ikonki_toolbar()//zrobione
	{
		JButton okienko1 = new JButton();
		Icon zapisz = new ImageIcon("ikonka1.jpg");
		okienko1.setIcon(zapisz);
		okienko1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				zapis_pliku();
				
			}
		});
		
		JButton okienko2 = new JButton();
		Icon wczytaj = new ImageIcon("ikonka2.jpg");
		okienko2.setIcon(wczytaj);
		okienko2.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				odczyt_pliku();
				
			}
		});
		
		JButton okienko3 = new JButton();
		Icon wyjdz = new ImageIcon("ikonka3.jpg");
		okienko3.setIcon(wyjdz);
		okienko3.addMouseListener(new MouseAdapter() 
		{			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				Zamykanie_Okna();
				
			}
		});
		
		
		JButton okienko4 = new JButton();
		Icon dodaj = new ImageIcon("ikonka4.jpg");
		okienko4.setIcon(dodaj);
		okienko4.addMouseListener(new MouseAdapter() 
		{			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
				dodaj(nr_kolumny_sp, nr_wiersza_sp, wprowadz_liczbe);
				
			}
		});
		
		JButton okienko5 = new JButton();
		Icon wyzeruj = new ImageIcon("ikonka5.jpg");
		okienko5.setIcon(wyzeruj);
		okienko5.addMouseListener(new MouseAdapter() 
		{			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
			
				wyzeruj(tabelka);
				
			}
		});
		
		JButton okienko6 = new JButton();
		Icon wypelnij = new ImageIcon("ikonka6.jpg");
		okienko6.setIcon(wypelnij);
		okienko6.addMouseListener(new MouseAdapter() 
		{			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				wypelnij(tabelka, wprowadz_liczbe);
				
			}
		});
		
		JButton okienko7 = new JButton();
		Icon suma = new ImageIcon("ikonka7.jpg");
		okienko7.setIcon(suma);
		okienko7.addMouseListener(new MouseAdapter() 
		{			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				suma_elementow(tabelka);
				
			}
		});
		
		JButton okienko8 = new JButton();
		Icon oblicz = new ImageIcon("ikonka8.jpg");
		okienko8.setIcon(oblicz);
		okienko8.addMouseListener(new MouseAdapter() 
		{			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				srednia_elementow(tabelka,uzyskany_rezultat_ta);
				
			}
		});
		
		JButton okienko9 = new JButton();
		Icon min = new ImageIcon("ikonka9.jpg");
		okienko9.setIcon(min);
		okienko9.addMouseListener(new MouseAdapter() 
		{			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				minimum(tabelka,uzyskany_rezultat_ta);
				
			}
		});
		
		JButton okienko10 = new JButton();
		Icon max = new ImageIcon("ikonka10.jpg");
		okienko10.setIcon(max);
		okienko10.addMouseListener(new MouseAdapter() 
		{			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				maksimum(tabelka,uzyskany_rezultat_ta);
				
			}
		});
		
		JButton okienko11 = new JButton();
		Icon pomoc = new ImageIcon("ikonka11.jpg");
		okienko11.setIcon(pomoc);
		okienko11.addMouseListener(new MouseAdapter() 
		{			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				O_Autorze.setVisible(true);
				O_Autorze();
				
			}
		});
		
		JButton okienko12 = new JButton();
		Icon info = new ImageIcon("ikonka12.jpg");
		okienko12.setIcon(info);
		okienko12.addMouseListener(new MouseAdapter() 
		{			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				Pomoc.setVisible(true);
				//Pomoc();
				
			}
		});
		
		Ikonki_Menu.add(Box.createHorizontalStrut(5));//odstêp
		Ikonki_Menu.add(okienko1);//dodanie przycisku
		Ikonki_Menu.add(okienko2);//dodanie przycisku
		Ikonki_Menu.add(okienko3);//dodanie przycisku
		Ikonki_Menu.add(Box.createHorizontalStrut(10));
		Ikonki_Menu.add(okienko4);//dodanie przycisku
		Ikonki_Menu.add(okienko5);//dodanie przycisku
		Ikonki_Menu.add(okienko6);//dodanie przycisku
		Ikonki_Menu.add(Box.createHorizontalStrut(10));
		Ikonki_Menu.add(okienko7);//dodanie przycisku
		Ikonki_Menu.add(okienko8);//dodanie przycisku
		Ikonki_Menu.add(okienko9);//dodanie przycisku
		Ikonki_Menu.add(okienko10);//dodanie przycisku
		Ikonki_Menu.add(Box.createHorizontalStrut(10));
		Ikonki_Menu.add(okienko11);//dodanie przycisku
		Ikonki_Menu.add(okienko12);//dodanie przycisku
		Ikonki_Menu.setFloatable(false);//nie mo¿na swobodnie tego paska narzêdziowego przemieszczaæ
	}
		
	
	/**
	 * Metoda odpowiedzalna za wyœwietlanie informacji o autorze 
	 */
	private void O_Autorze()//zrobione
	{
		O_Autorze = new JDialog();
		O_Autorze.setTitle("O autorze");
		O_Autorze.setLocationRelativeTo(null);
		O_Autorze.setSize(300, 300);
		JPanel aaa = new JPanel();
		aaa = (JPanel)O_Autorze.getContentPane();
		BoxLayout grid = new BoxLayout(aaa,BoxLayout.PAGE_AXIS);
		aaa.setLayout(grid);
		aaa.setBorder(BorderFactory.createEmptyBorder(170,10,10,10));
		aaa.add(new JLabel("Program: Projekt cw 1"));
		aaa.add(new JLabel("Wersja programu: v1.0"));
		aaa.add(new JLabel("Wykonawca: Patryk Miler"));
		aaa.add(new JLabel("Kontakt: miler.patryk@gmail.com"));
		aaa.add(new JLabel("Licencja: Freeware"));
		O_Autorze.addWindowListener(new WindowAdapter() 
		{		
			@SuppressWarnings("deprecation")
			@Override
			public void windowClosed(WindowEvent arg0) 
			{
				disable();
			}
		});		
	}
	

	/**
	 * Metoda odpowiedzalna za obliczenie sumy elementów znajduj¹cych sie w tabeli
	 * @param tabelka obiekt typu JTable okreœla z jakiej tabeli bêd¹ liczone sumy elementów
	 * @return zwraca wynik sumy elementów jako typ int
	 */
	private int suma_elementoww(JTable tabelka)//zrobione
	{
		int wynik = 0;
		try
		{
			
			for(int i =1; i < tabelka.getRowCount(); i++)
			{
				for(int j = 0; j < tabelka.getColumnCount(); j++)
				{
					wynik = wynik + Integer.parseInt(tabelka.getValueAt(i, j).toString());
					
				}
			}
			
		}
		catch(Exception ex)
		{
			
			
			JOptionPane.showMessageDialog(this, ex, "Ups", JOptionPane.OK_OPTION);
		}
		return wynik;
	}
	
	
	/**
	 * Metoda odpowiedzalna za wyœwietlenie rezultatu sumy elementów w obiekcie typu JTextArea
	 * @param tabelka obiekt typu JTable okreœla z jakiej tabeli bêd¹ liczone sumy elementów
	 */
	private void suma_elementow(JTable tabelka)//zrobione
	{
		uzyskany_rezultat_ta.append("Suma elementï¿½w wynosi: "+suma_elementoww( tabelka)+"\n");
	}
	
	
	/**
	 * Metoda odpowiedzalna za obliczenie œredniej elementów znajduj¹cych siê w tabeli
	 * @param tabelka obiekt typu JTable okreœla z jakiej tabeli bêdzie liczona œrednia
	 * @param uzyskany_rezultat_ta typu JTextArea okreœla gdzie zostanie wyœwietlony wynik
	 */
	private void srednia_elementow(JTable tabelka, JTextArea uzyskany_rezultat_ta)//zrobione
	{
		double wynik = 0;
		double wynik_double = 0;
		int ilosc_elementow = 0;
		try
		{
			wynik = suma_elementoww(tabelka);
			ilosc_elementow = (tabelka.getRowCount()-1) * tabelka.getColumnCount();//bo jeden rz¹d jest na nazwe kolumny 1,2,3...
			wynik_double = wynik/ilosc_elementow;
			uzyskany_rezultat_ta.append("Œrednia elementów wynosi: "+wynik_double+"\n");
		}
		catch(Exception ex)
		{
			
			
			JOptionPane.showMessageDialog(this, ex, "Ups", JOptionPane.OK_OPTION);
		}
		
	}
	
	
	/**
	 * Metoda odpowiedzalna za obliczenie minimalnego elementu znajduj¹cego siê w tabeli
	 * @param tabelka obiekt typu JTable okreœla z jakiej tabeli bêdzie szukaæ minimum
	 * @param uzyskany_rezultat_ta typu JTextArea okreœla gdzie zostanie wyœwietlony wynik
	 */
	private void minimum(JTable tabelka, JTextArea uzyskany_rezultat_ta)//zrobione
	{
		int najmniejsza_wartosc = 0;
		int liczba = 0;
		try
		{
			najmniejsza_wartosc = Integer.parseInt(tabelka.getValueAt(1, 0).toString());
			
			for(int i =1 ; i < tabelka.getRowCount();i++)
			{
				for(int j = 0; j < tabelka.getColumnCount(); j++)
				{
					liczba = Integer.parseInt(tabelka.getValueAt(i, j).toString());
					if(liczba < najmniejsza_wartosc)
					{
						najmniejsza_wartosc = liczba;
					}
				}
			}
			uzyskany_rezultat_ta.append("Wartoœæ min wynosi: "+najmniejsza_wartosc+"\n");
		}
		catch(Exception ex)
		{
			
			
			JOptionPane.showMessageDialog(this, ex, "Ups", JOptionPane.OK_OPTION);
		}
		
		
	}
	
	
	/**
	 * Metoda odpowiedzalna za obliczenie maksymalnego elementu znajduj¹cego siê w tabeli
	 * @param tabelka obiekt typu JTable okreœla z jakiej tabeli bêdzie szukaæ maksimum
	 * @param uzyskany_rezultat_ta typu JTextArea okreœla gdzie zostanie wyœwietlony wynik
	 */
	private void maksimum(JTable tabelka, JTextArea uzyskany_rezultat_ta)//zrobione
	{
		int najwieksza_wartosc = 0;
		int liczba = 0;
		
		try
		{
			najwieksza_wartosc = Integer.parseInt(tabelka.getValueAt(1, 0).toString());
			
			for(int i =1 ; i < tabelka.getRowCount();i++)
			{
				for(int j = 0; j < tabelka.getColumnCount(); j++)
				{
					liczba = Integer.parseInt(tabelka.getValueAt(i, j).toString());
					if(liczba > najwieksza_wartosc)
					{
						najwieksza_wartosc = liczba;
					}
				}
			}
			uzyskany_rezultat_ta.append("Wartoœæ max wynosi: "+najwieksza_wartosc+"\n");
		}
		catch(Exception ex)
		{
			
			
			JOptionPane.showMessageDialog(this, ex, "Ups", JOptionPane.OK_OPTION);
		}

	}
	
	
	/**
	 * Metoda odppwiedzalna za wprowadzenie liczby do tabeli
	 * @param nr_kolumny_sp obiekt typu JSpinner okreœla do jakiej kolumny bêdzie dodana liczba
	 * @param nr_wiersza_sp obiekt typu JSpinner okreœla do jakiego wierszu bêdzie dodana liczba
	 */
	private void dodaj(JSpinner nr_kolumny_sp, JSpinner nr_wiersza_sp, JTextField wprowadz_liczbe)//zrobione
	{
		String odczyt_kolumny;
		String odczyt_wiersza;
		Integer liczba;
		odczyt_kolumny = nr_kolumny_sp.getValue().toString();
		odczyt_wiersza = nr_wiersza_sp.getValue().toString();
		try
		{
			liczba = Integer.parseInt(wprowadz_liczbe.getText());
			tabelka.setValueAt(liczba.toString(), Integer.valueOf(odczyt_wiersza.toString()), Integer.valueOf(odczyt_kolumny.toString())-1);
		}
		catch(Exception ex)
		{
			
			
			JOptionPane.showMessageDialog(this, ex, "Ups", JOptionPane.OK_OPTION);
		}
	}
	
	
	/**
	 * Metoda odpwiedzalna za dodanie s³uchacza do przycisku "dodaj_btn" 
	 * odpowiedzalnego za dodanie liczby
	 * @param arg0 argument typu ActionListener
	 */	
	public void dodaj_do_tabeli_jbn(ActionListener arg0)//zrobione
	{
		dodaj_btn.addActionListener(arg0);
	}
	
	
	/**
	 * Metoda odpwiedzalna wyzerowanie ca³ej tabeli
	 * @param tabelka obiekt typu JTable okreœla która tabela bêdzie wyzerowana
	 */
	private void wyzeruj(JTable tabelka)//zrobione
	{
		for(int i =1; i < tabelka.getRowCount(); i++)
		{
			for(int j = 0; j < tabelka.getColumnCount(); j++)
			{
				tabelka.setValueAt("0", Integer.valueOf(i), Integer.valueOf(j));
			}
		}
	}
	
	
	/**
	 * Metoda odpowiedzalna za dodanie s³uchacza do przycisku "wyzeruj_btn"
	 * odpowiedzalnego za wyzerowanie tabeli
	 * @param arg0 argument typu ActionListener
	 */
	public void wyzeruj_do_tabeli_jbn(ActionListener arg0)//zrobione
	{
		wyzeruj_btn.addActionListener(arg0);
	}
	
	
	/**
	 * Metoda odpwiedzalna za dodanie s³uchacza do przycisku "wypelnij_btn"
	 * odpowiedzalnego za wype³nienie tabeli
	 * @param arg0 argument typu ActionListener
	 */
	public void wypelnij_do_tabeli_jbn(ActionListener arg0)//zrobione
	{
		wypelnij_btn.addActionListener(arg0);
	}
	
	
	/**
	 * Metoda odpwiedzalna za dodanie s³uchacza do przycisku "zapisz_btn"
	 * odpowiedzalnego za zapisanie wartoœci tabeli do pliku typu .txt
	 * @param arg0 argument typu ActionListener
	 */
	public void zapis_do_tabeli_jbn(ActionListener arg0)
	{
		zapisz_btn.addActionListener(arg0);
	}
	
	
	/**
	 * Metoda odpwiedzalna wype³nienie ca³ej tabeli podan¹ liczb¹
	 * @param tabelka obiekt typu JTable okreœla do której tabeli ma zapisaæ liczby
	 * @param wprowadz_liczbe obiekt typu JTextField okreœla jaka liczba zostanie wprowadzona
	 */
	private void wypelnij(JTable tabelka, JTextField wprowadz_liczbe)//zrobione
	{
		try
		{
			for(int i =1; i < tabelka.getRowCount(); i++)
			{
				for(int j = 0; j < tabelka.getColumnCount(); j++)
				{
					tabelka.setValueAt(Integer.parseInt(wprowadz_liczbe.getText()), Integer.valueOf(i), Integer.valueOf(j));
				}
				
			}
		}
		catch(Exception ex)
		{
			
			
			JOptionPane.showMessageDialog(this, ex, "Ups", JOptionPane.OK_OPTION);
			
		}
		
			//
		
	}	
	
	
	/**
	 * Metoda odpowiedzalna za wczytanie z pliku typu .txt wartoœci do tabeli
	 */
	private void odczyt_pliku()//zrobione
	{
		JFileChooser fileChooser = new JFileChooser();
		//fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);//albo this albo null
		if (result == JFileChooser.APPROVE_OPTION) 
		{
		    File selectedFile = fileChooser.getSelectedFile();		    
		    try
		    {
		      BufferedReader reader = new BufferedReader(new FileReader(selectedFile.getAbsolutePath()));
		      String line;
		      int wiersz = 1;
		      int kolumna = 0;
		      while ((line = reader.readLine()) != null)
		      {
		    	  if(kolumna == 5)
		    	  {
		    		  wiersz++;
		    		  kolumna = 0;
		    	  }
		    	  tabelka.setValueAt(line, wiersz, kolumna);
		    	  kolumna++;
		      }
		      reader.close(); 
		    }
		    catch (Exception ex)
		    {
		    	
		    	
		    	JOptionPane.showMessageDialog(this, ex, "Ups", JOptionPane.OK_OPTION);
		    }
		}
	}
	
	
	/**
	 * Metoda odpwiedzalna za zapisanie wartoœci tabeli do pliku typu .txt
	 */
	private void zapis_pliku()//zrobione
	{
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("pliki txt(*.txt)", "txt");
		fileChooser.addChoosableFileFilter(txtFilter);
		fileChooser.setFileFilter(txtFilter);
		
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) 
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
						out.write(tabelka.getValueAt(i, j).toString());
						out.newLine();
					}
				}
	            out.close();

	            JOptionPane.showMessageDialog(this, "Dane zosta³y zapisane do pliku pod nazw¹ "+sciezka_pliku, "Zapisz", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception ex)
			{
				
				
				JOptionPane.showMessageDialog(this, ex, "Ups", JOptionPane.OK_OPTION);
			}
		}
	}
	
	
	/**
	 * Konstruktor odpowiedzalny za utworzenie obiektu typu JFrame oraz 
	 * wywo³anie funkcji "utworz()" tworz¹cej GUI(Graficzny Interfejs U¿ytkownika)
	 * 
	 */
	public GUI(final tabelka_M m)//konstruktor
	{
		//Layout, do pliku z logami
		PatternLayout patternLayout = new PatternLayout("%-5p : %d %m%n");
		
		//Przypisanie layoutu i pliku do zmiennej logs
		try {
			logs = new FileAppender(patternLayout,"logs.log");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		//Dodanie zmiennych logs, consLogs do loggera
		logger.addAppender(logs);
		logger.addAppender(consLogs);
		//Ustawienie poziomu komunikatu do informacji
		logger.setLevel(Level.INFO);
		//Informacja jaka ma siê wyœwietliæ
		logger.info("Start");
		
		this.setSize(770,500);//ustawienie rozmiaru frame
		this.setLocation(500, 200);//ustawienie lokalizacji okienka frame
		this.setTitle("Projekt cw1");//ustawienie tytu³u okienka frame	
		this.setResizable(true);//ustawienie niezmienialnoœci okienka frame
		contenerPanel = (JPanel)this.getContentPane();
		BorderLayout BL = new BorderLayout();
		//BL.setHgap(20);
		//BL.setVgap(30);
		contenerPanel.setLayout(BL);
		
		info_panel();
		//zdarzenie zamykania okna
		this.addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e) 
			{
				InfoClosing(status_aplikacji);
				Zamykanie_Okna();
			}
			
			@Override
			public void windowOpened(WindowEvent arg0) 
			{
				StatusON(status_uruchomienia);				
				InfoOpen(status_aplikacji);
			}
			
			@Override
			public void windowClosed(WindowEvent e) 
			{
				StatusOFF(status_uruchomienia);
			}
			
			@Override
			public void windowActivated(WindowEvent e) 
			{
				InfoActive(status_aplikacji);
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) 
			{
				InfoDeactive(status_aplikacji);
			}
			
			@Override
			public void windowIconified(WindowEvent e) 
			{
				InfoIconified(status_aplikacji);
			}
		});
		
		//Próba utworzenia GUI, je¿eli siê uda to utworzy je¿eli nie to wyœwietli w konsoli komunikat
		try 
		{	
	        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
	            public void run() 
	            {
	            	
	            	
	            	utworz(m);
	            }
	        });	
		}
		catch(Exception e) 
		{
		
			
			System.out.println("ERROR - Blad podczas tworzenia GUI aplikacji");
		}
		
	}

	
	
	
	
	
	public static void main(String[] args) 
	{

		
		tabelka_M m = new tabelka_M();
		GUI okno = new GUI(m);
		tabelka_C c = new tabelka_C(okno,m);
		okno.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		okno.setVisible(true);
		//okno.setVisible(true);
	}

}




