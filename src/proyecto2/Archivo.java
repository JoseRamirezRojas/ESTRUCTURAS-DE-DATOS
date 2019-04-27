package proyecto2;

import java.io.File;
import java.lang.Comparable;

public class Archivo implements Comparable<Archivo>{
    File archivo;
    ArbolAVL <Cadena> palabras;
    double tf;

    private Archivo() {}

    public Archivo(String archivo) {
        if (!archivo.endsWith(".txt"))
            throw new IllegalArgumentException();

        this.archivo = new File(archivo);

        if (!this.archivo.exists() || !this.archivo.isFile())
            throw new IllegalArgumentException();
    }

    @Override public int compareTo(Archivo archivo) {
        return 0;
    }
}