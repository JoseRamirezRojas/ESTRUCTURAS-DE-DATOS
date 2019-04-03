package practica5;

/**
 * Ramírez Rojas José David
 * Cruz Carmona Uriel
 *
 * Clase que representa un árbol binario de búsqueda.
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> extends ArbolBinario<T> {

    /**
     * Constructor vacío de un Árbol binario de búsqueda
     */
    public ArbolBinarioBusqueda() {
        raiz = null;
        elementos = 0;
    }

    /**
     * Constructor a partir de un arreglo de un Árbol binario de búsqueda
     *
     * @param a Arreglo de elementos para construir el árbol de búsqueda
     */
    public ArbolBinarioBusqueda(T[] a) {
        super(a);
    }

    /**
     * Agrega un alemento a un árbol
     *
     * @param elemento Elemento a agregar
     */
    @Override
    public void agrega(T elemento) {
        Vertice vertice = new Vertice(elemento);
        elementos++;
        if (raiz == null) {
            raiz = vertice;
        }
        agregaRecursivo(raiz,vertice);


    }

    public void agregaRecursivo(Vertice actual, Vertice nuevo) {
        if (nuevo.elemento.compareTo(actual.elemento) <= 0) {
            if (actual.izquierdo == null) {
                nuevo = actual.izquierdo;
                return;
            }
            agregaRecursivo(actual.izquierdo, nuevo);
        }
        if (nuevo.elemento.compareTo(actual.elemento) > 0) {
            if (actual.derecho == null) {
                nuevo = actual.derecho;
                return;
            }
            agregaRecursivo(actual.derecho, nuevo);
        }

    }

    /**
     * @param elemento            Elemento sobre el que queremos saber si está en el árbol
     * @return <code>true</code>   Si la pila es igual al objeto recibido;
     * <code>false</code>  En otro caso.
     */
    @Override
    public boolean contiene(T elemento) {
        // Aquí va su codigo
        return this.busca(elemento) != null;

    }

    public Vertice busca(T elemento) {
        Vertice v = raiz;
        while (v != null) {
            if (elemento.compareTo(v.elemento) == 0) {
                return v;
            }
            if (elemento.compareTo(v.elemento) < 0) {
                v = v.izquierdo;
            }
            v = v.derecho;

        }

        return null;

    }

    public Vertice buscaIzquierdo(Vertice v) {
        if (v.izquierdo != null) {
            return buscaIzquierdo(v.izquierdo);
        }
        return v;
    }

    /**
     * Elimina un elemento del árbol
     *
     * @param elemento Elemento a eliminar del árbol
     * @return Elemento eliminado del árbol
     */
    @Override
    public boolean elimina(T elemento) {
        // Aquí va su código.
        if (this.busca(elemento) != null) {
            //caso 1: Que no tenga hijos el elemento a eliminar
            if (busca(elemento).izquierdo == null && busca(elemento).derecho == null) {
                busca(elemento).padre = null;
                elementos--;
                return true;
            }

            //caso 2: El vértice a eliminar tiene un solo hijo
            if (busca(elemento).izquierdo == null && busca(elemento).derecho != null) {
                busca(elemento).derecho.padre = busca(elemento).padre;
                busca(elemento).padre.derecho = busca(elemento).derecho;
                elementos--;
                return true;
            }
            if (busca(elemento).derecho == null && busca(elemento).izquierdo != null) {
                busca(elemento).izquierdo.padre = busca(elemento).padre;
                busca(elemento).padre.izquierdo = busca(elemento).izquierdo;
                elementos--;
                return true;
            }

            //caso 3: El vértice a eliminar tiene 2 hijos
            if (busca(elemento).derecho != null && busca(elemento).izquierdo != null) {
                Vertice aux = busca(elemento).derecho;
                Vertice masIzquierdo = buscaIzquierdo(aux);
                masIzquierdo = busca(elemento);
                if (masIzquierdo == null) {
                    //caso 1 en caso 3
                    masIzquierdo.padre = null;
                    elementos--;
                    return true;
                }

                if (masIzquierdo.derecho != null) {
                    //caso 2 en caso 3
                    masIzquierdo = buscaIzquierdo(busca(elemento).padre);
                    elementos--;
                    return true;
                }

            }

        }
        return false;
    }

    public static void main (String[]args){
        Integer [] arr= {4,2,3,1,5,6,7,8,12,10,11,9,13,14,15};
        ArbolBinarioBusqueda<Integer> arbol=new ArbolBinarioBusqueda<>(arr);
        for (Integer integer:arr) {
            arbol.dfs(2,f -> System.out.println(f));
        }

    }
}
