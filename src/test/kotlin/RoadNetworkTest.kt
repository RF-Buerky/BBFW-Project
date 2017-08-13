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

    @Test
    fun calculateDemandAtTimestep_DemandOfSomeMoreDifferentVehicleClasses_demandIsTheSumOfVehiclesDemand() {
        val road = RoadNetwork(20)

        val testBike1 = Bike(1, mutableListOf(1, 2, 5))
        val testBike2 = Bike(1, mutableListOf(1, 2, 5))
        val testBike3 = Bike(1, mutableListOf(1, 2, 5))
        val testBike4 = Bike(1, mutableListOf(1, 2, 5))
        val testBike5 = Bike(1, mutableListOf(1, 2, 5))
        val testBike6 = Bike(1, mutableListOf(1, 2, 5))

        val testCar1 = Car(1, mutableListOf(1, 2, 5))
        val testCar2 = Car(1, mutableListOf(1, 2, 5))
        val testCar3 = Car(1, mutableListOf(1, 2, 5))
        val testCar4 = Car(1, mutableListOf(1, 2, 5))
        val testCar5 = Car(1, mutableListOf(1, 2, 5))
        val testCar6 = Car(1, mutableListOf(1, 2, 5))
        val testCar7 = Car(1, mutableListOf(1, 2, 5))
        val testCar8 = Car(1, mutableListOf(1, 2, 5))
        val testCar9 = Car(1, mutableListOf(1, 2, 5))

        val testTruck1 = Truck(1, mutableListOf(1, 2, 5))
        val testTruck2 = Truck(1, mutableListOf(1, 2, 5))
        val testTruck3 = Truck(1, mutableListOf(1, 2, 5))

        val testTram1 = Tram(1, mutableListOf(1, 2, 5))
        val testTram2 = Tram(1, mutableListOf(1, 2, 5))

        val vehicles: List<Vehicle> = listOf(testCar1, testCar2, testCar3, testCar4, testCar5, testCar6, testCar7, testCar8, testCar9,
                testBike1, testBike2, testBike3, testBike4, testBike5, testBike6, testTruck1, testTruck2, testTruck3, testTram1, testTram2)


        val calculated = road.calculateDemandAtTimestep(vehicles, 5)

        assertEquals(286, calculated)
    }
}
