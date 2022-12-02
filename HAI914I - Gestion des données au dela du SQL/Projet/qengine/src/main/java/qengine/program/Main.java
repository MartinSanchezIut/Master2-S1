package qengine.program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import qengine.program.Dictionary.Dictonnary;
import qengine.program.Index.Index;
import qengine.program.QueryEngine.Jena;
import qengine.program.QueryEngine.QEngine;

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
	static String outputFile;
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
		QEngine.parseData();
		if (useJena) { Jena.parseData(); }


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
	public static List<String> parseQueries() throws IOException {
		List<String> queries = new ArrayList<>();

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
		return queries;
	}
}
