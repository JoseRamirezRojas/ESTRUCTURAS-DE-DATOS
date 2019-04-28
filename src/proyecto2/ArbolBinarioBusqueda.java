package proyecto2;

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
        super();
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
            vertice.padre=null;
            return;
        }
        agregaRecursivo(raiz,vertice);
    }

    public void agregaRecursivo(Vertice actual, Vertice nuevo) {
        if (nuevo.elemento.compareTo(actual.elemento) <= 0) {
            if (actual.izquierdo == null) {
                actual.izquierdo=nuevo;
                nuevo.padre=actual;
                return;
            }
            agregaRecursivo(actual.izquierdo, nuevo);
        }
        if (nuevo.elemento.compareTo(actual.elemento) > 0) {
            if (actual.derecho == null) {
                actual.derecho=nuevo;
                nuevo.padre=actual;
                return;
            }
            agregaRecursivo(actual.derecho, nuevo);
        }

    }

    /**
     * @param elemento            Elemento sobre el que queremos saber si está en el árbol
     * @return <code>true</code>   Si el elemento es igual al recibido;
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
            if (elemento.compareTo(v.elemento) == 0)
                return v;

            if (elemento.compareTo(v.elemento) < 0)
                v = v.izquierdo;
            else
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
        Vertice v=busca(elemento);
        if (v!= null) {

            //caso 1: Que no tenga hijos el elemento a eliminar
            if (v.izquierdo == null && v.derecho == null) {

                if (v.padre.derecho == v)
                    v.padre.derecho=null;
                else
                    v.padre.izquierdo=null;
                elementos--;
                if(raiz==v)
                    raiz=null;
                return true;
            }

            //caso 2: El vértice a eliminar tiene un solo hijo
            if (v.derecho == null && v.izquierdo != null) {
                v.izquierdo.padre = v.padre;
                v.padre.izquierdo = v.izquierdo;
                if(raiz==v)
                    raiz=v.izquierdo;
                elementos--;
                return true;
            }
            if (v.izquierdo == null && v.derecho != null) {
                v.derecho.padre = v.padre;
                v.padre.derecho = v.derecho;
                if(raiz==v)
                    raiz=v.derecho;
                elementos--;
                return true;
            }

            //caso 3: El vértice a eliminar tiene 2 hijos
            if (busca(elemento).derecho != null && busca(elemento).izquierdo != null) {
                Vertice aux = v.derecho;
                Vertice masIzquierdo = buscaIzquierdo(aux);
                Vertice aux2=v;
//                v.elemento=masIzquierdo.elemento;
                if (masIzquierdo.derecho == null) {
                    //caso 1 en caso 3
                    if(raiz!=v) {
                        if (v.padre.derecho == v)
                            v.padre.derecho.elemento = masIzquierdo.elemento;
                        else
                            v.padre.izquierdo.elemento = masIzquierdo.elemento;
                        aux2.elemento = masIzquierdo.elemento;
                    }
                    else {
                        v.elemento = masIzquierdo.elemento;
                        masIzquierdo.padre.izquierdo = null;
                    }
                    elementos--;
                    return true;
                }

                //caso 2 en caso 3
                if(raiz!=v) {
                    if (v.padre.derecho == v)
                        v.padre.derecho.elemento = masIzquierdo.elemento;
                    else
                        v.padre.izquierdo.elemento = masIzquierdo.elemento;
                    aux2.elemento = masIzquierdo.elemento;
                }
                else {
                    v.elemento = masIzquierdo.elemento;
                    masIzquierdo.padre.izquierdo = null;
                }
                masIzquierdo.derecho.padre=masIzquierdo.padre;
                masIzquierdo.padre.izquierdo=masIzquierdo.derecho;
                elementos--;
                return true;

            }

        }
        return false;
    }
}
