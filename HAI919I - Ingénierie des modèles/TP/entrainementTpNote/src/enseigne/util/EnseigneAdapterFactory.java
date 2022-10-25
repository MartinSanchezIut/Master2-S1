/**
 */
package enseigne.util;

import enseigne.CaracteristiqueVariable;
import enseigne.ElementDePersonnalisation;
import enseigne.EnseignePackage;
import enseigne.GammePersonnalisable;
import enseigne.NamedElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see enseigne.EnseignePackage
 * @generated
 */
public class EnseigneAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EnseignePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnseigneAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EnseignePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnseigneSwitch<Adapter> modelSwitch =
		new EnseigneSwitch<Adapter>() {
			@Override
			public Adapter caseGammePersonnalisable(GammePersonnalisable object) {
				return createGammePersonnalisableAdapter();
			}
			@Override
			public Adapter caseObject(enseigne.Object object) {
				return createObjectAdapter();
			}
			@Override
			public Adapter caseElementDePersonnalisation(ElementDePersonnalisation object) {
				return createElementDePersonnalisationAdapter();
			}
			@Override
			public Adapter caseCaracteristiqueVariable(CaracteristiqueVariable object) {
				return createCaracteristiqueVariableAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link enseigne.GammePersonnalisable <em>Gamme Personnalisable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see enseigne.GammePersonnalisable
	 * @generated
	 */
	public Adapter createGammePersonnalisableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link enseigne.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see enseigne.Object
	 * @generated
	 */
	public Adapter createObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link enseigne.ElementDePersonnalisation <em>Element De Personnalisation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see enseigne.ElementDePersonnalisation
	 * @generated
	 */
	public Adapter createElementDePersonnalisationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link enseigne.CaracteristiqueVariable <em>Caracteristique Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see enseigne.CaracteristiqueVariable
	 * @generated
	 */
	public Adapter createCaracteristiqueVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link enseigne.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see enseigne.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EnseigneAdapterFactory
