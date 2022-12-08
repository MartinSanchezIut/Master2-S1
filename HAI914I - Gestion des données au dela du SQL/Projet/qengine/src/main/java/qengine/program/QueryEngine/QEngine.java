package qengine.program.QueryEngine;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.algebra.StatementPattern;
import org.eclipse.rdf4j.query.algebra.helpers.StatementPatternCollector;
import org.eclipse.rdf4j.query.parser.ParsedQuery;
import org.eclipse.rdf4j.query.parser.sparql.SPARQLParser;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.Rio;
import qengine.program.Dictionary.Dictonnary;
import qengine.program.Index.Index;
import qengine.program.Main;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class QEngine {
    static final String baseURI = null;

    /**
     * Fichier contenant des données rdf
     */
    static String dataFile = Main.dataFile;

    // ========================================================================

    /**
     * Traite chaque triple lu dans {@link #dataFile} avec {@link MainRDFHandler}.
     */
    public static long timeReadingData;
    public static void parseData() throws IOException {
        long startTime = System.currentTimeMillis();
        try (Reader dataReader = new FileReader(dataFile)) {
            // On va parser des données au format ntriples
            RDFParser rdfParser = Rio.createParser(RDFFormat.NTRIPLES);

            // On utilise notre implémentation de handler
            rdfParser.setRDFHandler(new MainRDFHandler());

            // Parsing et traitement de chaque triple par le handler
            rdfParser.parse(dataReader, baseURI);
        }
        long endTime = System.currentTimeMillis();
        timeReadingData = (endTime - startTime);
    }

    // ========================================================================

    /**
     * Méthode utilisée ici lors du parsing de requête sparql pour agir sur l'objet obtenu.
     */
    public static List<String> processAQuery(String queryString) {
        SPARQLParser sparqlParser = new SPARQLParser();
        ParsedQuery query = sparqlParser.parseQuery(queryString, baseURI);

        ArrayList<Integer> results = evaluateStarRequest(query) ;
        ArrayList<String> verbalResult = new ArrayList<>() ;

        for (int r : results) { verbalResult.add(Dictonnary.getInstance().decode(r)); }
        return verbalResult;
    }

    // ========================================================================

    /**
     * Evalue une requette en etoile
     * @param query
     * @return la liste des resultats avant decodage par le dictionaire
     */
    private static ArrayList<Integer> evaluateStarRequest(ParsedQuery query) {
        ArrayList<Integer> results = null;
        List<StatementPattern> patterns = StatementPatternCollector.process(query.getTupleExpr());
        //On parcourt chaque request
        boolean firstPassage = true;
        for(StatementPattern sp : patterns) {
            //Si le resultat est null oon exécute la première request
            if (results == null) { results = new ArrayList<>() ; results.addAll(evaluateStatementPatern(sp)) ;}
            //Sinon on fait l'intersection entre les resultats précédent des request avec le résultat de la nouvelle requèt
            else { results = intersect(results, evaluateStatementPatern(sp)) ; }
        }
        return results ;
    }


    /**
     * Evalue un statement d'une requette en etoile
      * @param sp
     * @return la liste des resultats du statement avant decodage
     */
    private static ArrayList<Integer> evaluateStatementPatern(StatementPattern sp) {

        //On récupère le prédicat et l'object du StatementPattern
        Value p = sp.getPredicateVar().getValue();
        Value o = sp.getObjectVar().getValue();

        //On éxécute ces 2 valeurs sur l'arbre POS et on retourne le résultat.
        return new ArrayList<>(Index.getInstance().getFromPOS(p.toString(), o.toString()));
    }


    /**
     * Fait l'intersection entre deux ensemble d'entier
     * @param a1
     * @param a2
     * @return l'intersection
     */
    private static ArrayList<Integer> intersect(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        ArrayList<Integer> ret = new ArrayList<>();

        //Pour chaque valeur de a1 voit si il existe dans a2 et retourne chaque intersection
        for(Integer i : a1) { if (a2.contains(i)) { ret.add(i) ; } }
        return ret;
    }
}
