/**
 */
package paa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Field Dependant Query Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see paa.PaaPackage#getFieldDependantQueryType()
 * @model
 * @generated
 */
public enum FieldDependantQueryType implements Enumerator {
	/**
	 * The '<em><b>Find By</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIND_BY_VALUE
	 * @generated
	 * @ordered
	 */
	FIND_BY(0, "findBy", "findBy"),

	/**
	 * The '<em><b>Delete By</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_BY_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_BY(1, "deleteBy", "deleteBy");

	/**
	 * The '<em><b>Find By</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIND_BY
	 * @model name="findBy"
	 * @generated
	 * @ordered
	 */
	public static final int FIND_BY_VALUE = 0;

	/**
	 * The '<em><b>Delete By</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_BY
	 * @model name="deleteBy"
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_BY_VALUE = 1;

	/**
	 * An array of all the '<em><b>Field Dependant Query Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FieldDependantQueryType[] VALUES_ARRAY =
		new FieldDependantQueryType[] {
			FIND_BY,
			DELETE_BY,
		};

	/**
	 * A public read-only list of all the '<em><b>Field Dependant Query Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FieldDependantQueryType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Field Dependant Query Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FieldDependantQueryType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FieldDependantQueryType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Field Dependant Query Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FieldDependantQueryType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FieldDependantQueryType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Field Dependant Query Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FieldDependantQueryType get(int value) {
		switch (value) {
			case FIND_BY_VALUE: return FIND_BY;
			case DELETE_BY_VALUE: return DELETE_BY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FieldDependantQueryType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //FieldDependantQueryType
