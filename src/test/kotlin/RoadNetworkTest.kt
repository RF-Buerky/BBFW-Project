import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.RoadNetwork
import traffic_simulation.Vehicle

class RoadNetworkTest {

    @Test
    fun calculateDemand_DemandOfOneVehicle_demandIsTheVehiclesDemand() {
        val road = RoadNetwork(20)

        val BMW: Vehicle = Vehicle(1, mutableListOf(3, 4, 5, 8))

        val cars: List<Vehicle> = listOf(BMW)

        val calculated = road.calculateDemandFor24Hours(cars)

        val correctMap: MutableMap<Int , Int> = mutableMapOf( Pair(1 , 0) , Pair(2 , 0) , Pair(3 , 1) , Pair(4 , 1) , Pair(5 , 1) ,
                Pair(6 , 0) , Pair(7 , 0) , Pair(8 , 1) , Pair(9 , 0) , Pair(10 , 0) , Pair(11 , 0) , Pair(12 , 0) ,
                Pair(13 , 0) , Pair(14 , 0) , Pair(15 , 0) , Pair(16 , 0) , Pair(17 , 0) , Pair(18 , 0) , Pair(19 , 0) ,
                Pair(20 , 0) , Pair(21 , 0) , Pair(22 , 0) , Pair(23 , 0) , Pair(24 , 0) )

        assertEquals(correctMap, calculated)
    }

    @Test
    fun calculateDemand_DemandOfNoneVehicle_thereIsNoDemand() {
        val road = RoadNetwork(20)

        val cars: List<Vehicle> = listOf()

        val calculated = road.calculateDemandFor24Hours(cars)

        val correctMap: MutableMap<Int , Int> = mutableMapOf( Pair(1 , 0) , Pair(2 , 0) , Pair(3 , 0) , Pair(4 , 0) , Pair(5 , 0) ,
                Pair(6 , 0) , Pair(7 , 0) , Pair(8 , 0) , Pair(9 , 0) , Pair(10 , 0) , Pair(11 , 0) , Pair(12 , 0) ,
                Pair(13 , 0) , Pair(14 , 0) , Pair(15 , 0) , Pair(16 , 0) , Pair(17 , 0) , Pair(18 , 0) , Pair(19 , 0) ,
                Pair(20 , 0) , Pair(21 , 0) , Pair(22 , 0) , Pair(23 , 0) , Pair(24 , 0) )
        assertEquals(correctMap, calculated)
    }

    @Test
    fun calculateDemand_DemandOfSeveralVehicles_demandIsTheVehiclesDemand() {
        val road = RoadNetwork(20)

        val BMW: Vehicle = Vehicle(1, mutableListOf(3, 4, 5, 8, 24))
        val AUDI: Vehicle = Vehicle(2, mutableListOf(3, 4, 5, 8, 9, 10))
        val VOLVO: Vehicle = Vehicle(3, mutableListOf(3, 4, 5, 8))

        val cars: List<Vehicle> = listOf(BMW, AUDI, VOLVO)

        val calculated = road.calculateDemandFor24Hours(cars)

        val correctMap: MutableMap<Int , Int> = mutableMapOf( Pair(1 , 0) , Pair(2 , 0) , Pair(3 , 3) , Pair(4 , 3) , Pair(5 , 3) ,
                Pair(6 , 0) , Pair(7 , 0) , Pair(8 , 3) , Pair(9 , 1) , Pair(10 , 1) , Pair(11 , 0) , Pair(12 , 0) ,
                Pair(13 , 0) , Pair(14 , 0) , Pair(15 , 0) , Pair(16 , 0) , Pair(17 , 0) , Pair(18 , 0) , Pair(19 , 0) ,
                Pair(20 , 0) , Pair(21 , 0) , Pair(22 , 0) , Pair(23 , 0) , Pair(24 , 1) )
        assertEquals(correctMap, calculated)
    }

    @Test
    fun calculateDemand_SeveralCarsWithoutDemands_NoDemand() {
        val road = RoadNetwork(20)

        val BMW: Vehicle = Vehicle(1, mutableListOf())
        val AUDI: Vehicle = Vehicle(2, mutableListOf())
        val VOLVO: Vehicle = Vehicle(3, mutableListOf())

        val cars: List<Vehicle> = listOf(BMW, AUDI, VOLVO)

        val calculated = road.calculateDemandFor24Hours(cars)

        val correctMap: MutableMap<Int , Int> = mutableMapOf( Pair(1 , 0) , Pair(2 , 0) , Pair(3 , 0) , Pair(4 , 0) , Pair(5 , 0) ,
                Pair(6 , 0) , Pair(7 , 0) , Pair(8 , 0) , Pair(9 , 0) , Pair(10 , 0) , Pair(11 , 0) , Pair(12 , 0) ,
                Pair(13 , 0) , Pair(14 , 0) , Pair(15 , 0) , Pair(16 , 0) , Pair(17 , 0) , Pair(18 , 0) , Pair(19 , 0) ,
                Pair(20 , 0) , Pair(21 , 0) , Pair(22 , 0) , Pair(23 , 0) , Pair(24 , 0) )
        assertEquals(correctMap, calculated)
    }

