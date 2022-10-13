package me.martin.tp3ingomodel;


import org.eclipse.uml2.uml.StateMachine;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;


public class Main {
	
	
	
	
	public static void main(String[] args) {
		
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

}
