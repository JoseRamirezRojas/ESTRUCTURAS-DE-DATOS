package practica8;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Ramírez Rojas José David
 * Cruz Carmona Uriel
 *
 *
 *
 * Implementación de listas ligadas.
 */
public class Lista<T> implements Iterable<T>{

    // Clase interna para representar los nodos de nuestras listas.
    private class Nodo{

        public T elemento;
        public Nodo siguiente;
        public Nodo anterior;

        /**
         * Constructor de la clase Nodo
         */
        public Nodo(T e){
            this.elemento=e;
        }
    }

    // Clase para iterar la lista.
    private class Iterador implements Iterator<T>{

        public Nodo siguiente;

        /**
         * Constructor de la clase Iterador
         */
        public Iterador(){
            siguiente=cabeza;
        }


        /**
         * Nos dice si hay un elemento siguiente.
         */
        @Override
        public boolean hasNext(){
            return (siguiente!=null);
        }

        /**
         * Nos da el elemento siguiente.
         */
        @Override
        public T next(){
            if(siguiente==null)
                throw new NoSuchElementException();
            else{
                T e=siguiente.elemento;
                siguiente =siguiente.siguiente;
                return e;
            }
        }
    }

    private Nodo cabeza;
    private Nodo ultimo;
    private int longitud;

    /**
     * Constructor vacío de una lista
     */
    public Lista(){
        cabeza=null;
        ultimo=null;
        longitud=0;
    }

    /**
     * Constructor de una lista a partir de un arreglo, donde los elementos de un arreglo se meten a una lista
     * conservando su orden
     */
    public Lista(T[] arreglo){
        longitud=0;
        if (arreglo.length==1){
            cabeza=new Nodo (arreglo[0]);
            ultimo=cabeza;
            longitud++;
        }
        else {
            cabeza= new Nodo(arreglo[0]);
            cabeza.anterior=null;
            cabeza.siguiente=null;
            ultimo=cabeza;
            longitud++;
            for ( int i=1;i<arreglo.length;i++){
                Nodo aux=new Nodo(arreglo[i]);
                agregaFinal(aux.elemento);
            }
        }
    }

