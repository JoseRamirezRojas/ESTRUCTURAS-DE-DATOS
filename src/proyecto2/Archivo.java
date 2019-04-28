package proyecto2;

import java.io.File;
import java.lang.Comparable;

public class Archivo implements Comparable<Archivo>{

    /** Archivo interno */
    private File archivo;

    /** Colección de palabras en un archivo */
    private ArbolAVL<Cadena> palabras;

    /** Valor TF del archivo */
    private double tf;

    private Archivo() {}

    public Archivo(File archivo) {
        if (archivo == null || !archivo.exists() || !archivo.isFile())
            throw new IllegalArgumentException();

        this.archivo = archivo;
        palabras = new ArbolAVL<Cadena>();
    }

    public double getTF() {
        return tf;
    }

    public void setTF(double tf) {
        this.tf = tf;
    }

    public File getArchivo() {
        return archivo;
    }

    protected void agregaPalabra(Cadena palabra) {
        palabras.agrega(palabra);
    }

    @Override public int compareTo(Archivo archivo) {
        double tfArchivo = archivo.getTF();

        if (tf > tfArchivo)
            return 1;

        if (tf < tfArchivo)
            return -1;

        return 0;
    }
}
