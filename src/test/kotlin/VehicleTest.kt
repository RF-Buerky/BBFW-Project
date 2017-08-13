import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import traffic_simulation.*

class VehicleTest {

    // Tests for the different capacity Factors
    // ____________________________________________________________________________________________________
    // ____________________________________________________________________________________________________

    @Test
    fun capacityFactor_Car_capacityFactorIsCorrect() {
        val testCar: Car = Car(5, mutableListOf(1, 2))

        val result: Int = testCar.capacityFactor
        assertEquals(10, result)
    }

    @Test
    fun capacityFactor_Tram_capacityFactorIsCorrect() {
        val testTram: Tram = Tram(5, mutableListOf(1, 2))

        val result: Int = testTram.capacityFactor
        assertEquals(50, result)
    }

    @Test
    fun capacityFactor_Truck_capacityFactorIsCorrect() {
        val testTruck: Truck = Truck(5, mutableListOf(1, 2))

        val result: Int = testTruck.capacityFactor
        assertEquals(30, result)
    }

    @Test
    fun capacityFactor_Bike_capacityFactorIsCorrect() {
        val testBike: Bike = Bike(5, mutableListOf(1, 2))

        val result: Int = testBike.capacityFactor
        assertEquals(1, result)
    }

    // Tests for the default value of delay in every sub-class of interface Vehicle
    // ____________________________________________________________________________________________________
    // ____________________________________________________________________________________________________

    @Test
    fun delay_delayOfNewCar_delayIsZero() {
        val testCar: Car = Car(5, mutableListOf(1, 2))

        val result: Int = testCar.lagTillDestination
        assertEquals(0, result)
    }

    @Test
    fun delay_delayOfNewTram_delayIsZero() {
        val testTram: Tram = Tram(5, mutableListOf(1, 2))

        val result: Int = testTram.lagTillDestination
        assertEquals(0, result)
    }

    @Test
    fun delay_delayOfNewTruck_delayIsZero() {
        val testTruck: Truck = Truck(5, mutableListOf(1, 2))

        val result: Int = testTruck.lagTillDestination
        assertEquals(0, result)
    }

    @Test
    fun delay_delayOfNewBike_delayIsZero() {
        val testBike: Bike = Bike(5, mutableListOf(1, 2))

        val result: Int = testBike.lagTillDestination
        assertEquals(0, result)
    }

    // Tests if the lists of Vehicles sub-classes are empty at the beginning
    // ____________________________________________________________________________________________________
    // ____________________________________________________________________________________________________

    @Test
    fun delay_listsOfNewCar_listsAreEmpty() {
        val testCar: Car = Car(5, mutableListOf(1, 2))

        val list1: MutableList<Int> = testCar.gotNewDelayInHours
        val list2: MutableList<Int> = testCar.droveWithoutNewDelayInHours

        val result1: Boolean = list1.isEmpty()
        assertEquals(true, result1)
        val result2: Boolean = list2.isEmpty()
        assertEquals(true, result2)
    }

    @Test
    fun delay_listsOfNewTram_listsAreEmpty() {
        val testTram: Tram = Tram(5, mutableListOf(1, 2))

        val list1: MutableList<Int> = testTram.gotNewDelayInHours
        val list2: MutableList<Int> = testTram.droveWithoutNewDelayInHours

        val result1: Boolean = list1.isEmpty()
        assertEquals(true, result1)
        val result2: Boolean = list2.isEmpty()
        assertEquals(true, result2)
    }

    @Test
    fun delay_listsOfNewTruck_listsAreEmpty() {
        val testTruck: Truck = Truck(5, mutableListOf(1, 2))

        val list1: MutableList<Int> = testTruck.gotNewDelayInHours
        val list2: MutableList<Int> = testTruck.droveWithoutNewDelayInHours

        val result1: Boolean = list1.isEmpty()
        assertEquals(true, result1)
        val result2: Boolean = list2.isEmpty()
        assertEquals(true, result2)
    }

