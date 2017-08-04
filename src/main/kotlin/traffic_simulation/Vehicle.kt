package traffic_simulation

class Vehicle(val id : Int, val wannaDrive : Boolean, var delayed : Boolean = false){
    //Methods to be added here soon

    fun newVehicle (id : Int , wannaDrive : Boolean) : Vehicle {
        return Vehicle(id , wannaDrive)
    }

    fun wannaDrive (): Boolean {
        return wannaDrive
    }

    fun delayed (): Vehicle {
        return Vehicle (id , wannaDrive , true)
    }
}

