package practica5;

/**
 * Ramírez Rojas José David
 * Cruz Carmona Uriel
 *
 * Clase que representa un árbol binario de búsqueda.
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> extends ArbolBinario<T>{

    /**
     * Constructor vacío de un Árbol binario de búsqueda
     */
    public ArbolBinarioBusqueda(){
        raiz=null;
        elementos=0;
    }

    /**
     * Constructor a partir de un arreglo de un Árbol binario de búsqueda
     * @param a   Arreglo de elementos para construir el árbol de búsqueda
     */
    public ArbolBinarioBusqueda(T[] a){
        // Aquí va su código.
    }

    /**
     * Agrega un alemento a un árbol
     * @param elemento   Elemento a agregar
     */
    @Override
    public void agrega(T elemento){
        if(elemento
    }

    /**
     *
      * @param elemento
     * @return   <code>true</code>   Si la pila es igual al objeto recibido;
     *           <code>false</code>  En otro caso.
     */
    @Override
    public boolean contiene(T elemento){
        // Aquí va su código.
    }

    /**
     * Elimina un elemento del árbol
     * @param elemento   Elemento a eliminar del árbol
     * @return   Elemento eliminado del árbol
     */
    @Override
    public boolean elimina(T elemento){
        // Aquí va su código.
    }
}
