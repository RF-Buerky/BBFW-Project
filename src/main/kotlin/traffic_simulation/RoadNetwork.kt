package traffic_simulation

class RoadNetwork(val capacity : Int){

    val CarsPlaningToDrive : MutableList<Car> = mutableListOf()
    var capacityLoadByInterests : Int = 0

    //methods use lists of vehicles; the lists origin is not specified at the moment
    //as the functions don´t need to know the origin to work


    fun gatherPlansToDrive (allVehiclesPlans : List<Car>): MutableList<Car> {

        val gatheredPlansToDrive : MutableList<Car> = mutableListOf()

        for (vehicle in allVehiclesPlans){
            if (vehicle.wannaDrive == true){
                gatheredPlansToDrive.add(vehicle)
                CarsPlaningToDrive.add(vehicle)
            }
        }

        return gatheredPlansToDrive
    }


    fun calculateDemand(vehiclesDrivingPlans:List<Car>): Int{

        // a list of vehicles given to the function gets screened for the capacityFactor attribute
        //and adds these Doubles to a total capacity demand for this scenario (=1 hour)
        var capacityDemand : Int = 0

        for (vehicle in vehiclesDrivingPlans){
            capacityDemand = capacityDemand +1
            capacityLoadByInterests = capacityLoadByInterests +1
            }
        return capacityDemand
    }


    fun checkForTrafficJam (demand : Int):Boolean{
        if (capacity < demand){
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


