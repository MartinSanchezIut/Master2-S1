package qengine.program.Utils;

import java.util.List;

public class QueryResultLogger {

    private String resultOutput = "src/main/resources/index.csv" ;

    public QueryResultLogger() {
        // Ici créer le ficheir, ecrire l'entete
        // query, nbResult, results
    }

    public void logQueryResult(String query, List<String> queryResult) {
        // Ajouter au csv :

        /*

        System.out.println(query + " ("+ queryResult.size()+") : ");
        for (String result : queryResult) {
            System.out.println("    " + result);
        }

         */
    }


    public static void log(String query, List<String> queryResult) {
        System.out.println(query + " ("+ queryResult.size()+") : ");
        for (String result : queryResult) {
            System.out.println("    " + result);
        }
    }
}
