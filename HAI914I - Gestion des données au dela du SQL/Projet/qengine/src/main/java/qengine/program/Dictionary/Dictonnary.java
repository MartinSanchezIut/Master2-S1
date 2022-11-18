package qengine.program.Dictionary;


import java.io.*;
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


    HashMap<Integer, String> reverseDico;
    HashMap<String, Integer> Dico;
    int index;

    public Dictonnary() {
        this.reverseDico = new HashMap<>();
        this.Dico = new HashMap<>();
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

            for (Map.Entry m : reverseDico.entrySet()){
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
                    reverseDico.put(Integer.valueOf(csv[0]),csv[1]);
                    Dico.put(csv[1],Integer.valueOf(csv[0]));
                }
                sb.append("\n");
            }
            fr.close();
        }
        catch(IOException e)        {            e.printStackTrace();        }
    }


    public void add(String attribut) {
        if (Dico.get(attribut) == null) {
            Dico.put(attribut,index);
            reverseDico.put(index, attribut);
            ++index;
        }
        // On vera plus tard
        //      saveDictionnary();
    }

    public int encode(String attribut){
        return Dico.get(attribut);
    }
    public String decode(int val){
        return reverseDico.get(val);
    }
}
