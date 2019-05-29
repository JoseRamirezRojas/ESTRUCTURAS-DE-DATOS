package proyecto3;

import java.io.Serializable;

/**
 *
 * @author Ramírez Rojas José David
 * @author Cruz Carmona Uriel
 */
public class TablaUsuarios implements Serializable{
    private static TablaUsuarios tablaUsuarios;
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
     */ 
    public static TablaUsuarios getInstance(){ 
        if(tablaUsuarios == null) 
            tablaUsuarios = new TablaUsuarios(); 
        return tablaUsuarios; 
    } 
    
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
        return (tabla.getValor(usuario.getContrasena())!=null);
    }

    public TablaDeDispersion<String, Usuario> getTabla() {
        return tabla;
    }
    
    public boolean esVacia(){
    return tabla.esVacia();}
    
}