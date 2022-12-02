package qengine.program.QueryEngine;

import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.rio.helpers.AbstractRDFHandler;
import qengine.program.Dictionary.Dictonnary;
import qengine.program.Index.Index;

/**
 * Le RDFHandler intervient lors du parsing de données et permet d'appliquer un traitement pour chaque élément lu par le parseur.
 * 
 * <p>
 * Ce qui servira surtout dans le programme est la méthode {@link #handleStatement(Statement)} qui va permettre de traiter chaque triple lu.
 * </p>
 * <p>
 * À adapter/réécrire selon vos traitements.
 * </p>
 */
public final class MainRDFHandler extends AbstractRDFHandler {

	@Override
	public void handleStatement(Statement st) {
		// Printing statement
		//System.out.println("\n" + st.getSubject() + "\t " + st.getPredicate() + "\t " + st.getObject());

		// Updating Dictionnary
		Dictonnary d = Dictonnary.getInstance();
		d.add(st.getSubject().toString());
		d.add(st.getPredicate().toString());
		d.add(st.getObject().toString());

		// Indexing the statement
		Index i = Index.getInstance();
		i.indexStatement(st);
	}
}