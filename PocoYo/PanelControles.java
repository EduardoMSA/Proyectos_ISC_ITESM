import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PanelControles extends JPanel {
	private JTextField tfNombre;
	private JButton bSaludar,
					bCambiar,
					bCambiarColorGlobo,
					bSelArchivo;
	private JRadioButton 	rbRojo,
							rbVerde,
							rbAzul;
	private mipanel PanelDibujo;
	private JFileChooser fc;
	private JSlider slider;
	
	public PanelControles(mipanel PanelDibujo) {
		super();
		this.fc=new JFileChooser();
		
		this.PanelDibujo = PanelDibujo;
		this.setPreferredSize(new Dimension(150, 600));
		this.tfNombre=new JTextField(12);
		this.add(tfNombre);
		
		this.bSaludar=new JButton("Saludar");
		this.add(bSaludar);
		this.bSaludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Hola " +  this.tfNombre.getText());
				PanelDibujo.setNombre(tfNombre.getText());
			}
		});
		
		this.rbRojo = new JRadioButton("Color Rojo");
		this.rbRojo.setSelected(true);
		this.rbVerde = new JRadioButton("Color Verde");
		this.rbAzul = new JRadioButton("Color Azul");
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbRojo);
		bg.add(rbVerde);
		bg.add(rbAzul);
		this.add(rbRojo);
		this.add(rbVerde);
		this.add(rbAzul);
		
		this.bCambiar = new JButton("Cambiar");
		this.add(bCambiar);
		this.bCambiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==PanelControles.this.bCambiar) {
					if(PanelControles.this.rbAzul.isSelected()) {
						PanelControles.this.setBackground(Color.BLUE);
					}
					else if(PanelControles.this.rbRojo.isSelected()) {
						PanelControles.this.setBackground(Color.RED);
					}
					else {
						PanelControles.this.setBackground(Color.GREEN);
					}
				}
				
			}
		});
		
		this.bCambiarColorGlobo=new JButton("Cambiar Color Globo");
		this.bCambiarColorGlobo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color colorGlobo=JColorChooser.showDialog(PanelControles.this.PanelDibujo, "Selecciona el Color del Globo", PanelControles.this.PanelDibujo.getColorGlobo());
				PanelControles.this.PanelDibujo.setColorGlobo(colorGlobo);
				
			}
		});
		this.add(this.bCambiarColorGlobo);
		
		this.bSelArchivo=new JButton("Seleccionar Archivo");
		this.bSelArchivo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int opcion=PanelControles.this.fc.showOpenDialog(PanelControles.this.PanelDibujo);
				if(opcion==JFileChooser.APPROVE_OPTION) {
					System.out.println(PanelControles.this.fc.getSelectedFile());
				}
				
			}
		});
		this.add(this.bSelArchivo);
		
		
		this.slider = new JSlider(JSlider.VERTICAL, 0, 150, 0);
		this.add(slider);
		this.slider.setMajorTickSpacing(20);
		this.slider.setMinorTickSpacing(5);
		this.slider.setPaintLabels(true);
		this.slider.setPaintTicks(true);
		this.slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				PanelControles.this.PanelDibujo.setSubir(PanelControles.this.slider.getValue());
				
			}
		});
				
	}
	
}