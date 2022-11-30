package qengine.program.Utils;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.algebra.StatementPattern;
import org.eclipse.rdf4j.query.algebra.helpers.StatementPatternCollector;
import org.eclipse.rdf4j.query.parser.ParsedQuery;
import qengine.program.Index.Index;

import java.util.ArrayList;
import java.util.List;

public class EvaluateRequest {

    /*
        Prend en paramètre un ensemble de request
     */
    public static ArrayList<Integer> evaluateStarRequest(ParsedQuery query) {
        ArrayList<Integer> results = new ArrayList<>() ;
        List<StatementPattern> patterns = StatementPatternCollector.process(query.getTupleExpr());
        //On parcourt chaque request
        for(StatementPattern sp : patterns) {
            //Si le resultat est null oon exécute la première request
            if (results.isEmpty()) { results.addAll(RequestResult(sp)) ;}
            //Sinon on fait l'intersection entre les resultats précédent des request avec le résultat de la nouvelle requèt
            else { results = EvaluateRequest.intersect(results, RequestResult(sp)) ; }
        }
        return results ;
    }



    //retourne le résutat d'une requèt passé en paramètre.
    private static ArrayList<Integer> RequestResult(StatementPattern sp) {

        //On récupère le prédicat et l'object du StatementPattern
        Value p = sp.getPredicateVar().getValue();
        Value o = sp.getObjectVar().getValue();

        //On éxécute ces 2 valeurs sur l'arbre POS et on retourne le résultat.
        return new ArrayList<>(Index.getInstance().getFromPOS(p.toString(), o.toString()));
    }




    //fait l'intersection entre a1 et a2
    private static ArrayList<Integer> intersect(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        ArrayList<Integer> ret = new ArrayList<>();

        //Pour chaque valeur de a1 voit si il existe dans a2 et retourne chaque intersection
        for(Integer i : a1) { if (a2.contains(i)) { ret.add(i) ; } }
        return ret;
    }
}
