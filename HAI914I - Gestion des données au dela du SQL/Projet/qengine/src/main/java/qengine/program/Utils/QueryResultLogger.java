package qengine.program.Utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class QueryResultLogger {

    private String resultOutput = "src/main/resources/queriesresults.csv" ;
    private PrintWriter writer ;

    public QueryResultLogger() throws FileNotFoundException {
        writer = new PrintWriter(resultOutput) ;
        StringBuilder sb = new StringBuilder();
        sb.append("query");
        sb.append(',');
        sb.append("nbResult");
        sb.append(',');
        sb.append("results");
        sb.append('\n');
        writer.write(sb.toString());
        // query, nbResult, results
    }

    public void logQueryResult(String query, List<String> queryResult) {
        // Ajouter au csv :
        StringBuilder sb = new StringBuilder() ;
        sb.append(query) ;
        sb.append(',');
        sb.append(queryResult.size()) ;
        sb.append(',');
        for (String result : queryResult) {
            sb.append(result);
            sb.append(',');
        }
        sb.append('\n');
        writer.write(sb.toString());
    }

    public void close() {
        writer.close();
    }


    public static void log(String query, List<String> queryResult) {
        System.out.println(query + " ("+ queryResult.size()+") : ");
        for (String result : queryResult) {
            System.out.println("    " + result);
        }
    }
}
