package proyecto3;

import java.io.Serializable;

/**
 *
 * @author Ramírez Rojas José David
 * @author Cruz Carmona Uriel
 */
public class TablaUsuarios implements Serializable{
    //private static TablaUsuarios tablaUsuarios;
    TablaDeDispersion<String,Usuario> tabla;
    
    /** 
     * Constructor de la clase 
     */ 
    TablaUsuarios(){ 
        tabla = new TablaDeDispersion<>() ; 
    } 
    
    /** 
     * Obtiene una instancia de la clase MapaUsuarios 
     * @return 
     *
    public static TablaUsuarios getInstance(){ 
        if(tablaUsuarios == null) 
            tablaUsuarios = new TablaUsuarios(); 
        return tablaUsuarios; 
    } */
    
    /** 
     * Agrega un nuevo objeto Usuario al mapa 
     * @param usuario 
     */ 
    public void agregarNuevoUsuario(Usuario usuario){ 
        tabla.agrega(usuario.getNombre(), usuario); 
    } 
    
    /** 
     * Devuelve un objeto Usuario si se encuentra dentro del mapa 
     * @param nombre    Nombre del usuario 
     * @return Usuario asociado al nombre recibido.
     */ 
    public Usuario obtenerUsuario(String nombre){ 
        return tabla.getValor(nombre); 
    } 
    
    /** 
     * Devuelve si un Usuario se encuentra dentro del mapa 
     * @param usuario 
     * @return Usuario asociado al nombre recibido.
     */ 
    public boolean validarUsuario(Usuario usuario){ 
        return (tabla.getValor(usuario.getNombre())!=null);
    }

    public TablaDeDispersion<String, Usuario> getTabla() {
        return tabla;
    }
    
    public boolean esVacia(){
    return tabla.esVacia();
    }
    
    public static void main (String[] args){
        TablaUsuarios tablaDeDispersion;
        Usuario pedro=new Usuario("pedro","123");
        Usuario juan=new Usuario("juan","234");
        tablaDeDispersion = new TablaUsuarios();
        tablaDeDispersion.agregarNuevoUsuario(pedro);
        tablaDeDispersion.agregarNuevoUsuario(juan);
        //tablaDeDispersion.agregarNuevoUsuario();

        //System.out.println(tablaDeDispersion.contieneLlave(21));
        System.out.println("Valor correspondiente a la llave pedro: " + tablaDeDispersion.tabla.getValor("pedro"));
        System.out.println("Valor correspondiente a la llave juan: " + tablaDeDispersion.tabla.getValor("juan"));
        //System.out.println(tablaDeDispersion.contieneValor(89));

        System.out.print("\nValores : \n");
        tablaDeDispersion.tabla.getValores().imprimeElementos();
        /*System.out.print("Llaves : \n");
        tablaDeDispersion.getLlaves().imprimeElementos();

        System.out.println("\n\nValor eliminado correspondiente a la llave 21 : " + tablaDeDispersion.elimina(21));
        System.out.println("Valor eliminado correspondiente a la llave  35 : " + tablaDeDispersion.elimina(35));
        System.out.println(tablaDeDispersion.contieneValor(89));

        System.out.print("\nValores :\n");
        tablaDeDispersion.getValores().imprimeElementos();
        System.out.print("Llaves : \n");
        tablaDeDispersion.getLlaves().imprimeElementos();
        System.out.println("Elementos : "+tablaDeDispersion.getElementos());
    */
    }
    
}