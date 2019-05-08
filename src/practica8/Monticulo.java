package practica8;
import java.lang.reflect.Array;
import java.util.Comparator;


/**
 * Clase que implementa montículos mínimos y montículos máximos con enteros.
 *
 * @author Jose David Ramírez Rojas
 * @author Uriel Cruz Carmona
 */
public class Monticulo{

    private int[] elementos;
    private Comparator<Integer> comparador;
    private int ultimoIndice;

    /**
     * Constructor vacío de un heap, crea un arreglo de tamaño 100.
     */
    public Monticulo(){
        ultimoIndice=-1;
        elementos=new int[100];
        comparador= (integer1, integer2) -> {
            if (integer1>integer2)
                return 1;
            if (integer1<integer2)
                return -1;
            return 0;
        };
    }

    /**
     * Este constructor hace exactamente lo mismo que el constructor vacío pero recibiendo un comparador que puede ser
     * distinto al del orden natural de int.
     * @param comparador Comparator con el que se organizará el heap.
     */
    public Monticulo(Comparator<Integer> comparador){
        ultimoIndice=-1;
        elementos=new int[100];
    }

    /**
     * Constructor de un montículo a partir del arreglo dado.
     * @param elementos Arreglo con el que se contruirá el montículo.
     */
    public Monticulo(int[] elementos){
        int n;
        for(n=(elementos.length/2)-1;n>=0;n--){
            //falta código
        }
    }

    /**
     * Constructor de un montículo a partir del arreglo dado y con un comparador distinto al del orden natural de int.
     * @param elementos  Arreglo con el que se contruirá el montículo.
     * @param comparador Comparator con el que se organizará el heap.
     */
    public Monticulo(int[] elementos, Comparator<Integer> comparador){
        int n;
        for(n=(elementos.length/2)-1;n>=0;n--){
            //falta código
        }
    }

    /**
     * Elimina la raíz del montículo y lo reacomoda para que siga conservando sus propiedades.
     * Lanza la excepción {@link IllegalStateException} si el montículo esta vacío.
     * @return La raíz del montículo.
     * @throws IllegalStateException cuando el montículo está vacío.
     */
    public int elimina(){
        //falta código
        if(esVacio())
            throw new IllegalStateException();
        //regresar el elemento que estaba en la raíz del montículo.
        antiguaRaiz = elementos[0];
        elementos[ultimoIndice] = elementos[0];
        ultimoIndice --;
        acomodaHaciaAbajo(elementos[0]);
        return antiguaRaiz;



    }

    /**
     * Nos regresa si el elemento recibido está o no en el montículo.
     * @param elemento  Número entero del cual queremos saber si se encuentra en el montículo.
     * @return          <code>true</code>   Si el elemento está en el montículo.
     *                  <code>false</code>  En otro caso.
     */
    public boolean contiene(int elemento){
        if(elemento<0 || elemento>=elementos.length)
            return false;

        // Aquí va su código.
    }

    /**
     * Indica si el montículo es vacío.
     * @return  <code>true</code>   Si el montículo está vacío.
     *          <code>false</code>  En otro caso.
     */
    public boolean esVacio(){
        // Aquí va su código.
        return false;
    }

    /**
     * Regresa el tamaño del montículo.
     * @return Número de elementos del montículo.
     */
    public int getTamano(){
        return ultimoIndice+1;
    }

    /**
     * Agrega un elemento al final del arreglo y luego lo reacomoda.
     * @param i Elemento a agregar al montículo.
     */
    public void agrega(int i){
        // Aquí va su código.
        if(ultimoIndice+1 == this.elementos.length){
            int nuevoarreglo [] = new int [elementos.length*2];
            for(int i =0; i<elementos.length; i++){
                nuevoarreglo [i] = elementos [i];
            }  

        }


    }
}