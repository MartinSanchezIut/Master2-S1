/**
 */
package enseigne;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see enseigne.EnseignePackage
 * @generated
 */
public interface EnseigneFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnseigneFactory eINSTANCE = enseigne.impl.EnseigneFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Gamme Personnalisable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gamme Personnalisable</em>'.
	 * @generated
	 */
	GammePersonnalisable createGammePersonnalisable();

	/**
	 * Returns a new object of class '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object</em>'.
	 * @generated
	 */
	Object createObject();

	/**
	 * Returns a new object of class '<em>Element De Personnalisation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element De Personnalisation</em>'.
	 * @generated
	 */
	ElementDePersonnalisation createElementDePersonnalisation();

	/**
	 * Returns a new object of class '<em>Caracteristique Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Caracteristique Variable</em>'.
	 * @generated
	 */
	CaracteristiqueVariable createCaracteristiqueVariable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EnseignePackage getEnseignePackage();

} //EnseigneFactory
