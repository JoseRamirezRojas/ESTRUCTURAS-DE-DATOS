package proyecto2;

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

    //variables de todo arbol
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
        if(this.raiz!=null){
            Cola<Vertice> cola=new Cola<>();
            cola.mete(this.raiz);
            while (!cola.esVacia()){
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
     * @param v  Vértice del árbol sobre el que giramos
     */
    protected void giraDerecha(Vertice v){
        if(!contiene(v.elemento))
            return;
        if (v.izquierdo == null)
            return;

        Vertice aux=v;
        Vertice i = aux.izquierdo;
        if(aux.padre==null) {
            if (i.derecho != null) {
                aux.izquierdo = i.derecho;
                aux.izquierdo.padre=aux;
                i.derecho = aux;
                aux.padre=i;
                raiz = i;
                i.padre=null;
                return;
            }
            aux.izquierdo=null;
            i.derecho = aux;
            aux.padre=i;
            raiz = i;
            i.padre=null;
            return;
        }
        else {
            Vertice p = v.padre;
            if (aux.padre.derecho==aux) {
                if (i.derecho!=null) {
                    aux.izquierdo=i.derecho;
                    aux.izquierdo.padre=aux;
                    i.derecho = aux;
                    aux.padre = i;
                    p.derecho = i;
                    i.padre = p;
                    return;
                }
                aux.izquierdo = null;
                i.derecho = aux;
                aux.padre = i;
                p.derecho = i;
                i.padre = p;
                return;
            }
            if (aux.padre.izquierdo==aux) {
                if (i.derecho!=null) {
                    aux.izquierdo=i.derecho;
                    aux.izquierdo.padre=aux;
                    i.derecho = aux;
                    aux.padre = i;
                    p.izquierdo = i;
                    i.padre = p;
                    return;
                }
                aux.izquierdo = null;
                i.derecho = aux;
                aux.padre = i;
                p.izquierdo = i;
                i.padre = p;
                return;
            }
        }

    }

    /**
     * Gira sobre un vértice del árbol a la izquierda
     * @param v  Vértice del árbol sobre el que giramos
     */
    protected void giraIzquierda(Vertice v){
        if(!contiene(v.elemento))
            return;
        if (v.derecho == null)
            return;

        Vertice aux=v;
        Vertice d = aux.derecho;
        if(aux.padre==null) {
            if (d.izquierdo != null) {
                aux.derecho = d.izquierdo;
                aux.derecho.padre=aux;
                d.izquierdo = aux;
                aux.padre=d;
                raiz = d;
                d.padre=null;
                return;
            }
            aux.derecho=null;
            d.izquierdo = aux;
            aux.padre=d;
            raiz = d;
            d.padre=null;
            return;
        }
        else {
            Vertice p = v.padre;
            if (aux.padre.derecho==aux) {
                if (d.izquierdo!=null) {
                    aux.derecho=d.izquierdo;
                    aux.derecho.padre=aux;
                    d.izquierdo = aux;
                    aux.padre = d;
                    p.derecho = d;
                    d.padre = p;
                    return;
                }
                aux.derecho = null;
                d.izquierdo = aux;
                aux.padre = d;
                p.derecho = d;
                d.padre = p;
                return;
            }
            if (aux.padre.izquierdo==v) {
                if (d.izquierdo != null){
                    aux.derecho = d.izquierdo;
                    aux.derecho.padre = aux;
                    d.izquierdo=aux;
                    aux.padre=d;
                    p.izquierdo=d;
                    d.padre=p;
                    return;
                }
                aux.derecho = null;
                d.izquierdo=aux;
                aux.padre=d;
                p.izquierdo=d;
                d.padre=p;
                return;
            }
        }
    }
}