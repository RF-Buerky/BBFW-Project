import org.junit.Test
import org.junit.Assert.assertEquals
import traffic_simulation.RoadNetwork
import traffic_simulation.Vehicle

class VehicleTest {

    @Test
    fun sameVehicleDoesNotChangeAllVehiclesSize () {
        val vehicles : MutableList <Vehicle> = mutableListOf()

        var newVeh : Vehicle = Vehicle(7 , true)
        newVeh.newVehicle(vehicles )
        newVeh = Vehicle(8 , true)
        newVeh.newVehicle( vehicles)
        newVeh = Vehicle(9 , true)
        newVeh.newVehicle(vehicles )

        val vehicle : Vehicle = Vehicle (7 , true)

        var i : Int = 0
        for (veh in vehicles){
            i = i + 1
        }
        assertEquals (3 , i )
    }

    @Test
    fun otherVehicleDoesChangeAllVehiclesSize () {
        val vehicles : MutableList <Vehicle> = mutableListOf(Vehicle(7 , true) , Vehicle(8 , true) , Vehicle(9 , true))

        val vehicle : Vehicle = Vehicle (5 , true)

        vehicle.newVehicle(vehicles)

        var i : Int = 0
        for (veh in vehicles){
            i = i + 1
        }
        assertEquals (4 , i )
    }

    @Test
    fun sameVehicleIdIsNotNewVehicle () {
        val vehicles : MutableList <Vehicle> = mutableListOf(Vehicle(7 , true) , Vehicle(8 , true) , Vehicle(9 , true))

        val vehicle : Vehicle = Vehicle (7 , true)

        val result : Boolean = vehicle.isNewVehicle(vehicles)

        assertEquals (false , result )
    }

    @Test
    fun otherVehicleIdIsNewVehicle () {
        val vehicles : MutableList <Vehicle> = mutableListOf()

        var newVeh : Vehicle = Vehicle(7 , true)
        newVeh.newVehicle( vehicles)
        newVeh = Vehicle(8 , true)
        newVeh.newVehicle(vehicles )
        newVeh = Vehicle(9 , true)
        newVeh.newVehicle( vehicles)

        val vehicle : Vehicle = Vehicle (3 , true)

        val result : Boolean = vehicle.isNewVehicle(vehicles)

        assertEquals (true , result )
    }

    @Test
    fun sameVehicleIdCanBeFoundInAllVehiclesList () {
        val vehicles : MutableList <Vehicle> = mutableListOf()

        var newVeh : Vehicle = Vehicle(7 , true)
        newVeh.newVehicle(vehicles )
        newVeh = Vehicle(8 , true)
        newVeh.newVehicle( vehicles)
        newVeh = Vehicle(9 , true)
        newVeh.newVehicle( vehicles)

        val vehicle : Vehicle = Vehicle (7 , false)

        var test : Boolean = false

        for (veh in vehicles){
            if(veh.id == vehicle.id){
                test = true
            }
        }
        assertEquals (true , test)
    }

    @Test
    fun otherVehicleIdCanNotBeFoundInVehiclesList () {
        val vehicles : MutableList <Vehicle> = mutableListOf()

        var newVeh : Vehicle = Vehicle(7 , true)
        newVeh.newVehicle(vehicles )
        newVeh = Vehicle(8 , true)
        newVeh.newVehicle(vehicles )
        newVeh = Vehicle(9 , true)
        newVeh.newVehicle( vehicles)

        val otherVehicle : Vehicle = Vehicle (4 , false)

        var test : Boolean = false

        for (veh in vehicles){
            if(veh.id == otherVehicle.id){
                test = true
            }
        }
        assertEquals (false , test)
    }
}