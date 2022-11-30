package qengine.program.Index;

import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.util.Statements;
import org.eclipse.rdf4j.rio.helpers.AbstractRDFHandler;
import qengine.program.Dictionary.Dictonnary;
import qengine.program.Utils.Result;

import java.io.*;
import java.util.*;

/**
 *  Notre index s'appuie sur le pattern singleton, on veut une unique instance d'index.
 *  On utilise les méthodes loadIndex et saveIndex pour faire persister notre index en le stockant dans un fichier .csv
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



    /*
    Cette fonction permet de charger un index en fonction d'un fichier CSV
     */
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


    /*
    Cette fonction permet de sauvegarder l'index en fichier CSV sur le disque dure.
     */
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



    /*
    GetFromPos prend en paramètre un predicat et un obect qui sont des String.
    Elle retourne le résultat de la request sur l'arbre POS
     */
    public ArrayList<Integer> getFromPOS(String predicat, String object) {
        ArrayList<Integer> ret = new ArrayList<>(getFromMap(pos, predicat, object)) ;
        return ret;
    }

    /*
    Prend en paramètre une map (qui correspond à 1 des 6 arbres ),
    info1 et info2 qui sont soit des predicat, object ou subject.
    Elle retourne le résultat de la request de info1 et info2 en fonction de map.
     */
    private ArrayList<Integer> getFromMap(HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> map, String info1, String info2) {
        ArrayList<Integer> ret = new ArrayList<>() ;

        //On récupère les entiers qui correspond a info1 et info2 dans le dictionnaire
        int i1 = Dictonnary.getInstance().encode(info1) ;
        int i2 = Dictonnary.getInstance().encode(info2) ;


        //si le dictionnaire return -1 cela veut dire que le mot n'existe pas dans le dicrionnaire
        if(i1!=-1 && i2 != -1){

            //On voit si la première valeur est dans le premier noeud de l'arbre (On utilise get car est en O(1))
            if (map.get(i1) != null) {
                //On voir si la 2 ème valeur est dans le 2 ème noeud
                if (map.get(i1).get(i2)  != null) {
                    //on retourne toutes les feuilles du resultat de la requèt
                    ret.addAll(map.get(i1).get(i2)) ;
                }
            }
        }
        return ret;
    }



    /**
     *             Fonction d'indexation d'un statement ou d'un triplet d'entier
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
     */
    public void indexSPO(int s, int p, int o) {
        //On ajoute le truplet spo dans chaque arbre d'index
        indexInMap(spo, s, p, o);
        indexInMap(pso, p, s, o);
        indexInMap(osp, o, s, p);
        indexInMap(sop, s, o, p);
        indexInMap(pos, p, o, s);
        indexInMap(ops, o, p, s);
    }

    /**
     * Index in map elements first, second and third
     */
    private void indexInMap(HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> map, int first, int second, int third) {
        //On vérifie si first est dans le premier noeud alors on vérifie pour le noeud 2 et 3 avec second et third
        if (map.containsKey(first)) {
            if (map.get(first).containsKey(second)) {
                if (!map.get(first).get(second).contains(third)) {
                    //On rajoute la feuille third
                    map.get(first).get(second).add(third) ;
                }
                //Sinon on rajoute une branche dans le noeud second avec le noeud third
            }else {
                ArrayList<Integer> lvl3List = new ArrayList<>() ;

                lvl3List.add(third);
                map.get(first).put(second, lvl3List);
            }
            //Sinon on crée une nouvelle branche dans larbre avec first second et third
        }else {
            HashMap<Integer, ArrayList<Integer>> lvl2Hashmap = new HashMap<>();
            ArrayList<Integer> lvl3List = new ArrayList<>();

            lvl3List.add(third);
            lvl2Hashmap.put(second, lvl3List);
            map.put(first, lvl2Hashmap);
        }
    }
}

