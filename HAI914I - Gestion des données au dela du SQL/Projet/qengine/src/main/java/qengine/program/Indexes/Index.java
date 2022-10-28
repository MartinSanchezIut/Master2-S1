package qengine.program.Indexes;

import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.util.Statements;
import org.eclipse.rdf4j.rio.helpers.AbstractRDFHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Index {

/** ------------------------------------------------------------------- */
    //          S             P                     O
    HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> spo ;

    //          S              O                    P
    HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> sop ;

/** ------------------------------------------------------------------- */
    //          P             S                     O
    HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> pso ;

    //          P              O                    S
    HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> pos ;

/** ------------------------------------------------------------------- */
    //          O             S                     P
    HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> osp ;

    //          O              P                    S
    HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> ops ;

/** ------------------------------------------------------------------- */


    private static Index instance = null;
    public static Index getInstance() {
        if (instance == null) { instance = new Index() ; }
        return instance;
    }

    public Index() {
        spo = new HashMap<>() ; sop = new HashMap<>() ;
        pso = new HashMap<>() ; pos = new HashMap<>() ;
        osp = new HashMap<>() ; ops = new HashMap<>() ;
    }

    public void indexStatement(Statement s) {
        
        spo.putIfAbsent(Dicot.get(s.getSubject()), ) ;


    }
}

