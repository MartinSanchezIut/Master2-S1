package qengine.program.Utils;

import java.io.File;
import java.io.IOException;

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


    public OutputData() throws IOException {
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


    public OutputData setDataFileName(String dataFileName) {
        this.dataFileName = dataFileName; return this;
    }

    public OutputData setQueriesFileName(String queriesFileName) {
        this.queriesFileName = queriesFileName;return this;
    }

    public OutputData setNumberOfData(int numberOfData) {
        this.numberOfData = numberOfData;return this;
    }

    public OutputData setNumberOfQueries(int numberOfQueries) {
        this.numberOfQueries = numberOfQueries;return this;
    }

    public OutputData setTimeReadingData(double timeReadingData) {
        this.timeReadingData = timeReadingData;return this;
    }

    public OutputData setTimeReadingQueries(double timeReadingQueries) {
        this.timeReadingQueries = timeReadingQueries;return this;
    }

    public OutputData setTimeCreatingDictionary(double timeCreatingDictionary) {
        this.timeCreatingDictionary = timeCreatingDictionary;return this;
    }

    public OutputData setAmountOfIndexes(int amountOfIndexes) {
        this.amountOfIndexes = amountOfIndexes;return this;
    }

    public OutputData setTimeCreatingIndex(double timeCreatingIndex) {
        this.timeCreatingIndex = timeCreatingIndex;return this;
    }

    public OutputData setTimeWorkloadExecution(double timeWorkloadExecution) {
        this.timeWorkloadExecution = timeWorkloadExecution;return this;
    }

    public OutputData setTimeAllProgram(double timeAllProgram) {
        this.timeAllProgram = timeAllProgram; return this;
    }

    public String getDataFileName() {
        return dataFileName;
    }

    public String getQueriesFileName() {
        return queriesFileName;
    }

    public int getNumberOfData() {
        return numberOfData;
    }

    public int getNumberOfQueries() {
        return numberOfQueries;
    }

    public double getTimeReadingData() {
        return timeReadingData;
    }

    public double getTimeReadingQueries() {
        return timeReadingQueries;
    }

    public double getTimeCreatingDictionary() {
        return timeCreatingDictionary;
    }

    public int getAmountOfIndexes() {
        return amountOfIndexes;
    }

    public double getTimeCreatingIndex() {
        return timeCreatingIndex;
    }

    public double getTimeWorkloadExecution() {
        return timeWorkloadExecution;
    }

    public double getTimeAllProgram() {
        return timeAllProgram;
    }
}
