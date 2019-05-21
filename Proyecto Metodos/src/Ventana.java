/*
 * Eduardo Méndez
 * Luis Miramontes
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.*;


public class Ventana extends JFrame implements ActionListener{
	
	// declaracion de los atributos
	private Grafica graficaXT, graficaYT, graficaInterseccion;
	private TiroParabolico tp;
	private JPanel uno,dos,tres,cuatro;
	private JPanel panel;
	private JTextArea area;
	private JFileChooser chooser;
	private JCheckBox cb;
	private JMenu menu;
	private JMenuBar barra;
	private JMenuItem item1,item2;
	private ArrayList<Double> x,y,t;
	private boolean metodoAUsar;

	
	public Ventana() {
		
		super("Misil Balístico");
		setSize(800, 600);
		setLocation(150, 150);
		this.graficaXT = new Grafica("X-Tiempo", "Tiempo (s)", "X (m)");
		this.graficaYT = new Grafica("Y-Tiempo", "Tiempo (s)", "Y (m)");
		this.graficaInterseccion = new Grafica("Intersección X-Y", "X (m)", "Y (m)");
		
		Double[] x1 = {0.0};
		Double[] y1 = {0.0};
		Double[] x2 = {0.0};
		Double[] y2 = {0.0};
		Double[] x3 = {0.0};
		Double[] y3 = {0.0};
		
		
		this.metodoAUsar = true;
		
		this.x = new ArrayList<Double>();
		this.y = new ArrayList<Double>();
		this.t = new ArrayList<Double>();
		
		this.graficaXT.agregarGrafica(x1, y1, "Base");
		this.graficaYT.agregarGrafica(x2, y2, "Base");
		this.graficaInterseccion.agregarGrafica(x3, y3, "Base");
		
		this.area = new JTextArea();
		this.uno = this.graficaXT.getPanel();
		this.dos = this.graficaYT.getPanel();
		this.tres = this.graficaInterseccion.getPanel();
		this.cuatro = new JPanel();
		
		this.panel = new JPanel();
		this.chooser = new JFileChooser();
		this.barra = new JMenuBar();
		this.menu = new JMenu("File");
		this.item1 = new JMenuItem("Save");
		this.item2 = new JMenuItem("Load");

		this.item1.addActionListener(this);
		this.item2.addActionListener(this);
		
		this.menu.add(this.item1);
		this.menu.add(this.item2);
		
		this.cb = new JCheckBox("Intersección en ultimo punto",true);
		
		this.cb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int sel = e.getStateChange();
				if (sel==ItemEvent.SELECTED) {
					//System.out.println("Seleccion");
					Ventana.this.metodoAUsar = true;
				} else{
					//System.out.println("NO");
					Ventana.this.metodoAUsar = false;
				}
				System.out.println(metodoAUsar);
			}
		});
		
		this.cuatro.add(this.cb);
		this.cuatro.add(this.area);
		this.barra.add(this.menu);
		setJMenuBar(this.barra);
		
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		GridLayout gl = new GridLayout(2,2);
		this.panel.setLayout(gl);
		
		this.panel.add(uno);
		this.panel.add(dos);
		this.panel.add(tres);
		this.panel.add(cuatro);
		
		add(this.panel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource() == this.item1) {
			//System.out.println("Guardar");
			int r = this.chooser.showSaveDialog(this);
			if(r == JFileChooser.APPROVE_OPTION) {
				try {
					FileWriter fw = new FileWriter(this.chooser.getSelectedFile().getPath());
					BufferedWriter br = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(br);
					Double[] x = this.x.toArray(new Double[this.x.size()]);
					Double[] y = this.y.toArray(new Double[this.y.size()]);
					Double[] t = this.t.toArray(new Double[this.t.size()]);
					
					for(int i = 0; i<x.length; i++) {
						String s = "";
						for(int j = 1; j<=3; j++) {
							switch (j) {
							case 1:
								s += "" + t[i];
								break;

							case 2:
								s += " " + x[i];
								break;
							case 3:
								s += " " + y[i];
								break;
							}
						}
						pw.println(s);
					}
					
					
					br.close();
					
					
					
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		if(a.getSource() == this.item2) {
			//System.out.println("Load");
			int r = this.chooser.showOpenDialog(this);
			if(r == JFileChooser.APPROVE_OPTION) {
				try {
					FileReader fr = new FileReader(this.chooser.getSelectedFile().getPath());
					BufferedReader br = new BufferedReader(fr);
					String linea;
					
					while((linea = br.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(linea);
						//System.out.println();
						int tmp = 1;
						while (st.hasMoreTokens()) {
							
							switch (tmp) {
							case 1:
								t.add(Double.parseDouble(st.nextToken()));
								break;

							case 2:
								x.add(Double.parseDouble(st.nextToken()));
								break;
							case 3:
								y.add(Double.parseDouble(st.nextToken()));
								break;
							}
							tmp++;
							
						}
					}
					br.close();
				}catch(FileNotFoundException f) {
					f.printStackTrace();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
				
				/*for(int i = 0;i<x.size();i++) {
					System.out.println(1 + " - " + this.t.get(i) + ", " + this.x.get(i) + ", " + this.y.get(i));
				}	*/
			}
			
			this.calcular();
		}
	}
	
	private void calcular() {
		DecimalFormat df = new DecimalFormat("#.000");
		Double[] x = this.x.toArray(new Double[this.x.size()]);
		Double[] y = this.y.toArray(new Double[this.y.size()]);
		Double[] t = this.t.toArray(new Double[this.t.size()]);
		this.tp=new TiroParabolico(x,y,t);
		if(this.metodoAUsar) {			
			this.tp.interseccionEnUltimo();
		} else {
			this.tp.interseccionEnUltimo2();			
		}
		String s = "";
		if(this.tp.getPosible()) {
			s = ("\n\n\nV = " + df.format(this.tp.getV())+"m/s\nAngulo = " + df.format(this.tp.getAngulo())+"°\nTiempo para disparo = " + df.format(this.tp.getUltimoTiempo())+ "s\nTiempo de vuelo = "+ df.format(this.tp.getTiempoDeVuelo()) + "s\nTiempo para interceptar = "+ df.format(this.tp.getTiempoParaIntercepcion()) + "s");		
		} else {
			s = ("\n\n\nNo es posible Interseptar\nV = " + df.format(this.tp.getV())+"m/s\nAngulo = " + df.format(this.tp.getAngulo())+"°\nTiempo para disparo = " + df.format(this.tp.getUltimoTiempo())+ "s\nTiempo de vuelo = "+ df.format(this.tp.getTiempoDeVuelo()) + "s\nTiempo para interceptar = "+ df.format(this.tp.getTiempoParaIntercepcion()) + "s");
		}
		this.area.setText(s);
		Double[] interseccionX = {this.tp.getPx()};
		Double[] interseccionY = {this.tp.getPy()};
		Double[] interseccionT = {this.tp.getTiempoDeVuelo()};
		this.graficaInterseccion.borrarDatos();
		this.graficaXT.borrarDatos();
		this.graficaYT.borrarDatos();
		this.graficaXT.agregarGrafica(t, x,"Puntos");
		this.graficaYT.agregarGrafica(t, y,"Puntos");
		this.graficaInterseccion.agregarGrafica(x, y,"Puntos");
		this.graficaXT.agregarGrafica(interseccionT, interseccionX, "Intersección");
		this.graficaYT.agregarGrafica(interseccionT, interseccionY, "Intersección");
		this.graficaInterseccion.agregarGrafica(interseccionX, interseccionY, "Intersección");
		
	}



}