import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.RoadNetwork
import traffic_simulation.Vehicle

class VehicleTest {

    @Test

    fun doesDelayingVehicleWork() {
        val BMW: Vehicle = Vehicle(1, true)
        BMW.delayed = false
        BMW.gettingDelayed()

        assertEquals(true, BMW.delayed)
    }

    @Test
    fun defaultOfVehicleIsNotDelayed() {
        val BMW: Vehicle = Vehicle(1, true)

        assertEquals(false, BMW.delayed)
    }
}