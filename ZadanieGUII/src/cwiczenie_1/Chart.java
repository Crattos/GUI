package cwiczenie_1;

import java.text.DecimalFormat;

import javax.swing.JTable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


/** 
* Klasa Chart odpowiedzialana jest, za stworzenie i wy¶wietlenia wykresu ko³owego
* @author Patryk Miler	 	
* @version 1.0	16/05/2016
* -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
*/

public class Chart {
	
	/**
	 * Konstruktor domy¶lny
	 */
	
	public Chart(){
		
	}
	
	/**
	 * Konstruktor z parametrem
	 * @param tabelka pobiera zawarto¶æ tabelki z klasy GUI 
	 */
	
	public Chart(JTable tabelka){
		// Pobiera dane z tabeli
		DefaultPieDataset data = new DefaultPieDataset();
		int wartosc;
		
		
			
			for(int i =1; i < tabelka.getRowCount(); i++){
				for(int j = 0; j < tabelka.getColumnCount(); j++){
					
					wartosc = Integer.parseInt(tabelka.getValueAt(i, j).toString());
					if(wartosc>0)
						data.setValue("komórka:"+i+","+j,wartosc);
					
				}
			}

				// Tworzy wykres
				JFreeChart chart = ChartFactory.createPieChart(
										"Wykres ko³owy",
										data,
										false, // legend?
										true, // tooltips?
										false // URLs?
									);
				// Tworzy i wy¶wielta ramkê
				//Tworzy nowy obiekt
				
				PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator( "{0}- {2}", new DecimalFormat("0.0"), new DecimalFormat("0.0%"));
				PiePlot plot = (PiePlot) chart.getPlot();

				plot.setLabelGenerator(gen);
				
				ChartFrame frame = new ChartFrame("Wykres", chart);
				
				frame.pack();
				frame.getChartPanel();
				frame.setVisible(true);
	}

}
