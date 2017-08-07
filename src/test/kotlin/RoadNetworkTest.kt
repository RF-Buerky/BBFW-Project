import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.RoadNetwork
import traffic_simulation.Vehicle

class RoadNetworkTest {

    /*@Test
    fun gatherPlansToDriveGathersJustTrueDriveplans (){
        val road = RoadNetwork(20)

        val car1 : Vehicle = Vehicle(1, true)
        val car2 : Vehicle = Vehicle(2, false)
        val car3 : Vehicle = Vehicle(3, true)
        val car4 : Vehicle = Vehicle(4, false)
        val car5 : Vehicle = Vehicle(5, false)
        val car6 : Vehicle = Vehicle(6, false)

        val allVehicles : List<Vehicle> = listOf(car1, car2, car3, car4, car5, car6)

        val gatheredPlansToDrive : List<Vehicle> = road.gatherPlansToDrive(allVehicles)

        var i : Int = 0

        for (plan in gatheredPlansToDrive){
            i = i + 1
        }
        assertEquals(2, i)
    }

    @Test
    fun gatherPlansToDriveGathersJustTrueDriveplans2 (){
        val road = RoadNetwork(20)

        val car1 : Vehicle = Vehicle(1, false)
        val car2 : Vehicle = Vehicle(2, false)
        val car3 : Vehicle = Vehicle(3, false)
        val car4 : Vehicle = Vehicle(4, false)

        val allVehicles : List<Vehicle> = listOf(car1, car2, car3, car4)

        val gatheredPlansToDrive : List<Vehicle> = road.gatherPlansToDrive(allVehicles)

        var i : Int = 0

        for (plan in gatheredPlansToDrive){
            i = i + 1
        }

        assertEquals(0, i)
    }

    @Test
    fun doesCalculateDemandWork() {
        val road = RoadNetwork(20)

        val BMW     : Vehicle = Vehicle(1, true)
        val AUDI    : Vehicle = Vehicle(2, true)
        val VOLVO   : Vehicle = Vehicle(3, true)

        val cars : List<Vehicle> = listOf(BMW, AUDI, VOLVO)

        val calculated = road.calculateDemand(cars)

        assertEquals(3, calculated)
    }

    @Test
    fun calculateDemandCalculatesJustWannaDriveCars() {
        val road = RoadNetwork(20)

        val BMW     : Vehicle = Vehicle(1, true)
        val AUDI    : Vehicle = Vehicle(2, false)
        val VOLVO   : Vehicle = Vehicle(3, false)

        val cars : List<Vehicle> = listOf(BMW, AUDI, VOLVO)

        val calculated = road.calculateDemand(cars)

        assertEquals(1, calculated)
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

    @Test
    fun doesScenarioGiveRightAmountOfOutput(){
        val road = RoadNetwork(10)

        val car1 : Vehicle = Vehicle (1, true)
        val car2 : Vehicle = Vehicle (2, false)
        val car3 : Vehicle = Vehicle (3, true)
        val car4 : Vehicle = Vehicle (4, false)
        val car5 : Vehicle = Vehicle (5, false)
        val car6 : Vehicle = Vehicle (6, false)

        val allVehicles : List<Vehicle> = listOf(car1, car2, car3, car4, car5, car6)

        val output : List<Vehicle> = road.scenario(allVehicles)

        var i : Int = 0

        for (plan in output){
            i = i + 1
        }

        assertEquals(2, i)
    }

    @Test
    fun doesScenarioGiveRightAmountOfDelays(){
        val road = RoadNetwork(3)

        val car1 : Vehicle = Vehicle (1, true)
        val car2 : Vehicle = Vehicle (2, false)
        val car3 : Vehicle = Vehicle (3, true)
        val car4 : Vehicle = Vehicle (4, false)
        val car5 : Vehicle = Vehicle (5, true)
        val car6 : Vehicle = Vehicle (6, true)

        val allVehicles : List<Vehicle> = listOf(car1, car2, car3, car4, car5, car6)

        val output : List<Vehicle> = road.scenario(allVehicles)

        var i : Int = 0

        for (plan in output){
            if(plan.delayed == true){
                i = i + 1
            }
        }

        assertEquals(4, i)
    }

    @Test
    fun doesScenarioGiveRightAmountOfNotDelays(){
        val road = RoadNetwork(5)

        val car1 : Vehicle = Vehicle (1, true)
        val car2 : Vehicle = Vehicle (2, false)
        val car3 : Vehicle = Vehicle (3, true)
        val car4 : Vehicle = Vehicle (4, true)
        val car5 : Vehicle = Vehicle (5, true)
        val car6 : Vehicle = Vehicle (6, false)

        val allVehicles : List<Vehicle> = listOf(car1, car2, car3, car4, car5, car6)

        val output : List<Vehicle> = road.scenario(allVehicles)

        var i : Int = 0

        for (plan in output){
            if (plan.delayed == false){
                i = i + 1
            }
        }
        println(i)
        assertEquals (4, i)
    }*/
}