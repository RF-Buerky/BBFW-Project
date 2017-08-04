package traffic_simulation

class Car(val id : Int, val wannaDrive : Boolean){
    //Methods to be added here soon

    fun newCar (id : Int , wannaDrive : Boolean) : Car {
        return Car (id , wannaDrive)
    }
}

