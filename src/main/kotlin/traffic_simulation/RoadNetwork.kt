package traffic_simulation

class RoadNetwork(val capacity : Double){

    //methods use lists of vehicles; the lists origin is not specified at the moment
    //as the functions don´t need to know the origin to work

    fun calculateDemand(vehicles:List<Car>): Double{
        // a list of vehicles given to the function gets screened for the capacityFactor attribute
        //and adds these Doubles to a total capacity demand for this scenario (=1 hour)
        var capacityDemand : Double = 0.0

        for (vehicle in vehicles){
                capacityDemand = capacityDemand + 1
        }
        return capacityDemand
    }


    fun checkForTrafficJam (demand : Double):Boolean{
        if (capacity<demand){
            return true
        }
        return false
    }

    fun calculateTraffic (vehicleList: List<Car>){
        if(checkForTrafficJam(calculateDemand(vehicleList))){
            println("All vehicles are being delayed")

        }else {
            println("No traffic jam - this is joyful driving")
        }
    }

}


