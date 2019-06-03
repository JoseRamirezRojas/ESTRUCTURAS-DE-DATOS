package proyecto3;

import java.io.Serializable;

/**
 *
 * @author Ramírez Rojas José David
 * @author Cruz Carmona Uriel
 */
public class Probabilidad implements Serializable{

    public Probabilidad() {
    }
    
    
    public Equipos determinaGanador(Equipos e1, Equipos e2) throws InterruptedException{
        double prob1 = e1.getHabilidad() / e1.getHabilidad() + e2.getHabilidad();        
        double prob2 = e2.getHabilidad() / e1.getHabilidad() + e2.getHabilidad();        
        double rand = Math.random();
        
        Thread.sleep(6000);
        if(prob2>prob1){
            if(rand>=0&&rand<=prob2){
                return e2;
            }
            return e1;
        }
        if(rand>=0&&rand<=prob1){
            return e1;
        }
        return e2; 
        
    }
    
    public double cuotaDecimal1(Equipos e1, Equipos e2){
        double prob1 = e1.getHabilidad() / e1.getHabilidad() + e2.getHabilidad();
       
        double cuota1;
        
        cuota1 = 1/ prob1;
        
        return cuota1;
        
        
        
        
    }
    public double cuotaDecimal2(Equipos e1, Equipos e2){
       
        double prob2 = e2.getHabilidad() / e2.getHabilidad() + e1.getHabilidad();
        double cuota2;
        
        cuota2 = 1/ prob2;
        
        return cuota2;
        
        
        
        
    }
    
 
    
      
}

