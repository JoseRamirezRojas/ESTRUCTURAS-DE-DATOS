package proyecto2;

import java.io.File;
import java.io.InputStream;
import java.util.StringTokenizer;

/**
 * Clase que lee una serie de archivos y creo un objeto Archivo por cada archivo leido.
 */
public class ProcesadorArchivos {

    /** Lector de Archivo */
    private LectorArchivos lector;

    /** Lista De archivos */
    private Lista<Archivo> archivos;

    public ProcesadorArchivos(InputStream in) {
        archivos = new Lista<Archivo>();
        lector = new LectorArchivos(in);
        String linea;
        while ((linea = lector.leer()) != null) {
            StringTokenizer st = new StringTokenizer(linea.trim());
            while (st.hasMoreTokens()) {
                String palabra = st.nextToken();
                if (!palabra.endsWith(".txt"))
                    throw new IllegalArgumentException();

                File archivo = new File(palabra);

                archivos.agrega(new Archivo(archivo));
            }
        }
        lector.cerrar();
    }

    public Lista<Archivo> procesaArchivos() {
        for (Archivo archivo : archivos) {
            lector = new LectorArchivos(archivo.getArchivo());
            String linea;
            while ((linea = lector.leer())!= null) {
                StringTokenizer st = new StringTokenizer(linea);
                while (st.hasMoreTokens())
                    //System.out.println(st.nextToken());
                    archivo.agregaPalabra(new Cadena(st.nextToken()));
            }
        }
        return archivos;
    }
}
