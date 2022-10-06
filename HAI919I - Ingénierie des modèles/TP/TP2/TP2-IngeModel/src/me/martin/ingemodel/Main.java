package me.martin.ingemodel;

import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.internal.impl.TemplateParameterImpl;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallConcurrencyKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;

public class Main {
	
	
	public static void main(String[] args) {
		Model umlP = LoadUML.chargerModele("model/model.uml");
		
		
		//   Pour bouger une class de package
		/*
		Package dest =  (Package) umlP.getPackagedElement("AnnimalPackage")  ;
		Package sour  =  (Package) umlP.getPackagedElement("AnotherPackage")  ;
		
		Class c = (Class) sour.getPackagedElement("Husky") ;
				// Utils.findClassInPackage("Husky", Utils.findPackageInPackage("AnotherPackage", p)); 
		
		moveClassToPackage(c, dest) ;
		*/
		
		
		
		
		
		//Sauvegarder le modèle avec son nouveau nom
		LoadUML.sauverModele("model/test.uml", umlP);
		System.out.println("Done");
	}
	
	public static void setAttributeToPrivateInClass(Class theclass, String attribute){
		for (Property a : theclass.getAttributes()) {
			if (a.getName().equalsIgnoreCase(attribute)) {
				a.setVisibility(VisibilityKind.PRIVATE_LITERAL);
				
				// Getter
				Operation o = UMLFactory.eINSTANCE.createOperation();
				o.setIsStatic(false);
				o.setName("get"+a.getName());
				o.setType(a.getType());
				theclass.getAllOperations().add(o) ;
				
				// Setter
				o = UMLFactory.eINSTANCE.createOperation();
				o.setIsStatic(false);
				o.setName("set"+a.getName());
				o.createOwnedParameterSet(attribute);
				theclass.getAllOperations().add(o) ;
			}
		}
	}
	
	public static void remonterMethode(Class theClass, Operation method, Class superClass) {
		if (! theClass.getOperations().contains(method)) { return; }
		if (! theClass.getSuperClasses().contains(superClass)) { return; }
		
		
		int index = theClass.getOperations().indexOf(method) ;
		Operation o = theClass.getOperations().remove(index);
		
		superClass.getAllOperations().add(o) ;
		 
		
	}
	
	public static void moveClassToPackage(Class theClass, Package pack) {
		//   theClass.setPackage(pack);   equivalent ????
		
		pack.getPackagedElements().add(theClass) ;
	}
}
