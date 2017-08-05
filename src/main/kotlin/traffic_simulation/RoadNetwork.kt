package traffic_simulation

class RoadNetwork(val capacity : Int){

    val vehiclesPlanningToDrive: MutableList<Vehicle> = mutableListOf()
    var capacityLoadByInterests : Int = 0

    //methods use lists of vehicles; the lists origin is not specified at the moment
    //as the functions don´t need to know the origin to work

    fun gatherPlansToDrive (allVehiclesPlans : List<Vehicle>): MutableList<Vehicle> {
        val gatheredPlansToDrive : MutableList<Vehicle> = mutableListOf()

        for (vehicle in allVehiclesPlans){
            if (vehicle.wannaDrive()){
                gatheredPlansToDrive.add(vehicle)
                vehiclesPlanningToDrive.add(vehicle)
            }
        }
        return gatheredPlansToDrive
    }

    fun calculateDemand(vehiclesDrivingPlans:List<Vehicle>): Int{

        // a list of vehicles given to the function gets screened for the capacityFactor attribute
        //and adds these Doubles to a total capacity demand for this scenario (=1 hour)
        var capacityDemand : Int = 0

        for (vehicle in vehiclesDrivingPlans){
            capacityDemand = capacityDemand + 1
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


    fun scenario(vehicleList: List<Vehicle>): MutableList<Vehicle>{
        val vehiclesDriving : MutableList<Vehicle> = mutableListOf()
        val vehiclesPlanningToDrive: MutableList<Vehicle> = gatherPlansToDrive(vehicleList)

        val demand : Int = calculateDemand(vehiclesPlanningToDrive)

        for (vehicle in vehiclesPlanningToDrive){
            if (checkForTrafficJam(demand)) {
                val vehicle : Vehicle = vehicle.delayed()
                vehiclesDriving.add(vehicle)
            } else {
                vehiclesDriving.add(vehicle)
            }
        }
        return vehiclesDriving
    }

}


