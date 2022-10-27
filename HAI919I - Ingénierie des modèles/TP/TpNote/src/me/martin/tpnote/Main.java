package me.martin.tpnote;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;

import paa.Entity;
import paa.Field;
import paa.FieldBasicType;
import paa.FieldDependantQuery;
import paa.PaAModel;
import paa.PaaFactory;
import paa.Query;
import paa.Repository;

public class Main {
	
	private static PaaFactory paaFactory = PaaFactory.eINSTANCE;

	private static UMLFactory factory = UMLFactory.eINSTANCE;
	private static PrimitiveType uml_int = factory.createPrimitiveType();
	private static PrimitiveType uml_string = factory.createPrimitiveType();
	private static PrimitiveType uml_float = factory.createPrimitiveType();
	static {
		uml_int.setName("int");
		uml_string.setName("string");
		uml_float.setName("float");
	}
	
	
	public static void main(String[] args) {
		PaAModel model = FileUtils.chargerModelePaA("model/PaAModel.xmi") ;
		
		FileUtils.sauverModeleUML("test.uml", getModelFromPaa(model)) ;
		System.out.println("Done");		
	}
	
	
	
	
	
	
	/*
	 * 		Question 3.1 
	 */
	public static Model getModele() {
		Model generatedModel = factory.createModel();
		generatedModel.setName("generatedModel");
		generatedModel.getPackagedElements().add(uml_float) ;
		generatedModel.getPackagedElements().add(uml_string) ;
		generatedModel.getPackagedElements().add(uml_int) ;
		return generatedModel ;
	}

	
	/*
	 * 		Question 3.2
	 */	
	public static Property getPropertyFromField(Field f) {
		Property ret = factory.createProperty(); 
		ret.setVisibility(VisibilityKind.PRIVATE_LITERAL);
		ret.setName(f.getName());		
		if (f.getType().getName().equalsIgnoreCase("int")) {
			ret.setType(uml_int);
		}
		else if (f.getType().getName().equalsIgnoreCase("float")) {
			ret.setType(uml_float);
		}
		else if (f.getType().getName().equalsIgnoreCase("string")) {
			ret.setType(uml_string);
		}		
		return ret;
	}
	
	
	
	/*
	 * 		Question 3.3
	 */
	public static Class getClassFromEntity(Entity entity) {
		Class ret = factory.createClass();
		ret.setName(entity.getName());
		for(Field f : entity.getFields()) {
			ret.getOwnedAttributes().add(getPropertyFromField(f)) ;
		}
		// A VOIR
		ret.createOwnedComment().setBody("@Entity");
		
		return ret;
	}
	
	
	/*
	 * 		Question 3.4
	 */
	public static Operation getOperationFromFieldQuerry(FieldDependantQuery fdq) {
		Operation ret = factory.createOperation();
		ret.setVisibility(VisibilityKind.PUBLIC_LITERAL);
		ret.setName(fdq.getType().getName() + fdq.getField().getName());

		Parameter parameterOfOperation = factory.createParameter();
		parameterOfOperation.setName(fdq.getField().getName());

		if (fdq.getField().getName().equalsIgnoreCase("int")) {
			parameterOfOperation.setType(uml_int);
		}
		else if (fdq.getField().getType().getName().equalsIgnoreCase("float")) {
			parameterOfOperation.setType(uml_float);
		}
		else if (fdq.getField().getType().getName().equalsIgnoreCase("string")) {
			parameterOfOperation.setType(uml_string);
		}

		ret.getOwnedParameters().add(parameterOfOperation);
		return ret;
	}

	
	
	
	/*
	 * 		Question 3.5
	 */
	public static Interface getInterfaceFromRepository(Repository r) {
		Interface ret = factory.createInterface();
		ret.setName(r.getTypeEntity().getName()+"Repository");
		
		for(Query q : r.getQueries()) {
			Operation op = getOperationFromFieldQuerry((FieldDependantQuery)q);
			ret.getOwnedOperations().add(op);
		}
		
		ret.createOwnedComment().setBody("@Repository<"+r.getTypeEntity().getName()+">");		
		return ret;
	}
	
	
	
	/*
	 * 		Question 3.6
	 */
	public static Model getModelFromPaa(PaAModel paa) {
		Model ret = getModele() ;
		
		for(Entity e : paa.getEntities()) { 
			Class c = getClassFromEntity(e) ;
			ret.getPackagedElements().add(c) ;
		}
		
		for(Entity e : paa.getEntities()) {
			if(e.getSuperEntity() != null) {
					Class currentEntityClass = (Class) ret.getPackagedElement(e.getName());
					currentEntityClass.getSuperClasses().add((Class) ret.getPackagedElement(e.getSuperEntity().getName()));
			}
		}
		
		for(Repository e : paa.getRepositories()) {			
			Interface c = getInterfaceFromRepository(e) ;
			ret.getPackagedElements().add(c) ;
		}
		return ret;
	}	
}
