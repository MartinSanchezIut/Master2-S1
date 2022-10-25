/**
 */
package enseigne;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gamme Personnalisable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link enseigne.GammePersonnalisable#getCaracteristiquevariable <em>Caracteristiquevariable</em>}</li>
 *   <li>{@link enseigne.GammePersonnalisable#getObjects <em>Objects</em>}</li>
 *   <li>{@link enseigne.GammePersonnalisable#getElementdepersonnalisation <em>Elementdepersonnalisation</em>}</li>
 * </ul>
 *
 * @see enseigne.EnseignePackage#getGammePersonnalisable()
 * @model
 * @generated
 */
public interface GammePersonnalisable extends EObject {
	/**
	 * Returns the value of the '<em><b>Caracteristiquevariable</b></em>' containment reference list.
	 * The list contents are of type {@link enseigne.CaracteristiqueVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caracteristiquevariable</em>' containment reference list.
	 * @see enseigne.EnseignePackage#getGammePersonnalisable_Caracteristiquevariable()
	 * @model containment="true"
	 * @generated
	 */
	EList<CaracteristiqueVariable> getCaracteristiquevariable();

	/**
	 * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
	 * The list contents are of type {@link enseigne.Object}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' containment reference list.
	 * @see enseigne.EnseignePackage#getGammePersonnalisable_Objects()
	 * @model containment="true"
	 * @generated
	 */
	EList<enseigne.Object> getObjects();

	/**
	 * Returns the value of the '<em><b>Elementdepersonnalisation</b></em>' containment reference list.
	 * The list contents are of type {@link enseigne.ElementDePersonnalisation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elementdepersonnalisation</em>' containment reference list.
	 * @see enseigne.EnseignePackage#getGammePersonnalisable_Elementdepersonnalisation()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementDePersonnalisation> getElementdepersonnalisation();

} // GammePersonnalisable