    @Test
    fun delay_listsOfNewBike_listsAreEmpty() {
        val testBike: Bike = Bike(5, mutableListOf(1, 2))

        val list1: MutableList<Int> = testBike.gotNewDelayInHours
        val list2: MutableList<Int> = testBike.droveWithoutNewDelayInHours

        val result1: Boolean = list1.isEmpty()
        assertEquals(true, result1)
        val result2: Boolean = list2.isEmpty()
        assertEquals(true, result2)
    }

    // Tests if the function getClass works correctly for every Vehicle
    // ____________________________________________________________________________________________________
    // ____________________________________________________________________________________________________

    @Test
    fun getClass_getClassOfCar_givesStringCar() {
        val testCar: Car = Car(5, mutableListOf(1, 2))

        val result: String = testCar.getClass()
        assertEquals("Car", result)
    }

    @Test
    fun getClass_getClassOfTram_givesStringTram() {
        val testTram: Tram = Tram(5, mutableListOf(1, 2))

        val result: String = testTram.getClass()
        assertEquals("Tram", result)
    }

    @Test
    fun getClass_getClassOfTruck_givesStringTruck() {
        val testTruck: Truck = Truck(5, mutableListOf(1, 2))

        val result: String = testTruck.getClass()
        assertEquals("Truck", result)
    }

    @Test
    fun getClass_getClassOfBike_givesStringBike() {
        val testBike: Bike = Bike(5, mutableListOf(1, 2))

        val result: String = testBike.getClass()
        assertEquals("Bike", result)
    }

    // Tests if the function getID works correctly for every Vehicle
    // ____________________________________________________________________________________________________
    // ____________________________________________________________________________________________________

    @Test
    fun getID_getIDOFCar_givesIDCorrectly() {
        val testCar1: Car = Car(5, mutableListOf(1, 2))
        val testCar2: Car = Car(0, mutableListOf(1, 24))

        val result1: Int = testCar1.getID()
        val result2: Int = testCar2.getID()

        assertEquals(5, result1)
        assertEquals(0, result2)
    }

    @Test
    fun getID_getIDOFTram_givesIDCorrectly() {
        val testTram1: Tram = Tram(5, mutableListOf(1, 2))
        val testTram2: Tram = Tram(0, mutableListOf(1, 24))

        val result1: Int = testTram1.getID()
        val result2: Int = testTram2.getID()

        assertEquals(5, result1)
        assertEquals(0, result2)
    }

    @Test
    fun getID_getIDOFTruck_givesIDCorrectly() {
        val testTruck1: Truck = Truck(5, mutableListOf(1, 2))
        val testTruck2: Tram = Tram(0, mutableListOf(1, 24))

        val result1: Int = testTruck1.getID()
        val result2: Int = testTruck2.getID()

        assertEquals(5, result1)
        assertEquals(0, result2)
    }

    @Test
    fun getID_getIDOFBike_givesIDCorrectly() {
        val testBike1: Bike = Bike(5, mutableListOf(1, 2))
        val testBike2: Tram = Tram(0, mutableListOf(1, 24))

        val result1: Int = testBike1.getID()
        val result2: Int = testBike2.getID()

        assertEquals(5, result1)
        assertEquals(0, result2)
    }

    // Tests if the function vehicleWantsToDriveAt(timestep) returns correct Boolean
    // ____________________________________________________________________________________________________
    // ____________________________________________________________________________________________________

    @Test
    fun vehicleWantsToDriveAt_CarIsDelayedOrWantsToDrive_CarWantsToDrive() {
        val testCar1: Car = Car(5, mutableListOf(1, 2, 6))
        val testCar2: Car = Car(0, mutableListOf(5, 24))
        testCar2.lagTillDestination = 2

        val result1: Boolean = testCar1.vehicleWantsToDriveAt(6)
        val result2: Boolean = testCar2.vehicleWantsToDriveAt(6)

        assertEquals(true, result1)
        assertEquals(true, result2)
    }

