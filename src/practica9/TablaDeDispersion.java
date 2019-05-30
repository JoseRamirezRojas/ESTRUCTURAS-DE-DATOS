package practica9;


/**
 * Clase que define tablas de dispersión.
 *
 * Ramírez Rojas José Dvid
 * Cruz Carmona Uriel
 */
public class TablaDeDispersion<K, V>{

    /**
     * Clase privada de las tablas de dispersión, contiene una llave y un valor.
     */
    private class Entrada {

    	public K llave;
    	public V valor;

        /**
         * Constructor de la clase privada Entrada
         * @param llave Llave K con la que construimos la entrada
         * @param valor Valor V con la que construimos la entrada
         */
    	public Entrada(K llave, V valor){
    	    this.llave=llave;
    	    this.valor=valor;
    	}
    }
 
    private Lista<Entrada>[] tabla;  
    private Dispersor<K> dispersor;
    private int elementos;
    public static final int CAPACIDAD_MINIMA = 64;
    private static final double CARGA_MAXIMA = 0.75;

    /**
     * Crea un arreglo genérico
     * @param tamano  Tamaño del arreglo genérico
     * @return  Arrgelo de listas de entradas.
     */
    private Lista<Entrada>[] nuevoArreglo(int tamano){
	@SuppressWarnings("unchecked")
        Lista<Entrada>[] arreglo = (Lista<Entrada>[]) new Lista[tamano];
        return arreglo;
    }

    /**
     * Constructor vacío de una tabla de dispersión
     */
     public TablaDeDispersion(){

        this(CAPACIDAD_MINIMA, (K llave )-> llave.hashCode());
     }

    /**
     * Constructor de una tabla de dispersión que recibe la capacidad de la misma.
     * @param capacidad Capacidad de la tabla a crear
     */
    public TablaDeDispersion(int capacidad){

        this(capacidad, (K llave) -> llave.hashCode());
    }

    /**
     * Constructor de una tabla de dispersión que recibe un dispersor.
     * @param dispersor Dispersor de la tabla a crear
     */
    public TablaDeDispersion(Dispersor<K> dispersor){
        this(CAPACIDAD_MINIMA,dispersor);
    }

    /**
     * Constructor de una tabla de dispersión que recibe su dispersor y su capacidad
     * @param capacidad Capacidad de la tabla a crear
     * @param dispersor Dispersor de la tabla a crear
     */
    public TablaDeDispersion(int capacidad, Dispersor<K> dispersor){
	// Aquí va su código.
        this.dispersor = dispersor;
        int n = 1;
        
        while (n < capacidad * 2)
            n *= 2;

        tabla = nuevoArreglo(n);
    }

    /**
     * Recibe una llave y un valor, y agrega el valor a la posición correspondiente a la llave.
     * @param llave Llave recibida del valor.
     * @param valor Valor a agregar en la tabla.
     */
    public void agrega(K llave, V valor){
        if(llave == null || valor == null)
            return;

        int dispersion = dispersor.dispersa(llave) & (tabla.length - 1);

        if (tabla[dispersion] == null) {
            tabla[dispersion] = new Lista<>();
            tabla[dispersion].agregaFinal(new Entrada(llave,valor));
            elementos++;
        } else {
            boolean estaLlave = false;

            for (Entrada entrada : tabla[dispersion]) {
                if (entrada.llave.equals(llave)) {
                    estaLlave = true;
                    entrada.valor = valor;
                }
            }

            if (!estaLlave) {
                elementos++;
                tabla[dispersion].agregaFinal(new Entrada(llave,valor));
            }
        }

        if (getCarga() >= CARGA_MAXIMA)
            incrementaTabla();
    }

    /**
     * Recibe una llave y regresa el valor asociado a ella, si existe.
     * @param llave LLave de la que se quiere obtener su valor asociado.
     * @return      Valor de la llave recibida.
     */
    public V getValor(K llave){
        if (llave == null)
            return null;

        Lista<Entrada> listaTabla = tabla[dispersor.dispersa(llave) & (tabla.length-1)];
        V valor = null;
        for (Entrada entrada : listaTabla)
            if (entrada.llave.equals(llave))
                valor = entrada.valor;

        return valor;
    }

    /**
     * Indica si la llave recibida está contenida en la tabla.
     * @param llave     Llave que queremos saber si está en la tabla.
     * @return          <tt>true</tt>   Si la llave está en la tabla.
     *                  <tt>false</tt>  En otro caso.
     */
    public boolean contieneLlave(K llave){
        if (llave == null)
            return false;

        Lista<Entrada> listaTabla = tabla [dispersor.dispersa(llave) & (tabla.length-1)];
        for (Entrada entrada : listaTabla)
            if (entrada.llave.equals(llave))
                return true;

        return false;
    }

