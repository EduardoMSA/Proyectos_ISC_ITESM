import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.timer.Timer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelControles extends JPanel {
	private JSlider slider;
	private JButton iniciar,
			reset;
	private PanelTorres pt;
	private int numeroDiscos;
	
	public PanelControles(PanelTorres pt) {
		super();
		this.setPreferredSize(new Dimension(100, 900));
		this.pt=pt;
		this.slider = new JSlider(JSlider.VERTICAL, 1, 10, pt.getNumDiscos());
		this.numeroDiscos=pt.getNumDiscos();
		this.slider.setMajorTickSpacing(1);
		this.slider.setPaintTicks(true);
		this.slider.setPaintLabels(true);
		this.slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				numeroDiscos=slider.getValue();
			}
		});
		
		this.reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pt.reiniciar(numeroDiscos);
				
			}
		});
		
		this.iniciar=new JButton("Iniciar");
		iniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new javax.swing.Timer(100, this);
				pt.reiniciar(numeroDiscos);
				pt.hanoi(numeroDiscos, pt.getOrigen(), pt.getAux(), pt.getDestino());
				
			}
		});
		
		
		this.add(this.slider);
		this.add(this.reset);
		this.add(this.iniciar);
		
		
	}
}