    @Test
    fun vehicleWantsToDriveAt_TramIsDelayedOrWantsToDrive_TramWantsToDrive() {
        val testTram1: Tram = Tram(5, mutableListOf(1, 2, 6))
        val testTram2: Tram = Tram(0, mutableListOf(5, 24))
        testTram2.lagTillDestination = 2

        val result1: Boolean = testTram1.vehicleWantsToDriveAt(6)
        val result2: Boolean = testTram2.vehicleWantsToDriveAt(6)

        assertEquals(true, result1)
        assertEquals(true, result2)
    }

    @Test
    fun vehicleWantsToDriveAt_TruckIsDelayedOrWantsToDrive_TramWantsToDrive() {
        val testTram1: Tram = Tram(5, mutableListOf(1, 2, 6))
        val testTram2: Tram = Tram(0, mutableListOf(5, 24))
        testTram2.lagTillDestination = 2

        val result1: Boolean = testTram1.vehicleWantsToDriveAt(6)
        val result2: Boolean = testTram2.vehicleWantsToDriveAt(6)

        assertEquals(true, result1)
        assertEquals(true, result2)
    }

    @Test
    fun vehicleWantsToDriveAt_BikeIsDelayedOrWantsToDrive_BikeWantsToDrive() {
        val testBike1: Bike = Bike(5, mutableListOf(1, 2, 6))
        val testBike2: Bike = Bike(0, mutableListOf(5, 24))
        testBike2.lagTillDestination = 2

        val result1: Boolean = testBike1.vehicleWantsToDriveAt(6)
        val result2: Boolean = testBike2.vehicleWantsToDriveAt(6)

        assertEquals(true, result1)
        assertEquals(true, result2)
    }

    @Test
    fun vehicleWantsToDriveAt_CarmIsNotDelayedOrWantsNotToDrive_CarWantsNotToDrive() {
        val testCar1: Car = Car(5, mutableListOf(1, 2, 6))
        val testCar2: Car = Car(0, mutableListOf(5, 24))

        val result1: Boolean = testCar1.vehicleWantsToDriveAt(7)
        val result2: Boolean = testCar2.vehicleWantsToDriveAt(7)

        assertEquals(false, result1)
        assertEquals(false, result2)
    }

    @Test
    fun vehicleWantsToDriveAt_TramIsNotDelayedOrWantsNotToDrive_TramWantsNotToDrive() {
        val testTram1: Tram = Tram(5, mutableListOf(1, 2, 6))
        val testTram2: Tram = Tram(0, mutableListOf(5, 24))

        val result1: Boolean = testTram1.vehicleWantsToDriveAt(7)
        val result2: Boolean = testTram2.vehicleWantsToDriveAt(7)

        assertEquals(false, result1)
        assertEquals(false, result2)
    }

    @Test
    fun vehicleWantsToDriveAt_TruckIsNotDelayedOrWantsNotToDrive_TruckWantsNotToDrive() {
        val testTram1: Tram = Tram(5, mutableListOf(1, 2, 6))
        val testTram2: Tram = Tram(0, mutableListOf(5, 24))

        val result1: Boolean = testTram1.vehicleWantsToDriveAt(7)
        val result2: Boolean = testTram2.vehicleWantsToDriveAt(7)

        assertEquals(false, result1)
        assertEquals(false, result2)
    }

    @Test
    fun vehicleWantsToDriveAt_BikeIsNotDelayedOrWantsNotToDrive_BikeWantsNotToDrive() {
        val testBike1: Bike = Bike(5, mutableListOf(1, 2, 6))
        val testBike2: Bike = Bike(0, mutableListOf(5, 24))

        val result1: Boolean = testBike1.vehicleWantsToDriveAt(7)
        val result2: Boolean = testBike2.vehicleWantsToDriveAt(7)

        assertEquals(false, result1)
        assertEquals(false, result2)
    }


    // Tests if the function getDelayedAtHour works
    // ____________________________________________________________________________________________________
    // ____________________________________________________________________________________________________

