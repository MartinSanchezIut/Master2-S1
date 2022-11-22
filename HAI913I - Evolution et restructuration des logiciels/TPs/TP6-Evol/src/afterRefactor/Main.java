package afterRefactor;

/* 
 * Author : SANCHEZ Martin
 */

public class Main {
	
	public static void main(String[] args) {
		EncapsulateField t = new EncapsulateField(4) ;
		System.out.println(t.getToto());
	}
	
	/*
	 
	 EncapsulateField : 
	 	Met l'attribut designé en privé
	 	Crée un accesseur en lecture et en ecriture (getter / setter)
	 	Remplace tout les appels classe.attribut par classe.getter
	 	Remplace tout les appels attribut par getter
	 	
	 	Remplace tout les appels classe.attribut = x par classe.setter
	 	Remplace tout les appels attribut = x par setter
	 
	 		 	
	 	Viens modifier le main, pour que l'accès a l'attribut reste valide
	 	
	 	(Images) 
	 	
	 	
	 	Problemes :
	 		Dans le constructeur, le refactor est venu remplacer 
	 		this.toto par this.getToto() 
	 		ce qui n'est pas du tout optimal.
	 		
	 		Le refactor ne tiens pas compte de l'accesibilité des attribut.
	 		une classe a acces a ses atributs (privé ou non).
	 


	 	L'intéret : 
	 		ne change rien au fonctionnement du programe
	 		mais ajoute une pratique de programation plus saine (controler l'acces aux attributs)
	 
	 */
}



/*
 		REMOVE DEAD CODE, non present dans eclipse mais present dans (https://refactoring.com/catalog/)
 		supprime tout le code qui n'est pas accessible
 
 
 
*/