    @Test
    fun doesCheckForTrafficJamWorkForCapacityBiggerThanDemand() {
        val road = RoadNetwork(20)

        val trafficJam: Boolean = road.checkForTrafficJamInSingleHour(mutableMapOf(Pair(3, 5)), 3)
        assertEquals(false, trafficJam)
    }

    @Test
    fun doesCheckForTrafficJamWorkForCapacitySmallerThanDemand() {
        val road = RoadNetwork(2)

        val trafficJam: Boolean = road.checkForTrafficJamInSingleHour(mutableMapOf(Pair(3, 5)), 3)
        assertEquals(true, trafficJam)
    }

    @Test
    fun doesCheckForTrafficJamWorkForCapacityEqualToDemand() {
        val road = RoadNetwork(5)

        val trafficJam: Boolean = road.checkForTrafficJamInSingleHour(mutableMapOf(Pair(3, 5)), 3)
        assertEquals(false, trafficJam)
    }

    @Test
    fun roadNetworkWithZeroCapacityDelaysAlwaysCars() {
        val road = RoadNetwork(0)

        val trafficJam: Boolean = road.checkForTrafficJamInSingleHour(mutableMapOf(Pair(3, 5)), 3)
        assertEquals(true, trafficJam)
    }

    @Test
    fun noTrafficJamIfNoCapacityNeedetDespideNoCapacityThere() {
        val road = RoadNetwork(0)

        val trafficJam: Boolean = road.checkForTrafficJamInSingleHour(mutableMapOf(Pair(3, 0)), 3)
        assertEquals(false, trafficJam)
    }


    @Test
    fun simulateScenario_someVehiclesGettingDelayed_NumberOfDelaysIsCorrect() {
        val road = RoadNetwork(5)

        val car1: Vehicle = Vehicle(1, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car2: Vehicle = Vehicle(2, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car3: Vehicle = Vehicle(3, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car4: Vehicle = Vehicle(4, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car5: Vehicle = Vehicle(5, mutableListOf(3, 4, 5, 8))
        val car6: Vehicle = Vehicle(6, mutableListOf(3, 4, 5, 8))

        val allVehicles: List<Vehicle> = listOf(car1, car2, car3, car4, car5, car6)
        val output : List<Vehicle> = road.simulateScenario(allVehicles)

        var i: Int = 0

        for (car in output) {
            for (hour in car.delayedInHours) {
                i = i + 1
            }
        }
        assertEquals(24, i)
    }

    @Test
    fun simulateScenario_noVehiclesGettingDelayed_NumberOfDelaysIsCorrect() {
        val road = RoadNetwork(50)

        val car1: Vehicle = Vehicle(1, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car2: Vehicle = Vehicle(2, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car3: Vehicle = Vehicle(3, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car4: Vehicle = Vehicle(4, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car5: Vehicle = Vehicle(5, mutableListOf(3, 4, 5, 8))
        val car6: Vehicle = Vehicle(6, mutableListOf(3, 4, 5, 8))

        val allVehicles: List<Vehicle> = listOf(car1, car2, car3, car4, car5, car6)
        val output : List<Vehicle> = road.simulateScenario(allVehicles)

        var i: Int = 0

        for (car in output) {
            for (hour in car.delayedInHours) {
                i = i + 1
            }
        }
        assertEquals(0, i)
    }

    @Test
    fun simulateScenario_demandMatchesCapacity_noDelays() {
        val road = RoadNetwork(6)

        val car1: Vehicle = Vehicle(1, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car2: Vehicle = Vehicle(2, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car3: Vehicle = Vehicle(3, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car4: Vehicle = Vehicle(4, mutableListOf(3, 4, 5, 8, 9, 10, 11))
        val car5: Vehicle = Vehicle(5, mutableListOf(3, 4, 5, 8))
        val car6: Vehicle = Vehicle(6, mutableListOf(3, 4, 5, 8))
        val car7: Vehicle = Vehicle(6, mutableListOf(9,10,11))
        val car8: Vehicle = Vehicle(6, mutableListOf(9,10,11))

        val allVehicles: List<Vehicle> = listOf(car1, car2, car3, car4, car5, car6, car7, car8)
        val output : List<Vehicle> = road.simulateScenario(allVehicles)

        var i: Int = 0

        for (car in output) {
            for (hour in car.delayedInHours) {
                i = i + 1
            }
        }
        assertEquals(0, i)
    }
}
