package proyecto2;


public class Formulas {
    
    public double calculartf(Archivo doc, String term) {
        double resultado = 0;
        for (String s : doc) {
            if (term.equalsIgnoreCase(s))
                resultado++;
        }
        return resultado / doc.size();
    }

    
    public double calcularidf(Archivo docs, String term) {
        double n = 0;
        for (Archivo doc : docs) {
            for (String s : doc) {
                if (term.equalsIgnoreCase(s)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }

    
    public double tfIdf(Archivo doc, Archivo docs, String term) {
        return calculartf(doc, term) * calcularidf(docs, term);

    }


}