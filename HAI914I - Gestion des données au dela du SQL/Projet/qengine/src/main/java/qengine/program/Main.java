package qengine.program;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import qengine.program.Dictionary.Dictonnary;
import qengine.program.Index.Index;
import qengine.program.QueryEngine.Jena;
import qengine.program.QueryEngine.QEngine;
import qengine.program.Utils.OutputData;
import qengine.program.Utils.QueryResultLogger;

public final class Main {
	/**
	 * Votre répertoire de travail où vont se trouver les fichiers à lire
	 */
	static final String workingDir = "data/";
	/**
	 * Fichier contenant les requêtes sparql
	 */
	public static String queryFile = workingDir + "STAR_ALL_workload.queryset";
	/**
	 * Fichier contenant des données rdf
	 */
	public static String dataFile = workingDir + "100K.nt";



	/**
	 * Fichier de output
	 */
	public static String outputFile = null;
	/**
	 * Vérification des résultats avec jena
	 */
	static boolean useJena = false;
	/**
	 * Echauffement du systeme avec x% de requettes prises au hazard
	 */
	static int warm = 0;
	/**
	 * Melanger la liste des requettes en entrée
	 */
	static boolean shuffle = false;


	// ========================================================================


	/**
	 * Entrée du programme
	 */
	public static void main(String[] args) throws IOException {
		long totalExecutionTime;   long totalstartTime = System.nanoTime();

		QEngine.parseData();
		// Si on utilise Jena, on par les data pour jena
		if (useJena) { Jena.parseData(); }

		// Liste des queries présentes dans le fichier
		ArrayList<String> queries = parseQueries();

		// Si warm, alors choisir un nombre de requettes et les executer avec QEngine
		for(int i=0; i<warm; i++) { QEngine.processAQuery(queries.get(new Random().nextInt(queries.size()))) ; }
		// Si shuffle, melanger la liste des requetes
		if (shuffle) { Collections.shuffle(queries); }


		QueryResultLogger logger = new QueryResultLogger() ;
		long workloadTime;   long startTime = System.nanoTime();
		for (String query : queries) {
			List<String> qEngineResult = QEngine.processAQuery(query);
			logger.logQueryResult(query, qEngineResult);

			if (useJena) {
				List<String> jenaResult = Jena.processAQuery(query);
				Comparaison.verificationJena(jenaResult, qEngineResult);

			}
		}
		long endTime = System.nanoTime();   workloadTime = (endTime - startTime) / 1000000;
		logger.close();

		long totalendTime = System.nanoTime(); 	totalExecutionTime = (totalendTime - totalstartTime) / 1000000;



		OutputData data = new OutputData()
				.setDataFileName(dataFile)
				.setQueriesFileName(queryFile)
				.setNumberOfData(Dictonnary.getInstance().getSize())
				.setNumberOfQueries(queries.size())

				.setTimeReadingData(QEngine.timeReadingData)
				.setTimeReadingQueries(timeReadingQueries)
				.setTimeCreatingDictionary(-1)

				.setAmountOfIndexes(Index.getInstance().getSize())
				.setTimeCreatingIndex(-1)
				.setTimeWorkloadExecution(workloadTime)
				.setTimeAllProgram(totalExecutionTime) ;

		// Si output file, alors creer l'objet et l'ecrire
		if (outputFile != null) {
			File f = new File(outputFile);
			if(!f.exists()){
				f.createNewFile();
				FileOutputStream fos = new FileOutputStream(outputFile, true);
				fos.write(OutputData.getCSVHeader().getBytes());
				fos.write("\n".getBytes());
				fos.close();
			}

			FileOutputStream fos = new FileOutputStream(outputFile, true);
			fos.write(data.toCSV().getBytes());
			fos.write("\n".getBytes());
			fos.close();
		}

		System.out.println(OutputData.getCSVHeader());
		System.out.println(data.toCSV());

		// Serialize Dictionary and Index on disk
		Dictonnary.getInstance().saveDictionnary();
		Index.getInstance().saveIndex();
	}

	// ========================================================================

	/**
	 * Parse le fichier des requettes, et retourne une liste de requettes
	 * @return liste de requettes sous forme de string
	 * @throws IOException
	 */
	public static long timeReadingQueries;
	public static ArrayList<String> parseQueries() throws IOException {
		ArrayList<String> queries = new ArrayList<>();
		long startTime = System.nanoTime();
		try (Stream<String> lineStream = Files.lines(Paths.get(queryFile))) {
			Iterator<String> lineIterator = lineStream.iterator();
			StringBuilder queryString = new StringBuilder();

			while (lineIterator.hasNext()) {
				String line = lineIterator.next();
				queryString.append(line);

				if (line.trim().endsWith("}")) {
					queries.add(queryString.toString());
					queryString.setLength(0);
				}
			}
		}
		long endTime = System.nanoTime();
		timeReadingQueries = (endTime - startTime) / 1000000;
		return queries;
	}
}
