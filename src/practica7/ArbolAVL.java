package practica7;

/**
 * Implementación de árboles AVL
 *
 * Ramírez Rojas José David
 * Cruz Carmona Uriel
 */
public class ArbolAVL <T extends Comparable<T>> extends ArbolBinarioBusqueda<T>{
    protected class VerticeAVL extends Vertice{

        public int altura;

        public VerticeAVL(T elemento){
            super(elemento);
            altura =0;
        }
    }

    public ArbolAVL(){
        super();
    }

    public ArbolAVL(T[] elementos){
        super(elementos);
    }


    protected int getAltura(Vertice v){       
        if (v == null){
        	return -1;
        }

        if(v instanceof ArbolAVL.VerticeAVL)
            return ((VerticeAVL) v).altura;

        return (Math.max(getAltura(v.izquierdo), getAltura(v.derecho))+1);
    }

    protected void actualizaAltura(Vertice v){
        // Aquí va su código.
        v.altura = getAltura(v);
    }


    protected int getBalance(Vertice v){
        // Aquí va su código.
        return getAltura(v.izquierdo) - getAltura(v.derecho);
    }


    @Override
    public void agrega(T elemento){
        VerticeAVL v=new VerticeAVL(elemento);
        elementos++;
        if (raiz==null) {
            raiz = v;
            balancea(v);
            return;
        }
        agregaRecursivo(raiz,v);
        balancea(v);
    }

    /**
     * Algoritmo para rebalancear un árbol AVL
     * @param v Vértice sobre el que balanceamos el árbol AVL
     */
    public void balancea(Vertice v){
    	if(v==null){
    		return;
    	}
    	v.altura = getAltura(v);

    	if(getBalance(v) == -2){
    		if(getBalance(v.derecho)==1){
    			giraDerecha(v.derecho);
    		}
    		giraIzquierda(v);
    	}
    	if(getBalance(v) == 2){
    		if(getBalance(v.izquierdo)==-1){
    			giraIzquierda(v.izquierdo);
    		}
    		giraDerecha(v);
    	}

    	balancea(v.padre);


    }

    @Override
    public boolean elimina(T elemento){
        Vertice v = busca(elemento);
        if (busca(elemento) != null) {
        	 Vertice aux = v.derecho;
             Vertice masIzquierdo = buscaIzquierdo(aux);
             Vertice aux2=v;
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
                    balancea(v.padre);
                    elementos--;
                    return true;
                }

                if (masIzquierdo.derecho != null) {
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
                    balancea(v.padre);
                    elementos--;
                    return true;
                }


        }
        return false;
 	}

    @Override
    protected void giraIzquierda(Vertice v){
        // Aquí va su código.
        super.giraIzquierda(v);  //actualizar altura de v y del padre
        actualizaAltura(v);
        actualizaAltura(v.padre);
    }

    @Override
    protected void giraDerecha(Vertice v){
        // Aquí va su código.
        super.giraDerecha(v);  //actualizar altura de v y del padre
        actualizaAltura(v);
        actualizaAltura(v.padre);
    }

}
