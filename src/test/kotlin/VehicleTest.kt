import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.Vehicle

class VehicleTest {

    @Test
    fun gettingDelayed_trafficJamInOneHour_vehicleGetDelayed() {
        val BMW: Vehicle = Vehicle(1, mutableListOf(1,2,3))

        BMW.gettingDelayedInSpecialHour(1)

        val correctList : MutableList <Int> = mutableListOf(1)
        assertEquals(correctList, BMW.delayedInHours)
    }

    @Test
    fun gettingDelayed_trafficJamInSeveralHours_vehicleGetsOftenDelayed() {
        val BMW: Vehicle = Vehicle(1, mutableListOf(1,2,3,4,5,6))

        BMW.gettingDelayedInSpecialHour(1)
        BMW.gettingDelayedInSpecialHour(3)
        BMW.gettingDelayedInSpecialHour(4)
        BMW.gettingDelayedInSpecialHour(5)

        val correctList : MutableList <Int> = mutableListOf(1,3,4,5)
        assertEquals(correctList, BMW.delayedInHours)
    }

    @Test
    fun gettingDelayed_trafficJamInCriticalHour24_vehicleGetsDelayed() {
        val BMW: Vehicle = Vehicle(1, mutableListOf(23,24))

        BMW.gettingDelayedInSpecialHour(24)

        val correctList : MutableList <Int> = mutableListOf(24)
        assertEquals(correctList, BMW.delayedInHours)
    }

    @Test
    fun gettingDelayed_trafficJamInUnorderedSeveralHours_vehicleGetsOftenDelayedAndOutputIsInOrder() {
        val BMW: Vehicle = Vehicle(1, mutableListOf(1,2,3,4,5,6))

        BMW.gettingDelayedInSpecialHour(1)
        BMW.gettingDelayedInSpecialHour(5)
        BMW.gettingDelayedInSpecialHour(3)
        BMW.gettingDelayedInSpecialHour(4)

        val correctList : MutableList <Int> = mutableListOf(1,3,4,5)
        assertEquals(correctList, BMW.delayedInHours)
    }

    @Test
    fun defaultOfVehicleIsNotDelayed() {
        val BMW: Vehicle = Vehicle(1, mutableListOf(1,2,3,4,5,6))

        val correctList : MutableList <Int> = mutableListOf()

        assertEquals(correctList, BMW.delayedInHours)
    }
}
