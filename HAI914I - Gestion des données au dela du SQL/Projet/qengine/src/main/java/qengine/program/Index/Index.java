package qengine.program.Index;

import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.util.Statements;
import org.eclipse.rdf4j.rio.helpers.AbstractRDFHandler;
import qengine.program.Dictionary.Dictonnary;

import java.io.*;
import java.util.*;

/**
 *  Notre index s'appuie sur le pattern singleton, on veut une unique instance d'index.
 *  On utilise les méthode loadIndex et saveIndex pour faire persister notre index en le stockant dans un fichier .csv
 */
public class Index {

    /** ------------------------------------------------------------------- */
    //          S             P                     O
    private HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> spo ;

    //          S              O                    P
    private HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> sop ;

    /** ------------------------------------------------------------------- */
    //          P             S                     O
    private HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> pso ;

    //          P              O                    S
    private HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> pos ;

    /** ------------------------------------------------------------------- */
    //          O             S                     P
    private HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> osp ;

    //          O              P                    S
    private HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> ops ;

    /** ------------------------------------------------------------------- */

    private String indexFilePath = "src/main/resources/index.csv" ;
    private File indexFile ;
    private static Index instance = null;
    public static Index getInstance() {
        if (instance == null) { instance = new Index() ; }
        return instance;
    }

    private Index() {
        indexFile = new File(indexFilePath);
        spo = new HashMap<>() ; sop = new HashMap<>() ;
        pso = new HashMap<>() ; pos = new HashMap<>() ;
        osp = new HashMap<>() ; ops = new HashMap<>() ;
        loadIndex();
    }



    public void loadIndex() {
        try  {
            FileReader fr = new FileReader(indexFile);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while((line = br.readLine()) != null)       {
                String[] csv = line.split(",");
                if(!csv[0].equals("Subject") && !csv[1].equals("Predicate")&& !csv[2].equals("Object") ){
                    indexSPO(Integer.parseInt(csv[0]),Integer.parseInt(csv[1]),Integer.parseInt(csv[2]));
                }
                sb.append("\n");
            }
            fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    public void saveIndex() {
        try (PrintWriter writer = new PrintWriter(indexFile)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Subject");
            sb.append(',');
            sb.append("Predicate");
            sb.append(',');
            sb.append("Object");
            sb.append('\n');

            for (Map.Entry s : spo.entrySet()){
                HashMap<Integer, ArrayList<Integer>> po = (HashMap<Integer, ArrayList<Integer>>)s.getValue();
                for(Map.Entry p : po.entrySet()){
                    ArrayList<Integer> objects = (ArrayList<Integer>) p.getValue();
                    for(int o : objects){
                        sb.append(s.getKey());
                        sb.append(',');
                        sb.append(p.getKey());
                        sb.append(',');
                        sb.append(o);
                        sb.append('\n');
                    }

                }
            }
            writer.write(sb.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }




    /**
     *             Fonctions de recherche dans notre index
     */

    /**
     * Recherche dans l'index tout elements correspondant aux 2 info donnés
     * @param info1 a Subject, predicate or object
     * @param info2 a Subject, predicate or object
     * @return Values found
     */
    public ArrayList<Integer> get(String info1, String info2) {
        ArrayList<Integer> ret = new ArrayList<>() ;
        Dictonnary d = Dictonnary.getInstance() ;
        int i1 = d.encode(info1) ;
        int i2 = d.encode(info2) ;

        ret.addAll(getFromMap(spo, i1, i2)) ;
        ret.addAll(getFromMap(pso, i1, i2)) ;
        ret.addAll(getFromMap(osp, i1, i2)) ;
        ret.addAll(getFromMap(sop, i1, i2)) ;
        ret.addAll(getFromMap(pos, i1, i2)) ;
        ret.addAll(getFromMap(ops, i1, i2)) ;
        return ret;
    }

    /**
     * Look if map contains a list for values i1 and i2
     * @param map
     * @param i1
     * @param i2
     * @return List of values (i1 (i2 l))
     */
    public ArrayList<Integer> getFromMap(HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> map, int i1, int i2) {
        ArrayList<Integer> ret = new ArrayList<>() ;
        if (map.containsKey(i1)) {
            if (map.get(i1).containsKey(i2)) {
                ret.addAll(map.get(i1).get(i2)) ;
            }
        }
        return ret;
    }



    /**
     *             Fonction d'indexation d'un statement ou d'un triplet d'entier
     */


    /**
     * Indexe un statement s
     * @param s
     */
    public void indexStatement(Statement s) {
        Dictonnary d = Dictonnary.getInstance() ;
        int sub = d.encode(s.getSubject().toString()) ;
        int pre = d.encode(s.getPredicate().toString()) ;
        int obj = d.encode(s.getObject().toString()) ;

        indexSPO(sub, pre, obj);
    }

    /**
     * Indexe un tripplet s p o
     * @param s the subject
     * @param p the predicate
     * @param o the object
     */
    public void indexSPO(int s, int p, int o) {
        indexInMap(spo, s, p, o);
        indexInMap(pso, p, s, o);
        indexInMap(osp, o, s, p);
        indexInMap(sop, s, o, p);
        indexInMap(pos, p, o, s);
        indexInMap(ops, o, p, s);
    }

    /**
     * Index in map elements first, second and third
     * @param map
     * @param first
     * @param second
     * @param third
     */
    private void indexInMap(HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> map, int first, int second, int third) {
        if (map.containsKey(first)) {
            if (map.get(first).containsKey(second)) {
                if (map.get(first).get(second).contains(third)) {
                    // Existe déja.
                    return;
                }else {
                    map.get(first).get(second).add(third) ;
                }
            }else {
                ArrayList<Integer> lvl3List = new ArrayList<>() ;

                lvl3List.add(third);
                map.get(first).put(second, lvl3List);
            }
        }else {
            HashMap<Integer, ArrayList<Integer>> lvl2Hashmap = new HashMap<>();
            ArrayList<Integer> lvl3List = new ArrayList<>();

            lvl3List.add(third);
            lvl2Hashmap.put(second, lvl3List);
            map.put(first, lvl2Hashmap);
        }
    }
}



/*
         //  SPO
        if (spo.containsKey(sub)) {
            if (spo.get(sub).containsKey(pre)) {
                if (spo.get(sub).get(pre).contains(obj)) {
                    // Existe déja.
                    return;
                }else {
                    spo.get(sub).get(pre).add(obj) ;
                }
            }else {
                ArrayList<Integer> lvl3List = new ArrayList<>() ;

                lvl3List.add(obj);
                spo.get(sub).put(pre, lvl3List);
            }
        }else {
            HashMap<Integer, ArrayList<Integer>> lvl2Hashmap = new HashMap<>();
            ArrayList<Integer> lvl3List = new ArrayList<>();

            lvl3List.add(obj);
            lvl2Hashmap.put(pre, lvl3List);
            spo.put(sub, lvl2Hashmap);
        }

 */