package traffic_simulation

class Vehicle(val id : Int, val wannaDrive : Boolean, var delayed : Boolean = false){

    val allVehicles : MutableList<Vehicle> = mutableListOf()

    fun isNewVehicle (newVehicle : Vehicle) : Boolean {
        var isNew : Boolean = true
        for (vehicle in allVehicles){
            if (vehicle.id == newVehicle.id){
                isNew = false
            }
        }
        return isNew
    }

    fun newVehicle (vehicle : Vehicle): Vehicle{
        if (isNewVehicle(vehicle)) {
            allVehicles.add(vehicle)
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

