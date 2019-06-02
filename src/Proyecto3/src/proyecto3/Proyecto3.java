package proyecto3;

import java.io.Serializable;

/**
 *
 * @author pepew
 */
public class Proyecto3 implements Serializable{

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Usuario u=new Usuario("pp","123");
        Torneo t=new Torneo(u);
        t.setVisible(true);
        t.iniciaTorneo();
    }
    
}
