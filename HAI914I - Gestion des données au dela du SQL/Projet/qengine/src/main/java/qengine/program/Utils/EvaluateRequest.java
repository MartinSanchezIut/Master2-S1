package qengine.program.Utils;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.algebra.StatementPattern;
import org.eclipse.rdf4j.query.parser.ParsedQuery;
import qengine.program.Index.Index;

import java.util.ArrayList;

public class EvaluateRequest {

    public static ArrayList<Result> evaluatePattern(StatementPattern sp) {
        Value s = sp.getSubjectVar().getValue();
        Value p = sp.getPredicateVar().getValue();
        Value o = sp.getObjectVar().getValue();

        return Index.getInstance().get(s.toString(), p.toString(), o.toString()) ;
    }

    public static ArrayList<Integer> intersect(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        ArrayList<Integer> ret = new ArrayList<>();
        for(Integer i : a1) { if (a2.contains(i)) { ret.add(i) ; } }
        return ret;
    }
}
