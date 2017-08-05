import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.RoadNetwork
import traffic_simulation.Vehicle

class VehicleTest {

    @Test
    fun sameVehicleDoesNotChangeAllVehiclesSize () {

        var newVeh : Vehicle = Vehicle(7 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(8 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(9 , true)
        newVeh.newVehicle( )

        var vehicle : Vehicle = Vehicle (7 , true)

        var i : Int = 0
        for (veh in vehicle.allVehicles){
            i = i + 1
        }

        assertEquals (3 , i )
    }

    @Test
    fun otherVehicleDoesChangeAllVehiclesSize () {

        var newVeh : Vehicle = Vehicle(7 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(8 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(9 , true)
        newVeh.newVehicle( )

        var vehicle : Vehicle = Vehicle (5 , true)

        var i : Int = 0
        for (veh in vehicle.allVehicles){
            i = i + 1
        }

        assertEquals (4 , i )
    }

    @Test
    fun sameVehicleIdIsNotNewVehicle () {

        var newVeh : Vehicle = Vehicle(7 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(8 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(9 , true)
        newVeh.newVehicle( )

        var vehicle : Vehicle = Vehicle (7 , true)

        val result : Boolean = vehicle.isNewVehicle()

        assertEquals (false , result )
    }

    @Test
    fun otherVehicleIdIsNewVehicle () {

        var newVeh : Vehicle = Vehicle(7 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(8 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(9 , true)
        newVeh.newVehicle( )

        var vehicle : Vehicle = Vehicle (3 , true)

        val result : Boolean = vehicle.isNewVehicle()

        assertEquals (true , result )
    }

    @Test
    fun sameVehicleIdCanBeFoundInAllVehiclesList () {

        var newVeh : Vehicle = Vehicle(7 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(8 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(9 , true)
        newVeh.newVehicle( )

        var vehicle : Vehicle = Vehicle (7 , false)

        var test : Boolean = false

        for (veh in vehicle.allVehicles){
            if(veh.id == vehicle.id){
                test = true
            }
        }

        assertEquals (true , test)

    }

    @Test
    fun otherVehicleIdCanNotBeFoundInAllVehiclesList () {

        var newVeh : Vehicle = Vehicle(7 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(8 , true)
        newVeh.newVehicle( )
        newVeh = Vehicle(9 , true)
        newVeh.newVehicle( )

        var vehicle : Vehicle = Vehicle (4 , false)

        var test : Boolean = false

        for (veh in vehicle.allVehicles){
            if(veh.id == vehicle.id){
                test = true
            }
        }

        assertEquals (false , test)

    }

}