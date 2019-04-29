package proyecto2;

import java.io.File;
import java.lang.Comparable;

public class Archivo implements Comparable<Archivo>{

    /** Archivo interno */
    private File archivo;

    /** Coleccion de palabras en un archivo */
    private ArbolAVL<Cadena> palabras;

    /** Valor de la similitud del archivo  con una busqueda*/
    private double sim  ;

    private Archivo() {}

    public Archivo(File archivo) {
        if (archivo == null || !archivo.exists() || !archivo.isFile())
            throw new IllegalArgumentException();

        this.archivo = archivo;
        palabras = new ArbolAVL<Cadena>();

        sim = -1;
    }

    public double getSim() {
        return sim;
    }

    public void setSim(double sim) {
        this.sim = sim;
    }

    public File getArchivo() {
        return archivo;
    }

    public void agregaPalabra(Cadena palabra) {
        palabras.agrega(palabra);
    }

    public ArbolAVL<Cadena> getPalabras() {
        return palabras;
    }

    @Override public int compareTo(Archivo archivo) {
        double tfArchivo = archivo.getSim();

        if (sim > tfArchivo)
            return 1;

        if (sim < tfArchivo)
            return -1;

        return 0;
    }
}
