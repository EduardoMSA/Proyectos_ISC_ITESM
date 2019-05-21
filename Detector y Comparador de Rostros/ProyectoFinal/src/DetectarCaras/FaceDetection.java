package DetectarCaras;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetection {

    public static final Size DIMENSIONES_ESTANDAR = new Size(100, 100);

    public void deteccion(String file) throws NullPointerException {
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

	// Lee y transforma una imagen a Mat
	Mat src = Imgcodecs.imread(file);

	// Separa el tipo del archivo de la dirección
	String[] direccion = file.split("\\.");

	Imgcodecs.imwrite(direccion[0] + "." + direccion[1], src);

	// Usa un archivo .xml para crear un classifier
	String xmlFile = "Extras/lbpcascade_frontalface.xml";
	CascadeClassifier classifier = new CascadeClassifier(xmlFile);

	// Detecta caras en la imagen
	MatOfRect faceDetections = new MatOfRect();
	classifier.detectMultiScale(src, faceDetections);
	//System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

	// En caso de detectar más de una cara
	// Dibuja marco al rededor de cara

	Rect rectCrop = null;
	for(Rect rect : faceDetections.toArray()) {
	    Imgproc.rectangle(src,                                               // where to draw the box
		    new Point(rect.x, rect.y),                            // bottom left
		    new Point(rect.x + rect.width, rect.y + rect.height), // top right
		    new Scalar(0, 0, 255), 3
	    // RGB colour
	    );
	    // Guarda en un rect los puntos para crear el cuadro
	    rectCrop = new Rect(rect.x, rect.y, rect.width, rect.height);
	    break;
	}

	// Guarda la imagen
	Imgcodecs.imwrite(direccion[0] + "cuadro." + direccion[1], src);
	// Crea un Mat con las nuevas restricciones del crop
	Mat crop = new Mat(src, rectCrop);
	Mat cropResize = new Mat();

	// Guarda la imagen recortada
	Imgproc.resize(crop, cropResize, DIMENSIONES_ESTANDAR);
	Imgcodecs.imwrite(direccion[0] + "crop." + direccion[1], cropResize);

	//System.out.println("Done.");

    }

    public static void main(String[] args) {
    }
}