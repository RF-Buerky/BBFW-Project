import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.*

class RoadNetworkTest {

    // Tests for calculateDemandAtTimestep
    // ____________________________________________________________________________________________________
    // ____________________________________________________________________________________________________

    @Test
    fun calculateDemandAtTimestep_DemandOfOneVehicleInFirstHour_demandIsTheVehiclesDemand() {
        val road = RoadNetwork(20)

        val testCar = Car(1, mutableListOf(1, 2, 5))
        val cars: List<Vehicle> = listOf(testCar)
        var calculated = road.calculateDemandAtTimestep(cars, 1)
        assertEquals(10, calculated)

        val testBike = Bike(1, mutableListOf(1, 2, 5))
        val bikes: List<Bike> = listOf(testBike)
        calculated = road.calculateDemandAtTimestep(bikes, 1)
        assertEquals(1, calculated)

        val testTruck = Truck(1, mutableListOf(1, 2, 5))
        val trucks: List<Truck> = listOf(testTruck)
        calculated = road.calculateDemandAtTimestep(trucks, 1)
        assertEquals(30, calculated)

        val testTram = Tram(1, mutableListOf(1, 2, 5))
        val trams: List<Tram> = listOf(testTram)
        calculated = road.calculateDemandAtTimestep(trams, 1)
        assertEquals(50, calculated)
    }

    @Test
    fun calculateDemandAtTimestep_DemandOfDifferentVehicleClasses_demandIsTheSumOfVehiclesDemand() {
        val road = RoadNetwork(20)

        val testBike = Bike(1, mutableListOf(1, 2, 5))
        val testCar = Car(1, mutableListOf(1, 2, 5))
        val testTruck = Truck(1, mutableListOf(1, 2, 5))
        val testTram = Tram(1, mutableListOf(1, 2, 5))

        val vehicles: List<Vehicle> = listOf(testCar, testBike, testTruck, testTram)

        val calculated = road.calculateDemandAtTimestep(vehicles, 5)

        assertEquals(91, calculated)
    }

    @Test
    fun calculateDemandAtTimestep_DemandOfOneVehicleInLastHour_demandIsTheVehiclesDemand() {
        val road = RoadNetwork(20)

        val testCar = Car(1, mutableListOf(1, 2, 5, 24))
        val cars: List<Vehicle> = listOf(testCar)
        var calculated = road.calculateDemandAtTimestep(cars, 24)
        assertEquals(10, calculated)

        val testBike = Bike(1, mutableListOf(1, 2, 5, 24))
        val bikes: List<Bike> = listOf(testBike)
        calculated = road.calculateDemandAtTimestep(bikes, 24)
        assertEquals(1, calculated)

        val testTruck = Truck(1, mutableListOf(1, 2, 5, 24))
        val trucks: List<Truck> = listOf(testTruck)
        calculated = road.calculateDemandAtTimestep(trucks, 24)
        assertEquals(30, calculated)

        val testTram = Tram(1, mutableListOf(1, 2, 5, 24))
        val trams: List<Tram> = listOf(testTram)
        calculated = road.calculateDemandAtTimestep(trams, 24)
        assertEquals(50, calculated)
    }

    @Test
    fun calculateDemandAtTimestep_DemandOfNoneVehicle_thereIsNoDemand() {
        val road = RoadNetwork(20)

        val cars: List<Vehicle> = listOf()

        val calculated = road.calculateDemandAtTimestep(cars, 5)

        assertEquals(0, calculated)
    }

    @Test
    fun calculateDemandAtTimestep_SeveralCarsWithoutDemands_NoDemand() {
        val road = RoadNetwork(20)

        val BMW: Car = Car(1, mutableListOf())
        val AUDI: Car = Car(2, mutableListOf())
        val VOLVO: Car = Car(3, mutableListOf())

        val cars: List<Car> = listOf(BMW, AUDI, VOLVO)

        val calculated = road.calculateDemandAtTimestep(cars, 24)

        assertEquals(0, calculated)
    }
}
