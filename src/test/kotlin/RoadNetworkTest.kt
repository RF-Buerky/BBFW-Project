import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.RoadNetwork
import traffic_simulation.Vehicle

class RoadNetworkTest {

    @Test
    fun doesCalculateDemandWork() {
        val road = RoadNetwork(20)

        val BMW     : Vehicle = Vehicle(1 , true)
        val AUDI    : Vehicle = Vehicle(1 , true)
        val VOLVO   : Vehicle = Vehicle(1 , true)

        val cars : List<Vehicle> = listOf(BMW,AUDI,VOLVO)

        val calculated = road.calculateDemand(cars)

        assertEquals(3,calculated)
    }

    @Test
    fun doesCheckForTrafficJamWorkForCapacityBiggerThanDemand() {
        val road = RoadNetwork(20)

        val trafficJam : Boolean = road.checkForTrafficJam(3)
        assertEquals(false,trafficJam)
    }

    @Test
    fun doesCheckForTrafficJamWorkForCapacitySmallerThanDemand() {
        val road = RoadNetwork(2)

        val trafficJam : Boolean = road.checkForTrafficJam(3)
        assertEquals(true,trafficJam)
    }

    @Test
    fun doesCheckForTrafficJamWorkForCapacityEqualToDemand() {
        val road = RoadNetwork(3)

        val trafficJam : Boolean = road.checkForTrafficJam(3)
        assertEquals(false,trafficJam)
    }

}