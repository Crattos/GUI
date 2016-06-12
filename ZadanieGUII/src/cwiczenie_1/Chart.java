package cwiczenie_1;

import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class Chart {
	
	public Chart(){
		// create a dataset...
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("Category 1", -20);
		data.setValue("Category 2", 27.9);
		data.setValue("Category 3", 79.5);
		// create a chart...
		JFreeChart chart = ChartFactory.createPieChart(
								"Sample Pie Chart",
								data,
								true, // legend?
								true, // tooltips?
								false // URLs?
							);
		// create and display a frame...
		
		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator( "{0}- {2}", new DecimalFormat("0.0"), new DecimalFormat("0.0%"));
		PiePlot plot = (PiePlot) chart.getPlot();

		plot.setLabelGenerator(gen);
		
		ChartFrame frame = new ChartFrame("First", chart);
		
		frame.pack();
		frame.getChartPanel();
		frame.setVisible(true);

	}

}
