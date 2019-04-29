package proyecto2;

public class Formulas {

    /**
     * Calcula la frecuencia del término en un documento.
     * @param doc   Archivo actual de la busqueda.
     * @param term  Término actual de busqueda.
     * @return      TF
     */
    public double calcularTF(Archivo doc, String term) {
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
     * @param term  Termino actual de busqueda.
     * @return      IDF
     */
    public double calcularIDF(Lista<Archivo> docs,Archivo doc, String term) {
        ArbolAVL<Cadena> palabras = doc.getPalabras();
        int concurrencias = palabras.concurrencia(new Cadena(term));
        int n = docs.getLongitud()+1;
        int nt = 0 ;
        for (Archivo d : docs) {
            if (calcularTF(d,term) > 0)
                nt++;
        }
        return Math.log(n/nt)/Math.log(2);
    }

    /**
     * Similitud coseno
     * @param docs      Lista de archivos de la busquedas
     * @param doc       Archivo actual de la busqueda
     * @param terms     Terminos de la busqueda ingresada
     */
    public double sim(Lista<Archivo> docs,Archivo doc, Cola<String> terms) {
        double sumaProdDeTerminos=0;
        int aux = docs.getLongitud();
//        int[] similitudes;
//        similitudes.length=aux;
        for (String term : terms) {
            for (Archivo d :  docs) {
                double prodTfIdf=(this.calcularIDF(docs,doc,term))*(this.calcularTF(doc,term));
                sumaProdDeTerminos=sumaProdDeTerminos+prodTfIdf;
                return (sumaProdDeTerminos/doc.getPalabras().NoPalabras());
            }
        }
        return 0;
    }

    public Lista<Archivo> rankeaDocumentos(Lista<Archivo> docs,Cola<String> terms){
        Lista<Archivo> documentosOrdenados;
        for(Archivo doc:docs){
            doc.setSim(this.sim(docs,doc,terms));
        }
        documentosOrdenados=docs.mergeSort(docs);
        return documentosOrdenados;
    }
}