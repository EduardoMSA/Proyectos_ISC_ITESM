import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

public class PanelControl extends JPanel implements Runnable{
	
	/*private JButton reiniciar;*/
	private Juego juego;
	private JTextArea turno, 
				   ronda,
				   cronometro;
	private int min,
				seg,
				sleep;
	
	
	public PanelControl(Juego juego) {
		super();
		
		this.sleep=0;
		this.juego=juego;
		this.min=00;
		this.seg=00;
		
		this.setPreferredSize(new Dimension(700,50));
		this.setLayout(new BorderLayout());
		
		this.cronometro = new JTextArea("\nTiempo Transcurrido:   "+(this.min + ":" + this.seg),2,10);
		this.cronometro.setFont(new Font("Arial", Font.BOLD, 20));
		this.cronometro.setEditable(false);
		
		this.turno = new JTextArea("\n Turno: " + (juego.getTurno()==0?"Claro":"Oscuro"), 2, 10);
		this.turno.setFont(new Font("Arial", Font.BOLD, 20));
		this.turno.setEditable(false);
		
		this.ronda = new JTextArea("\nRonda: "+ juego.getRonda(),2,10);
		this.ronda.setFont(new Font("Arial", Font.BOLD, 20));
		this.ronda.setEditable(false);
		
		this.add(this.turno, BorderLayout.WEST);
		this.add(this.cronometro, BorderLayout.CENTER);
		this.add(this.ronda, BorderLayout.EAST);		
		
		/*this.reiniciar=new JButton("Reiniciar Juego");
		this.reiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				juego.reiniciar();
			}
		});
		this.add(this.reiniciar, BorderLayout.NORTH);*/
		
		
		Thread hilo = new Thread(this);
		hilo.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				if(sleep%1000==0) {
				this.seg++;
				}
				if(seg==60) {
					this.min++;
					this.seg=0;
				}
				if(this.min<10) {
					this.cronometro.setText("\nTiempo Transcurrido:   0"+this.min + ":");
				}
				else {
					this.cronometro.setText("\nTiempo Transcurrido:  "+this.min + ":");
				}
				if(this.seg<10) {
					this.cronometro.setText(this.cronometro.getText()+"0"+this.seg);
				}
				else {
					this.cronometro.setText(this.cronometro.getText() + this.seg);
				}
				this.turno.setText("\nTurno: " + (juego.getTurno()==0?"Claro":"Oscuro"));
				this.ronda.setText("\nRonda: "+ juego.getRonda());
				sleep+=100;
				Thread.sleep(100);
			}
		}
		catch(InterruptedException ex) {
			System.out.println(ex);
		}
		
	}
}
