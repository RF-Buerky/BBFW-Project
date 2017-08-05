package traffic_simulation

class Vehicle(val id : Int, val wannaDrive : Boolean, var delayed : Boolean = false){

    val allVehicles : MutableList<Vehicle> = mutableListOf()

    fun isNewVehicle (vehicles : List<Vehicle>) : Boolean {
        var isNew : Boolean = true
        for (vehicle in vehicles){
            if (this.id == vehicle.id){
                isNew = false
            }
        }
        return isNew
    }

    fun newVehicle (vehicles : List<Vehicle>): Vehicle{
        if (isNewVehicle(vehicles)) {
            allVehicles.add(this)
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

