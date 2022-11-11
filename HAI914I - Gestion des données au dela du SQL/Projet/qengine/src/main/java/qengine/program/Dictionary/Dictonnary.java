package qengine.program.Dictionary;


import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.helpers.AbstractRDFHandler;
import qengine.program.Index.Index;
import qengine.program.MainRDFHandler;

import java.io.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 *  Notre dictionnaire s'appuie sur le pattern singleton, on veut une unique instance du dictionnaire.
 *  On utilise les méthode loadDictionnary et saveDictionnary pour faire persister notre dictionnaire en le stockant dans un fichier .csv
 */
public class Dictonnary {

    private String dictionaryFilePath = "src/main/resources/dico.csv" ;
    private File dictionaryFile ;
    private static Dictonnary instance = null;
    public static Dictonnary getInstance() {
        if (instance == null) {
            instance = new Dictonnary() ;
        }
        return instance;
    }


    HashMap<Integer, String> map1;
    HashMap<String, Integer> map2;
    int index;

    public Dictonnary() {
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();
        index = 0;
        dictionaryFile = new File(dictionaryFilePath);
        loadDictionary();
    }





    public void saveDictionnary() {
        try (PrintWriter writer = new PrintWriter(dictionaryFile)) {
            StringBuilder sb = new StringBuilder();
            sb.append("id");
            sb.append(',');
            sb.append("String");
            sb.append('\n');

            for (Map.Entry m : map1.entrySet()){
                sb.append(m.getKey());
                sb.append(',');
                sb.append(m.getValue());
                sb.append('\n');
            }
            writer.write(sb.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadDictionary() {
        try  {
            FileReader fr = new FileReader(dictionaryFile);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while((line = br.readLine()) != null)       {
                String[] csv = line.split(",");
                if(!csv[0].equals("id") && !csv[1].equals("id") ){
                    map1.put(Integer.valueOf(csv[0]),csv[1]);
                    map2.put(csv[1],Integer.valueOf(csv[0]));
                }
                sb.append("\n");
            }
            fr.close();
        }
        catch(IOException e)        {            e.printStackTrace();        }
    }


    public void add(String attribut) {
        if (!map1.containsValue(attribut)) {
            map1.put(index, attribut);
            map2.put(attribut,index);
            ++index;
        }
        // On vera plus tard
        //      saveDictionnary();
    }

    public int encode(String attribut){
        return map2.get(attribut);
    }
    public String decode(int val){
        return map1.get(val);
    }
}
