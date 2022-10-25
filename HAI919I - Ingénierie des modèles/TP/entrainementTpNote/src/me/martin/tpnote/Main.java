package me.martin.tpnote;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import enseigne.CaracteristiqueVariable;
import enseigne.EnseignePackage;
import enseigne.GammePersonnalisable;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;

public class Main {

	private static GammePersonnalisable gamme;
	public static void main(String[] args) {
		Resource resource = Utils.chargerModele("model/GammePersonnalisable.xmi", EnseignePackage.eINSTANCE); 
		if (resource == null) System.err.println(" Erreur de chargement du modèle");
		gamme = (GammePersonnalisable) resource.getContents().get(0);
		

		UMLFactory factory = UMLFactory.eINSTANCE;
		Model model = factory.createModel();

	
		Class objAbstract = factory.createClass();
		objAbstract.setName("ObjetAbstrait");
		objAbstract.setIsAbstract(true);
		objAbstract.getOwnedOperations().addAll(getOperations(factory)); 
		model.getPackagedElements().add(objAbstract);

		Class objDecore = factory.createClass();
		objDecore.setName("ObjetDecore");
		objDecore.setIsAbstract(true);	
		objDecore.getSuperClasses().add(objAbstract) ;
		objDecore.getOwnedOperations().addAll(new ArrayList<Operation>(getOperations(factory))); 
		model.getPackagedElements().add(objDecore);

		for (enseigne.Object o : listOfObjects(gamme)) {
			Class concreteObject = factory.createClass();
			concreteObject.setName(o.getNom());
			concreteObject.setIsAbstract(false);	
			concreteObject.getSuperClasses().add(objDecore) ;	
			concreteObject.getOwnedOperations().addAll(new ArrayList<Operation>(getOperations(factory))); 
			model.getPackagedElements().add(concreteObject);
		}
		
		
		
		Class decoration = factory.createClass();
		decoration.setName("Decoration");
		decoration.setIsAbstract(true);	
		decoration.getSuperClasses().add(objAbstract) ;
		decoration.getOwnedOperations().addAll(new ArrayList<Operation>(getOperations(factory))); 
		model.getPackagedElements().add(decoration);

		for (enseigne.ElementDePersonnalisation o : listOfElements(gamme)) {
			Class concreteDecoration = factory.createClass();
			concreteDecoration.setName(o.getNom());
			concreteDecoration.setIsAbstract(false);	
			concreteDecoration.getSuperClasses().add(decoration) ;
			concreteDecoration.getOwnedOperations().addAll(new ArrayList<Operation>(getOperations(factory))); 
			model.getPackagedElements().add(concreteDecoration);
		}
		
		
		Property p1 = factory.createProperty();
		p1.setType(decoration);
		p1.setUpper(1);
		p1.setLower(1);
		objAbstract.getOwnedAttributes().add(p1);

		Property p2 = factory.createProperty();
		p2.setType(objAbstract);
		p2.setIsComposite(true);
		decoration.getOwnedAttributes().add(p2);
		
		Association objAbs_Decoration = factory.createAssociation();
		objAbs_Decoration.setName("Decore");
		objAbs_Decoration.getMemberEnds().add(p1);
		objAbs_Decoration.getMemberEnds().add(p2);
		model.getPackagedElements().add(objAbs_Decoration);

		

		Utils.sauverModele("test.uml", model);
		System.out.println("Done");
	}
	
	public static ArrayList<Operation> getOperations(UMLFactory factory) {
		ArrayList<Operation> ops = new ArrayList<Operation>();
		for (CaracteristiqueVariable c : listOfCaracteristics(gamme)) {
			Operation operation = factory.createOperation();
			operation.setName(c.getNom());
			ops.add(operation) ;
		}
		return ops;
	}
	public static List<enseigne.Object> listOfObjects(GammePersonnalisable gamme) {
		ArrayList<enseigne.Object> ret = new ArrayList<enseigne.Object>();
		for(enseigne.Object o : gamme.getObjects()) {
			ret.add(o) ;
		}
		return ret;
	}
	public static List<enseigne.ElementDePersonnalisation> listOfElements(GammePersonnalisable gamme) {
		ArrayList<enseigne.ElementDePersonnalisation> ret = new ArrayList<>();
		for(enseigne.ElementDePersonnalisation o : gamme.getElementdepersonnalisation()){
			ret.add(o) ;
		}
		return ret;
	}
	public static List<enseigne.CaracteristiqueVariable> listOfCaracteristics(GammePersonnalisable gamme) {
		ArrayList<enseigne.CaracteristiqueVariable> ret = new ArrayList<>();
		for(enseigne.CaracteristiqueVariable o : gamme.getCaracteristiquevariable()){
			ret.add(o) ;
		}
		return ret;
	}
}