    /**
     * Indica si el valor recibido está contenido en la tabla.
     * @param valor     Valor que queremos saber si está en la tabla.
     * @return          <tt>true</tt>   Si el valor está en la tabla.
     *                  <tt>false</tt>  En otro caso.
     */
    public boolean contieneValor(V valor){
        if (valor == null)
            return false;

        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i]==null)
                continue;
            Lista<Entrada> lista = tabla[i];
            for (Entrada entrada : lista)
                if (entrada.valor.equals(valor))
                    return true;
        }

        return false;
    }

    /**
     * Indica si la tabla es vacía.
     * @return       <tt>true</tt>   Si la tabla está vacía.
     *               <tt>false</tt>  En otro caso.
     */
    public boolean esVacia(){
	    return elementos==0;
    }

    /**
     * Elimina el elemento asociado a la llave.
     * @param llave  Llave del elemento a eliminar
     * @return       Elemento eliminado de la tabla de dispersión, asociado a la llave recibida.
     */
    public V elimina(K llave){
        if (llave == null)
            return null;

        int llaveDispersada = dispersor.dispersa(llave) & (tabla.length-1);
        Lista<Entrada> listaTabla = tabla[dispersor.dispersa(llave) & (tabla.length-1)];

        if(listaTabla == null)
            return null;

        for (Entrada entrada : listaTabla) {
            if (entrada.llave.equals(llave)) {
                listaTabla.elimina(entrada);
                elementos--;
                if (listaTabla.getLongitud()==0)
                    tabla[llaveDispersada] = null;
                return entrada.valor;
            }
        }
        
        return null;
    }

    /**
     * Regresa el número de elementos de la tabla.
     * @return  Variable de clase elementos
     */
    public int getElementos(){
	    return elementos;
    }

    /**
     * Regresa una lista con todas las llaves de la tabla.
     * @return  Lista con las llaves de la tabla.
     */
    public Lista<K> getLlaves(){
        Lista<K> llaves = new Lista<>();

        for (Lista<Entrada> lista : tabla)
            if (lista != null)
                for (Entrada entrada : lista)
                    llaves.agregaFinal(entrada.llave);

        return llaves;
    }

    /**
     * Regresa una lista con todos los valores de la tabla.
     * @return  Lista con los valores de la tabla.
     */
    public Lista<V> getValores(){
        Lista<V> valores = new Lista<>();

        for (Lista<Entrada> lista : tabla)
            if (lista != null)
                for (Entrada entrada : lista)
                    valores.agregaFinal(entrada.valor);

        return valores;
    }

    /**
     * Regresa la carga actual del diccionario.
     * @return Carga del diccionario.
     */
    private double getCarga() {
        return (double)elementos/tabla.length;
    }

    /**
     * Incrementa el tamaño de la tabla al doble.
     */
    private void incrementaTabla() {
        Lista<Entrada>[] diccionario = tabla;
        tabla = nuevoArreglo(diccionario.length*2);
        int llaveDispersada;

        for (Lista<Entrada> entradas : diccionario) {
            if (entradas != null) {
                for (Entrada entrada : entradas) {
                    llaveDispersada = dispersor.dispersa(entrada.llave) & (tabla.length - 1);
                    if (tabla[llaveDispersada] != null) {
                        tabla[llaveDispersada].agregaFinal(entrada);
                    } else {
                        Lista<Entrada> nuevaEntrada = new Lista<>();
                        nuevaEntrada.agregaFinal(entrada);
                        tabla[llaveDispersada] = nuevaEntrada;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TablaDeDispersion<Integer, Integer> tablaDeDispersion = new TablaDeDispersion<>();
        tablaDeDispersion.agrega(21, 12);
        tablaDeDispersion.agrega(25, 121);
        tablaDeDispersion.agrega(30, 151);
        tablaDeDispersion.agrega(33, 15);
        tablaDeDispersion.agrega(35, 89);

        System.out.println(tablaDeDispersion.contieneLlave(21));
        System.out.println("Valor correspondiente a la llave 21: " + tablaDeDispersion.getValor(21));
        System.out.println("Valor correspondiente a la llave 35: " + tablaDeDispersion.getValor(35));
        System.out.println(tablaDeDispersion.contieneValor(89));

        System.out.print("\nValores : \n");
        tablaDeDispersion.getValores().imprimeElementos();
        System.out.print("Llaves : \n");
        tablaDeDispersion.getLlaves().imprimeElementos();

        System.out.println("\n\nValor eliminado correspondiente a la llave 21 : " + tablaDeDispersion.elimina(21));
        System.out.println("Valor eliminado correspondiente a la llave  35 : " + tablaDeDispersion.elimina(35));
        System.out.println(tablaDeDispersion.contieneValor(89));

        System.out.print("\nValores :\n");
        tablaDeDispersion.getValores().imprimeElementos();
        System.out.print("Llaves : \n");
        tablaDeDispersion.getLlaves().imprimeElementos();
        System.out.println("Elementos : "+tablaDeDispersion.getElementos());


        String palabra="adios";
        byte[] bytes=palabra.getBytes();
        System.out.println("\nPrueba DBJ\n"+ Dispersiones.dispersionDJB(bytes));

    }
}