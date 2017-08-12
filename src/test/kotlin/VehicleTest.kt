
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import traffic_simulation.*

class VehicleTest {

    // Tests for the different capacity Factors
    // __________________________________________________________________________________________

    @Test
    fun capacityFactor_Car_capacityFactorIsCorrect(){
        val testCar : Car = Car (5 , mutableListOf(1,2))

        val result : Int = testCar.capacityFactor
        assertEquals ( 10 , result)
    }

    @Test
    fun capacityFactor_Tram_capacityFactorIsCorrect(){
        val testTram : Tram = Tram (5 , mutableListOf(1,2))

        val result : Int = testTram.capacityFactor
        assertEquals ( 50 , result)
    }

    @Test
    fun capacityFactor_Truck_capacityFactorIsCorrect(){
        val testTruck : Truck = Truck (5 , mutableListOf(1,2))

        val result : Int = testTruck.capacityFactor
        assertEquals ( 30 , result)
    }

    @Test
    fun capacityFactor_Bike_capacityFactorIsCorrect(){
        val testBike : Bike = Bike (5 , mutableListOf(1,2))

        val result : Int = testBike.capacityFactor
        assertEquals ( 1 , result)
    }

    // Tests for the default value of delay in every sub-class of interface Vehicle
    // __________________________________________________________________________________________

    @Test
    fun delay_delayOfNewCar_delayIsZero(){
        val testCar : Car = Car (5 , mutableListOf(1,2))

        val result : Int = testCar.delay
        assertEquals ( 0 , result)
    }

    @Test
    fun delay_delayOfNewTram_delayIsZero(){
        val testTram : Tram = Tram (5 , mutableListOf(1,2))

        val result : Int = testTram.delay
        assertEquals ( 0 , result)
    }

    @Test
    fun delay_delayOfNewTruck_delayIsZero(){
        val testTruck : Truck = Truck (5 , mutableListOf(1,2))

        val result : Int = testTruck.delay
        assertEquals ( 0 , result)
    }

    @Test
    fun delay_delayOfNewBike_delayIsZero(){
        val testBike : Bike = Bike (5 , mutableListOf(1,2))

        val result : Int = testBike.delay
        assertEquals ( 0 , result)
    }

    // Tests if the lists of Vehicles sub-classes are empty at the beginning
    // __________________________________________________________________________________________

    @Test
    fun delay_listsOfNewCar_listsAreEmpty(){
        val testCar : Car = Car (5 , mutableListOf(1,2))

        val list1 : MutableList<Int> = testCar.gotNewDelayInHours
        val list2 : MutableList<Int> = testCar.droveWithoutNewDelayInHours

        val result1 : Boolean = list1.isEmpty()
        assertEquals ( true , result1)
        val result2 : Boolean = list2.isEmpty()
        assertEquals ( true , result2)
    }

    @Test
    fun delay_listsOfNewTram_listsAreEmpty(){
        val testTram : Tram = Tram (5 , mutableListOf(1,2))

        val list1 : MutableList<Int> = testTram.gotNewDelayInHours
        val list2 : MutableList<Int> = testTram.droveWithoutNewDelayInHours

        val result1 : Boolean = list1.isEmpty()
        assertEquals ( true , result1)
        val result2 : Boolean = list2.isEmpty()
        assertEquals ( true , result2)
    }

    @Test
    fun delay_listsOfNewTruck_listsAreEmpty(){
        val testTruck : Truck = Truck (5 , mutableListOf(1,2))

        val list1 : MutableList<Int> = testTruck.gotNewDelayInHours
        val list2 : MutableList<Int> = testTruck.droveWithoutNewDelayInHours

        val result1 : Boolean = list1.isEmpty()
        assertEquals ( true , result1)
        val result2 : Boolean = list2.isEmpty()
        assertEquals ( true , result2)
    }

    @Test
    fun delay_listsOfNewBike_listsAreEmpty(){
        val testBike : Bike = Bike (5 , mutableListOf(1,2))

        val list1 : MutableList<Int> = testBike.gotNewDelayInHours
        val list2 : MutableList<Int> = testBike.droveWithoutNewDelayInHours

        val result1 : Boolean = list1.isEmpty()
        assertEquals ( true , result1)
        val result2 : Boolean = list2.isEmpty()
        assertEquals ( true , result2)
    }

    // Tests if the function getClass works correctly for every Vehicle
    // __________________________________________________________________________________________

    @Test
    fun getClass_getClassOfCar_givesStringCar(){
        val testCar : Car = Car (5 , mutableListOf(1,2))

        val result : String = testCar.getClass()
        assertEquals ( "Car" , result)
    }

    @Test
    fun getClass_getClassOfTram_givesStringTram(){
        val testTram : Tram = Tram (5 , mutableListOf(1,2))

        val result : String = testTram.getClass()
        assertEquals ( "Tram" , result)
    }

