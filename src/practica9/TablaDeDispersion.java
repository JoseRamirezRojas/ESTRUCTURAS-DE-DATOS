/**
 * Clase que define tablas de dispersión.
 */
public class TablaDeDispersion<K, V>{

        private class Entrada {

    	public K llave;
    	public V valor;

    	public Entrada(K llave, V valor){
    	    // Aquí va su código.
    	}
    }
 
    private Lista<Entrada>[] tabla;  
    private Dispersor<K> dispersor;
    private int elementos;
    public static final int CAPACIDAD_MINIMA = 64;
    private static final double CARGA_MAXIMA = 0.75;

    
    private Lista<Entrada>[] nuevoArreglo(int tamano){
	@SuppressWarnings("unchecked")
	Lista<Entrada>[] arreglo = (Lista<Entrada>[]) new Lista[tamano];
	return arreglo;
    }

     public TablaDeDispersion(){
	 // Aquí va su código.
        this(CAPACIDAD_MINIMA, (k llave -> llave.hashCode());
    }
    
    public TablaDeDispersion(int capacidad){
	// Aquí va su código.
        this(capacidad, (k llave -> llave.hashCode()))
    }

    public TablaDeDispersion(Dispersor<K> dispersor){
	// Aquí va su código.
        this(CAPACIDAD_MINIMA,dispersor);

    }

    public TablaDeDispersion(int capacidad, Dispersor<K> dispersor){
	// Aquí va su código.
        this.dispersor = dispersor;
        int n = 1;
        
        while (n < capacidad * 2)
            n *= 2;

        tabla = nuevoArreglo(n);
    }

    public void agrega(K llave, V valor){
	// Aquí va su código.
        
    }
 
    public V getValor(K llave){
	// Aquí va su código.
    }

    public boolean contieneLlave(K llave){
	// Aquí va su código.
    }

    public boolean contieneValor(V valor){
	// Aquí va su código.
    }

    public boolean esVacia(){
	// Aquí va su código.
    }

    public V elimina(K llave){
	// Aquí va su código.
    }

    public int getElementos(){
	// Aquí va su código.
    }

    public Lista<K> getLlaves(){
	// Aquí va su código.
    }

    public Lista<V> getValores(){
	// Aquí va su código.
    } 
}