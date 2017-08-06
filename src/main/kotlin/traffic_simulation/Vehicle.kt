package traffic_simulation

class Vehicle(val id : Int, val wannaDrive : Boolean, var delayed : Boolean = false){

    val allVehicles : MutableList<Vehicle> = mutableListOf()

    fun isNewVehicle (vehicles : MutableList<Vehicle>) : Boolean {
        println("Dies ist in der Funktion isNewVehicle")
        var isNew : Boolean = true
        for (vehicle in vehicles){
            if (this.id == vehicle.id){
                isNew = false
            }
        }
        return isNew
    }

    fun newVehicle (vehicles : MutableList<Vehicle>): Vehicle{
        if (isNewVehicle(vehicles)) {
            vehicles.add(this)
            println("Dies ist in der Funktion newVehicle")
        }
        return Vehicle(id, wannaDrive)
    }

    fun wannaDrive (): Boolean {
        return wannaDrive
    }

    fun delayed (): Vehicle {
        return Vehicle (id , wannaDrive , true)
    }
}

