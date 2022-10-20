package me.martin.tp3ingomodel;


import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Vertex;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.PackageElement;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;


public class Main {
	
	
	
	
	public static void main(String[] args) {
		Model uml = LoadUML.chargerModele("model/model.uml") ;
		
		Class aClass = (Class) uml.getPackagedElement("StageMachineClass") ;
		
		System.out.println("States machines in 'StageMachineClass': ");
		for (StateMachine sm : getAllStateMachine(aClass)) {
			System.out.println(sm.getName());
			
			System.out.println("isValid("+sm.getName()+") : " + isValid(sm));
			
			
			System.out.println("States : ");
			for (State s : getStatesOfMachine(sm)) {
				System.out.println("     " + s.getName());
			}
			
			
			System.out.println("Operations : ");
			for (Operation s : getOperationsOfMachine(sm)) {
				System.out.println("     " + s.getName());
			}
			
			
			System.out.println("--");
		}
		
		applyState(aClass) ;
		LoadUML.sauverModele("test/test.uml", uml);
		System.out.println("Done");
		
		LoadUML.sauverModele("test/test.uml", applyStatetoModel("model/model.uml")) ;
		System.out.println("Done");

	}
	
	
	
	/*
	 * 
	 * 		FONCTIONS
	 * 
	 */	
	public static List<StateMachine> getAllStateMachine(Class theClass) {
		ArrayList<StateMachine> ret = new ArrayList<StateMachine>();
				
		for (Behavior b : theClass.getOwnedBehaviors()) {
			if (b instanceof StateMachine) {
				ret.add((StateMachine) b) ;
			}
		}
		return ret;
	}
	
	
	public static boolean isValid(StateMachine sm) {
		return sm.getRegions().size() == 1;
	}

	public static List<State> getStatesOfMachine(StateMachine sm) {
		assert isValid(sm) ;

		ArrayList<State> ret = new ArrayList<State>();
		
		Region r = sm.getRegions().get(0) ;
		for (Vertex e : r.getSubvertices()) {
			if (e instanceof State) {
				ret.add((State) e) ;
			}
		}
		return ret;
	}
	
	
	
	public static List<Operation> getOperationsOfMachine(StateMachine sm) {
		assert isValid(sm) ;
		
		ArrayList<Operation> ret = new ArrayList<>();
		
		Region r = sm.getRegions().get(0) ;
		for (Transition e : r.getTransitions()) {	
			for (Trigger t : e.getTriggers()) {
				if (t.getEvent() instanceof CallEvent) {
					Operation op = ((CallEvent) t.getEvent()).getOperation();
					ret.add(op);
				}	
			}
		}
		return ret;
	}
	
	public static void applyState(Class theClass) {
		UMLFactory factory = UMLFactory.eINSTANCE ;
		
		Class etatA = factory.createClass();
		etatA.setName("Etat_"+theClass.getName());
		etatA.setIsAbstract(true);
		etatA.setPackage(theClass.getPackage());
		
		
		// pas sur
		Property p1 = factory.createProperty();
		p1.setType(etatA);
		p1.setUpper(1);
		p1.setLower(1);
		theClass.getOwnedAttributes().add(p1);

		Property p2 = factory.createProperty();
		p2.setType(theClass);
		p2.setUpper(1);
		p2.setLower(1);		
		etatA.getOwnedAttributes().add(p2);
		
		Association etatA_theClass = factory.createAssociation();
		etatA_theClass.setName("classToState");
		etatA_theClass.getMemberEnds().add(p1);
		etatA_theClass.getMemberEnds().add(p2);
		etatA_theClass.setPackage(etatA.getPackage());
		
		StateMachine machineOfTheClass = getAllStateMachine(theClass).get(0) ;
		for (Operation m : getOperationsOfMachine(machineOfTheClass)) {			
				Operation op =factory.createOperation();
				op.setIsAbstract(true);
				op.setName(m.getName());
				etatA.getOwnedOperations().add(op);
		}
		
		
		
		for (State s : getStatesOfMachine(machineOfTheClass)) {
			Class state = factory.createClass();
			state.setName("c_"+ s.getName());
			state.getSuperClasses().add(etatA) ;
			state.setPackage(etatA.getPackage());
			
			for (Operation op : etatA.getOperations()) {
				Operation operation = factory.createOperation();
				operation.setName(op.getName());
				state.getOwnedOperations().add(operation);
			}
			
		}	
	}
	
	
	public static Model applyStatetoModel(String modelName) {
		Model uml = LoadUML.chargerModele(modelName) ;
		
		ArrayList<PackageableElement> test = new ArrayList<PackageableElement>();
		for (PackageableElement pe : uml.getPackagedElements()) {
			test.add(pe) ;
		}
				
		for (PackageableElement pe : test){
			if (pe instanceof Class) {
				Class aClass = (Class) pe;
				List<StateMachine> lsm = getAllStateMachine(aClass) ;
				if(!lsm.isEmpty() && isValid(lsm.get(0))) {
					applyState(aClass);
				}
			}
		}
		return uml;
	}
	
	
}
