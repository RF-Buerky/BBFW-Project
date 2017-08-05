package traffic_simulation

class Vehicle(val id : Int, val wannaDrive : Boolean, var delayed : Boolean = false){

    val allVehicles : MutableList<Vehicle> = mutableListOf()

    fun isNewVehicle () : Boolean {
        var isNew : Boolean = true
        for (vehicle in allVehicles){
            if (this.id == vehicle.id){
                isNew = false
            }
        }
        return isNew
    }

    fun newVehicle (): Vehicle{
        if (isNewVehicle()) {
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

