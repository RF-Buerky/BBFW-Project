/*
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import traffic_simulation.Vehicle

class VehicleTest {

    @Test
    fun getDelayedAtHour_trafficJamInOneHour_vehicleGetDelayed() {
        val BMW: Vehicle = Vehicle(1, mutableListOf(1, 2, 3))

        BMW.getDelayedAtHour(1)

        val correctList: MutableList <Int> = mutableListOf(1)
        assertEquals(correctList, BMW.gotNewDelayInHours)
    }

    @Test
    fun getDelayedAtHour_trafficJamInSeveralHours_vehicleGetsOftenDelayed() {
        val BMW: Vehicle = Vehicle(1, mutableListOf(1, 2, 3, 4, 5, 6))

        BMW.getDelayedAtHour(1)
        BMW.getDelayedAtHour(3)
        BMW.getDelayedAtHour(4)
        BMW.getDelayedAtHour(5)

        val correctList: MutableList <Int> = mutableListOf(1, 3, 4, 5)
        assertEquals(correctList, BMW.gotNewDelayInHours)
    }

    @Test
    fun getDelayedAtHour_trafficJamInCriticalHour24_vehicleGetsDelayed() {
        val BMW: Vehicle = Vehicle(1, mutableListOf(23, 24))

        BMW.getDelayedAtHour(24)

        val correctList: MutableList <Int> = mutableListOf(24)
        assertEquals(correctList, BMW.gotNewDelayInHours)
    }

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
*/
