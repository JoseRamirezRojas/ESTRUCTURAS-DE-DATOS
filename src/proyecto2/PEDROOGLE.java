package proyecto2;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Jose Rojas
 * @author Uriel Cruz
 *
 * Date: 28/04/19
 */
public class PEDROOGLE {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {

        Lista<Archivo> archivoLista = new Lista<>();
        Scanner entrada;
        Animacion a = new Animacion();
        int opcion;
        boolean ejecutar=true;
        LectorArchivos lector;
        ProcesadorArchivos procesador;

        a.limpiarPantalla();
        do {
            System.out.println(" _____________________");
            System.out.println("|                     |");
            System.out.println("|                     |");
            System.out.println("|  " + ANSI_YELLOW + "P" + ANSI_RESET + " " + ANSI_PURPLE + "E" + ANSI_RESET + " "
                    + ANSI_GREEN + "D" + ANSI_RESET + " " + ANSI_CYAN + "R" + ANSI_RESET + " " + ANSI_RED + "O " + ANSI_YELLOW +
                    "O" + ANSI_RESET + " " + ANSI_CYAN + "G" + ANSI_RESET + " " + ANSI_GREEN + "L" + ANSI_RESET + " "
                    + ANSI_RED + "E" + ANSI_RESET + "  |");
            System.out.println("|                     |");
            System.out.println("|_____________________|");
            Thread.sleep(500);
            System.out.println("ESCOGE LA ACCION A REALIZAR:");
            System.out.println("\n\t| 1)Ingresar una busqueda");
            System.out.println("\t| 2)Agregar un documento .txt");
            System.out.println("\t| 3)Salir del programa");
            System.out.println("\t\t\t\t\t\t\t\t Actualmente buscando en " +archivoLista.getLongitud()+
                    " documentos.");

            entrada = new Scanner(System.in);
            opcion = entrada.nextInt();
            a.limpiarPantalla();
            switch (opcion) {
                case 1:
                    if(archivoLista.getLongitud()<=0){
                        System.out.println("\nNo hay archivos sobre los cuales realizar una busqueda.");
                        opcion = 2;
                    }

                case 2:
                    Cola<String> cola = new Cola<String>();
                    System.out.println("\nPor favor ingresa la ruta del archivo en tu equipo :");

                    while (entrada.hasNext()) {
                        cola.mete(entrada.next());
                    }

                    procesador = new ProcesadorArchivos(cola);
                    for (Archivo archivo : procesador.procesaArchivos())
                        archivoLista.agrega(archivo);

                    break;

                case 3:
                    ejecutar = false;
                    break;

                default:
                    System.out.println("\nERROR.Selecciona una opcion correcta:");
                    System.out.println("\n\t| 1)Ingresar una busqueda");
                    System.out.println("\t| 2)Agregar un documento .txt");
                    System.out.println("\t| 3)Salir del programa");
                    System.out.println("\t\t\t\t\t\t\t Actualmente buscando en " +archivoLista.getLongitud()+
                            " archivos.");

            }
            a.limpiarPantalla();
        }
        while (ejecutar);
    }
}