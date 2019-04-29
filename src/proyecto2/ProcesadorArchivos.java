package proyecto2;

import java.io.File;
import java.io.InputStream;
import java.util.StringTokenizer;

/**
 * Clase que lee una serie de archivos y creo un objeto Archivo por cada archivo leido.
 */
public class ProcesadorArchivos {

    /** Lector de archivos .txt */
    private LectorArchivos lector;

    /** Lista De archivos */
    private Lista<Archivo> archivos;

    public ProcesadorArchivos(Iterable<String> archivos) {
        this.archivos = new Lista<Archivo>();
        for (String ruta : archivos) {

            if (!ruta.endsWith(".txt")) {
                System.out.println("ERROR: Solo se puede leer archivos con extension .txt");
                return;
            }

            File archivo = new File(ruta);

            if (!archivo.exists() || !archivo.isFile()) {
                System.out.println("Error: no se encontro archivo");
                return;
            }

            this.archivos.agrega(new Archivo(archivo));
        }
    }

    public Lista<Archivo> procesaArchivos() {
        for (Archivo archivo : archivos) {
            lector = new LectorArchivos(archivo.getArchivo());
            String linea;
            while ((linea = lector.leer())!= null) {
                StringTokenizer st = new StringTokenizer(linea);
                while (st.hasMoreTokens())
                    archivo.agregaPalabra(new Cadena(st.nextToken()));
            }
        }
        return archivos;
    }
}
