/**
 */
package enseigne.impl;

import enseigne.CaracteristiqueVariable;
import enseigne.ElementDePersonnalisation;
import enseigne.EnseigneFactory;
import enseigne.EnseignePackage;
import enseigne.GammePersonnalisable;
import enseigne.NamedElement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnseignePackageImpl extends EPackageImpl implements EnseignePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gammePersonnalisableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementDePersonnalisationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caracteristiqueVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see enseigne.EnseignePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EnseignePackageImpl() {
		super(eNS_URI, EnseigneFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link EnseignePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EnseignePackage init() {
		if (isInited) return (EnseignePackage)EPackage.Registry.INSTANCE.getEPackage(EnseignePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredEnseignePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EnseignePackageImpl theEnseignePackage = registeredEnseignePackage instanceof EnseignePackageImpl ? (EnseignePackageImpl)registeredEnseignePackage : new EnseignePackageImpl();

		isInited = true;

		// Create package meta-data objects
		theEnseignePackage.createPackageContents();

		// Initialize created meta-data
		theEnseignePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEnseignePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EnseignePackage.eNS_URI, theEnseignePackage);
		return theEnseignePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGammePersonnalisable() {
		return gammePersonnalisableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGammePersonnalisable_Caracteristiquevariable() {
		return (EReference)gammePersonnalisableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGammePersonnalisable_Objects() {
		return (EReference)gammePersonnalisableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGammePersonnalisable_Elementdepersonnalisation() {
		return (EReference)gammePersonnalisableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObject() {
		return objectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementDePersonnalisation() {
		return elementDePersonnalisationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaracteristiqueVariable() {
		return caracteristiqueVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Nom() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnseigneFactory getEnseigneFactory() {
		return (EnseigneFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		gammePersonnalisableEClass = createEClass(GAMME_PERSONNALISABLE);
		createEReference(gammePersonnalisableEClass, GAMME_PERSONNALISABLE__CARACTERISTIQUEVARIABLE);
		createEReference(gammePersonnalisableEClass, GAMME_PERSONNALISABLE__OBJECTS);
		createEReference(gammePersonnalisableEClass, GAMME_PERSONNALISABLE__ELEMENTDEPERSONNALISATION);

		objectEClass = createEClass(OBJECT);

		elementDePersonnalisationEClass = createEClass(ELEMENT_DE_PERSONNALISATION);

		caracteristiqueVariableEClass = createEClass(CARACTERISTIQUE_VARIABLE);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NOM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		objectEClass.getESuperTypes().add(this.getNamedElement());
		elementDePersonnalisationEClass.getESuperTypes().add(this.getNamedElement());
		caracteristiqueVariableEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(gammePersonnalisableEClass, GammePersonnalisable.class, "GammePersonnalisable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGammePersonnalisable_Caracteristiquevariable(), this.getCaracteristiqueVariable(), null, "caracteristiquevariable", null, 0, -1, GammePersonnalisable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGammePersonnalisable_Objects(), this.getObject(), null, "objects", null, 0, -1, GammePersonnalisable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGammePersonnalisable_Elementdepersonnalisation(), this.getElementDePersonnalisation(), null, "elementdepersonnalisation", null, 0, -1, GammePersonnalisable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectEClass, enseigne.Object.class, "Object", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementDePersonnalisationEClass, ElementDePersonnalisation.class, "ElementDePersonnalisation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(caracteristiqueVariableEClass, CaracteristiqueVariable.class, "CaracteristiqueVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Nom(), ecorePackage.getEString(), "nom", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //EnseignePackageImpl
