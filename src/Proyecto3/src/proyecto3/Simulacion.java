/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.util.Random;
import static proyecto3.Equipos.AMERICA;
import static proyecto3.Equipos.CHIVAS;
import static proyecto3.Equipos.CRUZAZUL;
import static proyecto3.Equipos.LEON;
import static proyecto3.Equipos.MONTERREY;
import static proyecto3.Equipos.PUMAS;
import static proyecto3.Equipos.TIBURONES;
import static proyecto3.Equipos.TIGRES;

/**
 *
 */
public class Simulacion {
    
    
    public void asignaEquipos(){
        Equipos[] equipos;
        equipos = new Equipos[]{AMERICA,CRUZAZUL,CHIVAS,PUMAS,LEON,TIGRES,
            MONTERREY,TIBURONES};
        Equipos[] equiposAleatorios = new Equipos[8];
        Random r=new Random();
        for (int j = equiposAleatorios.length; j > 0; j--) {
            int aleatorio = r.nextInt(j);
            Equipos temp = equiposAleatorios[j -1];
            equiposAleatorios[j -1] = equiposAleatorios[aleatorio];
            equiposAleatorios[aleatorio] = temp;
        }
        
    }
}
