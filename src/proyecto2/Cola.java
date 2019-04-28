package proyecto2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ramírez Rojas José David
 * Cruz Carmona Uriel
 *
 * Implementación de colas.
 */
public class Cola<T> implements Iterable<T>{

    private Lista<T> cola;

    /**
     * Constructor vacío de una cola, que construye la cola como una lista
     */
    public Cola(){
        cola=new Lista<T>();
    }

    /**
     * Constructor de una cola que recibe una lista
     * @param l   Lista sobre la que se construye la cola.
     */
    public Cola(Lista<T> l){
        cola=l;
    }

    /**
     * Constructor de una cola que recibe un arreglo de tipos T
     * @param arreglo Arreglo que se transforma en la lista usada para construir la cola.
     */
    public Cola(T[] arreglo){
        cola = new Lista<T>();
        for (T elemento : arreglo)
            cola.agregaFinal(elemento);
    }

    /**
     * Regresa true si la cola está vacía. Regresa false en otro caso.
     */
    public boolean esVacia(){
        return cola.esVacia();
    }

    /**
     * Regresa el elemento siguiente de la cola (peek).
     * @return  el siguiente elemento de la cola.
     * @throws NoSuchElementException   Si la cola está vacía.
     */
    public T mira(){
        if(cola.esVacia())
            throw new NoSuchElementException();

        return cola.getPrimero();
    }

    /**
     * Hace deque del siguiente elemento de la cola.
     *
     * @return el elemento sacado de la cola.
     * @throws NoSuchElementException   Si la cola está vacía.
     */
    public T saca(){
        if(cola.esVacia())
            throw new NoSuchElementException();
        return cola.eliminaPrimero();
    }

    /**
     * Hace enque de un elemento, dejándolo al final de la cola.
     *
     * @param t   El elemento a meter en la cola.
     */
    public void mete(T t){
        cola.agregaFinal(t);
    }

    /**
     * Regresa una representación en cadena de la cola.
     * @return   Un String con los elementos de la cola.
     */
    @Override
    public String toString(){
        return cola.toString();
    }

    /**
     * Nos dice si la cola es igual al objeto recibido.
     * @param o   El objeto con el que hay que comparar.
     * @return <code>true</code>   Si la cola es igual al objeto recibido;
     *         <code>false</code>  En otro caso.
     */
    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass())
            return false;
        @SuppressWarnings("unchecked") Cola<T> c = (Cola<T>)o;

        boolean igual =false;
        for (T e: c) {
            if (this.cola.iterator().next().equals(e))
                igual = true;
            return igual;
        }
        return false;
    }

    /**
     * Regresa un iterador para recorrer la cola .
     * @return   Un objeto iterador para recorrer nuestra cola.
     */
    @Override
    public Iterator<T> iterator(){
        return cola.iterator();
    }
}
