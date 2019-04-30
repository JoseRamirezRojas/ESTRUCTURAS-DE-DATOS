package proyecto2;

/**
 * Implementación de árboles AVL
 *
 * Ramírez Rojas José David
 * Cruz Carmona Uriel
 */
public class ArbolAVL <T extends Comparable<T>> extends ArbolBinarioBusqueda<T> {
    protected class VerticeAVL extends Vertice{

        public int altura;

        public int concurrencia;

        public VerticeAVL(T elemento){
            super(elemento);
            altura = 0;
            concurrencia = 1;
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

//        if(v instanceof ArbolAVL.VerticeAVL)
//            return ((VerticeAVL) v).altura;

        return (Math.max(getAltura(v.izquierdo), getAltura(v.derecho))+1);
    }

    protected void actualizaAltura(Vertice v){
        // Aquí va su código.
        if(!(v instanceof ArbolAVL.VerticeAVL))
            return;
        ((VerticeAVL)v).altura = getAltura(v);
    }


    protected int getBalance(Vertice v){
        // Aquí va su código.
        if(v==null)
            return 0;
        return (getAltura(v.izquierdo) - getAltura(v.derecho));
    }


    @Override
    public void agrega(T elemento) {
        VerticeAVL v = (VerticeAVL) busca(elemento);

        if (v != null) {
            v.concurrencia++;
            return;
        }

        v=new VerticeAVL(elemento);
        elementos++;
        if(raiz==null){
            raiz=v;
            return;
        }
        agregaRecursivo(raiz,v);
        balancea(v.padre);
    }

    /**
     * Algoritmo para rebalancear un árbol AVL
     * @param v Vértice sobre el que balanceamos el árbol AVL
     */
    public void balancea(Vertice v){
        if(v==null){
            return;
        }
//        actualizaAltura(v);
        ((VerticeAVL) v).altura = Math.max(getAltura(v.izquierdo), getAltura(v.derecho))+1;
        int bal= getBalance(v);


        if(bal == -2){
            VerticeAVL sobrinoIzq= ((VerticeAVL)v.derecho.izquierdo);
            if(getBalance(v.derecho)==1){
                this.giraDerecha(v.derecho);
                giraIzquierda(v);
            }
            this.giraIzquierda(v);

            return;
        }
        if(bal == 2){
            VerticeAVL sobrinoDer= ((VerticeAVL)v.izquierdo.derecho);
            if(getBalance(v.izquierdo)==-1){
                this.giraIzquierda(v.izquierdo);
                giraDerecha(v);
//                ((VerticeAVL)v.izquierdo).altura=getAltura(v.izquierdo);
//                sobrinoDer.altura=getAltura(sobrinoDer);
            }
            this.giraDerecha(v);
//            ((VerticeAVL) v).altura=getAltura(v);
//            ((VerticeAVL)v.izquierdo).altura=getAltura(v.izquierdo);
//            balancea(v.izquierdo.padre);
            return;
        }

        balancea(v.padre);
    }

    public int concurrencia(T elemento) {
        Vertice v = busca(elemento);

	if (v == null)
		return 0;

	VerticeAVL vertice = (VerticeAVL) v;

        return vertice.concurrencia;
    }

    public int NoPalabras() {
        if (raiz == null)
            return 0;

        Cola<Vertice> cola = new Cola<Vertice>();
        Cola<VerticeAVL> palabras = new Cola<VerticeAVL>();
        Vertice vertice = null;
        cola.mete(raiz);

        while (!cola.esVacia()) {
            vertice = cola.saca();
            palabras.mete((VerticeAVL) vertice);
            if (vertice.izquierdo != null)
                cola.mete(vertice.izquierdo);
            if (vertice.derecho != null)
                cola.mete(vertice.derecho);
        }

        int noPalabras = 0;
        for (VerticeAVL v : palabras)
            noPalabras += v.concurrencia;

        return noPalabras;
    }

    @Override
    public boolean elimina(T elemento){
        Vertice v = busca(elemento);
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

    @Override
    protected void giraIzquierda(Vertice v){
        // Aquí va su código.
        super.giraIzquierda(v);  //actualizar altura de v y del padre
        actualizaAltura(v);
        actualizaAltura(v.derecho);
    }

    @Override
    protected void giraDerecha(Vertice v){
        // Aquí va su código.
        super.giraDerecha(v);  //actualizar altura de v y del padre
        actualizaAltura(v);
        actualizaAltura(v.izquierdo);
    }
}