    @Test
    fun getClass_getClassOfTruck_givesStringTruck(){
        val testTruck : Truck = Truck (5 , mutableListOf(1,2))

        val result : String = testTruck.getClass()
        assertEquals ( "Truck" , result)
    }

    @Test
    fun getClass_getClassOfBike_givesStringBike(){
        val testBike : Bike = Bike (5 , mutableListOf(1,2))

        val result : String = testBike.getClass()
        assertEquals ( "Bike" , result)
    }

    // Tests if the function getID works correctly for every Vehicle
    // __________________________________________________________________________________________

    @Test
    fun getID_getIDOFCar_givesIDCorrectly(){
        val testCar1 : Car = Car (5 , mutableListOf(1,2))
        val testCar2 : Car = Car (0 , mutableListOf(1,24))

        val result1 : Int = testCar1.getID()
        val result2 : Int = testCar2.getID()

        assertEquals ( 5 , result1)
        assertEquals ( 0 , result2)
    }

    @Test
    fun getID_getIDOFTram_givesIDCorrectly(){
        val testTram1 : Tram = Tram (5 , mutableListOf(1,2))
        val testTram2 : Tram = Tram (0 , mutableListOf(1,24))

        val result1 : Int = testTram1.getID()
        val result2 : Int = testTram2.getID()

        assertEquals ( 5 , result1)
        assertEquals ( 0 , result2)
    }

    @Test
    fun getID_getIDOFTruck_givesIDCorrectly(){
        val testTruck1 : Truck = Truck (5 , mutableListOf(1,2))
        val testTruck2 : Tram = Tram (0 , mutableListOf(1,24))

        val result1 : Int = testTruck1.getID()
        val result2 : Int = testTruck2.getID()

        assertEquals ( 5 , result1)
        assertEquals ( 0 , result2)
    }

    @Test
    fun getID_getIDOFBike_givesIDCorrectly(){
        val testBike1 : Bike = Bike (5 , mutableListOf(1,2))
        val testBike2 : Tram = Tram (0 , mutableListOf(1,24))

        val result1 : Int = testBike1.getID()
        val result2 : Int = testBike2.getID()

        assertEquals ( 5 , result1)
        assertEquals ( 0 , result2)
    }

    // Tests if the function vehicleWantsToDriveAt(timestep) returns correct Boolean
    // __________________________________________________________________________________________

    @Test
    fun vehicleWantsToDriveAt_CarIsDelayedOrWantsToDrive_CarWantsToDrive(){
        val testCar1 : Car = Car (5 , mutableListOf(1,2,6))
        val testCar2 : Car = Car (0 , mutableListOf(5,24))
        testCar2.delay = 2

        val result1 : Boolean = testCar1.vehicleWantsToDriveAt(6)
        val result2 : Boolean = testCar2.vehicleWantsToDriveAt(6)

        assertEquals ( true , result1)
        assertEquals ( true , result2)
    }

    @Test
    fun vehicleWantsToDriveAt_TramIsDelayedOrWantsToDrive_TramWantsToDrive(){
        val testTram1 : Tram = Tram (5 , mutableListOf(1,2,6))
        val testTram2 : Tram = Tram (0 , mutableListOf(5,24))
        testTram2.delay = 2

        val result1 : Boolean = testTram1.vehicleWantsToDriveAt(6)
        val result2 : Boolean = testTram2.vehicleWantsToDriveAt(6)

        assertEquals ( true , result1)
        assertEquals ( true , result2)
    }

    @Test
    fun vehicleWantsToDriveAt_TruckIsDelayedOrWantsToDrive_TramWantsToDrive(){
        val testTram1 : Tram = Tram (5 , mutableListOf(1,2,6))
        val testTram2 : Tram = Tram (0 , mutableListOf(5,24))
        testTram2.delay = 2

        val result1 : Boolean = testTram1.vehicleWantsToDriveAt(6)
        val result2 : Boolean = testTram2.vehicleWantsToDriveAt(6)

        assertEquals ( true , result1)
        assertEquals ( true , result2)
    }

    @Test
    fun vehicleWantsToDriveAt_BikeIsDelayedOrWantsToDrive_BikeWantsToDrive(){
        val testBike1 : Bike = Bike (5 , mutableListOf(1,2,6))
        val testBike2 : Bike = Bike (0 , mutableListOf(5,24))
        testBike2.delay = 2

        val result1 : Boolean = testBike1.vehicleWantsToDriveAt(6)
        val result2 : Boolean = testBike2.vehicleWantsToDriveAt(6)

        assertEquals ( true , result1)
        assertEquals ( true , result2)
    }

    @Test
    fun vehicleWantsToDriveAt_CarmIsNotDelayedOrWantsNotToDrive_CarWantsNotToDrive(){
        val testCar1 : Car = Car (5 , mutableListOf(1,2,6))
        val testCar2 : Car = Car (0 , mutableListOf(5,24))

        val result1 : Boolean = testCar1.vehicleWantsToDriveAt(7)
        val result2 : Boolean = testCar2.vehicleWantsToDriveAt(7)

        assertEquals ( false , result1)
        assertEquals ( false , result2)
    }

