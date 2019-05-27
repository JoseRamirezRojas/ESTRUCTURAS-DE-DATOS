package proyecto3;
import java.io.EOFException; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger; 

/**
 *
 */
public class Datos {
    private  Datos datos; 
    private TablaUsuarios tablaUsuarios; 
    private final String archivo = "Archivo.txt"; 
    
    /**
     * Constructor de  clase Datos
     */
    private Datos(){ 
        obtenerMapa(); 
    } 

    /** 
     * Obtiene el mapa del archivo plano que es generado por el Administrador 
     */ 
    private void obtenerMapa(){ 
        try { 
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(archivo)); 
            try { 
                tablaUsuarios = (TablaUsuarios) input.readObject(); 
            } catch (ClassNotFoundException ex) { 
                tablaUsuarios = TablaUsuarios.getInstance(); 
            } catch (EOFException ex){ 
                input.close(); 
            }catch (IOException ex) { 
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex); 
            } 
        } catch(FileNotFoundException ex){ 
            tablaUsuarios = TablaUsuarios.getInstance(); 
        } catch (IOException ex) { 
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    }
    
    /** 
     * Guarda la tabla en el archivo que ya había sido generado por el Administrador 
     */ 
    private void guardarMapa(){ 
        try { 
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(archivo))) {
                output.writeObject(tablaUsuarios);
            } 
        } catch (IOException ex) { 
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 

    
    /** 
     * Obtiene una nueva instancia de la clase Utils 
     * @return 
     */ 
    public Datos getInstance(){ 
        if(datos == null) 
            datos = new Datos(); 
        return datos; 
    } 
    
    /** 
     * Registra un nuevo usuario en 
     * @param usuario
     */ 
    public void registrarUsuario(Usuario usuario){ 
        if(!buscarUsuario(usuario.getNombre(), usuario.getContrasena())){ 
            tablaUsuarios.agregarNuevoUsuario(usuario); 
            guardarMapa(); 
        } 
    } 
    
    /** 
     * Valida que el usuario exista dentro de la tabla. 
     * Si el usuario es valido entonces devuelve true, 
     * en otro caso devuelve false 
     * @param nombre
     * @param contrasena 
     * @return 
     */ 
    public boolean buscarUsuario(String nombre, String contrasena){ 
        Usuario usuario = tablaUsuarios.obtenerUsuario(nombre); 
        if(usuario != null){ 
            if(usuario.getContrasena().equals(contrasena)){ 
                return true; 
            } 
        } 
        return false; 
    } 
    
    /** 
     * Actualiza al usuario en el mapa 
     * @param usuario
     */ 
    public void actualizarUsuario(Usuario usuario){ 
        if(validarUsuario(usuario.getNombre(), usuario.getContrasena())){ 
            tablaUsuarios.agregarNuevoUsuario(usuario); 
            guardarMapa(); 
        } 
    } 

    /** 
     * Valida que el usuario exista dentro del mapa. 
     * Si el usuario es valido entonces devuelve true de otro modo devuelve false 
     * @param nombre
     * @param contrasena 
     * @return 
     */ 
    public boolean validarUsuario(String nombre, String contrasena){ 
        Usuario usuario = tablaUsuarios.obtenerUsuario(nombre); 
        if(usuario != null){ 
            if(usuario.getContrasena().equals(contrasena)){ 
                return true; 
            } 
        } 
        return false; 
    } 

    /** 
     * Valida que el usuario exista dentro del mapa 
     * @param usuario 
     * @return 
     */ 
    public boolean validarUsuario(Usuario usuario){ 
        Usuario aux = tablaUsuarios.obtenerUsuario(usuario.getNombre()); 
        return aux != null; 
    } 

    /** 
     * Recupera un usuario de la tabla de usuarios con su nombre 
     * @param nombre 
     * @return 
     */ 
    public Usuario getUsuario(String nombre){ 
        return tablaUsuarios.obtenerUsuario(nombre); 
    } 
}
