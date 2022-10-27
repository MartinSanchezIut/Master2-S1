/**
 */
package paa;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pa AModel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link paa.PaAModel#getEntities <em>Entities</em>}</li>
 *   <li>{@link paa.PaAModel#getRepositories <em>Repositories</em>}</li>
 * </ul>
 *
 * @see paa.PaaPackage#getPaAModel()
 * @model
 * @generated
 */
public interface PaAModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
	 * The list contents are of type {@link paa.Entity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' containment reference list.
	 * @see paa.PaaPackage#getPaAModel_Entities()
	 * @model containment="true"
	 * @generated
	 */
	EList<Entity> getEntities();

	/**
	 * Returns the value of the '<em><b>Repositories</b></em>' containment reference list.
	 * The list contents are of type {@link paa.Repository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repositories</em>' containment reference list.
	 * @see paa.PaaPackage#getPaAModel_Repositories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Repository> getRepositories();

} // PaAModel
