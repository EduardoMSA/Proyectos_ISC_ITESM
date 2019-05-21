/*
 * Eduardo Méndez Santa Ana A01632947
 * Clase donde está el main: Principal
 * 23/01/18
 * 
 * El repaint dentro de la clase ReglaRecursiva ocasiona que se vea doble la regla
 * cada vez que se quiere utilizar el JSlider,
 * cambiar de tamaño la ventana hace que se vea normal la regla.
 * 
 */

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelControl extends JPanel implements ChangeListener{
	private ReglaRecursiva regla;
	private JSlider slider;
	public PanelControl(ReglaRecursiva regla) {
		super();
		this.regla=regla;
		this.setPreferredSize(new Dimension(40, 300));
		this.slider=new JSlider(JSlider.VERTICAL,1,10,1);
		this.add(slider);
		this.slider.setMajorTickSpacing(4);
		this.slider.setMinorTickSpacing(1);
		this.slider.setPaintLabels(true);
		this.slider.setPaintTicks(true);
		this.slider.addChangeListener(this);
	}
	public void stateChanged(ChangeEvent e) {
		
		this.regla.setNivel(this.slider.getValue());
	}
}