    @Test
    fun getDelayedAtHour_vehicleGetsDelayed_newDelayIsAddedToListOfDelays() {
        val testCar = Car(1, mutableListOf(1, 2, 5))
        val testBike = Bike(1, mutableListOf(1, 2, 5))
        val testTruck = Truck(1, mutableListOf(1, 2, 5))
        val testTram = Tram(1, mutableListOf(1, 2, 5))

        val vehicles: List<Vehicle> = listOf(testCar, testBike, testTruck, testTram)

        for (vehicle in vehicles) {

            vehicle.getDelayedAtHour(5)
            val result: Boolean = vehicle.gotNewDelayInHours.contains(5)

            assertEquals(true, result)
        }
    }

    @Test
    fun getDelayedAtHour_vehicleGetsDelayed_NotANewDelayIfTimestepWasNotInWannaDriveList() {
        val testCar = Car(1, mutableListOf(1, 2, 5))
        val testBike = Bike(1, mutableListOf(1, 2, 5))
        val testTruck = Truck(1, mutableListOf(1, 2, 5))
        val testTram = Tram(1, mutableListOf(1, 2, 5))

        val vehicles: List<Vehicle> = listOf(testCar, testBike, testTruck, testTram)

        for (vehicle in vehicles) {

            vehicle.getDelayedAtHour(6)
            val result: Boolean = vehicle.gotNewDelayInHours.contains(6)

            assertEquals(false, result)
        }
    }

    @Test
    fun getDelayedAtHour_vehicleGetsDelayed_lagTillDestinationIncreasesIfTimestepWasInList() {
        val testCar = Car(1, mutableListOf(1, 2, 5, 6))
        val testBike = Bike(1, mutableListOf(1, 2, 5, 6))
        val testTruck = Truck(1, mutableListOf(1, 2, 5, 6))
        val testTram = Tram(1, mutableListOf(1, 2, 5, 6))

        var result1 : Int = testCar.lagTillDestination
        assertEquals (0 , result1)
        testCar.getDelayedAtHour(5)
        var result2 : Int = testCar.lagTillDestination
        assertEquals (1 , result2)
        testCar.getDelayedAtHour(6)
        var result3 : Int = testCar.lagTillDestination
        assertEquals (2 , result3)

        result1 = testBike.lagTillDestination
        assertEquals (0 , result1)
        testBike.getDelayedAtHour(5)
        result2 = testBike.lagTillDestination
        assertEquals (1 , result2)
        testBike.getDelayedAtHour(6)
        result3 = testBike.lagTillDestination
        assertEquals (2 , result3)

        result1 = testTruck.lagTillDestination
        assertEquals (0 , result1)
        testTruck.getDelayedAtHour(5)
        result2 = testTruck.lagTillDestination
        assertEquals (1 , result2)
        testTruck.getDelayedAtHour(6)
        result3 = testTruck.lagTillDestination
        assertEquals (2 , result3)

        result1 = testTram.lagTillDestination
        assertEquals (0 , result1)
        testTram.getDelayedAtHour(5)
        result2 = testTram.lagTillDestination
        assertEquals (1 , result2)
        testTram.getDelayedAtHour(6)
        result3 = testTram.lagTillDestination
        assertEquals (2 , result3)

    }

