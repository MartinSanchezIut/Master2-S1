/**
 */
package paa;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link paa.Repository#getTypeEntity <em>Type Entity</em>}</li>
 *   <li>{@link paa.Repository#getQueries <em>Queries</em>}</li>
 * </ul>
 *
 * @see paa.PaaPackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Entity</em>' reference.
	 * @see #setTypeEntity(Entity)
	 * @see paa.PaaPackage#getRepository_TypeEntity()
	 * @model required="true"
	 * @generated
	 */
	Entity getTypeEntity();

	/**
	 * Sets the value of the '{@link paa.Repository#getTypeEntity <em>Type Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Entity</em>' reference.
	 * @see #getTypeEntity()
	 * @generated
	 */
	void setTypeEntity(Entity value);

	/**
	 * Returns the value of the '<em><b>Queries</b></em>' containment reference list.
	 * The list contents are of type {@link paa.Query}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' containment reference list.
	 * @see paa.PaaPackage#getRepository_Queries()
	 * @model containment="true"
	 * @generated
	 */
	EList<Query> getQueries();

} // Repository
