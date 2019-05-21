/*
 * Eduardo Méndez
 * Luis Miramontes
 */

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafica {
	
	private String titulo, tX,tY;
	private JFreeChart grafica;
	private XYSeriesCollection datos;
	
	
	public Grafica(String titulo, String tX, String tY) {
		datos = new XYSeriesCollection();
		grafica = ChartFactory.createScatterPlot(titulo, tX, tY, datos, PlotOrientation.VERTICAL, true, true,false);
	}
	
	public void agregarGrafica(Double[] x, Double[] y, String name) {
		XYSeries s = new XYSeries(name);
		int n = x.length;
		for (int i=0; i<n;i++) {
			s.add(x[i],y[i]);	
		}
		this.datos.addSeries(s);
		
	}
	
	public JPanel getPanel() {
		return new ChartPanel(grafica);
	}
	
	public void borrarDatos() {
		this.datos.removeAllSeries();
		Double[] x = {0.0};
		Double[] y = {0.0};
		this.agregarGrafica(x, y, "Base");
	}
}