    @Test
    fun getDelayedAtHour_vehicleGetsDelayed_lagTillDestinationDoesNotIncreaseAsTimestepIsNotInWannaDriveList() {
        val testCar = Car(1, mutableListOf(1, 2, 5, 6))
        val testBike = Bike(1, mutableListOf(1, 2, 5, 6))
        val testTruck = Truck(1, mutableListOf(1, 2, 5, 6))
        val testTram = Tram(1, mutableListOf(1, 2, 5, 6))

        var result1 : Int = testCar.lagTillDestination
        assertEquals (0 , result1)
        testCar.getDelayedAtHour(8)
        var result2 : Int = testCar.lagTillDestination
        assertEquals (0 , result2)
        testCar.getDelayedAtHour(9)
        var result3 : Int = testCar.lagTillDestination
        assertEquals (0 , result3)

        result1 = testBike.lagTillDestination
        assertEquals (0 , result1)
        testBike.getDelayedAtHour(8)
        result2 = testBike.lagTillDestination
        assertEquals (0 , result2)
        testBike.getDelayedAtHour(9)
        result3 = testBike.lagTillDestination
        assertEquals (0 , result3)

        result1 = testTruck.lagTillDestination
        assertEquals (0 , result1)
        testTruck.getDelayedAtHour(8)
        result2 = testTruck.lagTillDestination
        assertEquals (0 , result2)
        testTruck.getDelayedAtHour(9)
        result3 = testTruck.lagTillDestination
        assertEquals (0 , result3)

        result1 = testTram.lagTillDestination
        assertEquals (0 , result1)
        testTram.getDelayedAtHour(8)
        result2 = testTram.lagTillDestination
        assertEquals (0 , result2)
        testTram.getDelayedAtHour(9)
        result3 = testTram.lagTillDestination
        assertEquals (0 , result3)

    }

    // Tests if the function driveAtHour works
    // ____________________________________________________________________________________________________
    // ____________________________________________________________________________________________________

    @Test
    fun driveAtHour_CarDrivesAtOneHour_drivenHourGetsAddedInListOfDrivesWithoutNewDelay() {
        val testCar: Car = Car(5, mutableListOf(1, 2, 6))

        val result1: Boolean = testCar.droveWithoutNewDelayInHours.isEmpty()

        testCar.driveAtHour(1)
        val result2: Boolean = testCar.droveWithoutNewDelayInHours.contains(1)

        assertEquals(true, result1)
        assertEquals(true, result2)
    }

    @Test
    fun driveAtHour_VehiclesDriveAtOneHour_drivenHourGetsAddedInListOfDrivesWithoutNewDelay() {
        val testCar = Car(1, mutableListOf(1, 2, 5))
        val testBike = Bike(1, mutableListOf(1, 2, 5))
        val testTruck = Truck(1, mutableListOf(1, 2, 5))
        val testTram = Tram(1, mutableListOf(1, 2, 5))

        val vehicles: List<Vehicle> = listOf(testCar, testBike, testTruck, testTram)

        for (vehicle in vehicles) {

            val result1: Boolean = vehicle.droveWithoutNewDelayInHours.isEmpty()

            vehicle.driveAtHour(1)
            val result2: Boolean = vehicle.droveWithoutNewDelayInHours.contains(1)

            assertEquals(true, result1)
            assertEquals(true, result2)
        }
    }

    @Test
    fun driveAtHour_CarDriveAtOneHourBecauseOfDelay_drivenHourAddedInListOfDrivesWithoutNewDelayAndDelayDecreases() {
        val testCar = Car(1, mutableListOf(1, 2, 5))
        testCar.lagTillDestination = 2

        val result1: Int = testCar.lagTillDestination
        testCar.driveAtHour(7)
        val result2: Boolean = testCar.droveWithoutNewDelayInHours.contains(7)
        val result3: Int = testCar.lagTillDestination

        assertEquals(2, result1)
        assertEquals(true, result2)
        assertEquals(1, result3)
    }

    @Test
    fun driveAtHour_BikeDriveAtOneHourBecauseOfDelay_drivenHourAddedInListOfDrivesWithoutNewDelayAndDelayDecreases() {
        val testBike = Bike(1, mutableListOf(1, 2, 5))
        testBike.lagTillDestination = 2

        val result1: Int = testBike.lagTillDestination
        testBike.driveAtHour(7)
        val result2: Boolean = testBike.droveWithoutNewDelayInHours.contains(7)
        val result3: Int = testBike.lagTillDestination

        assertEquals(2, result1)
        assertEquals(true, result2)
        assertEquals(1, result3)
    }

    @Test
    fun driveAtHour_TruckDriveAtOneHourBecauseOfDelay_drivenHourAddedInListOfDrivesWithoutNewDelayAndDelayDecreases() {
        val testTruck = Truck(1, mutableListOf(1, 2, 5))
        testTruck.lagTillDestination = 2

        val result1: Int = testTruck.lagTillDestination
        testTruck.driveAtHour(7)
        val result2: Boolean = testTruck.droveWithoutNewDelayInHours.contains(7)
        val result3: Int = testTruck.lagTillDestination

        assertEquals(2, result1)
        assertEquals(true, result2)
        assertEquals(1, result3)
    }

