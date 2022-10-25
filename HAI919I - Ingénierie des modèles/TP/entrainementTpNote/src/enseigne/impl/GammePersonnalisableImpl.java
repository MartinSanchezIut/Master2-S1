/**
 */
package enseigne.impl;

import enseigne.CaracteristiqueVariable;
import enseigne.ElementDePersonnalisation;
import enseigne.EnseignePackage;
import enseigne.GammePersonnalisable;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gamme Personnalisable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link enseigne.impl.GammePersonnalisableImpl#getCaracteristiquevariable <em>Caracteristiquevariable</em>}</li>
 *   <li>{@link enseigne.impl.GammePersonnalisableImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link enseigne.impl.GammePersonnalisableImpl#getElementdepersonnalisation <em>Elementdepersonnalisation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GammePersonnalisableImpl extends MinimalEObjectImpl.Container implements GammePersonnalisable {
	/**
	 * The cached value of the '{@link #getCaracteristiquevariable() <em>Caracteristiquevariable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaracteristiquevariable()
	 * @generated
	 * @ordered
	 */
	protected EList<CaracteristiqueVariable> caracteristiquevariable;

	/**
	 * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<enseigne.Object> objects;

	/**
	 * The cached value of the '{@link #getElementdepersonnalisation() <em>Elementdepersonnalisation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementdepersonnalisation()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementDePersonnalisation> elementdepersonnalisation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GammePersonnalisableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnseignePackage.Literals.GAMME_PERSONNALISABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CaracteristiqueVariable> getCaracteristiquevariable() {
		if (caracteristiquevariable == null) {
			caracteristiquevariable = new EObjectContainmentEList<CaracteristiqueVariable>(CaracteristiqueVariable.class, this, EnseignePackage.GAMME_PERSONNALISABLE__CARACTERISTIQUEVARIABLE);
		}
		return caracteristiquevariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<enseigne.Object> getObjects() {
		if (objects == null) {
			objects = new EObjectContainmentEList<enseigne.Object>(enseigne.Object.class, this, EnseignePackage.GAMME_PERSONNALISABLE__OBJECTS);
		}
		return objects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementDePersonnalisation> getElementdepersonnalisation() {
		if (elementdepersonnalisation == null) {
			elementdepersonnalisation = new EObjectContainmentEList<ElementDePersonnalisation>(ElementDePersonnalisation.class, this, EnseignePackage.GAMME_PERSONNALISABLE__ELEMENTDEPERSONNALISATION);
		}
		return elementdepersonnalisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EnseignePackage.GAMME_PERSONNALISABLE__CARACTERISTIQUEVARIABLE:
				return ((InternalEList<?>)getCaracteristiquevariable()).basicRemove(otherEnd, msgs);
			case EnseignePackage.GAMME_PERSONNALISABLE__OBJECTS:
				return ((InternalEList<?>)getObjects()).basicRemove(otherEnd, msgs);
			case EnseignePackage.GAMME_PERSONNALISABLE__ELEMENTDEPERSONNALISATION:
				return ((InternalEList<?>)getElementdepersonnalisation()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EnseignePackage.GAMME_PERSONNALISABLE__CARACTERISTIQUEVARIABLE:
				return getCaracteristiquevariable();
			case EnseignePackage.GAMME_PERSONNALISABLE__OBJECTS:
				return getObjects();
			case EnseignePackage.GAMME_PERSONNALISABLE__ELEMENTDEPERSONNALISATION:
				return getElementdepersonnalisation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EnseignePackage.GAMME_PERSONNALISABLE__CARACTERISTIQUEVARIABLE:
				getCaracteristiquevariable().clear();
				getCaracteristiquevariable().addAll((Collection<? extends CaracteristiqueVariable>)newValue);
				return;
			case EnseignePackage.GAMME_PERSONNALISABLE__OBJECTS:
				getObjects().clear();
				getObjects().addAll((Collection<? extends enseigne.Object>)newValue);
				return;
			case EnseignePackage.GAMME_PERSONNALISABLE__ELEMENTDEPERSONNALISATION:
				getElementdepersonnalisation().clear();
				getElementdepersonnalisation().addAll((Collection<? extends ElementDePersonnalisation>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EnseignePackage.GAMME_PERSONNALISABLE__CARACTERISTIQUEVARIABLE:
				getCaracteristiquevariable().clear();
				return;
			case EnseignePackage.GAMME_PERSONNALISABLE__OBJECTS:
				getObjects().clear();
				return;
			case EnseignePackage.GAMME_PERSONNALISABLE__ELEMENTDEPERSONNALISATION:
				getElementdepersonnalisation().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EnseignePackage.GAMME_PERSONNALISABLE__CARACTERISTIQUEVARIABLE:
				return caracteristiquevariable != null && !caracteristiquevariable.isEmpty();
			case EnseignePackage.GAMME_PERSONNALISABLE__OBJECTS:
				return objects != null && !objects.isEmpty();
			case EnseignePackage.GAMME_PERSONNALISABLE__ELEMENTDEPERSONNALISATION:
				return elementdepersonnalisation != null && !elementdepersonnalisation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GammePersonnalisableImpl
