/**
 */
package Maps;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Maps.Map#getName <em>Name</em>}</li>
 *   <li>{@link Maps.Map#getSpaces <em>Spaces</em>}</li>
 *   <li>{@link Maps.Map#getRoads <em>Roads</em>}</li>
 * </ul>
 *
 * @see Maps.MapsPackage#getMap()
 * @model
 * @generated
 */
public interface Map extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Maps.MapsPackage#getMap_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Maps.Map#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Spaces</b></em>' containment reference list.
	 * The list contents are of type {@link Maps.PublicSpace}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spaces</em>' containment reference list.
	 * @see Maps.MapsPackage#getMap_Spaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<PublicSpace> getSpaces();

	/**
	 * Returns the value of the '<em><b>Roads</b></em>' containment reference list.
	 * The list contents are of type {@link Maps.Road}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roads</em>' containment reference list.
	 * @see Maps.MapsPackage#getMap_Roads()
	 * @model containment="true"
	 * @generated
	 */
	EList<Road> getRoads();

} // Map
