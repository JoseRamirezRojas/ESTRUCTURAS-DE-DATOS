package proyecto3;
import java.io.Serializable;
/**
 *
 * @author Ramírez Rojas José David
 * @author Cruz Carmona Uriel 
 */
public class Usuario implements Serializable {
    private String nombre; 
    private String contrasena; 
    private float saldo; 
    private String historial;

    /**
     *
     * @param nombre
     * @param contrasena
     */
    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        saldo = 0;
        historial=" ";
    }
    
    /**
     * 
     * @return  nombre de usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @return contraseña de usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * 
     * @return  saldo de usuario
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * 
     * @param nombre Nombre a establecer del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @param contrasena Contraseña a establecer del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * 
     * @param saldo Saldo a establecer del usuario.
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public void setHistorial(String historial) {
        this.historial = historial;
    }

}
