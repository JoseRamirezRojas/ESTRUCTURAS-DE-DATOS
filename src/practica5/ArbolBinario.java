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
            this.agrega(elemento);
        }
    }


    public abstract void agrega(T elemento);

    public abstract boolean elimina(T elemento);

    public abstract boolean contiene(T elemento);

    public void bfs(Consumer<T> funcion){
        funcion.accept(raiz.elemento);
        T t -> 
    }

    public void dfs(int tipo, Consumer<T> funcion){
        switch (tipo){

        }
    }

    public int getElementos(){
        return elementos;
    }
}