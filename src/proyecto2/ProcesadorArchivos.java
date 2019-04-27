package proyecto2;

import java.io.File;
import java.io.InputStream;
import java.util.StringTokenizer;

public class ProcesadorArchivos {

    /** Lector de Archivo */
    LectorArchivos lector;

    /** Cola de ficheros */
    Cola<File> ficheros;

    public ProcesadorArchivos(InputStream in) {
        lector = new LectorArchivos(in);
        String linea;
        while ((linea = lector.leer()) != null) {
            StringTokenizer st = new StringTokenizer(linea.trim());
            while (st.hasMoreTokens()) {
                String palabra = st.nextToken();
                if (!palabra.endsWith(".txt"))
                    throw new IllegalArgumentException();

                File archivo = new File(palabra);

                if (!archivo.exists() || !archivo.isFile())
                    throw new IllegalArgumentException();

                ficheros.mete(archivo);
            }
        }
        lector.cerrar();
    }


}
