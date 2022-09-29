package utilisationMaps;

import Maps.MapsPackage;
import Maps.Pedestrian;
import Maps.Road;
import Maps.Street;
import Maps.impl.MapsFactoryImpl;
import Maps.Garden;
import Maps.Map;
import Maps.MapsFactory;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;


public class ManipulationsMaps {
	private static Map maMap;

	private static String fileNameString = "Map" ;
	
	public static void main(String[] args) {
		
		//Je charge l'instance map.xmi du méta-modèle maps.ecore
		Resource resource = chargerModele("model/"+ fileNameString +".xmi", MapsPackage.eINSTANCE); // ligne à adapter au nom de votre modèle
		if (resource == null) System.err.println(" Erreur de chargement du modèle");
		//Instruction récupérant le modèle sous forme d'arbre à partir de la classe racine "Map"
		maMap = (Map) resource.getContents().get(0);
		System.out.println(maMap.getName());	// affichage du nom de la carte.
		
		
		for(Street s : returnListOfStreets(maMap)) {
			System.out.println(s.getName());
		}
		for(Pedestrian s : returnListOfPedestrian(maMap)) {
			System.out.println(s.getName());
		}		
		
		for(Street s : returnStreetsNextTo(maMap, "RueDeLaSoif")) {
			System.out.println(s.getName());
		}
		
		Garden test = createGarden(maMap, "COUCOU", new ArrayList<Road>()) ;
		System.out.println(test.getName());
		
	}
	
	public static Garden createGarden(Map map, String name, List<Road> roads) {
		Garden g = MapsFactory.eINSTANCE.createGarden() ;
		g.setName(name);
		g.getBorderedfly().addAll(roads) ;
		map.getSpaces().add(g) ;
		
		sauverModele("test.xmi", map);
		return g;	
	}
	
	/**
	 * Return list of streets next to the street name given
	 * @param roadName
	 * @return List<Street>
	 */
	public static List<Street> returnStreetsNextTo(Map thatMap, String roadName) {
		ArrayList<Street> ret = new ArrayList<Street>();
		
		for(Road r : thatMap.getRoads()) {
			if (r.getName().equalsIgnoreCase(roadName)) {
				for(Road s : r.getMeet()) {
					if (s instanceof Street) {
						ret.add((Street) s) ;
					}
				}
			}
		}	
		return ret;
	}
	
	
	
	/**
	 * Return list of "Pedestrian" of "thatMap"
	 * @param thatMap
	 * @return List<Pedestrian>
	 */
	public static List<Pedestrian> returnListOfPedestrian(Map thatMap) {
		ArrayList<Pedestrian> ret = new ArrayList<Pedestrian>();
		for(Road r : thatMap.getRoads()) {
			if (r instanceof Pedestrian) {
				ret.add((Pedestrian) r) ;
			}
		}
		return ret;
	}
		
	
	/**
	 * Retourne la liste des "Street" de "thatMap"
	 * @param thatMap 
	 * @return List<Street>
	 */
	public static List<Street>  returnListOfStreets(Map thatMap) {
		ArrayList<Street> ret = new ArrayList<Street>();
		
		for(Road r : thatMap.getRoads()) {
			if (r instanceof Street) {
				ret.add((Street) r) ;
			}
		}
		return ret ;
	}
	
	
	
	public static Resource chargerModele(String uri, EPackage pack) {
		   Resource resource = null;
		   try {
		      URI uriUri = URI.createURI(uri);
		      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		      resource = (new ResourceSetImpl()).createResource(uriUri);
		      XMLResource.XMLMap xmlMap = new XMLMapImpl();
		      xmlMap.setNoNamespacePackage(pack);
		      java.util.Map options = new java.util.HashMap();
		      options.put(XMLResource.OPTION_XML_MAP, xmlMap);
		      resource.load(options);
		   }
		   catch(Exception e) {
		      System.err.println("ERREUR chargement du modèle : "+e);
		      e.printStackTrace();
		   }
		   return resource;
		}
	
	public static void sauverModele(String uri, EObject root) {
		   Resource resource = null;
		   try {
		      URI uriUri = URI.createURI(uri);
		      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		      resource = (new ResourceSetImpl()).createResource(uriUri);
		      resource.getContents().add(root);
		      resource.save(null);
		   } catch (Exception e) {
		      System.err.println("ERREUR sauvegarde du modèle : "+e);
		      e.printStackTrace();
		   }
		}

}