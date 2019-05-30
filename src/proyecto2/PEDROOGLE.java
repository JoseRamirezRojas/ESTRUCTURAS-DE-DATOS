package proyecto2;

import java.io.InputStream;
import java.util.Scanner;
import java.lang.NumberFormatException;
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
            System.out.println("\t _____________________");
            System.out.println("\t|                     |");
            System.out.println("\t|                     |");
            System.out.println("\t|  " + ANSI_YELLOW + "P" + ANSI_RESET + " " + ANSI_PURPLE + "E" + ANSI_RESET + " "
                    + ANSI_GREEN + "D" + ANSI_RESET + " " + ANSI_CYAN + "R" + ANSI_RESET + " " + ANSI_RED + "O " + ANSI_YELLOW +
                    "O" + ANSI_RESET + " " + ANSI_CYAN + "G" + ANSI_RESET + " " + ANSI_GREEN + "L" + ANSI_RESET + " "
                    + ANSI_RED + "E" + ANSI_RESET + "  |");
            System.out.println("\t|                     |");
            System.out.println("\t|_____________________|");
            Thread.sleep(500);
            System.out.println("\n\tESCOGE LA ACCION A REALIZAR:");
            System.out.println("\t\t| 1)Ingresar una búsqueda");
            System.out.println("\t\t| 2)Agregar un documento .txt");
            System.out.println("\t\t| 3)Salir del programa");
            System.out.print("\t\t\t\t\t\t\t\t Actualmente buscando en " +archivoLista.getLongitud()+
                    " documentos.\n\t");

            entrada = new Scanner(System.in);
            try {
		opcion = Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException nfe) {
		opcion = 4;
	    }
	    a.limpiarPantalla();
            switch (opcion) {
                case 1:
                    if(archivoLista.getLongitud()<=0) {
                        System.out.println("\nNo hay archivos sobre los cuales realizar una busqueda.");
                        opcion = 2;
			a.retrasarImpresion(1400);
			a.limpiarPantalla();
                    } else {

                        Cola<String> cola = new Cola<String>();
                        System.out.print("\nIngresa una busqueda:\n\t");

                        while (entrada.hasNext()) {
                            cola.mete(entrada.next());
                        }

                        Formulas form = new Formulas();

                        System.out.println("\nResultados de busqueda :\n");

                        for (Archivo doc : form.rankeaDocumentos(archivoLista,cola).reversa())
                          if (doc.getSim() > 0)
                            System.out.println("** " + doc.getArchivo().getName());

                        System.out.println("Regresando al menu principal...");
                        a.retrasarImpresion(7000);
                        break;
                    }

                case 2:
                    Cola<String> cola = new Cola<String>();
                    System.out.print("\nPor favor ingresa la ruta del archivo en tu equipo :\n\t");

                    while (entrada.hasNext())
                        cola.mete(entrada.next());

                    procesador = new ProcesadorArchivos(cola);
                    for (Archivo archivo : procesador.procesaArchivos())
                        archivoLista.agrega(archivo);

                    break;

                case 3:
                    ejecutar = false;
                    break;

                default:
                    System.out.println("\nERROR.\nSelecciona una opción correcta.");
                   a.retrasarImpresion(1400);
            }
            a.limpiarPantalla();
        }
        while (ejecutar);
    }
}
