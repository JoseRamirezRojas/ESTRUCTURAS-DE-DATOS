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
    private double saldo; 

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    

}
