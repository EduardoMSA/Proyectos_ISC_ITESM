import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JPanel implements MouseListener {
	private Jugador jugador1,
					jugador2;
	private Tablero tablero;
	private boolean seleccionFicha;
	private Celda celdaorigen,
				  celdadestino,
				  poscicionReyClaro,
				  poscisionReyOscuro;
	private int turno,
				ronda;
	
	public Juego() {
		super();
		this.jugador1=new Jugador();
		this.jugador2=new Jugador();
		this.tablero = new Tablero();
		this.reiniciar();
		this.seleccionFicha=false;
		this.setPreferredSize(new Dimension(700, 700));
		this.addMouseListener(this);
		this.turno=0;
		this.ronda=1;
		this.poscicionReyClaro=this.tablero.getCelda(4, 7);
		this.poscisionReyOscuro=this.tablero.getCelda(4, 0);
	}
	
	public void cargar(int ronda, int turno, Celda[][] celdas) {
		this.ronda = ronda;
		this.turno = turno;
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas[i].length; j++) {
				this.tablero.getCelda(i, j).setFicha(celdas[i][j].getFicha());
			}
		}
		this.repaint();
	}
	
	public void reiniciar() {
		this.turno=0;
		this.ronda=1;
		for(int i = 0; i<8;i++) {
			for(int j = 0;j<8;j++) {
				this.tablero.getCelda(i, j).setFicha(null);
			}
		}
		for(int i = 0;i<8;i++) {
			this.tablero.getCelda(i, 1).setFicha(new Peon(1));
			this.tablero.getCelda(i, 6).setFicha(new Peon(0));
			switch(i) {
			case 0:
			case 7:
				this.tablero.getCelda(i, 0).setFicha(new Torre(1));
				this.tablero.getCelda(i, 7).setFicha(new Torre(0));
				break;
			case 1:
			case 6:
				this.tablero.getCelda(i, 0).setFicha(new Caballo(1));
				this.tablero.getCelda(i, 7).setFicha(new Caballo(0));
				break;
			case 2:
			case 5:
				this.tablero.getCelda(i, 0).setFicha(new Alfil(1));
				this.tablero.getCelda(i, 7).setFicha(new Alfil(0));
				break;
			case 3:
				this.tablero.getCelda(i, 0).setFicha(new Reina(1));
				this.tablero.getCelda(i, 7).setFicha(new Reina(0));
				break;
			case 4:
				this.tablero.getCelda(i, 0).setFicha(new Rey(1));
				this.tablero.getCelda(i, 7).setFicha(new Rey(0));
				break;
				
			}
		}
		this.jugador1.reiniciarJugador();
		this.jugador2.reiniciarJugador();
		this.repaint();
	}
	
	public Celda getCelda(int px, int py) {
		int x=-1;
		int y=-1;
		if(px>50&&px<125) {
			x=0;
		}
		else if(px>125&&px<200) {
			x=1;
		}
		else if(px>200&&px<275) {
			x=2;
		}
		else if(px>275&&px<350) {
			x=3;
		}
		else if(px>350&&px<425) {
			x=4;
		}
		else if(px>425&&px<500) {
			x=5;
		}
		else if(px>500&&px<575) {
			x=6;
		}
		else if(px>575&&px<650) {
			x=7;
		}
		
		if(py>50&&py<125) {
			y=0;
		}
		else if(py>125&&py<200) {
			y=1;
		}
		else if(py>200&&py<275) {
			y=2;
		}
		else if(py>275&&py<350) {
			y=3;
		}
		else if(py>350&&py<425) {
			y=4;
		}
		else if(py>425&&py<500) {
			y=5;
		}
		else if(py>500&&py<575) {
			y=6;
		}
		else if(py>575&&py<650) {
			y=7;
		}
		
		if(x>=0&&y>=0) {
			//System.out.println(x +"-"+y);
			return this.tablero.getCelda(x, y);
		}
		else {
			return null;
		}
		
	}

	public void contarFichas() {
		int reyClaro = 0,
			reyOscuro = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Celda celda = tablero.getCelda(i, j);
				if(celda.tieneFicha()) {
					if(celda.getFicha().getTipo()=="REY") {
						if (celda.getFicha().getColor() == "CLARO") {
							reyClaro++;
						} else {
							reyOscuro++;
						}
					}
				}
			}
		}
		this.jugador1.setTieneRey(reyClaro>0);
		this.jugador2.setTieneRey(reyOscuro>0);
		
	}
	
	public int getRonda() {
		return this.ronda;
	}

	public int getTurno() {
		return this.turno;
	}
	
	public Tablero getTablero() {
		return this.tablero;
	}
	
	public Jugador getJugador(int i) {
		return i==0?this.jugador1:this.jugador2;
	}
	
	public void resaltaMovibles(Celda celdaorigen) {
		for(int i=0;i<celdaorigen.getFicha().movible(celdaorigen, this.tablero).size();i++) {
			celdaorigen.getFicha().movible(celdaorigen, this.tablero).get(i).setResaltado(true);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.tablero.dibujaTablero(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch (turno) {
		case 0:
			if (!seleccionFicha) {
				this.celdaorigen = this.getCelda(e.getX(), e.getY());
				if (this.celdaorigen.tieneFicha() && this.celdaorigen.getFicha().getColor() == "CLARO") {
					this.seleccionFicha = true;
					this.resaltaMovibles(celdaorigen);
					this.repaint();
				}
			} else {
				this.celdadestino = this.getCelda(e.getX(), e.getY());
				if (this.celdadestino != this.celdaorigen) {
					if (this.moverFicha(this.celdaorigen, this.celdadestino)) {
						this.buscaRey();
						this.jaqueALosClaros();
						this.jaqueALosOscuros();
						this.turno = 1;
					}
					if(!this.hayReyOscuro()) {
						JOptionPane.showMessageDialog(this, "Victoria para los Claros");
						this.reiniciar();
					}
					
				}
				this.seleccionFicha=false;
			}
			break;
		case 1:
			if (!seleccionFicha) {
				this.celdaorigen = this.getCelda(e.getX(), e.getY());
				if (this.celdaorigen.tieneFicha() && this.celdaorigen.getFicha().getColor() == "OSCURO") {
					this.seleccionFicha = true;
					this.resaltaMovibles(celdaorigen);
					this.repaint();
				}
			} else {
				this.celdadestino = this.getCelda(e.getX(), e.getY());
				if (this.celdadestino != this.celdaorigen) {
					if (this.moverFicha(this.celdaorigen, this.celdadestino)) {
						this.buscaRey();
						this.jaqueALosClaros();
						this.jaqueALosOscuros();
						this.turno = 0;
						this.ronda++;
					}
					
				}
				if(!this.hayReyClaro()) {
					JOptionPane.showMessageDialog(this, "Victoria para los Oscuros");
					this.reiniciar();
				}
				this.seleccionFicha = false;
			}
			break;
		}

		this.repaint();
	}
	
	public void buscaRey() {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(this.tablero.getCelda(i, j).getFicha()!=null) {
					if(this.tablero.getCelda(i, j).getFicha().getColor()=="CLARO" && this.tablero.getCelda(i, j).getFicha().getTipo()=="REY") {
						this.poscicionReyClaro=this.tablero.getCelda(i, j);
					}
					if(this.tablero.getCelda(i, j).getFicha().getColor()=="OSCURO" && this.tablero.getCelda(i, j).getFicha().getTipo()=="REY") {
						this.poscisionReyOscuro=this.tablero.getCelda(i, j);
					}
				}
			}
		}
	}
	
	public boolean hayReyClaro() {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(this.tablero.getCelda(i, j).getFicha()!=null) {
					if(this.tablero.getCelda(i, j).getFicha().getColor()=="CLARO" && this.tablero.getCelda(i, j).getFicha().getTipo()=="REY") {
						this.poscicionReyClaro=this.tablero.getCelda(i, j);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean hayReyOscuro() {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(this.tablero.getCelda(i, j).getFicha()!=null) {
					if(this.tablero.getCelda(i, j).getFicha().getColor()=="OSCURO" && this.tablero.getCelda(i, j).getFicha().getTipo()=="REY") {
						this.poscicionReyClaro=this.tablero.getCelda(i, j);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public boolean jaqueALosClaros() {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				//if(this.tablero.getCelda(i, j).getFicha().getColor()!="CLARO"&&this.tablero.getCelda(i, j).getFicha().movible(tablero.getCelda(i, j), this.tablero).contains(poscicionReyClaro)) {
				if(this.tablero.getCelda(i, j).getFicha()!=null) {
					if(this.tablero.getCelda(i, j).getFicha().getColor()!="CLARO"&&this.tablero.getCelda(i, j).getFicha().movible(tablero.getCelda(i, j), this.tablero).contains(poscicionReyClaro)) {
						JOptionPane.showMessageDialog(null, "Jaque a los claros");
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public boolean jaqueALosOscuros() {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(this.tablero.getCelda(i, j).getFicha()!=null) {
					if(this.tablero.getCelda(i, j).getFicha().getColor()!="OSCURO"&&this.tablero.getCelda(i, j).getFicha().movible(tablero.getCelda(i, j), this.tablero).contains(poscisionReyOscuro)) {
						JOptionPane.showMessageDialog(null, "Jaque a los oscuros");
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public boolean moverFicha(Celda celdaorigen, Celda celdadestino) {
		if(celdadestino!=null&&celdaorigen!=null) {
			if(celdaorigen.getFicha().movible(celdaorigen, this.tablero).contains(celdadestino)) {
				//Enroque
				try {
				if(celdaorigen.getFicha().getTipo()=="TORRE"&&celdaorigen.getFicha().getMovimientos()==0) {
					if (celdaorigen == this.tablero.getCelda(0, 0) || celdaorigen == this.tablero.getCelda(0, 7)) {
						if (this.tablero.getCelda(4, celdaorigen.getY()).tieneFicha()) {
							if (this.tablero.getCelda(4, celdaorigen.getY()).getFicha().getMovimientos() == 0) {
								this.tablero.getCelda(2, celdadestino.getY())
										.setFicha(this.tablero.getCelda(4, celdadestino.getY()).getFicha());
								this.tablero.getCelda(2, celdadestino.getY()).getFicha().anadeMovimientos();
								this.tablero.getCelda(4, celdadestino.getY()).setFicha(null);
							}
						}
					}
					else {
						if (this.tablero.getCelda(4, celdaorigen.getY()).tieneFicha()) {
							if (this.tablero.getCelda(4, celdaorigen.getY()).getFicha().getMovimientos() == 0) {
								this.tablero.getCelda(6, celdadestino.getY())
										.setFicha(this.tablero.getCelda(4, celdadestino.getY()).getFicha());
								this.tablero.getCelda(6, celdadestino.getY()).getFicha().anadeMovimientos();
								this.tablero.getCelda(4, celdadestino.getY()).setFicha(null);
							}
						}
					}
				}
				}
				catch(NullPointerException ex) {
					
				}
				
				//Al Paso
				if(celdaorigen.getFicha().getColor()=="CLARO" && celdaorigen.getFicha().getTipo() =="PEON" && celdadestino.getY()==4 && celdaorigen.getFicha().getMovimientos()==0) {
					try {
					if(this.tablero.getCelda(celdadestino.getX()+1, celdadestino.getY()).tieneFicha() && this.tablero.getCelda(celdadestino.getX()+1, celdadestino.getY()).getFicha().getColor()=="OSCURO") {
						if(this.tablero.getCelda(celdadestino.getX()+1, celdadestino.getY()).getFicha().getTipo()=="PEON"&&this.tablero.getCelda(celdadestino.getX()+1, celdadestino.getY()).getFicha().getColor()=="OSCURO") {
							int opcion = JOptionPane.showConfirmDialog(this, "Jugador 2 puede realizar captura al paso", "Captura al Paso", JOptionPane.YES_NO_CANCEL_OPTION);
							switch(opcion) {
							case 0: 
								this.tablero.getCelda(celdadestino.getX(), celdadestino.getY()+1).setFicha(this.tablero.getCelda(celdadestino.getX()+1, celdadestino.getY()).getFicha());
								this.tablero.getCelda(celdadestino.getX(), celdadestino.getY()+1).getFicha().anadeMovimientos();
								this.tablero.getCelda(celdadestino.getX()+1, celdadestino.getY()).setFicha(null);
								celdaorigen.setFicha(null);
								this.turno = 0;
								this.ronda++;
								return false;
							case 1:
								break;
							case 2:
							case -1:
								return false;
							}
						}
					}
					}
					catch(ArrayIndexOutOfBoundsException ex) {
						
					}
					try {
					if(this.tablero.getCelda(celdadestino.getX()-1, celdadestino.getY()).tieneFicha()) {
						if(this.tablero.getCelda(celdadestino.getX()-1, celdadestino.getY()).getFicha().getTipo()=="PEON" && this.tablero.getCelda(celdadestino.getX()-1, celdadestino.getY()).getFicha().getColor()=="OSCURO") {
							int opcion = JOptionPane.showConfirmDialog(this, "Jugador 2 puede realizar captura al paso", "Captura al Paso", JOptionPane.YES_NO_CANCEL_OPTION);
							switch(opcion) {
							case 0: 
								this.tablero.getCelda(celdadestino.getX(), celdadestino.getY()+1).setFicha(this.tablero.getCelda(celdadestino.getX()-1, celdadestino.getY()).getFicha());
								this.tablero.getCelda(celdadestino.getX(), celdadestino.getY()+1).getFicha().anadeMovimientos();
								this.tablero.getCelda(celdadestino.getX()-1, celdadestino.getY()).setFicha(null);
								celdaorigen.setFicha(null);
								this.turno = 0;
								this.ronda++;
								return false;
							case 1:
								break;
							case 2:
							case -1:
								return false;
							}
						}
					}
					}
					catch(ArrayIndexOutOfBoundsException ex) {
						
					}
					
					
				}
				if(celdaorigen.getFicha().getColor()=="OSCURO" && celdaorigen.getFicha().getTipo() =="PEON" && celdadestino.getY()==3 && celdaorigen.getFicha().getMovimientos()==0) {
					try {
					if(this.tablero.getCelda(celdadestino.getX()+1, celdadestino.getY()).tieneFicha() && this.tablero.getCelda(celdadestino.getX()+1, celdadestino.getY()).getFicha().getColor()=="CLARO") {
						if(this.tablero.getCelda(celdadestino.getX()+1, celdadestino.getY()).getFicha().getTipo()=="PEON") {
							int opcion = JOptionPane.showConfirmDialog(this, "Jugador 2 puede realizar captura al paso", "Captura al Paso", JOptionPane.YES_NO_CANCEL_OPTION);
							switch(opcion) {
							case 0: 
								this.tablero.getCelda(celdadestino.getX(), celdadestino.getY()-1).setFicha(this.tablero.getCelda(celdadestino.getX()+1, celdadestino.getY()).getFicha());
								this.tablero.getCelda(celdadestino.getX(), celdadestino.getY()-1).getFicha().anadeMovimientos();
								this.tablero.getCelda(celdadestino.getX()+1, celdadestino.getY()).setFicha(null);
								celdaorigen.setFicha(null);
								this.turno = 1;
								return false;
							case 1:
								break;
							case 2:
							case -1:
								return false;
							}
							
						}
					}
					}
					catch(ArrayIndexOutOfBoundsException ex) {
						
					}
					
					try {
					if(this.tablero.getCelda(celdadestino.getX()-1, celdadestino.getY()).tieneFicha()) {
						if(this.tablero.getCelda(celdadestino.getX()-1, celdadestino.getY()).getFicha().getTipo()=="PEON" && this.tablero.getCelda(celdadestino.getX()-1, celdadestino.getY()).getFicha().getColor()=="CLARO") {
							int opcion = JOptionPane.showConfirmDialog(this, "Jugador 2 puede realizar captura al paso", "Captura al Paso", JOptionPane.YES_NO_CANCEL_OPTION);
							switch(opcion) {
							case 0: 
								this.tablero.getCelda(celdadestino.getX(), celdadestino.getY()-1).setFicha(this.tablero.getCelda(celdadestino.getX()-1, celdadestino.getY()).getFicha());
								this.tablero.getCelda(celdadestino.getX(), celdadestino.getY()-1).getFicha().anadeMovimientos();
								this.tablero.getCelda(celdadestino.getX()-1, celdadestino.getY()).setFicha(null);
								celdaorigen.setFicha(null);
								this.turno = 1;
								return false;
							case 1:
								break;
							case 2:
							case -1:
								return false;
							}
						}
					}
					}
					catch(ArrayIndexOutOfBoundsException ex) {
						
					}
				}
				
				
				
				celdadestino.setFicha(celdaorigen.getFicha());
				celdaorigen.setFicha(null);
				celdadestino.getFicha().anadeMovimientos();
				
				if(celdadestino.getFicha().getTipo()=="PEON" && (celdadestino.getY()==7||celdadestino.getY()==0)) {
					Object[] opciones = {"Reina","Alfil","Caballo","Torre"};
					int eleccion = JOptionPane.showOptionDialog(this, "¿Por qué ficha deseas cambiar el peón?", "Promoción del Peón", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
					int color = (celdadestino.getFicha().getColor()=="CLARO")?0:1;
					Ficha elegida = null;
					switch(eleccion) {
					case 0:
						elegida = new Reina(color);
						break;
					case 1:
						elegida = new Alfil(color);
						break;
					case 2:
						elegida = new Caballo(color);
						break;
					case 3:
						elegida = new Torre(color);
						break;
					}
					celdadestino.setFicha(null);
					celdadestino.setFicha(elegida);
					return true;
				}
				
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
