package me.martin.tpnote;

import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

import paa.PaAModel;
import paa.PaaPackage;

public class FileUtils {
	
	
	
	public static void sauverModeleUML(String uri, EObject root) {
		   Resource resource = null;
		   try {
		      URI uriUri = URI.createURI(uri);
		      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml", new XMIResourceFactoryImpl());
		      resource = (new ResourceSetImpl()).createResource(uriUri);
		      resource.getContents().add(root);
		      resource.save(null);
		   } catch (Exception e) {
		      System.err.println("ERREUR sauvegarde du modèle : "+e);
		      e.printStackTrace();
		   }
		}

	
	
		public static PaAModel chargerModelePaA(String uri) {
			Resource resource = null;
			   try {
			      URI uriUri = URI.createURI(uri);
			      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			      resource = (new ResourceSetImpl()).createResource(uriUri);
			      XMLResource.XMLMap xmlMap = new XMLMapImpl();
			      xmlMap.setNoNamespacePackage(PaaPackage.eINSTANCE);
			      java.util.Map options = new java.util.HashMap();
			      options.put(XMLResource.OPTION_XML_MAP, xmlMap);
			      resource.load(options);
			   }
			   catch(Exception e) {
			      System.err.println("ERREUR chargement du modèle : "+e);
			      e.printStackTrace();
			   }
			   return (PaAModel) resource.getContents().get(0);
			}
		
		   
		

}

