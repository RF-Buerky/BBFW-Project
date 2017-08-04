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
    fun doesCheckForTrafficJamWork1() {//Capacity bigger than demand
        val road = RoadNetwork(20.0)

        val BMW     : Vehicle = Vehicle(1.0)
        val AUDI    : Vehicle = Vehicle(1.0)
        val VOLVO   : Vehicle = Vehicle(1.0)

        val cars : List<Vehicle> = listOf(BMW,AUDI,VOLVO)
        val calculated = road.calculateDemand(cars)
        val trafficJam : Boolean = road.checkForTrafficJam(calculated)
        assertEquals(false,trafficJam)
    }

    @Test
    fun doesCheckForTrafficJamWork2() {//Capacity smaller than demand
        val road = RoadNetwork(2.0)

        val BMW     : Vehicle = Vehicle(1.0)
        val AUDI    : Vehicle = Vehicle(1.0)
        val VOLVO   : Vehicle = Vehicle(1.0)

        val cars : List<Vehicle> = listOf(BMW,AUDI,VOLVO)
        val calculated = road.calculateDemand(cars)
        val trafficJam : Boolean = road.checkForTrafficJam(calculated)
        assertEquals(true,trafficJam)
    }

    @Test
    fun doesCheckForTrafficJamWork3() {//Capacity equal to demand
        val road = RoadNetwork(3.0)

        val BMW     : Vehicle = Vehicle(1.0)
        val AUDI    : Vehicle = Vehicle(1.0)
        val VOLVO   : Vehicle = Vehicle(1.0)

        val cars : List<Vehicle> = listOf(BMW,AUDI,VOLVO)
        val calculated = road.calculateDemand(cars)
        val trafficJam : Boolean = road.checkForTrafficJam(calculated)
        assertEquals(false,trafficJam)
    }

}