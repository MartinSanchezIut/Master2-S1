/**
 */
package Maps;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Public Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Maps.PublicSpace#getName <em>Name</em>}</li>
 *   <li>{@link Maps.PublicSpace#getBorderedfly <em>Borderedfly</em>}</li>
 * </ul>
 *
 * @see Maps.MapsPackage#getPublicSpace()
 * @model abstract="true"
 * @generated
 */
public interface PublicSpace extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Maps.MapsPackage#getPublicSpace_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Maps.PublicSpace#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Borderedfly</b></em>' reference list.
	 * The list contents are of type {@link Maps.Road}.
	 * It is bidirectional and its opposite is '{@link Maps.Road#getBorder <em>Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Borderedfly</em>' reference list.
	 * @see Maps.MapsPackage#getPublicSpace_Borderedfly()
	 * @see Maps.Road#getBorder
	 * @model opposite="border" required="true"
	 * @generated
	 */
	EList<Road> getBorderedfly();

} // PublicSpace
