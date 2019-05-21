import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class panelcontrol extends JPanel implements ChangeListener {
	
	private panelbarco panel;
	private JSlider slider;
	private JButton	encender,
					apagar;
	
	public panelcontrol(panelbarco panel) {
		super();
		this.panel = panel;
		this.setPreferredSize(new Dimension(200, 600));
		this.setLayout(new BorderLayout());
		
		this.slider=new JSlider(JSlider.VERTICAL, 0, 400, 0);
		this.add(slider,BorderLayout.CENTER);
		this.slider.setMajorTickSpacing(100);
		this.slider.setMinorTickSpacing(25);
		this.slider.setPaintLabels(true);
		this.slider.setPaintTicks(true);
		this.slider.addChangeListener(this);
		
		/*
		this.encender = new JButton("Encender");
		this.encender.addActionListener(this);
		//this.add(encender,BorderLayout.NORTH);
		
		this.apagar = new JButton("Apagar");
		this.apagar.addActionListener(this);
		//this.add(apagar,BorderLayout.SOUTH);
		*/
		
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		this.panel.setCambioNivel(this.slider.getValue());
		
	}
/*
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}*/
}