    /**
     * Regresa la cabeza de la lista
     */
    public T getPrimero(){
        if(cabeza==null)
            throw new NoSuchElementException();
        return cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista
     */
    public T getUltimo(){
        if(ultimo==null)
            throw new NoSuchElementException();
        return ultimo.elemento;
    }

    /**
     * Elimina la cabeza de la lista
     * @return   El elemento eliminado
     */
    public T eliminaPrimero(){
        T e;
        if(cabeza==null)
            throw new NoSuchElementException();
        if (longitud==1) {
            longitud--;
            e=cabeza.elemento;
            cabeza = null;
            ultimo = null;
            return e;
        }
        else {
            longitud--;
            e=cabeza.elemento;
            cabeza.siguiente.anterior = null;
            cabeza=cabeza.siguiente;
            return e;
        }
    }

    /**
     * Elimina el último elemento de la lista
     * @return   El elemento eliminado
     */
    public T eliminaUltimo(){
        T e;
        if(cabeza==null)
            throw new NoSuchElementException();
        if (longitud==1) {
            longitud--;
            e=ultimo.elemento;
            cabeza = null;
            ultimo = null;
            return e;
        }
        else {
            longitud--;
            e=ultimo.elemento;
            ultimo.anterior.siguiente = null;
            ultimo=ultimo.anterior;
            return e;
        }
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos, el elemento a agregar será
     * el primero y último.
     *
     * @param t   El elemento a agregar.
     */
    public void agregaInicio(T t){
        if (longitud==0) {
            cabeza = new Nodo(t);
            ultimo = cabeza;
            longitud++;
            return;
        }
        Nodo nuevaCabeza=new Nodo(t);
        cabeza.anterior=nuevaCabeza;
        nuevaCabeza.siguiente=cabeza;
        cabeza=nuevaCabeza;
        longitud++;
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,el elemento a agregar será
     * el primero y último.
     * @param t   El elemento a agregar.
     */
    public void agregaFinal(T t){
        if (longitud==0) {
            ultimo = new Nodo(t);
            cabeza = ultimo;
            longitud++;
            return;
        }
        Nodo nuevoUltimo=new Nodo(t);
        ultimo.siguiente=nuevoUltimo;
        nuevoUltimo.anterior=ultimo;
        ultimo=nuevoUltimo;
        longitud++;
    }

    /**
     * Nos dice si un elemento está en la lista.
     * @param t   El elemento que queremos saber si está en la lista.
     * @return true   si el elemento t está en la lista,
     *         false  en otro caso.
     */
    public boolean contiene(T t){
        Nodo n= buscaNodo(t);
        if (n==null)
            return false;
        else return true;
    }

    /**
     * Regresa la longitud de la lista.
     * @return   La longitud de la lista, es decir, el número de elementos que contiene.
     */
    public int getLongitud(){
        return longitud;
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la lista, la lista no se modifica.
     * @param t el elemento a eliminar.
     * @return true   si eliminó el elemento t de la lista,
     *         false  si no lo hizo, lo que significa que dicho elemento no se encontraba en la lista.
     */
    public boolean elimina(T t){
        Nodo n=buscaNodo(t);
        if(n==null)
            return false;
        else if (cabeza==ultimo){
            cabeza=null;
            ultimo=null;
            longitud--;
        }
        else if (n==cabeza) {
            this.eliminaPrimero();
            return true;
        }
        else if (n==ultimo) {
            this.eliminaUltimo();
            return true;
        }
        else {
            n.anterior.siguiente=n.siguiente;
            n.siguiente.anterior=n.anterior;
            longitud--;
            return true;
        }
        return false;
    }

    /**
     * Busca el primer Nodo en la lista que contiene a un elemento dado.
     * @param e   El elemento a buscar en alguno de los nodos.
     * @return   El nodo que contiene al elemento ingresado
     */
    public Nodo buscaNodo(T e){
        Nodo n=cabeza;
        for (T tipo : this){
            tipo =n.elemento;
            if(tipo==e)
                return n;
            else n=n.siguiente;
        }
        return null;
    }

    /**
     * Busca el Nodo en la lista con la posición dada.
     * @param indx   La posición del nodo del cual queremos el elemento.
     * @return   El nodo de la posición ingresada
     */
    public Nodo buscaNodo(int indx){
        if(0<=indx && indx<=longitud){
            Nodo n = this.cabeza;
            for(int aux =0; aux<=indx; aux++){
                if(aux==indx){
                    return n;
                }
                n=n.siguiente;
            }
        }
        return null;
    }

    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    public void limpia(){
        cabeza=null;
        ultimo=null;
        longitud=0;
        return;
    }


    /**
     * Regresa el i-ésimo elemento de la lista.
     * @param indx   El índice del elemento en la lsta que queremos.
     * @return       El i-ésimo elemento de la lista.
     * @throws IndexOutOfBoundsException   Si indx es menor que cero o mayor o igual que el número de elementos
     * en la lista.
     */
    public T get(int indx){
        if(indx<0 || indx > longitud){
            throw new IndexOutOfBoundsException();

        }
        return buscaNodo(indx).elemento;
    }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * @param indx   El índice dónde insertar el elemento. Si es menor que 0 el elemento se agrega al inicio de la lista
     * y si es mayor o igual que el número de elementos en la lista se agrega al final.
     * @param t      El elemento a insertar.
     * @throws IndexOutOfBoundsException Si indx es menor que cero o mayor o igual que el número de elementos
     * en la lista.
     */
    public void inserta(int indx, T t){
        if(indx < 1)
            this.agregaInicio(t);

        if(indx > longitud)
            this.agregaFinal(t);

        longitud ++;
        Nodo nuevo = new Nodo(t);
        Nodo n = this.buscaNodo(indx);
        nuevo.anterior= n.anterior;
        n.anterior.siguiente = nuevo;
        nuevo.siguiente=n;
        n.anterior= nuevo;
    }

    /**
     * Regresa un arreglo con los mismos elementos de nuestra lista, en el mismo orden.
     */
    public Object[] toArray(){
        Object [] arr = new Object[longitud];
        for(int i=0; i<= longitud-1;i++){
            arr[i]=this.get(i);
        }
        return arr;
    }

    /**
     * Regresa la reversa de la lista.
     * @return   Una nueva lista con los elementos de la lista en orden inverso.
     */
    public Lista<T> reversa(){
        Nodo aux = ultimo;
        Lista<T> listaReversa = new Lista<T>();
        while (aux != null) {
            listaReversa.agregaFinal(aux.elemento);
            aux = aux.anterior;
        }
        return listaReversa;
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la lista , en el mismo orden.
     * @return   Una lista idéntica a la nuestra.
     */
    public Lista<T> copia(){
        Nodo aux = cabeza;
        Lista<T> listaCopia = new Lista<T>();
        while (aux != null) {
            listaCopia.agregaFinal(aux.elemento);
            aux = aux.siguiente;
        }
        return listaCopia;
    }

    /**
     * Regresa una representación en cadena de la lista.
     * @return   Un String con los elementos de la lista.
     */
    @Override
    public String toString(){
        if (longitud==0)
            return "[]";
        Nodo aux = cabeza.siguiente;
        String lista = "[" + cabeza.elemento;
        while (aux != null) {
            lista += ", " + aux.elemento;
            aux = aux.siguiente;
        }
        return lista + "]";
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param o   El objeto con el que hay que comparar.
     * @return <code>true</code>   Si la pila es igual al objeto recibido;
     *         <code>false</code>  En otro caso.
     */
    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass())
            return false;
        @SuppressWarnings("unchecked") Lista<T> lista = (Lista<T>)o;
        if (longitud != lista.getLongitud())
            return false;
        Nodo nodoAuxiliar = ((Lista<T>) o).cabeza;
        for (int i = 0; nodoAuxiliar != null; i++) {
            if (!nodoAuxiliar.elemento.equals(lista.get(i)))
                return false;
            nodoAuxiliar = nodoAuxiliar.siguiente;
        }
        return true;
    }

    /**
     * Imprime en orden los elementos de la lista.
     */
    public void imprimeElementos(){
        Nodo nodo=cabeza;
        while (nodo!=null){
            System.out.println(nodo.elemento);
            nodo=nodo.siguiente;
        }
    }

    /**
     * Regresa un iterador para recorrer la lista .
     * @return   Un objeto iterador para recorrer nuestra lista.
     */
    @Override
    public Iterator<T> iterator(){
        return new Iterador();
    }

    public static void main (String[] args){
        String [] pruebaLista={"1er elemento","2do elem","3er elem"};
        String pruebaAgregaInicio="nuevo inicial";
        String pruebaAgregaFin="nuevo final";
        Lista lista= new Lista(pruebaLista);
        Lista listaVacia= new Lista();
        lista.imprimeElementos();
        System.out.println(lista.getPrimero());
        System.out.println(lista.getUltimo());
        System.out.println(lista.getLongitud());
//        System.out.println(listaVacia.getPrimero());
//        System.out.println(listaVacia.getUltimo());
        System.out.println(lista.eliminaPrimero());
        System.out.println(lista.getLongitud());
        System.out.println(lista.eliminaPrimero());
        lista.agregaInicio(pruebaAgregaInicio);
        lista.agregaFinal(pruebaAgregaFin);
        lista.imprimeElementos();
        System.out.println(lista.contiene(pruebaAgregaFin));
        System.out.println(lista.getLongitud());
        System.out.println(lista.eliminaUltimo());
        System.out.println(lista.getLongitud());
        lista.agregaInicio(pruebaAgregaInicio);
        lista.agregaFinal(pruebaAgregaFin);
        lista.imprimeElementos();
        System.out.println(lista.elimina("3er elem"));
        lista.imprimeElementos();
        System.out.println(lista.getLongitud());
        lista.reversa().imprimeElementos();
        lista.copia().imprimeElementos();
        System.out.println(lista.toString());
        System.out.println(listaVacia.toString());
        System.out.println(lista.equals(lista.copia()));
        System.out.println(lista.equals(listaVacia));
        lista.inserta(1,"inserte");
        lista.imprimeElementos();
        System.out.println(lista.get(2));
        System.out.println(lista.toArray());
    }
}
