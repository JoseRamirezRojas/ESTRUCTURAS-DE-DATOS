package proyecto3;

/**
 * Clase con varias funciones de dispersión.
 */
public class Dispersiones{

    /**
     * Función de dispersión de XOR
     * @param a Arreglo de bytes
     * @return  Dispersión de la entrada.
     */
    public static int dispersionXOR(byte[] a){
	// Aquí va su código.
        return 0;
    }

    /**
     * Función de dispersión de Bob Jenkins
     * @param a Arreglo de bytes
     * @return  Dispersión de la entrada.
     */
    public static int dispersionBJ(byte[] a){
	// Aquí va su código.
        return 0;
    }

    /**
     * Función de dispersión de Daniel J. Bernstein
     * @param a Arreglo de bytes
     * @return  Dispersión de la entrada.
     */
    public static int dispersionDJB(byte[] a){
        int djb=5381;
        for (byte b : a) {
            djb = djb * 33 + (b & 0xFF);
        }
        return djb;
    }
}