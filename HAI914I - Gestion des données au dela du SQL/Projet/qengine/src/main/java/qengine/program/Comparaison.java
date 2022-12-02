package qengine.program;

import qengine.program.QueryEngine.Jena;
import qengine.program.QueryEngine.QEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Comparaison {

    public static void main(String[] args) throws IOException {
        Jena.parseData();
        QEngine.parseData();

        String query = "SELECT ?v0 WHERE {	?v0 <http://purl.org/dc/terms/Location> <http://db.uwaterloo.ca/~galuc/wsdbm/City2> .	?v0 <http://schema.org/nationality> <http://db.uwaterloo.ca/~galuc/wsdbm/Country169> .	?v0 <http://db.uwaterloo.ca/~galuc/wsdbm/gender> <http://db.uwaterloo.ca/~galuc/wsdbm/Gender1> . }";
        System.out.println(query);
        System.out.println("JENA");
        for ( String s : Jena.processAQuery(query)) {
            System.out.println(s);
        }

        System.out.println("--------------");
        System.out.println("QEngine");
        for ( String s : QEngine.processAQuery(query)) {
            System.out.println(s);
        }

    }



    public static void verificationJena(List<String> JenaRequest, List<String> QEngineRequest) {
        ArrayList<String> difference = new ArrayList<>();

        for (String j : QEngineRequest) {
            if (! JenaRequest.contains(j)) {
                difference.add(j);
            }
        }

        for (String d : difference) {
            System.out.println(d);
        }
        if (! difference.isEmpty()) { System.out.println("\n\n\n\n"); }

/*
        boolean result = true;
        for (String j : JenaRequest) {
            if (!QEngineRequest.contains(j)) {
                result = false;
            }
        }

        for (String j : QEngineRequest) {
            if (!JenaRequest.contains(j)) {
                result = false;
            }
        }
        System.out.println(result);
        if(!result){

        }*/
    }
}
