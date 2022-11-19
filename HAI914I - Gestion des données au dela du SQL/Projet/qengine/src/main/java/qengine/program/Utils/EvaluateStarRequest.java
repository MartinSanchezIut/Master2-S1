package qengine.program.Utils;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.algebra.StatementPattern;
import org.eclipse.rdf4j.query.algebra.helpers.StatementPatternCollector;
import org.eclipse.rdf4j.query.parser.ParsedQuery;
import qengine.program.Index.Index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluateStarRequest {

    public static ArrayList<Integer> evaluateStarRequest(ParsedQuery query) {
        ArrayList<Integer> results = new ArrayList<>() ;
        List<StatementPattern> patterns = StatementPatternCollector.process(query.getTupleExpr());

        for(StatementPattern sp : patterns) {
            if (results.isEmpty()) { results.addAll(evaluateStarRequest(sp)) ;}
            else { EvaluateStarRequest.intersect(results, evaluateStarRequest(sp)) ; }
        }
        return results ;
    }



    private static ArrayList<Integer> evaluateStarRequest(StatementPattern sp) {
        Value s = sp.getSubjectVar().getValue(); // Sera forcément égal a null
        Value p = sp.getPredicateVar().getValue();
        Value o = sp.getObjectVar().getValue();
        return new ArrayList<>(Index.getInstance().getFromPOS(p.toString(), o.toString()));
    }





    private static ArrayList<Integer> intersect(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        ArrayList<Integer> ret = new ArrayList<>();
        for(Integer i : a1) { if (a2.contains(i)) { ret.add(i) ; } }
        return ret;
    }
}
