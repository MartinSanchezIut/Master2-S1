package qengine.program;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Jena {

    private Model model;

    public Jena(String dataPath) throws IOException {
        model = createModel(dataPath) ;
    }

    // Parsedata
    private Model createModel(String path) throws IOException {
       InputStream in = Files.newInputStream(new File(path).toPath());

       // Create an empty in-memory model and populate it from the graph
       Model model = ModelFactory.createMemModelMaker().createFreshModel();
       model.read(in,Main.baseURI); // null base URI, since model URIs are absolute
       in.close();
       return model;
   }

   public List<String> processAQuerry(String queryString) {
       ArrayList<String> results = new ArrayList<>();

       Query query = QueryFactory.create(queryString);
       // Execute the query and obtain results
       QueryExecution qe = QueryExecutionFactory.create(query, model);
       ResultSet res = qe.execSelect();

       while ( res.hasNext() ) {
           results.add(ResultSetFormatter.asText(res));
       }

       // Important - free up resources used running the query
       qe.close();
       return results;
   }

}
