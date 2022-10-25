/**
 */
package enseigne;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see enseigne.EnseigneFactory
 * @model kind="package"
 * @generated
 */
public interface EnseignePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "enseigne";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "enseigne";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "enseigne";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnseignePackage eINSTANCE = enseigne.impl.EnseignePackageImpl.init();

	/**
	 * The meta object id for the '{@link enseigne.impl.GammePersonnalisableImpl <em>Gamme Personnalisable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see enseigne.impl.GammePersonnalisableImpl
	 * @see enseigne.impl.EnseignePackageImpl#getGammePersonnalisable()
	 * @generated
	 */
	int GAMME_PERSONNALISABLE = 0;

	/**
	 * The feature id for the '<em><b>Caracteristiquevariable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMME_PERSONNALISABLE__CARACTERISTIQUEVARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMME_PERSONNALISABLE__OBJECTS = 1;

	/**
	 * The feature id for the '<em><b>Elementdepersonnalisation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMME_PERSONNALISABLE__ELEMENTDEPERSONNALISATION = 2;

	/**
	 * The number of structural features of the '<em>Gamme Personnalisable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMME_PERSONNALISABLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Gamme Personnalisable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMME_PERSONNALISABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link enseigne.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see enseigne.impl.NamedElementImpl
	 * @see enseigne.impl.EnseignePackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NOM = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link enseigne.impl.ObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see enseigne.impl.ObjectImpl
	 * @see enseigne.impl.EnseignePackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__NOM = NAMED_ELEMENT__NOM;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link enseigne.impl.ElementDePersonnalisationImpl <em>Element De Personnalisation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see enseigne.impl.ElementDePersonnalisationImpl
	 * @see enseigne.impl.EnseignePackageImpl#getElementDePersonnalisation()
	 * @generated
	 */
	int ELEMENT_DE_PERSONNALISATION = 2;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DE_PERSONNALISATION__NOM = NAMED_ELEMENT__NOM;

	/**
	 * The number of structural features of the '<em>Element De Personnalisation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DE_PERSONNALISATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Element De Personnalisation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DE_PERSONNALISATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link enseigne.impl.CaracteristiqueVariableImpl <em>Caracteristique Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see enseigne.impl.CaracteristiqueVariableImpl
	 * @see enseigne.impl.EnseignePackageImpl#getCaracteristiqueVariable()
	 * @generated
	 */
	int CARACTERISTIQUE_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARACTERISTIQUE_VARIABLE__NOM = NAMED_ELEMENT__NOM;

	/**
	 * The number of structural features of the '<em>Caracteristique Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARACTERISTIQUE_VARIABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Caracteristique Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARACTERISTIQUE_VARIABLE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link enseigne.GammePersonnalisable <em>Gamme Personnalisable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gamme Personnalisable</em>'.
	 * @see enseigne.GammePersonnalisable
	 * @generated
	 */
	EClass getGammePersonnalisable();

	/**
	 * Returns the meta object for the containment reference list '{@link enseigne.GammePersonnalisable#getCaracteristiquevariable <em>Caracteristiquevariable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Caracteristiquevariable</em>'.
	 * @see enseigne.GammePersonnalisable#getCaracteristiquevariable()
	 * @see #getGammePersonnalisable()
	 * @generated
	 */
	EReference getGammePersonnalisable_Caracteristiquevariable();

	/**
	 * Returns the meta object for the containment reference list '{@link enseigne.GammePersonnalisable#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Objects</em>'.
	 * @see enseigne.GammePersonnalisable#getObjects()
	 * @see #getGammePersonnalisable()
	 * @generated
	 */
	EReference getGammePersonnalisable_Objects();

	/**
	 * Returns the meta object for the containment reference list '{@link enseigne.GammePersonnalisable#getElementdepersonnalisation <em>Elementdepersonnalisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elementdepersonnalisation</em>'.
	 * @see enseigne.GammePersonnalisable#getElementdepersonnalisation()
	 * @see #getGammePersonnalisable()
	 * @generated
	 */
	EReference getGammePersonnalisable_Elementdepersonnalisation();

	/**
	 * Returns the meta object for class '{@link enseigne.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see enseigne.Object
	 * @generated
	 */
	EClass getObject();

	/**
	 * Returns the meta object for class '{@link enseigne.ElementDePersonnalisation <em>Element De Personnalisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element De Personnalisation</em>'.
	 * @see enseigne.ElementDePersonnalisation
	 * @generated
	 */
	EClass getElementDePersonnalisation();

	/**
	 * Returns the meta object for class '{@link enseigne.CaracteristiqueVariable <em>Caracteristique Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Caracteristique Variable</em>'.
	 * @see enseigne.CaracteristiqueVariable
	 * @generated
	 */
	EClass getCaracteristiqueVariable();

	/**
	 * Returns the meta object for class '{@link enseigne.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see enseigne.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link enseigne.NamedElement#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see enseigne.NamedElement#getNom()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Nom();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EnseigneFactory getEnseigneFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link enseigne.impl.GammePersonnalisableImpl <em>Gamme Personnalisable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see enseigne.impl.GammePersonnalisableImpl
		 * @see enseigne.impl.EnseignePackageImpl#getGammePersonnalisable()
		 * @generated
		 */
		EClass GAMME_PERSONNALISABLE = eINSTANCE.getGammePersonnalisable();

		/**
		 * The meta object literal for the '<em><b>Caracteristiquevariable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAMME_PERSONNALISABLE__CARACTERISTIQUEVARIABLE = eINSTANCE.getGammePersonnalisable_Caracteristiquevariable();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAMME_PERSONNALISABLE__OBJECTS = eINSTANCE.getGammePersonnalisable_Objects();

		/**
		 * The meta object literal for the '<em><b>Elementdepersonnalisation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAMME_PERSONNALISABLE__ELEMENTDEPERSONNALISATION = eINSTANCE.getGammePersonnalisable_Elementdepersonnalisation();

		/**
		 * The meta object literal for the '{@link enseigne.impl.ObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see enseigne.impl.ObjectImpl
		 * @see enseigne.impl.EnseignePackageImpl#getObject()
		 * @generated
		 */
		EClass OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '{@link enseigne.impl.ElementDePersonnalisationImpl <em>Element De Personnalisation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see enseigne.impl.ElementDePersonnalisationImpl
		 * @see enseigne.impl.EnseignePackageImpl#getElementDePersonnalisation()
		 * @generated
		 */
		EClass ELEMENT_DE_PERSONNALISATION = eINSTANCE.getElementDePersonnalisation();

		/**
		 * The meta object literal for the '{@link enseigne.impl.CaracteristiqueVariableImpl <em>Caracteristique Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see enseigne.impl.CaracteristiqueVariableImpl
		 * @see enseigne.impl.EnseignePackageImpl#getCaracteristiqueVariable()
		 * @generated
		 */
		EClass CARACTERISTIQUE_VARIABLE = eINSTANCE.getCaracteristiqueVariable();

		/**
		 * The meta object literal for the '{@link enseigne.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see enseigne.impl.NamedElementImpl
		 * @see enseigne.impl.EnseignePackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NOM = eINSTANCE.getNamedElement_Nom();

	}

} //EnseignePackage
