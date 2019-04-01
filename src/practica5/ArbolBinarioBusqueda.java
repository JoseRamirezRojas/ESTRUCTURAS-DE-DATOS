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
        Vertice vertice = new Vertice(elemento);
        elementos ++;
        if(this.raiz==null){
            this.raiz = vertice;
        }
        agregaRecursivo();

        
    }
    public void agregaRecursivo(Vertice actual, Vertice nuevo){
        if(nuevo.elemento.compareTo(actual.elemento)<=0){
            if(actual.izquierdo== null){
                nuevo = actual.izquierdo;
            }
            agregaRecursivo(actual.izquierdo, nuevo);
        }
        if(nuevo.elemento.compareTo(actual.elemento)>0){
            if(actual.derecho == null){
                nuevo = actual.derecho;
            }
            agregaRecursivo(actual.derecho, nuevo);
        }

    }

    /**
     *
      * @param elemento
     * @return   <code>true</code>   Si la pila es igual al objeto recibido;
     *           <code>false</code>  En otro caso.
     */
    @Override
    public boolean contiene(T elemento){
        // Aquí va su codigo
        if(this.busca(elemento)!=null){
            return true;

        }
        return false;
        
    }
    public Vertice busca(T elemento){
        Vertice v = raiz;
        while(v!=null){
            if(elemento.compareTo(v.elemento)==0){
                return v;
            }
            if(elemento.compareTo(v.elemento)<0){
                v=v.izquierdo;
            }
            v=v.derecho;

        }       


    }
    public Vertice buscaIzquierdo(Vertice v){
        if(v.izquierdo!=null){
            return buscaIzquierdo(v.izquierdo);
        }
        return v;
    }

    /**
     * Elimina un elemento del árbol
     * @param elemento   Elemento a eliminar del árbol
     * @return   Elemento eliminado del árbol
     */
    @Override
    public boolean elimina(T elemento){
        // Aquí va su código.
        if(this.busca(elemento)!=null){
            if(this.busca(elemento).izquierdo==null&&this.busca(elemento).derecho==null){
                this.busca(elemento).padre= null;
                elementos--;
            }
            if(this.busca(elemento).izquierdo==null&&this.busca(elemento).derecho!=null){//caso 2
                this.busca(elemento).derecho.padre=this.busca(elemento).padre;
                elementos--;
            }
            if(this.busca(elemento).derecho==null&&this.busca(elemento).izquierdo!=null){
                this.busca(elemento).izquierdo.padre=this.busca(elemento).padre;
                elementos--;
            }
            if(this.busca(elemento).derecho!=null&&this.busca(elemento).izquierdo!=null){
                this.buscaIzquierdo(this.busca(elemento).derecho) = this.busca(elemento);
                if(this.buscaIzquierdo(this.busca(elemento).derecho).derecho==null){//caso 1 en caso 3
                    this.buscaIzquierdo(this.busca(elemento).derecho).padre= null;
                    elementos--;
                }
                if(this.buscaIzquierdo(this.busca(elemento).derecho).derecho!=null){
                    this.buscaIzquierdo(this.busca(elemento).derecho)= this.buscaIzquierdo(this.busca(elemento).padre);//caso 2 en caso 3
                    elementos--;
                }

            }
        return false;

    }

}
