/**
 */
package Maps;

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
 * @see Maps.MapsFactory
 * @model kind="package"
 * @generated
 */
public interface MapsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Maps";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "Maps";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Maps";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MapsPackage eINSTANCE = Maps.impl.MapsPackageImpl.init();

	/**
	 * The meta object id for the '{@link Maps.impl.MapImpl <em>Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Maps.impl.MapImpl
	 * @see Maps.impl.MapsPackageImpl#getMap()
	 * @generated
	 */
	int MAP = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Spaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP__SPACES = 1;

	/**
	 * The feature id for the '<em><b>Roads</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP__ROADS = 2;

	/**
	 * The number of structural features of the '<em>Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Maps.impl.PublicSpaceImpl <em>Public Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Maps.impl.PublicSpaceImpl
	 * @see Maps.impl.MapsPackageImpl#getPublicSpace()
	 * @generated
	 */
	int PUBLIC_SPACE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLIC_SPACE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Borderedfly</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLIC_SPACE__BORDEREDFLY = 1;

	/**
	 * The number of structural features of the '<em>Public Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLIC_SPACE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Public Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLIC_SPACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Maps.impl.GardenImpl <em>Garden</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Maps.impl.GardenImpl
	 * @see Maps.impl.MapsPackageImpl#getGarden()
	 * @generated
	 */
	int GARDEN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARDEN__NAME = PUBLIC_SPACE__NAME;

	/**
	 * The feature id for the '<em><b>Borderedfly</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARDEN__BORDEREDFLY = PUBLIC_SPACE__BORDEREDFLY;

	/**
	 * The number of structural features of the '<em>Garden</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARDEN_FEATURE_COUNT = PUBLIC_SPACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Garden</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARDEN_OPERATION_COUNT = PUBLIC_SPACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Maps.impl.SquareImpl <em>Square</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Maps.impl.SquareImpl
	 * @see Maps.impl.MapsPackageImpl#getSquare()
	 * @generated
	 */
	int SQUARE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE__NAME = PUBLIC_SPACE__NAME;

	/**
	 * The feature id for the '<em><b>Borderedfly</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE__BORDEREDFLY = PUBLIC_SPACE__BORDEREDFLY;

	/**
	 * The number of structural features of the '<em>Square</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_FEATURE_COUNT = PUBLIC_SPACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Square</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_OPERATION_COUNT = PUBLIC_SPACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Maps.impl.RoadImpl <em>Road</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Maps.impl.RoadImpl
	 * @see Maps.impl.MapsPackageImpl#getRoad()
	 * @generated
	 */
	int ROAD = 4;

	/**
	 * The feature id for the '<em><b>Meet</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD__MEET = 0;

	/**
	 * The feature id for the '<em><b>Border</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD__BORDER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD__NAME = 2;

	/**
	 * The feature id for the '<em><b>Lenght</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD__LENGHT = 3;

	/**
	 * The number of structural features of the '<em>Road</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Road</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Maps.impl.StreetImpl <em>Street</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Maps.impl.StreetImpl
	 * @see Maps.impl.MapsPackageImpl#getStreet()
	 * @generated
	 */
	int STREET = 5;

	/**
	 * The feature id for the '<em><b>Meet</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREET__MEET = ROAD__MEET;

	/**
	 * The feature id for the '<em><b>Border</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREET__BORDER = ROAD__BORDER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREET__NAME = ROAD__NAME;

	/**
	 * The feature id for the '<em><b>Lenght</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREET__LENGHT = ROAD__LENGHT;

	/**
	 * The number of structural features of the '<em>Street</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREET_FEATURE_COUNT = ROAD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Street</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREET_OPERATION_COUNT = ROAD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Maps.impl.PedestrianImpl <em>Pedestrian</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Maps.impl.PedestrianImpl
	 * @see Maps.impl.MapsPackageImpl#getPedestrian()
	 * @generated
	 */
	int PEDESTRIAN = 6;

	/**
	 * The feature id for the '<em><b>Meet</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__MEET = ROAD__MEET;

	/**
	 * The feature id for the '<em><b>Border</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__BORDER = ROAD__BORDER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__NAME = ROAD__NAME;

	/**
	 * The feature id for the '<em><b>Lenght</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__LENGHT = ROAD__LENGHT;

	/**
	 * The number of structural features of the '<em>Pedestrian</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN_FEATURE_COUNT = ROAD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pedestrian</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN_OPERATION_COUNT = ROAD_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link Maps.Map <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map</em>'.
	 * @see Maps.Map
	 * @generated
	 */
	EClass getMap();

	/**
	 * Returns the meta object for the attribute '{@link Maps.Map#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Maps.Map#getName()
	 * @see #getMap()
	 * @generated
	 */
	EAttribute getMap_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link Maps.Map#getSpaces <em>Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Spaces</em>'.
	 * @see Maps.Map#getSpaces()
	 * @see #getMap()
	 * @generated
	 */
	EReference getMap_Spaces();

	/**
	 * Returns the meta object for the containment reference list '{@link Maps.Map#getRoads <em>Roads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roads</em>'.
	 * @see Maps.Map#getRoads()
	 * @see #getMap()
	 * @generated
	 */
	EReference getMap_Roads();

	/**
	 * Returns the meta object for class '{@link Maps.PublicSpace <em>Public Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Public Space</em>'.
	 * @see Maps.PublicSpace
	 * @generated
	 */
	EClass getPublicSpace();

	/**
	 * Returns the meta object for the attribute '{@link Maps.PublicSpace#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Maps.PublicSpace#getName()
	 * @see #getPublicSpace()
	 * @generated
	 */
	EAttribute getPublicSpace_Name();

	/**
	 * Returns the meta object for the reference list '{@link Maps.PublicSpace#getBorderedfly <em>Borderedfly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Borderedfly</em>'.
	 * @see Maps.PublicSpace#getBorderedfly()
	 * @see #getPublicSpace()
	 * @generated
	 */
	EReference getPublicSpace_Borderedfly();

	/**
	 * Returns the meta object for class '{@link Maps.Garden <em>Garden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Garden</em>'.
	 * @see Maps.Garden
	 * @generated
	 */
	EClass getGarden();

	/**
	 * Returns the meta object for class '{@link Maps.Square <em>Square</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Square</em>'.
	 * @see Maps.Square
	 * @generated
	 */
	EClass getSquare();

	/**
	 * Returns the meta object for class '{@link Maps.Road <em>Road</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Road</em>'.
	 * @see Maps.Road
	 * @generated
	 */
	EClass getRoad();

	/**
	 * Returns the meta object for the reference list '{@link Maps.Road#getMeet <em>Meet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Meet</em>'.
	 * @see Maps.Road#getMeet()
	 * @see #getRoad()
	 * @generated
	 */
	EReference getRoad_Meet();

	/**
	 * Returns the meta object for the reference list '{@link Maps.Road#getBorder <em>Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Border</em>'.
	 * @see Maps.Road#getBorder()
	 * @see #getRoad()
	 * @generated
	 */
	EReference getRoad_Border();

	/**
	 * Returns the meta object for the attribute '{@link Maps.Road#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Maps.Road#getName()
	 * @see #getRoad()
	 * @generated
	 */
	EAttribute getRoad_Name();

	/**
	 * Returns the meta object for the attribute '{@link Maps.Road#getLenght <em>Lenght</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lenght</em>'.
	 * @see Maps.Road#getLenght()
	 * @see #getRoad()
	 * @generated
	 */
	EAttribute getRoad_Lenght();

	/**
	 * Returns the meta object for class '{@link Maps.Street <em>Street</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Street</em>'.
	 * @see Maps.Street
	 * @generated
	 */
	EClass getStreet();

	/**
	 * Returns the meta object for class '{@link Maps.Pedestrian <em>Pedestrian</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pedestrian</em>'.
	 * @see Maps.Pedestrian
	 * @generated
	 */
	EClass getPedestrian();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MapsFactory getMapsFactory();

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
		 * The meta object literal for the '{@link Maps.impl.MapImpl <em>Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Maps.impl.MapImpl
		 * @see Maps.impl.MapsPackageImpl#getMap()
		 * @generated
		 */
		EClass MAP = eINSTANCE.getMap();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAP__NAME = eINSTANCE.getMap_Name();

		/**
		 * The meta object literal for the '<em><b>Spaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP__SPACES = eINSTANCE.getMap_Spaces();

		/**
		 * The meta object literal for the '<em><b>Roads</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP__ROADS = eINSTANCE.getMap_Roads();

		/**
		 * The meta object literal for the '{@link Maps.impl.PublicSpaceImpl <em>Public Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Maps.impl.PublicSpaceImpl
		 * @see Maps.impl.MapsPackageImpl#getPublicSpace()
		 * @generated
		 */
		EClass PUBLIC_SPACE = eINSTANCE.getPublicSpace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLIC_SPACE__NAME = eINSTANCE.getPublicSpace_Name();

		/**
		 * The meta object literal for the '<em><b>Borderedfly</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PUBLIC_SPACE__BORDEREDFLY = eINSTANCE.getPublicSpace_Borderedfly();

		/**
		 * The meta object literal for the '{@link Maps.impl.GardenImpl <em>Garden</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Maps.impl.GardenImpl
		 * @see Maps.impl.MapsPackageImpl#getGarden()
		 * @generated
		 */
		EClass GARDEN = eINSTANCE.getGarden();

		/**
		 * The meta object literal for the '{@link Maps.impl.SquareImpl <em>Square</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Maps.impl.SquareImpl
		 * @see Maps.impl.MapsPackageImpl#getSquare()
		 * @generated
		 */
		EClass SQUARE = eINSTANCE.getSquare();

		/**
		 * The meta object literal for the '{@link Maps.impl.RoadImpl <em>Road</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Maps.impl.RoadImpl
		 * @see Maps.impl.MapsPackageImpl#getRoad()
		 * @generated
		 */
		EClass ROAD = eINSTANCE.getRoad();

		/**
		 * The meta object literal for the '<em><b>Meet</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROAD__MEET = eINSTANCE.getRoad_Meet();

		/**
		 * The meta object literal for the '<em><b>Border</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROAD__BORDER = eINSTANCE.getRoad_Border();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROAD__NAME = eINSTANCE.getRoad_Name();

		/**
		 * The meta object literal for the '<em><b>Lenght</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROAD__LENGHT = eINSTANCE.getRoad_Lenght();

		/**
		 * The meta object literal for the '{@link Maps.impl.StreetImpl <em>Street</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Maps.impl.StreetImpl
		 * @see Maps.impl.MapsPackageImpl#getStreet()
		 * @generated
		 */
		EClass STREET = eINSTANCE.getStreet();

		/**
		 * The meta object literal for the '{@link Maps.impl.PedestrianImpl <em>Pedestrian</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Maps.impl.PedestrianImpl
		 * @see Maps.impl.MapsPackageImpl#getPedestrian()
		 * @generated
		 */
		EClass PEDESTRIAN = eINSTANCE.getPedestrian();

	}

} //MapsPackage
