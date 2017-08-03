package traffic_simulation

class RoadNetwork(val capacity : Double){

    //methods use lists of vehicles; the lists origin is not specified at the moment
    //as the functions don´t need to know the origin to work

    fun calculateDemand(vehicles:List<Vehicle>): Double{
        // a list of vehicles given to the function gets screened for the capacityFactor attribute
        //and adds these Doubles to a total capacity demand for this scenario (=1 hour)
        var capacityDemand : Double = 0.0

        for (vehicle in vehicles){
            if(vehicle.wannaDrive){
                capacityDemand = capacityDemand + vehicle.capacityFactor
            }
        }
        return capacityDemand
    }


    fun checkForTrafficJam (demand : Double):Boolean{
        if (capacity<demand){
            return true
        }
        return false
    }

    fun delayVehicles(vehicles: List<Vehicle>){
        for(vehicle in vehicles){
            vehicle.delayed = true
        }
    }

}

val testRoad: RoadNetwork = RoadNetwork(8.0)
