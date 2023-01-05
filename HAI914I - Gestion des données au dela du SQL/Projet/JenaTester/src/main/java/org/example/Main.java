package org.example;


import org.apache.commons.cli.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static String queryFile = "src/main/resources/requetes";

    public static void main(String[] args) throws IOException, ParseException {
        CommandLine cmd = getCommandLine(args, new Options(), new DefaultParser()) ;

        String queriesFolder = cmd.getOptionValue("queries") ;
        String data = cmd.getOptionValue("data") ;

        if (queriesFolder != null) { Main.queryFile = queriesFolder; }
        if (data != null) { Jena.dataFile = data; }



        System.out.println("Jena parsing data.");
        Jena.parseData();

        ArrayList<String> queries = new ArrayList<>();
        File dir = new File(queryFile);
        if (dir.isFile()) {
            queries.addAll(parseQueries(dir.getPath()));
        }else if (dir.isDirectory()) {
            File[] liste = dir.listFiles();
            for (File item : liste) {
                if (item.isFile()) {
                    queries.addAll(parseQueries(item.getPath()));

/*                String[] split = item.getName().split(".");
                String extention = split[split.length-1];

                if (extention.equals("queryset"))
  */
                }
            }
        }
       // BufferedWriter writer = new BufferedWriter(new FileWriter("output_2M.csv"));
        //BufferedWriter writer2 = new BufferedWriter(new FileWriter("nbResults_2M.csv"));


        int requetzero = 0;
        int nbResultat[] = new int [500];
        for (int i = 0; i<nbResultat.length; i++) { nbResultat[i] = 0; }

        Collections.shuffle(queries);
        for (String query : queries) {
            List<String> jenaResult = Jena.processAQuery(query);

            if (jenaResult.size() < 500) {
                nbResultat[jenaResult.size()] += 1;
            }

            String statements = query.substring(query.indexOf('{')+1, query.indexOf('}')) ;
            int nbStatements = statements.length() - statements.replace("?","").length();


           // writer.write(query + ", " + jenaResult.size() + ", " + nbStatements + "\n");
            if (jenaResult.isEmpty()) { ++requetzero; }

        }
        /*for (int i = 0; i<nbResultat.length; i++) {
            writer2.write(i + ", "+ nbResultat[i] + "\n");
        }*/


      //  writer.close();
        //writer2.close();
        System.out.println("\n\n\n");
        System.out.println("Taux de requettes sans réponse : " + requetzero + "/" + queries.size());
    }



    public static List<String> parseQueries(String path) throws IOException {
        ArrayList<String> queries = new ArrayList<>();
        try (Stream<String> lineStream = Files.lines(Paths.get(path))) {
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

    public static CommandLine getCommandLine(String[] args, Options options, CommandLineParser parser) throws ParseException {
        /*
        java -jar jena
            -queries "/chemin/vers/dossier/requetes"
            -data "/chemin/vers/fichier/donnees"
        */
        options.addOption("queries", true, "/chemin/vers/dossier/requetes");
        options.addOption("data", true, "/chemin/vers/fichier/donnees");
        return parser.parse(options, args);
    }
}