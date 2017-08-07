import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.RoadNetwork
import traffic_simulation.Vehicle

class VehicleTest {

    @Test

    fun doesDelayingVehicleWork(){
        val trafficJam : Boolean =true
        val BMW : Vehicle = Vehicle(1 ,true)
        BMW.delayed=false
        BMW.gettingDelayed()

        assertEquals(trafficJam,BMW.delayed)
    }
}