/**
 */
package paa;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Dependant Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link paa.FieldDependantQuery#getField <em>Field</em>}</li>
 *   <li>{@link paa.FieldDependantQuery#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see paa.PaaPackage#getFieldDependantQuery()
 * @model
 * @generated
 */
public interface FieldDependantQuery extends Query {
	/**
	 * Returns the value of the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field</em>' reference.
	 * @see #setField(Field)
	 * @see paa.PaaPackage#getFieldDependantQuery_Field()
	 * @model required="true"
	 * @generated
	 */
	Field getField();

	/**
	 * Sets the value of the '{@link paa.FieldDependantQuery#getField <em>Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' reference.
	 * @see #getField()
	 * @generated
	 */
	void setField(Field value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link paa.FieldDependantQueryType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see paa.FieldDependantQueryType
	 * @see #setType(FieldDependantQueryType)
	 * @see paa.PaaPackage#getFieldDependantQuery_Type()
	 * @model
	 * @generated
	 */
	FieldDependantQueryType getType();

	/**
	 * Sets the value of the '{@link paa.FieldDependantQuery#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see paa.FieldDependantQueryType
	 * @see #getType()
	 * @generated
	 */
	void setType(FieldDependantQueryType value);

} // FieldDependantQuery
