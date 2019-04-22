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
        }
    }

    public ArbolAVL(){
        super();
    }

    public ArbolAVL(T[] elementos){
        super(elementos);
    }


    protected int getAltura(Vertice v){
        if(v instanceof ArbolAVL.VerticeAVL)
            return ((VerticeAVL) v).altura;
    }

    protected void actualizaAltura(Vertice v){
        // Aquí va su código.
    }


    protected int getBalance(Vertice v){
        // Aquí va su código.
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

    }

    @Override
    public boolean elimina(T elemento){
        if (busca(elemento) != null) {
        }
        return false;
        }

    @Override
    protected void giraIzquierda(Vertice v){
        // Aquí va su código.
    }

    @Override
    protected void giraDerecha(Vertice v){
        // Aquí va su código.
    }

}
