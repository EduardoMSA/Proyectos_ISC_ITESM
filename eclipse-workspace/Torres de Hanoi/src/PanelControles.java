
/*
 * Eduardo Méndez A01632947
 * Sebastián Serna A01633102
 * Clase con main = Principal
 * 26/02/2018
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelControles extends JPanel {
	private JSlider slider;
	private JButton iniciar, reset, set;
	private JTextArea turno, tfVelocidad;
	private PanelTorres pt;
	private JSpinner spinner;
	private int numeroDiscos, contador, numSlider;
	private long velocidad;

	public PanelControles(PanelTorres pt) {
		super();
		this.setPreferredSize(new Dimension(100, 900));
		this.pt = pt;
		this.contador = 0;
		this.velocidad = 600;
		this.numeroDiscos = this.numSlider = pt.getNumDiscos();
		
		this.slider = new JSlider(JSlider.VERTICAL, 1, 10, pt.getNumDiscos());
		this.slider.setMajorTickSpacing(1);
		this.slider.setPaintTicks(true);
		this.slider.setPaintLabels(true);
		this.slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				PanelControles.this.numSlider = slider.getValue();
			}
		});

		this.reset = new JButton("Reset");
		this.reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelControles.this.contador = 0;
				PanelControles.this.turno.setText("\n Movimiento: " + PanelControles.this.contador);
				PanelControles.this.pt.reiniciar(PanelControles.this.numeroDiscos);

			}
		});

		this.set = new JButton("Set");
		this.set.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelControles.this.numeroDiscos = PanelControles.this.numSlider;
				PanelControles.this.contador = 0;
				PanelControles.this.turno.setText("\n Movimiento: " + PanelControles.this.contador);
				PanelControles.this.pt.reiniciar(PanelControles.this.numeroDiscos);
			}
		});
		;

		this.iniciar = new JButton("Iniciar");
		this.iniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				PanelControles.this.contador = 0;
				PanelControles.this.turno.setText("\n Movimiento: " + PanelControles.this.contador);
				PanelControles.this.pt.reiniciar(PanelControles.this.numeroDiscos);
				try {
					PanelControles.this.hanoi(numeroDiscos, PanelControles.this.pt.getOrigen(),
							PanelControles.this.pt.getAux(), PanelControles.this.pt.getDestino());
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Movimientos totales: " + PanelControles.this.contador);

			}
		});

		this.turno = new JTextArea("\n Movimiento: " + this.contador, 2, 10);
		this.turno.setFont(new Font("Arial", Font.BOLD, 10));
		this.turno.setEditable(false);

		SpinnerModel model = new SpinnerNumberModel(3, 1, 5, 1);
		this.spinner = new JSpinner(model);
		this.spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				PanelControles.this.velocidad = 1200 - ((int) PanelControles.this.spinner.getValue() * 200);

			}
		});

		this.tfVelocidad = new JTextArea("Velocidad");
		this.tfVelocidad.setFont(new Font("Arial", Font.BOLD, 10));
		this.tfVelocidad.setEditable(false);

		this.add(this.turno);
		this.add(this.iniciar);
		this.add(this.slider);
		this.add(this.set);
		this.add(this.reset);
		this.add(this.tfVelocidad);
		this.add(this.spinner);
	}

	public void mover(Torre origen, Torre destino) throws InterruptedException {
		Thread.sleep(this.velocidad);
		this.contador++;
		this.turno.setText("\n Movimiento: " + this.contador);
		this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
		destino.push(origen.pop());
		System.out.println("Movimiento de " + origen.getNum() + " a " + destino.getNum());
		this.pt.paintImmediately(0, 0, this.pt.getWidth(), this.pt.getHeight());
	}

	public void hanoi(int n, Torre origen, Torre auxiliar, Torre destino) throws InterruptedException {
		if (n == 1) {
			this.mover(origen, destino);
		} else {
			hanoi(n - 1, origen, destino, auxiliar);

			this.mover(origen, destino);
			hanoi(n - 1, auxiliar, origen, destino);
		}
	}
}
