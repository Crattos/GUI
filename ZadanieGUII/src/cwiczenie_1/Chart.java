package cwiczenie_1;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class Chart {
	
	public Chart(){
		

	}
	
	public Chart(JTable tabelka){
		// create a dataset...
		DefaultPieDataset data = new DefaultPieDataset();
		int wartosc;
		
		
			
			for(int i =1; i < tabelka.getRowCount(); i++)
			{
				for(int j = 0; j < tabelka.getColumnCount(); j++)
				{
					
					wartosc = Integer.parseInt(tabelka.getValueAt(i, j).toString());
					if(wartosc>0)
						data.setValue("komórka:"+i+","+j,wartosc);
					
				}
			}
			
		
	
		
		
		
		
//				data.setValue("Category 1", -20);
//				data.setValue("Category 2", 27.9);
//				data.setValue("Category 3", 79.5);
				// create a chart...
				JFreeChart chart = ChartFactory.createPieChart(
										"Sample Pie Chart",
										data,
										false, // legend?
										true, // tooltips?
										false // URLs?
									);
				// create and display a frame...
				
				PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator( "{0}- {2}", new DecimalFormat("0.0"), new DecimalFormat("0.0%"));
				PiePlot plot = (PiePlot) chart.getPlot();

				plot.setLabelGenerator(gen);
				
				ChartFrame frame = new ChartFrame("Wykres", chart);
				
				frame.pack();
				frame.getChartPanel();
				frame.setVisible(true);
	}

}
