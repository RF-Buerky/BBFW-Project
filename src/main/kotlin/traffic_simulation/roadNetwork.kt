package traffic_simulation

class roadNetwork(val capacity : Double){

    //methods use lists of vehicles; the lists origin is not specified at the moment
    //as the functions dont need to know the origin to work

    fun calculateDemand(vehicles:MutableList<vehicle>): Double{
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

}

val testRoad:roadNetwork= roadNetwork(8.0)
