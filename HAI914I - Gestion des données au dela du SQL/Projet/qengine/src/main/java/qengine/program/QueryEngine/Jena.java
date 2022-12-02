package qengine.program.QueryEngine;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RDFDataMgr;
import qengine.program.Main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Jena {

    static final String baseURI = null;

    /**
     * Fichier contenant les requêtes sparql
     */
    static String queryFile = Main.queryFile;
    /**
     * Fichier contenant des données rdf
     */
    static String dataFile = Main.dataFile;
    /**
     *  Le model contenant les données parsés
     */
    private static Model model ;


    /**
     * Parse les données
     */
    private static void parseData() { model = RDFDataMgr.loadModel(dataFile) ; }

    /**
     * Execute une requette avec jena
     * @param queryString la requette en question
     * @return la liste des resultats
     */
   public static List<String> processAQuery(String queryString) {
       ArrayList<String> results = new ArrayList<>();

       // Construction de la requete
       Query query = QueryFactory.create(queryString);
       // Execution de la requette
       QueryExecution qe = QueryExecutionFactory.create(query, model);
       // Récupération des resultats
       ResultSet res = qe.execSelect();
       // On sauvegarde les resultats dans notre arraylist
       while ( res.hasNext() ) { results.add(ResultSetFormatter.asText(res)); }
       qe.close();
       return results;
   }

    /**
     * Parse le fichier des requettes, et retourne une liste de requettes
     * @return liste de requettes sous forme de string
     * @throws IOException
     */
    public static List<String> parseQueries() throws IOException {
        List<String> queries = new ArrayList<>();

        try (Stream<String> lineStream = Files.lines(Paths.get(queryFile))) {
            Iterator<String> lineIterator = lineStream.iterator();
            StringBuilder queryString = new StringBuilder();

            while (lineIterator.hasNext()) {
                String line = lineIterator.next();
                queryString.append(line);

                if (line.trim().endsWith("}")) {
                    queries.add(queryString.toString());
                    queryString.setLength(0);
                }
            }
        }
        return queries;
    }
}
