package practica8;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * Ramírez Rojas José David
 * Cruz Carmona Uriel
 *
 * Clase con varios métodos para ordenar arreglos y listas.
 */
public class Ordenamientos{


    /**
     * Constructor
     */
    private Ordenamientos(){}

    public static <T extends Comparable<T>> void quickSort(T[] a){
        quickSort(a,0,a.length-1);
    }
    /**
     * Ordena un arreglo de tipo T mediante el algoritmo de Quicksort.
     * @param a   El arreglo a ordenar por Quicksort
     */
    private static <T extends Comparable<T>> void quickSort(T[] a, int inicio, int fin) {
        if (inicio >= fin)
            return;
        int i = inicio + 1, j = fin;
        while(i<j)
            if(a[i].compareTo(a[inicio]) > 0 && a[j].compareTo(a[inicio]) <= 0)
                intercambia(a,i,j);
            else
            if (a[i].compareTo(a[inicio]) <= 0)
                i++;
            else
                j--;
        if (a[i].compareTo(a[inicio])<=0)
            i--;
        intercambia(a,i,inicio);
        quickSort(a,inicio,i-1);
        quickSort(a,i+1,fin);
    }

    /**
     * Ordena un arreglo de tipo T mediante el algoritmo de Merge Sort.
     * @param l   La lista a ordenar mediante Merge Sort.
     * @return    La lista ordenada.
     */
    public static <T extends Comparable<T>> Lista<T> mergeSort(Lista<T> l){
        if (l.getLongitud() <= 1)
            return l.copia();

        Lista<T> sublistaA = new Lista<>();
        Lista<T> sublistaB = new Lista<>();


        for (int i = 0; i < l.getLongitud()/2; i++)
            sublistaA.agregaFinal(l.get(i));

        for (int j = l.getLongitud()/2; j < l.getLongitud(); j++)
            sublistaB.agregaFinal(l.get(j));

        mergeSort(sublistaA);
        mergeSort(sublistaB);
        return mezcla(sublistaA,sublistaB);


    }

    public static <T extends Comparable<T>> Lista<T> mezcla(Lista<T> listaA, Lista<T> listaB) {
        Lista<T> listaOrdenada = new Lista<>();
        int longitudA = listaA.getLongitud();
        int longitudB = listaB.getLongitud();
        int j = 0;
        int i = 0;
        while (i < longitudA || j < longitudB) {
            if (listaA.get(i).compareTo(listaB.get(j)) <= 0) {
                listaOrdenada.agregaFinal(listaA.get(i));
                i++;
            } else {
                listaOrdenada.agregaInicio(listaB.get(j));
                j++;
            }
        }

        while (j < longitudB) {
            listaOrdenada.agregaFinal(listaB.get(j));
            j++;
        }

        while (i < longitudA) {
            listaOrdenada.agregaFinal(listaA.get(i));
            i++;
        }

        return listaOrdenada;
    }

    /**
     * Busca la posición de un valor ingresado mediante Búsqueda Binaria.
     * @param a          Arreglo ordenado en el que se realizará la búsqueda.
     * @param elemento   Valor a encontrar en el arreglo ordenado.
     * @return  La posición del arreglo en la que encontró al elemento. Si el elemento no se encuentra en el arreglo
     *          regresa un -1 .
     */
    public static <T extends Comparable<T>> int busquedaBinaria(T[] a, T elemento) {
        int in = 0;
        int fin = a.length - 1;
        int mit = (in + fin) / 2;
        while (in <= fin) {
            if (a[mit].compareTo(elemento) < 0) {
                T[] nuevo = Arrays.copyOfRange(a, mit + 1, a.length);
                int indice = busquedaBinaria(nuevo, elemento);
                if (indice != -1) {
                    indice = mit+ 1 + indice;
                    return indice;
                }

            } else if (a[mit].compareTo(elemento) > 0) {
                T[] nuevo = Arrays.copyOfRange(a, 0, mit);
                return busquedaBinaria(nuevo, elemento);
            }
            return mit;
        }
        return  mit;
    }


