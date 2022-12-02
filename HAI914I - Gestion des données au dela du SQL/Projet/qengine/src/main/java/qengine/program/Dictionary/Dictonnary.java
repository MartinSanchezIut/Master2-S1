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


    //On crée 2 Map pour décoder de String->Integer et Integer->String en O(1)
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


    private int size;
    public int getSize() {return size; }


    /*
    Cette fonction permet de sauver le disctionnaire en CSV sur le disque dure
     */
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

    /*
    Permet de charger le dictionnaire en fonction d'un CSV
     */
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



    //Permet d'ajouter une valeur dans le dico
    public void add(String attribut) {
        size++;
        //si la valeur existe déjà on ne le met pas dans le dico
        if (Dico.get(attribut) == null) {
            Dico.put(attribut,index);
            reverseDico.put(index, attribut);
            ++index;
        }
    }

    public int encode(String attribut){
        if(Dico.get(attribut)==null){
            return -1;
        }else{
            return Dico.get(attribut);
        }

    }
    public String decode(int val){
        if(reverseDico.get(val)==null){
            return null;
        }else{
            return reverseDico.get(val);
        }
    }
}
