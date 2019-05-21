
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;


public class panelOpciones extends JPanel{
	private Juego juego;
	private JButton reiniciar,
					guardar,
					salir,
					cargar;
	private JFileChooser fc;
	public panelOpciones(Juego juego) {
		super();
		this.juego=juego;
		this.fc=new JFileChooser();
		this.setPreferredSize(new Dimension(700, 50));
		this.reiniciar=new JButton("JUEGO NUEVO");
		this.reiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelOpciones.this.juego.reiniciar();
			}
		});
		
		this.guardar=new JButton("GUARDAR JUEGO");
		this.guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int archivo = panelOpciones.this.fc.showSaveDialog(panelOpciones.this.juego);
				if(archivo == JFileChooser.APPROVE_OPTION) {
					PrintWriter pw = null;
					try {
						pw = new PrintWriter(new FileWriter(panelOpciones.this.fc.getSelectedFile()));
						pw.println(panelOpciones.this.juego.getRonda());
						pw.println(panelOpciones.this.juego.getTurno());
						for(int i = 0; i<8; i++) {
							for(int j = 0; j<8; j++) {
								if (panelOpciones.this.juego.getTablero().getCelda(i, j).tieneFicha()) {
									
									int tipo = 0;
									int color = 0;
									switch(panelOpciones.this.juego.getTablero().getCelda(i, j).getFicha().getTipo()) {
									case "REY":
										tipo = 1;
										break;
									case "REINA":
										tipo = 2;
										break;
									case "ALFIL":
										tipo = 3;
										break;
									case "CABALLO":
										tipo = 4;
										break;
									case "TORRE":
										tipo = 5;
										break;
									case "PEON":
										tipo = 6;
										break;
									}
									color = panelOpciones.this.juego.getTablero().getCelda(i, j).getFicha().getColor()=="CLARO"?0:1;
									
									pw.println(color+""+tipo);
								}
								else {
									pw.println(-1);
								}
							}
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 

					finally {
						pw.close();
					}
					
				}
				
			}
		});
		
		this.cargar=new JButton("CARGAR JUEGO");
		this.cargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int archivo = panelOpciones.this.fc.showOpenDialog(panelOpciones.this.juego);
				if (archivo == JFileChooser.APPROVE_OPTION) {
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(panelOpciones.this.fc.getSelectedFile()));
						Celda[][] celdas = new Celda[8][8];
						int ronda = Integer.parseInt(br.readLine());
						int turno = Integer.parseInt(br.readLine());
						for(int i = 0; i< celdas.length;i++) {
							for(int j = 0; j< celdas[i].length;j++) {
								int codigo =Integer.parseInt(br.readLine());
								if(codigo>0) {
									int tipo = codigo%10;
									int color = codigo/10;
									switch(tipo) {
									case 1:
										celdas[i][j]=new Celda(new Rey(color));
										break;
									case 2:
										celdas[i][j]=new Celda(new Reina(color));
										break;
									case 3:
										celdas[i][j]=new Celda(new Alfil(color));
										break;
									case 4:
										celdas[i][j]=new Celda(new Caballo(color));
										break;
									case 5:
										celdas[i][j]=new Celda(new Torre(color));
										break;
									case 6:
										celdas[i][j]=new Celda(new Peon(color));
										break;
									}
									
								}
								else {
									celdas[i][j] = new Celda(null);
								}
							}
						}
						panelOpciones.this.juego.cargar(ronda, turno, celdas);
						//panelOpciones.this.juego.cargar(celdas);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}finally {
						try {
							br.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		this.salir=new JButton("SALIR DEL JUEGO");
		this.salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
				
			}
		});
		
		this.add(this.reiniciar);
		this.add(this.cargar);
		this.add(this.guardar);
		this.add(this.salir);
		
	}
	
}