    @Test
    fun driveAtHour_TramDriveAtOneHourBecauseOfDelay_drivenHourAddedInListOfDrivesWithoutNewDelayAndDelayDecreases() {
        val testTram = Tram(1, mutableListOf(1, 2, 5))
        testTram.lagTillDestination = 2

        val result1: Int = testTram.lagTillDestination
        testTram.driveAtHour(7)
        val result2: Boolean = testTram.droveWithoutNewDelayInHours.contains(7)
        val result3: Int = testTram.lagTillDestination

        assertEquals(2, result1)
        assertEquals(true, result2)
        assertEquals(1, result3)
    }

    // Tests with mix of getDelayedAtHour and driveAtHour
    // ____________________________________________________________________________________________________
    // ____________________________________________________________________________________________________

    @Test
    fun delayAndDrive_mixedDelaysAndDriveRequirements_driveRequirementsCorrectlyReported() {
        val testCar = Car(1, mutableListOf(1, 5))
        val testBike = Bike(1, mutableListOf(1, 5))
        val testTruck = Truck(1, mutableListOf(1, 5))
        val testTram = Tram(1, mutableListOf(1, 5))

        val vehicles: List<Vehicle> = listOf(testCar, testBike, testTruck, testTram)

        for (vehicle in vehicles) {

            assertTrue(vehicle.vehicleWantsToDriveAt(1))

            vehicle.getDelayedAtHour(1)
            // couldn't drive at 1, so wants to drive at 2
            assertTrue(vehicle.vehicleWantsToDriveAt(2))

            vehicle.getDelayedAtHour(2)
            // again, couldn't drive,  so wants to drive at 3
            assertTrue(vehicle.vehicleWantsToDriveAt(3))

            vehicle.driveAtHour(3)
            // finally time to drive; this resolves delay from hour 1, so no more driving
            assertFalse(vehicle.vehicleWantsToDriveAt(4))

            // wants to drive at hour 5 as per original requirements
            assertTrue(vehicle.vehicleWantsToDriveAt(5))
        }
    }

    @Test
    fun delayAndDrive_mixedDelaysAndDriveRequirements_driveRequirementsCarriedAcross() {
        val testCar = Car(1, mutableListOf(1, 2, 5))
        val testBike = Bike(1, mutableListOf(1, 2, 5))
        val testTruck = Truck(1, mutableListOf(1, 2, 5))
        val testTram = Tram(1, mutableListOf(1, 2, 5))

        val vehicles: List<Vehicle> = listOf(testCar, testBike, testTruck, testTram)

        for (vehicle in vehicles) {
            assertTrue(vehicle.vehicleWantsToDriveAt(1))

            vehicle.getDelayedAtHour(1)
            // couldn't drive at 1 _and_ wanted to drive at 2 anyways
            assertTrue(vehicle.vehicleWantsToDriveAt(2))

            vehicle.getDelayedAtHour(2)
            // couldn't drive at 1 & 2, so definitely wants to drive at 3
            assertTrue(vehicle.vehicleWantsToDriveAt(3))

            vehicle.driveAtHour(3)
            // still one hour delayed _and_ wants to drive at 4 anyways
            assertTrue(vehicle.vehicleWantsToDriveAt(4))

            vehicle.driveAtHour(4)
            // driving at 4 accomplished but still one hour delayed, so wants to drive again
            assertTrue(vehicle.vehicleWantsToDriveAt(5))

            vehicle.driveAtHour(5)
            // finally all done
            assertFalse(vehicle.vehicleWantsToDriveAt(6))
        }
    }

    // Tests for randomDelayByCapacityAndDemand
    // ____________________________________________________________________________________________________
    // ____________________________________________________________________________________________________


}
