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
    public double calcularIDF(Lista<Archivo> docs, String term) {
        int nt = 0;

	for(Archivo doc : docs)
		if (calcularTF(doc,term) > 0)
			nt++;
	if (nt == 0)
		return 0;

        return Math.log((docs.getLongitud()+1)/nt)/Math.log(2);
    }

    /**
     * Similitud coseno
     * @param docs      Lista de archivos de la busquedas
     * @param doc       Archivo actual de la busqueda
     * @param terms     Terminos de la busqueda ingresada
     */
    public double sim(Lista<Archivo> docs,Archivo doc, Cola<String> terms) {
        double sumaProdDeTerminos = 0;
        for (String term : terms) {
		sumaProdDeTerminos += calcularTF(doc,term)*calcularIDF(docs,term);
        }
        return sumaProdDeTerminos/doc.getPalabras().NoPalabras();
    }

    public Lista<Archivo> rankeaDocumentos(Lista<Archivo> docs,Cola<String> terms){
        Lista<Archivo> documentosOrdenados = null;

        for(Archivo doc : docs)
            doc.setSim(sim(docs,doc,terms));

        documentosOrdenados = docs.mergeSort((a, b) -> a.compareTo(b));
        return documentosOrdenados;
    }
}
