package proyecto2;

public class Formulas {

    /**
     * Calcula la frecuencia del término en un documento.
     * @param doc   Archivo actual de la busqueda.
     * @param term  Término actual de busqueda.
     * @return      TF
     */
    public static double calcularTF(Archivo doc, String term) {
        ArbolAVL<Cadena> palabras = doc.getPalabras();
        int concurrencias = palabras.concurrencia(new Cadena(term));

        if (concurrencias > 0)
            return (Math.log(concurrencias)/Math.log(2))+1;

        return 0;
    }

    /**
     * Calcula la frecuencia inversa del documento.
     * @param docs  Lista de archivos
     * @param doc   Archivo actual de la busqueda.
     * @param term  Término actual de busqueda.
     * @return      IDF
     */
    public static double calcularIDF(Lista<Archivo> docs,Archivo doc, String term) {
        ArbolAVL<Cadena> palabras = doc.getPalabras();
        int concurrencias = palabras.concurrencia(new Cadena(term));
        int n = docs.getLongitud()+1;
        int nt=0 ;
        for (Archivo d : docs) {
            if (concurrencias > 0)
                nt++;
        }
        return Math.log(n/nt)/Math.log(2);
    }

    /**
     * similitud coseno
     * @param docs
     * @param terms
     */
    public static void sim(Lista<Archivo> docs, Cola<String> terms) {
        int d = 0;
        for (String term : terms) {
            d+= term.length();

            for (Archivo doc :  docs) {

            }
        }
    }
}