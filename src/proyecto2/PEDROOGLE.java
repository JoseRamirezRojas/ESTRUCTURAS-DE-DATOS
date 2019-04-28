package proyecto2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Jose Rojas
 * @author Uriel Cruz
 *
 * Date: 28/04/19
 */
public class PEDROOGLE {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Lista<Archivo> archivoLista = new Lista<>();
        Scanner entrada = new Scanner(System.in);
        Animacion a = new Animacion();
        int opcion=0;
        boolean ejecutar=true;
        LectorArchivos lector;
        ProcesadorArchivos procesador;

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
        System.out.println("\n\t| 1)Ingresar una búsqueda");
        System.out.println("\t| 2)Agregar un documento .txt");
        System.out.println("\t| 3)Salir del programa");
        System.out.println("\t\t\t\t\t\t\t\t Actualmente buscando en " +archivoLista.getLongitud()+
                " documentos.");
        do {
            try
            {
                opcion = Integer.parseInt(br.readLine());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            switch (opcion) {
                case 1:
                    if(archivoLista.getLongitud()<=0){
                        System.out.println("\nNo hay archivos sobre los cuales realizar una busqueda.");
                        opcion = 2;
                    }

                case 2:
                    System.out.println("\nPor favor ingresa la ruta del archivo en tu equipo :");

                    lector=new LectorArchivos(System.in);

                    break;

                case 3:
                    ejecutar = false;
                    break;

                default:
                    System.out.println("\nERROR.Selecciona una opción correcta:");
                    System.out.println("\n\t| 1)Ingresar una búsqueda");
                    System.out.println("\t| 2)Agregar un documento .txt");
                    System.out.println("\t| 3)Salir del programa");
                    System.out.println("\t\t\t\t\t\t\t Actualmente buscando en " +archivoLista.getLongitud()+
                        " archivos.");

            }
        }
        while (ejecutar);
    }
}