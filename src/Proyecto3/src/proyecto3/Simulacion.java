/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
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
public class Simulacion implements Serializable{
    
    public Simulacion(){
    }
    
    public Equipos[] asignaEquipos(){
        Equipos[] equipos;
        equipos = new Equipos[]{AMERICA,CRUZAZUL,CHIVAS,PUMAS,LEON,TIGRES,
            MONTERREY,TIBURONES};
        Equipos[] equiposAleatorios = new Equipos[8];
        Random r=new Random();
        for (int i = 0; i < equipos.length; i++) {
            equiposAleatorios[i] = equipos[i];
        }
        for (int j = equiposAleatorios.length; j > 0; j--) {
            int aleatorio = r.nextInt(j);
            Equipos temp = equiposAleatorios[j -1];
            equiposAleatorios[j -1] = equiposAleatorios[aleatorio];
            equiposAleatorios[aleatorio] = temp;
        }
        return equiposAleatorios;
    }
    
    public Equipos[] semifinales(Equipos [] cuartos){
//        Equipos [] cuartos= new Equipos[8];
        Equipos [] semifinales= new Equipos[4];
        Probabilidad ganadores=new Probabilidad();
        semifinales[0]= ganadores.determinaGanador(cuartos[0], cuartos[1]);
        semifinales[1]= ganadores.determinaGanador(cuartos[2], cuartos[3]);
        semifinales[2]= ganadores.determinaGanador(cuartos[4], cuartos[5]);
        semifinales[3]= ganadores.determinaGanador(cuartos[6], cuartos[7]);
        
        return semifinales;
    }
    
    public Equipos[] partidaFinal(Equipos [] semi){
        Equipos [] fin= new Equipos[2];
        Probabilidad ganadores=new Probabilidad();
        fin[0]= ganadores.determinaGanador(semi[0], semi[1]);
        fin[1]= ganadores.determinaGanador(semi[2], semi[3]);
       
        return fin;
    }
    
    public void esperarResultados(JLabel[]e1,JLabel []e2,JLabel e3){
        for(JLabel e:e1){
            try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Torneo.class.getName()).log(Level.SEVERE, null, ex);
        }
            e.setVisible(true);
        }
        for(JLabel f:e2){
            try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Torneo.class.getName()).log(Level.SEVERE, null, ex);
        }
            f.setVisible(true);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Torneo.class.getName()).log(Level.SEVERE, null, ex);
        }
            e3.setVisible(true);
    }
    
}
