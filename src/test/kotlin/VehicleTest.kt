import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.RoadNetwork
import traffic_simulation.Vehicle

class VehicleTest {

    @Test
    fun sameVehicleDoesNotChangeAllVehiclesSize () {

        Vehicle(7 , true).newVehicle( )
        Vehicle(8 , true).newVehicle( )
        Vehicle(9 , true).newVehicle( )

        var vehicle : Vehicle = Vehicle (7 , true)

        var i : Int = 0
        for (veh in vehicle.allVehicles){
            i = i + 1
        }

        assertEquals (3 , i )
    }

    @Test
    fun sameVehicleIdIsNotNewVehicle () {

        Vehicle(7 , true).newVehicle()
        Vehicle(8 , true).newVehicle()
        Vehicle(9 , true).newVehicle()

        var vehicle : Vehicle = Vehicle (7 , true)

        val result : Boolean = vehicle.isNewVehicle()

        for (vehicle in vehicle.allVehicles){
            print(vehicle.id)
            println(vehicle.wannaDrive)
        }
        assertEquals (false , result )
    }

    @Test
    fun sameVehicleIsNotAddedToAllVehicles () {

        Vehicle(7 , true).newVehicle()
        Vehicle(8 , true).newVehicle()
        Vehicle(9 , true).newVehicle()

        var vehicle : Vehicle = Vehicle (7 , false)

        vehicle.newVehicle()

        var i : Int = 0
        for (vehicle in vehicle.allVehicles){
            i = i + 1
        }

        assertEquals (3 , i)

    }


}