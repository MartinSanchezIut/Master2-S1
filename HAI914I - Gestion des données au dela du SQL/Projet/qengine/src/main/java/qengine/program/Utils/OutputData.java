package qengine.program.Utils;

public class OutputData {

    /*
    nom du fichier de données
    nom du dossier des requêtes
    nombre de triplets RDF
    nombre de requêtes
    temps de lecture des données (ms)
    temps de lecture des requêtes (ms)
    temps création dico (ms)
    nombre d’index
    temps de création des index (ms)
    temps total d’évaluation du workload (ms)
    temps total (du début à la fin du programme) (ms)
     */
    private String dataFileName, queriesFileName;
    private int numberOfData, numberOfQueries;
    private double timeReadingData, timeReadingQueries, timeCreatingDictionary;
    private int amountOfIndexes;
    private double timeCreatingIndex;
    private double timeWorkloadExecution, timeAllProgram;


    public OutputData() {
        this.dataFileName = "NON_DISPONIBLE";
        this.queriesFileName = "NON_DISPONIBLE";
        this.numberOfData = -1;
        this.numberOfQueries = -1;
        this.timeReadingData = -1;
        this.timeReadingQueries = -1;
        this.timeCreatingDictionary = -1;
        this.amountOfIndexes = -1;
        this.timeCreatingIndex = -1;
        this.timeWorkloadExecution = -1;
        this.timeAllProgram = -1;
    }

    public String toCSV() {
        return dataFileName +", "+ queriesFileName +", "+ numberOfData +", "+numberOfQueries+", "+timeReadingData+", "+timeReadingQueries+", "+
                timeCreatingDictionary+", "+amountOfIndexes+", "+timeCreatingIndex+", "+timeWorkloadExecution+", "+timeAllProgram+",";
    }
    public static String getCSVHeader() {
        return "nom du fichier de données, nom du dossier des requêtes, nombre de triplets RDF, nombre de requêtes, temps de lecture des données (ms)," +
                "temps de lecture des requêtes (ms), temps création dico (ms), nombre d’index, temps de création des index (ms)," +
                "temps total d’évaluation du workload (ms), temps total (du début à la fin du programme) (ms),";
    }






    public String getDataFileName() {
        return dataFileName;
    }

    public void setDataFileName(String dataFileName) {
        this.dataFileName = dataFileName;
    }

    public String getQueriesFileName() {
        return queriesFileName;
    }

    public void setQueriesFileName(String queriesFileName) {
        this.queriesFileName = queriesFileName;
    }

    public int getNumberOfData() {
        return numberOfData;
    }

    public void setNumberOfData(int numberOfData) {
        this.numberOfData = numberOfData;
    }

    public int getNumberOfQueries() {
        return numberOfQueries;
    }

    public void setNumberOfQueries(int numberOfQueries) {
        this.numberOfQueries = numberOfQueries;
    }

    public double getTimeReadingData() {
        return timeReadingData;
    }

    public void setTimeReadingData(double timeReadingData) {
        this.timeReadingData = timeReadingData;
    }

    public double getTimeReadingQueries() {
        return timeReadingQueries;
    }

    public void setTimeReadingQueries(double timeReadingQueries) {
        this.timeReadingQueries = timeReadingQueries;
    }

    public double getTimeCreatingDictionary() {
        return timeCreatingDictionary;
    }

    public void setTimeCreatingDictionary(double timeCreatingDictionary) {
        this.timeCreatingDictionary = timeCreatingDictionary;
    }

    public double getTimeCreatingIndex() {
        return timeCreatingIndex;
    }

    public void setTimeCreatingIndex(double timeCreatingIndex) {
        this.timeCreatingIndex = timeCreatingIndex;
    }

    public int getAmountOfIndexes() {
        return amountOfIndexes;
    }

    public void setAmountOfIndexes(int amountOfIndexes) {
        this.amountOfIndexes = amountOfIndexes;
    }

    public double getTimeWorkloadExecution() {
        return timeWorkloadExecution;
    }

    public void setTimeWorkloadExecution(double timeWorkloadExecution) {
        this.timeWorkloadExecution = timeWorkloadExecution;
    }

    public double getTimeAllProgram() {
        return timeAllProgram;
    }

    public void setTimeAllProgram(double timeAllProgram) {
        this.timeAllProgram = timeAllProgram;
    }
}
