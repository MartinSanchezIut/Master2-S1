/**
 */
package paa;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link paa.BasicQuery#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see paa.PaaPackage#getBasicQuery()
 * @model
 * @generated
 */
public interface BasicQuery extends Query {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link paa.BasicQueryType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see paa.BasicQueryType
	 * @see #setType(BasicQueryType)
	 * @see paa.PaaPackage#getBasicQuery_Type()
	 * @model
	 * @generated
	 */
	BasicQueryType getType();

	/**
	 * Sets the value of the '{@link paa.BasicQuery#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see paa.BasicQueryType
	 * @see #getType()
	 * @generated
	 */
	void setType(BasicQueryType value);

} // BasicQuery
