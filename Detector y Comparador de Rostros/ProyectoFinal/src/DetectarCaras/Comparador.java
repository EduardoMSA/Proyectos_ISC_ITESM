package DetectarCaras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import AVL.ArbolAVL;
import AVL.NodoAVL;
import jssim.SsimException;

public class Comparador extends JPanel {

    private String	   path	= "";
    private JFileChooser   fc;
    private ArbolAVL	   rostros;
    private PrintWriter	   pw;
    private BufferedReader br;
    private Rostro	   rostro, rostroSimilar;
    private Image	   imagen1, imagen2;
    private boolean	   estado;
    private JButton	   imagenSiguiente, guardar;
    private JLabel	   nombreDelRostro;
    private double	   ssim;

    public Comparador() throws SsimException, IOException, NullPointerException {
	this.setPreferredSize(new Dimension(700, 800));
	this.fc = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
	fc.setFileFilter(filter);
	fc.setCurrentDirectory(new File("C:\\Users\\eduar\\Desktop\\Imagenes Prueba"));
	fc.showOpenDialog(Comparador.this);
	this.path = fc.getSelectedFile().getAbsolutePath();
	this.rostros = new ArbolAVL();
	this.leerArbol();
	this.rostro = new Rostro(path);
	this.rostroSimilar = this.rostros.rostroSimilarProfundo(this.rostro); // Cambiar metodo a rostroSimilarProfundo
									      // para más precisión
	// this.rostroSimilar = this.rostros.rostroSimilar(this.rostro);
	this.ssim = rostro.compareTo(rostroSimilar);
	this.estado = true;
	this.imagen1 = new ImageIcon(this.rostro.getCuadro().getPath()).getImage();
	this.imagen2 = new ImageIcon(this.rostroSimilar.getCuadro().getPath()).getImage();
	this.imagenSiguiente = new JButton("Siguiente");
	this.imagenSiguiente.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Comparador.this.estado = !Comparador.this.estado;
		repaint();

	    }
	});
	this.nombreDelRostro = new JLabel("Tú");
	this.nombreDelRostro.setForeground(Color.RED);
	this.guardar = new JButton("Guardar Imagen");
	this.guardar.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		try {

		    String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
		    nombre = nombre.replace(' ', '_');
		    Mat src = Imgcodecs.imread(Comparador.this.path);
		    Imgcodecs.imwrite("IMGS/" + nombre + ".jpg", src);
		    System.out.println("IMGS/" + nombre + ".jpg");
		    Comparador.this.rostros.insertar(new Rostro("IMGS/" + nombre + ".jpg"));
		    Comparador.this.guardarArbol();
		}
		catch(SsimException | IOException | NullPointerException ex) {
		    // TODO Auto-generated catch block
		}

	    }
	});

	this.add(this.imagenSiguiente);
	this.add(this.guardar);
	this.add(this.nombreDelRostro);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	if(this.estado) {
	    this.nombreDelRostro.setText("Tú");
	    g.drawImage(this.imagen1, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	else {
	    String n = this.rostroSimilar.getPath().replace("IMGS/", "");
	    n = n.replace(".jpg", "");
	    n = n.replace("_", " ");
	    this.nombreDelRostro.setText(n + " SSMI: " + this.ssim);
	    g.drawImage(this.imagen2, 0, 0, this.getWidth(), this.getHeight(), this);
	}

    }

    public void guardarArbol() throws IOException {
	NodoAVL[] nodos = this.rostros.preorder();
	pw = new PrintWriter(new FileWriter("Extras/rostros.txt"));
	for(NodoAVL nodo : nodos) {
	    // System.out.println(nodo.getRostro().getPath());
	    pw.println(nodo.getRostro().getPath());
	}
	pw.close();
    }

    public void leerArbol() throws IOException, SsimException {
	br = new BufferedReader(new FileReader("Extras/rostros.txt"));
	String linea;
	Stack<Rostro> rostros = new Stack<>();
	while((linea = br.readLine()) != null) {
	    rostros.push(new Rostro(linea));
	}
	while(!rostros.isEmpty()) {
	    this.rostros.insertar(rostros.pop());
	}
    }

    public static void main(String[] args) {
    }
}
