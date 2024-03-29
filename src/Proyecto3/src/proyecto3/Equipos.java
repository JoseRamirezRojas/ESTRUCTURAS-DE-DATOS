package proyecto3;

import java.io.Serializable;

/**
 *
 * @author Ramírez Rojas José David
 * @author Cruz Carmona Uriel
 */
public enum Equipos implements Serializable{
    AMERICA("AMÉRICA",390),CHIVAS("CHIVAS",360),CRUZAZUL("CRUZ AZUL",240),
    PUMAS("UNAM",210),LEON("LEON",220),TIGRES("TIGRES",230),MONTERREY("RAYADOS",120), TIBURONES("VERACRUZ",80);
    
    private final String nombre;
    private final int habilidad;
    
    private Equipos(String nombre,int habilidad){
        this.nombre=nombre;
        this.habilidad=habilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHabilidad() {
        return habilidad;
    }
}