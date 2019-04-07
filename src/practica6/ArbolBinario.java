package practica5;
import java.util.function.Consumer;

/**
 * Ramírez Rojas José David
 * Cruz Carmona Uriel
 *
 * Clase que representa un Árbol Binario.
 */
public abstract class ArbolBinario<T>{

    protected class Vertice{

        public T elemento;
        public Vertice izquierdo;
        public Vertice derecho;
        public Vertice padre;

        /**
         * Representa un vértice de un árbol.
         * @param elemento
         */
        public Vertice(T elemento){
            this.elemento=elemento;
        }
    }

    /* variables de todo arbol */
    protected Vertice raiz;
    protected int elementos;

    /**
     * Constructor vacío de un Árbol binario
     */
    public ArbolBinario(){
        raiz=null;
        elementos=0;
    }

    /**
     * Constructor a partir de un arreglo de un Árbol binario
     * @param arreglo   Arreglo de elementos para construir el árbol
     */
    public ArbolBinario(T[] arreglo){
        for (T elemento: arreglo) {
            agrega(elemento);
        }
    }


    public abstract void agrega(T elemento);

    public abstract boolean elimina(T elemento);

    public abstract boolean contiene(T elemento);

    /**
     * Realiza un recorrido BFS del árbol.
     * @param funcion Dicta lo que debe hacer el método con cada elemento del recorrido.
     */
    public void bfs(Consumer<T> funcion){
        if(raiz!=null){
            Cola<Vertice> cola=new Cola<>();
            cola.mete(this.raiz);
            while (!cola.esVacia()){
                Vertice v=cola.mira();
                cola.saca();
                funcion.accept(v.elemento);
                if (v.izquierdo!=null)
                    cola.mete(v.izquierdo);
                if (v.derecho!=null)
                    cola.mete(v.derecho);

            }
        }
    }

    /**
     * Realiza un recorrido DFS del árbol.Recibe un entero que nos dirá qué tipo de recorrido DFS se realiza.
     * @param tipo    Entero que indica el tipo de recorrido a realizar: 1 para preorden, 2 para inorden,
     *                y 3 para postorden.
     * @param funcion Dicta lo que debe hacer el método con cada elemento del recorrido.
     */
    public void dfs(int tipo, Consumer<T> funcion){
        switch (tipo) {
            case 1:
                //pre order
                dfsPreOrder(raiz,funcion);
                break;
            case 2:
                //in order
                dfsInOrder(raiz,funcion);
                break;
            case 3:
                //post order
                dfsPostOrder(raiz,funcion);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Algoritmo recursivo de recorrido preorden
     * @param v         Vertice del árbol con el que se hace el recorrido
     * @param funcion   Dicta lo que debe hacer el método con cada elemento del recorrido.
     */
    private void dfsPreOrder(Vertice v,Consumer<T> funcion){
        if(v!=null){
            funcion.accept(v.elemento);
            dfsPreOrder(v.izquierdo, funcion);
            dfsPreOrder(v.derecho,funcion);
        }
    }

    /**
     * Algoritmo recursivo de recorrido inorden
     * @param v         Vertice del árbol con el que se hace el recorrido
     * @param funcion   Dicta lo que debe hacer el método con cada elemento del recorrido.
     */
    private void dfsInOrder(Vertice v,Consumer<T> funcion){
        if(v!=null){
            dfsInOrder(v.izquierdo,funcion);
            funcion.accept(v.elemento);
            dfsInOrder(v.derecho,funcion);
        }
    }

    /**
     * Algoritmo recursivo de recorrido postorden
     * @param v         Vertice del árbol con el que se hace el recorrido
     * @param funcion   Dicta lo que debe hacer el método con cada elemento del recorrido.
     */
    private void dfsPostOrder(Vertice v,Consumer<T> funcion){
        if(v!=null){
            dfsPostOrder(v.izquierdo,funcion);
            dfsPostOrder(v.derecho,funcion);
            funcion.accept(v.elemento);

        }
    }

    /**
     * Regresa el número de elementos en el árbol.
     * @return  Número de vértices del árbol.
     */
    public int getElementos(){
        return elementos;
    }

    /**
     * Gira sobre un vértice del árbol a la derecha
     * @param v  Elemento del vértice sobre el que giramos
     */
    public void giraDerecha(Vertice v){
        if (v.izquierdo == null)
            return;
        
		Vertice temp = v.izquierdo;
		temp.padre=v.padre;
		v.padre = temp;
		v.izquierdo=temp.derecho;
		if (temp.derecho!=null)
			temp.derecho.padre = v;
		temp.derecho = v;
    }

    /**
     * Gira sobre un vértice del árbol a la izquierda
     * @param v  Elemento del vértice sobre el que giramos
     */
    public void giraIzquierda(Vertice v){
        if (v.derecho == null)
            return;

        Vertice temp = v.derecho;
        temp.padre = v.padre;
        v.padre = temp;
        v.derecho=temp.izquierdo;
        if (temp.izquierdo!=null) {
            temp.izquierdo.padre = v;
        }
        temp.izquierdo = v;
    }
}