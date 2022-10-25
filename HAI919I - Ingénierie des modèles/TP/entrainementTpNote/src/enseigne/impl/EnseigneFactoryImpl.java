/**
 */
package enseigne.impl;

import enseigne.CaracteristiqueVariable;
import enseigne.ElementDePersonnalisation;
import enseigne.EnseigneFactory;
import enseigne.EnseignePackage;
import enseigne.GammePersonnalisable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnseigneFactoryImpl extends EFactoryImpl implements EnseigneFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnseigneFactory init() {
		try {
			EnseigneFactory theEnseigneFactory = (EnseigneFactory)EPackage.Registry.INSTANCE.getEFactory(EnseignePackage.eNS_URI);
			if (theEnseigneFactory != null) {
				return theEnseigneFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EnseigneFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnseigneFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EnseignePackage.GAMME_PERSONNALISABLE: return createGammePersonnalisable();
			case EnseignePackage.OBJECT: return createObject();
			case EnseignePackage.ELEMENT_DE_PERSONNALISATION: return createElementDePersonnalisation();
			case EnseignePackage.CARACTERISTIQUE_VARIABLE: return createCaracteristiqueVariable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GammePersonnalisable createGammePersonnalisable() {
		GammePersonnalisableImpl gammePersonnalisable = new GammePersonnalisableImpl();
		return gammePersonnalisable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public enseigne.Object createObject() {
		ObjectImpl object = new ObjectImpl();
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementDePersonnalisation createElementDePersonnalisation() {
		ElementDePersonnalisationImpl elementDePersonnalisation = new ElementDePersonnalisationImpl();
		return elementDePersonnalisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaracteristiqueVariable createCaracteristiqueVariable() {
		CaracteristiqueVariableImpl caracteristiqueVariable = new CaracteristiqueVariableImpl();
		return caracteristiqueVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnseignePackage getEnseignePackage() {
		return (EnseignePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EnseignePackage getPackage() {
		return EnseignePackage.eINSTANCE;
	}

} //EnseigneFactoryImpl
