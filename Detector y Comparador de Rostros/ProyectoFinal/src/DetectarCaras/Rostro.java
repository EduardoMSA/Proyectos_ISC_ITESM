package DetectarCaras;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import jssim.SsimCalculator;
import jssim.SsimException;

public class Rostro {

    private File		      cara, crop, cuadro;
    private SsimCalculator	      ssim;
    private double		      indiceNC;
    private String		      path;
    private String		      nombre;
    public static final FaceDetection FD      = new FaceDetection();
    public static final File	      NC_CROP = new File("IMGS/NCcrop.jpg");

    public Rostro(String path) throws SsimException, IOException {

	// Detecta la cara dentro de la imagen y crea otra imagen recortada
	this.path = path;
	try {
	    FD.deteccion(this.path);
	}
	catch(NullPointerException ex) {
	    JOptionPane.showMessageDialog(null, "Rostro no encontrado.");
	}

	this.cara = new File(this.path);
	String[] direccion = this.path.split("\\.");
	this.crop = new File(direccion[0] + "crop." + direccion[1]);
	this.cuadro = new File(direccion[0] + "cuadro." + direccion[1]);
	String[] nombres = direccion[0].split("/");
	this.nombre = nombres[0].replace('_', ' '); // CAMBIAR
	// Crea objeta SSIM para que sea posible la comparación con otras imagenes
	this.ssim = new SsimCalculator(this.crop);
	this.indiceNC = this.compareTo(NC_CROP);
    }

    // Getters
    public File getCara() {
	return this.cara;
    }

    public String getNombre() {
	return this.nombre;
    }

    public String getPath() {
	return this.path;
    }

    public File getCrop() {
	return this.crop;
    }

    public File getCuadro() {
	return this.cuadro;
    }

    public double getIndiceNC() {
	return this.indiceNC;
    }

    // Metodos de comparación
    public double compareTo(File file) throws SsimException, IOException {
	return ssim.compareTo(file);
    }

    public double compareTo(String ruta) throws SsimException, IOException {
	File file = new File(ruta);
	return ssim.compareTo(file);
    }

    public double compareTo(Rostro rostro) throws SsimException, IOException {
	return ssim.compareTo(rostro.getCrop());
    }

    public static void main(String[] args) {
	// Rostro rostro1 = new Rostro("IMGS/taylorL.jpg");
	// Rostro rostro2 = new Rostro("IMGS/krisH.jpg");
	// System.out.println(rostro1.compareTo(rostro2));
	// System.out.println(rostro1.getIndiceNC());
	// System.out.println(rostro2.getIndiceNC());
	try {
	    Rostro rostro1 = new Rostro("IMGS/John_Krasinki.jpg");
	    System.out.println(rostro1.getNombre());
	}
	catch(SsimException | IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
