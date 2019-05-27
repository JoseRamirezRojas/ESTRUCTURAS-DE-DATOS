package proyecto3;

/**
 *
 * @author Ramírez Rojas José David
 * @author Cruz Carmona Uriel
 */
public class TablaUsuarios {
    private static TablaUsuarios tablaUsuarios;
    TablaDeDispersion<String,Usuario> tabla;
    
    /** 
     * Constructor de la clase 
     */ 
    private TablaUsuarios(){ 
        tabla = new TablaDeDispersion<>() ; 
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
     * @param nombre    Nombre del usuuario 
     * @return Usuario asociado al nombre recibido.
     */ 
    public Usuario obtenerUsuario(String nombre){ 
        return tabla.getValor(nombre); 
    } 

}