    @Test
    fun vehicleWantsToDriveAt_TramIsNotDelayedOrWantsNotToDrive_TramWantsNotToDrive(){
        val testTram1 : Tram = Tram (5 , mutableListOf(1,2,6))
        val testTram2 : Tram = Tram (0 , mutableListOf(5,24))

        val result1 : Boolean = testTram1.vehicleWantsToDriveAt(7)
        val result2 : Boolean = testTram2.vehicleWantsToDriveAt(7)

        assertEquals ( false , result1)
        assertEquals ( false , result2)
    }

    @Test
    fun vehicleWantsToDriveAt_TruckIsNotDelayedOrWantsNotToDrive_TruckWantsNotToDrive(){
        val testTram1 : Tram = Tram (5 , mutableListOf(1,2,6))
        val testTram2 : Tram = Tram (0 , mutableListOf(5,24))

        val result1 : Boolean = testTram1.vehicleWantsToDriveAt(7)
        val result2 : Boolean = testTram2.vehicleWantsToDriveAt(7)

        assertEquals ( false , result1)
        assertEquals ( false , result2)
    }

    @Test
    fun vehicleWantsToDriveAt_BikeIsNotDelayedOrWantsNotToDrive_BikeWantsNotToDrive(){
        val testBike1 : Bike = Bike (5 , mutableListOf(1,2,6))
        val testBike2 : Bike = Bike (0 , mutableListOf(5,24))

        val result1 : Boolean = testBike1.vehicleWantsToDriveAt(7)
        val result2 : Boolean = testBike2.vehicleWantsToDriveAt(7)

        assertEquals ( false , result1)
        assertEquals ( false , result2)
    }


    // Tests if the function getDelayedAtHour works
    // __________________________________________________________________________________________
/*

    @Test
    fun getDelayedAtHour_trafficJamInUnorderedSeveralHours_vehicleGetsOftenDelayedAndOutputIsInOrder() {
        val BMW: Vehicle = Vehicle(1, mutableListOf(1, 2, 3, 4, 5, 6))

        BMW.getDelayedAtHour(1)
        BMW.getDelayedAtHour(5)
        BMW.getDelayedAtHour(3)
        BMW.getDelayedAtHour(4)

        val correctList: MutableList <Int> = mutableListOf(1, 3, 4, 5)
        assertEquals(correctList, BMW.gotNewDelayInHours)
    }
*/

    @Test
    fun defaultOfVehicleIsNotDelayed() {
        val BMW: Vehicle = Vehicle(1, mutableListOf(1, 2, 3, 4, 5, 6))

        val correctList: MutableList <Int> = mutableListOf()

        assertEquals(correctList, BMW.gotNewDelayInHours)
    }

    @Test
    fun delayAndDrive_mixedDelaysAndDriveRequirements_driveRequirementsCorrectlyReported() {
        val tesla = Vehicle(1, mutableListOf(1, 5))
        assertTrue(tesla.vehicleWantsToDriveAt(1))

        tesla.getDelayedAtHour(1)
        // couldn't drive at 1, so wants to drive at 2
        assertTrue(tesla.vehicleWantsToDriveAt(2))

        tesla.getDelayedAtHour(2)
        // again, couldn't drive,  so wants to drive at 3
        assertTrue(tesla.vehicleWantsToDriveAt(3))

        tesla.driveAtHour(3)
        // finally time to drive; this resolves delay from hour 1, so no more driving
        assertFalse(tesla.vehicleWantsToDriveAt(4))

        // wants to drive at hour 5 as per original requirements
        assertTrue(tesla.vehicleWantsToDriveAt(5))
    }

    @Test
    fun delayAndDrive_mixedDelaysAndDriveRequirements_driveRequirementsCarriedAcross() {
        val tesla = Vehicle(1, mutableListOf(1, 2, 4))
        assertTrue(tesla.vehicleWantsToDriveAt(1))

        tesla.getDelayedAtHour(1)
        // couldn't drive at 1 _and_ wanted to drive at 2 anyways
        assertTrue(tesla.vehicleWantsToDriveAt(2))

        tesla.getDelayedAtHour(2)
        // couldn't drive at 1 & 2, so definitely wants to drive at 3
        assertTrue(tesla.vehicleWantsToDriveAt(3))

        tesla.driveAtHour(3)
        // still one hour delayed _and_ wants to drive at 4 anyways
        assertTrue(tesla.vehicleWantsToDriveAt(4))

        tesla.driveAtHour(4)
        // driving at 4 accomplished but still one hour delayed, so wants to drive again
        assertTrue(tesla.vehicleWantsToDriveAt(5))

        tesla.driveAtHour(5)
        // finally all done
        assertFalse(tesla.vehicleWantsToDriveAt(6))
    }
}
