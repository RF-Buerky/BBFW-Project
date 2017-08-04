import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.RoadNetwork
import traffic_simulation.Vehicle

class RoadNetworkTest {

    @Test
    fun doesCalculateDemandWork() {
        val road = RoadNetwork(20.0)

        val BMW     : Vehicle = Vehicle(1.0)
        val AUDI    : Vehicle = Vehicle(1.0)
        val VOLVO   : Vehicle = Vehicle(1.0)

        val cars : List<Vehicle> = listOf(BMW,AUDI,VOLVO)

        val calculated = road.calculateDemand(cars)

        assertEquals(3.0,calculated,0.001)
    }

    @Test
    fun doesCheckForTrafficJamWorkForCapacityBiggerThanDemand() {
        val road = RoadNetwork(20.0)

        val trafficJam : Boolean = road.checkForTrafficJam(3.0)
        assertEquals(false,trafficJam)
    }

    @Test
    fun doesCheckForTrafficJamWorkForCapacitySmallerThanDemand() {
        val road = RoadNetwork(2.0)

        val trafficJam : Boolean = road.checkForTrafficJam(3.0)
        assertEquals(true,trafficJam)
    }

    @Test
    fun doesCheckForTrafficJamWorkForCapacityEqualToDemand() {
        val road = RoadNetwork(3.0)

        val trafficJam : Boolean = road.checkForTrafficJam(3.0)
        assertEquals(false,trafficJam)
    }

}