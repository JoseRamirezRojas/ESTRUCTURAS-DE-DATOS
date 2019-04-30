package proyecto2;

public class Animacion {
    public void limpiarPantalla()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void retrasarImpresion(int tiempo) {
      try {
        Thread.sleep(tiempo);
      } catch (InterruptedException ie) {}
    }
}
