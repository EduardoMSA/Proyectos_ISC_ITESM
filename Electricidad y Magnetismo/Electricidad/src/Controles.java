import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controles extends JPanel{
	private JRadioButton positivo,
						 negativo;
	public JButton simular,
				   reiniciar,
				   salir;
	private JLabel v,
	   			   xDist,
	               yDist,
	               pot;
	private JTextField velocidad;
	private EyM panelDibujo;
	private JSlider distX,
					distY,
					potencia;
	private double x,
				   y,
				   potenciaValor;
	public static final double me = 0.000000000000000000000000000000911,
							   mp = 0.00000000000000000000000000167,
							   qe = 0.00000000000000000016;
	
	public Controles(EyM panelDibujo) {
		super();
		this.setPreferredSize(new Dimension(200, 600));
		this.positivo = new JRadioButton("Protón");
		this.negativo = new JRadioButton("Electrón");
		ButtonGroup bg = new ButtonGroup();
		bg.add(this.positivo);
		bg.add(this.negativo);
		this.add(this.positivo);
		this.add(this.negativo);
		
		this.v = new JLabel("Velocidad");
		this.add(this.v);
		this.velocidad = new JTextField(12);
		this.add(this.velocidad);
		
		this.pot = new JLabel("Potencia (*10^)");
		this.add(this.pot);
		this.potencia = new JSlider(-6, 6, 0);
		this.potencia.setMajorTickSpacing(1);
		this.potencia.setPaintTicks(true);
		this.potencia.setPaintLabels(true);
		this.potencia.addChangeListener(new ChangeListener(){
			
			public void stateChanged(ChangeEvent e) {
				potenciaValor = potencia.getValue();
			}
		});
		this.add(this.potencia);
		
		this.reiniciar = new JButton("Reiniciar");
		this.reiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				Controles.this.panelDibujo.setXv(0);
//				Controles.this.panelDibujo.setYv(0);
				Ventana v = new Ventana();
				
			}
		});
		
		this.salir = new JButton("Salir");
		this.salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		this.add(this.reiniciar);
		this.add(salir);
		
		this.xDist = new JLabel("Distancia en X");
		this.add(xDist);
		this.distX = new JSlider(JSlider.VERTICAL, 1, 10, 2);
		this.distX.setMajorTickSpacing(1);
		this.distX.setPaintTicks(true);
		this.distX.setPaintLabels(true);
		this.distX.addChangeListener(new ChangeListener(){
			int x;
			
			public void stateChanged(ChangeEvent e) {
				x = distX.getValue();
				panelDibujo.setDistX(x);
			}
		});
		this.add(distX);
		
		this.yDist = new JLabel("Distancia en Y");
		this.add(yDist);
		this.distY = new JSlider(JSlider.VERTICAL, 1, 10, 2);
		this.distY.setMajorTickSpacing(1);
		this.distY.setPaintTicks(true);
		this.distY.setPaintLabels(true);
		this.distY.addChangeListener(new ChangeListener(){
			int y;
			
			public void stateChanged(ChangeEvent e) {
				y = distY.getValue();
				panelDibujo.setDistY(y);
			}
		});
		this.add(distY);	
		
		this.simular = new JButton("Simular");
		this.add(this.simular);
		
		this.simular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color tmpColor;
				String carga, v;
				double vel,
					   acc;
				
				if(positivo.isSelected()) {
					tmpColor = Color.RED;
					carga = "+";
				}
				else {
					tmpColor = Color.BLUE;
					carga = "-";
				}
				panelDibujo.setColor(tmpColor);
				panelDibujo.setCarga(carga);
				panelDibujo.setSimula();
				v = velocidad.getText();
				vel = Double.parseDouble(v);
				vel = vel*Math.pow(10, potenciaValor);
				panelDibujo.setVelocidad(vel);
				
				//No sirve esto pero igual lo dejo
				acc = (qe*(2*panelDibujo.getDistX()*Math.pow(vel, 2)*me)/(qe*Math.pow(panelDibujo.getDistY(), 2)))/me;
				panelDibujo.setAc(acc);
				String s = "";
				System.out.println("X: " + panelDibujo.getDistX());
				s+= "X: " + panelDibujo.getDistX();
				System.out.println("Velocidad: " + vel);
				s+= "\nVelocidad: " + vel;
				System.out.println("Velocidad^2: " + Math.pow(vel, 2));
				s+= "\nVelocidad^2: " + Math.pow(vel, 2);
				System.out.println("Masa de la particula: " + me);
				s+= "\nMasa de la particula: " + me;
				System.out.println("Carga: " + qe);
				s+= "\nCarga: " + qe;
				System.out.println("Y: " + panelDibujo.getDistY());
				s+= "\nY: " + panelDibujo.getDistY();
				System.out.println("Y^2: " + Math.pow(panelDibujo.getDistY(), 2));
				s+= "\nY^2: " + Math.pow(panelDibujo.getDistY(), 2);
				System.out.print("Campo electrico: ");
				s+="\nCampo electrico: ";
				DecimalFormat df = new DecimalFormat("#.00000000000");
				if("-".equals(panelDibujo.getCarga())) {
					System.out.println((2*panelDibujo.getDistX()*Math.pow(vel, 2)*me)/(qe*Math.pow(panelDibujo.getDistY(), 2)) + " N/C");
					s+=((double)(2*panelDibujo.getDistX()*Math.pow(vel, 2)*me)/(qe*Math.pow(panelDibujo.getDistY(), 2))) + " N/C";
				}
				else {
					System.out.println((2*panelDibujo.getDistX()*Math.pow(vel, 2)*mp)/(qe*Math.pow(panelDibujo.getDistY(), 2)) + " N/C");
					s+=((double)(2*panelDibujo.getDistX()*Math.pow(vel, 2)*mp)/(qe*Math.pow(panelDibujo.getDistY(), 2))) + " N/C";
				}
				System.out.println(x);
				
				JTextArea textArea = new JTextArea(s);
				JScrollPane scrollPane = new JScrollPane(textArea);  
				textArea.setLineWrap(true);  
				textArea.setWrapStyleWord(true); 
				scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
				JOptionPane.showMessageDialog(null, scrollPane, "dialog test with textarea",  
				                                       JOptionPane.YES_NO_OPTION);
				
				
			}
			
		});
	}
}
