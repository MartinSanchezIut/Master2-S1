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
     * Fichier contenant des données rdf
     */
    static String dataFile = Main.dataFile;
    /**
     *  Le model contenant les données parsés
     */
    private static Model model ;

    // ========================================================================

    /**
     * Parse les données
     */
    public static void parseData() { model = RDFDataMgr.loadModel(dataFile) ; }

    // ========================================================================

    /**
     * Execute une requette avec jena
     * @param queryString la requette en question
     * @return la liste des resultats
     */
 /*  public static List<String> processAQuery(String queryString) {
       ArrayList<String> results = new ArrayList<>();

       // Construction de la requete
       Query query = QueryFactory.create(queryString);
       // Execution de la requette
       QueryExecution qe = QueryExecutionFactory.create(query, model);
       // Récupération des resultats
       ResultSet res = qe.execSelect();
       // On sauvegarde les resultats dans notre arraylist
       while ( res.hasNext() ) {
           QuerySolution soln = res.next() ;

           while ( soln.varNames().hasNext() ) {

               String var = soln.varNames().next();
               results.add(soln.get(var).toString());

           }

       }
       qe.close();
       return results;
   } */



    public static List<String> processAQuery(String queryString) {
        ArrayList<String> results = new ArrayList<>();

        // Construction de la requete
        Query query = QueryFactory.create(queryString);
        // Execution de la requette
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        // Récupération des resultats
        Iterator<QuerySolution> res = qe.execSelect();
        // On sauvegarde les resultats dans notre arraylist

        //System.out.println(queryString);
        for ( ; res.hasNext() ; )
        {
            QuerySolution soln = res.next() ;
            results.add(soln.get("v0").toString());
            //System.out.println(soln.get("v0"));
        }
        qe.close();
        //System.out.println(results.size());
        return results;
    }

}
