import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.RoadNetwork
import traffic_simulation.Vehicle

class VehicleTest {

    @Test
    fun sameVehicleIdIsNotNewVehicle () {
        var vehicles : MutableList<Vehicle> = mutableListOf(Vehicle (7 , true))

        var vehicle : Vehicle = Vehicle (7 , false)

        val result : Boolean = vehicle.isNewVehicle(vehicles)

        assertEquals (false , result )
    }


}