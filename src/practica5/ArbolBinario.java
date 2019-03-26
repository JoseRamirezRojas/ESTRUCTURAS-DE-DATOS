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
        if(this.raiz!=null){
            Cola<Vertice> cola=new Cola<>();
            cola.mete(this.raiz);
            while (cola.esVacia()==false){
                Vertice v=cola.mira();
                if (v.izquierdo!=null)
                    cola.mete(v.izquierdo);
                if (v.derecho!=null)
                    cola.mete(v.derecho);
                funcion.accept(v.elemento);
                cola.saca();
            }
        }
    }

    public void dfs(int tipo, Consumer<T> funcion){
        switch (tipo) {
            case 1:
                //pre order
                dfsPreOrder(raiz,funcion);
            case 2:
                //in order
                dfsInOrder(raiz,funcion);
            case 3:
                //post order
                dfsPostOrder(raiz,funcion);
        }
    }

    private void dfsPreOrder(Vertice v,Consumer<T> funcion){
        if(v!=null){
            funcion.accept(v.elemento);
            dfsPreOrder(v.izquierdo, funcion);
            dfsPreOrder(v.derecho,funcion);
        }
        return;
    }

    private void dfsInOrder(Vertice v,Consumer<T> funcion){
        if(v!=null){
            dfsInOrder(v.izquierdo,funcion);
            funcion.accept(v.elemento);
            dfsInOrder(v.derecho,funcion);
        }
        return;
    }

    private void dfsPostOrder(Vertice v,Consumer<T> funcion){
        if(v!=null){
            dfsPostOrder(v.izquierdo,funcion);
            dfsPostOrder(v.derecho,funcion);
            funcion.accept(v.elemento);

        }
        return;
    }


    public int getElementos(){
        return elementos;
    }
}