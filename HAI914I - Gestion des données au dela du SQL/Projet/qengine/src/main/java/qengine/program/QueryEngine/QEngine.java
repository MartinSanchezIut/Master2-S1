package qengine.program.QueryEngine;

import org.eclipse.rdf4j.query.parser.ParsedQuery;
import org.eclipse.rdf4j.query.parser.sparql.SPARQLParser;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.Rio;
import qengine.program.Dictionary.Dictonnary;
import qengine.program.Main;
import qengine.program.Utils.EvaluateRequest;

import java.io.FileNotFoundException;
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
     * Méthode utilisée ici lors du parsing de requête sparql pour agir sur l'objet obtenu.
     */
    public static List<String> processAQuery(String queryString) {
        SPARQLParser sparqlParser = new SPARQLParser();
        ParsedQuery query = sparqlParser.parseQuery(queryString, baseURI);

        ArrayList<Integer> results = EvaluateRequest.evaluateStarRequest(query) ;
        ArrayList<String> verbalResult = new ArrayList<>() ;

        System.out.println("Querry : " + query);
        for (int r : results) { verbalResult.add(Dictonnary.getInstance().decode(r)); }
        return verbalResult;
    }

    // ========================================================================

    /**
     * Traite chaque triple lu dans {@link #dataFile} avec {@link MainRDFHandler}.
     */
    public static void parseData() throws IOException {
        try (Reader dataReader = new FileReader(dataFile)) {
            // On va parser des données au format ntriples
            RDFParser rdfParser = Rio.createParser(RDFFormat.NTRIPLES);

            // On utilise notre implémentation de handler
            rdfParser.setRDFHandler(new MainRDFHandler());

            // Parsing et traitement de chaque triple par le handler
            rdfParser.parse(dataReader, baseURI);
        }
    }

}