    public void imprime(Object[] a){
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    /**
     * Ordena un arreglo de tipo T mediante el algoritmo de Bubble Sort.
     * @param a   El arreglo a ordenar por Bubble Sort
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] a){
        for(int i=0; i<a.length; i++){
            for(int j= 0; j < a.length-1-i; j++){
                if(a[j].compareTo (a[j+1])>0){
                    T tomp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=tomp;
                }
            }
        }
    }

    /**
     * Hace un intercambio de dos elementos de un arreglo(swap).
     * @param arreglo   Arreglo sobre el que intercambiamos
     * @param a         Primera posición sobre la que se hace el swap
     * @param b         Segunda posición sobre la que se hace el swap
     */
    private static <T> void intercambia(T[] arreglo, int a, int b) {
        T aux = arreglo[a];
        arreglo[a] = arreglo[b];
        arreglo[b] = aux;
    }

    /**
     * Ordena un arreglo de tipo T mediante el algoritmo de Selection Sort.
     * @param a   El arreglo a ordenar por Selection Sort
     */
    public static <T extends Comparable<T>> void selectionSort(T[] a){
        for (int i = 0; i < a.length - 1; ++i){
            int indice = i;
            for (int j = i + 1; j < a.length; ++j){
                if (a[j].compareTo(a[indice]) < 0){
                    indice = j;
                }
            }

            T aux = a[i];
            a[i] = a[indice];
            a[indice] = aux;
        }
    }


    private static <T extends Comparable<T>> boolean estaOrdenado(T[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i-1].compareTo(a[i]) > 0)
                return false;
        return true;
    }

    public static void heapSort(int[] a){
        Monticulo monticulo=new Monticulo(a);
        for (int i = 0; i<a.length;i++){
            a[i]= monticulo.elimina();
        }
    }

    public static void main(String args[]){
        Random random = new Random();
//                int total = 10 + random.nextInt(90);
        long tiempoInicial,tiempoTotal;
        Integer[] arreglo1 = new Integer[100];
        Integer[] arreglo2 = new Integer[1000];
        Integer[] arreglo3 = new Integer[100];
        Integer[] arreglo4 = new Integer[1000];
        Integer[] arreglo5 = new Integer[100];
        Integer[] arreglo6 = new Integer[1000];
        arreglo1[0] = 1;
        arreglo1[1] = 0;
        tiempoInicial=System.nanoTime();
        for (int i = 2; i < 100; i++)
            arreglo1[i] = random.nextInt(999999);
        Ordenamientos.quickSort(arreglo1);
        tiempoTotal = System.nanoTime() - tiempoInicial;
        System.out.printf("%2.9f segundos en ordenar un arreglo con 100 elementos usando QuickSort.\n", (tiempoTotal/1000000000.0));

        arreglo2[0] = 1;
        arreglo2[1] = 0;
        tiempoInicial=System.nanoTime();
        for (int i = 2; i < 1000; i++)
            arreglo2[i] = random.nextInt(999999);
        Ordenamientos.quickSort(arreglo2);
        tiempoTotal = System.nanoTime() - tiempoInicial;

        System.out.printf("%2.9f segundos en ordenar un arreglo con 1000 elementos usando QuickSort.\n", (tiempoTotal/1000000000.0));


        arreglo3[0] = 1;
        arreglo3[1] = 0;
        tiempoInicial=System.nanoTime();
        for (int i = 2; i < 100; i++)
            arreglo3[i] = random.nextInt(999999);
        Ordenamientos.selectionSort(arreglo3);
        tiempoTotal = System.nanoTime() - tiempoInicial;
        System.out.printf("%2.9f segundos en ordenar un arreglo con 100 elementos usando selection sort.\n", (tiempoTotal/1000000000.0));

        arreglo4[0] = 1;
        arreglo4[1] = 0;
        tiempoInicial=System.nanoTime();
        for (int i = 2; i < 1000; i++)
            arreglo4[i] = random.nextInt(999999);
        Ordenamientos.selectionSort(arreglo4);
        tiempoTotal = System.nanoTime() - tiempoInicial;

        System.out.printf("%2.9f segundos en ordenar un arreglo con 1000 elementos usando selection sort.\n", (tiempoTotal/1000000000.0));


        arreglo5[0] = 1;
        arreglo5[1] = 0;
        tiempoInicial=System.nanoTime();
        for (int i = 2; i < 100; i++)
            arreglo5[i] = random.nextInt(999999);
        Ordenamientos.bubbleSort(arreglo5);
        tiempoTotal = System.nanoTime() - tiempoInicial;
        System.out.printf("%2.9f segundos en ordenar un arreglo con 100 elementos usando bubble sort.\n", (tiempoTotal/1000000000.0));

        arreglo6[0] = 1;
        arreglo6[1] = 0;
        tiempoInicial=System.nanoTime();
        for (int i = 2; i < 1000; i++)
            arreglo6[i] = random.nextInt(999999);
        Ordenamientos.bubbleSort(arreglo6);
        tiempoTotal = System.nanoTime() - tiempoInicial;

        System.out.printf("%2.9f segundos en ordenar un arreglo con 1000 elementos usando bubble sort.\n", (tiempoTotal/1000000000.0));


    }


}