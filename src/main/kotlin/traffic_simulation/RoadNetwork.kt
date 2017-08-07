package traffic_simulation

class RoadNetwork(val capacity : Int){

    //The following // lines are no longer needed but are kept due to possible restoring issues
    //val vehiclesPlanningToDrive: MutableList<Vehicle> = mutableListOf()
    //val vehiclesDrove : MutableList<Vehicle> = mutableListOf()
    /*fun gatherPlansToDrive (allVehiclesPlans : List<Vehicle>): MutableList<Vehicle> {
        val gatheredPlansToDrive : MutableList<Vehicle> = mutableListOf()

        for (vehicle in allVehiclesPlans){
            if (vehicle.wannaDrive()){
                vehicle.newVehicle(gatheredPlansToDrive)
                vehicle.newVehicle(vehiclesPlanningToDrive)
            }
        }
        return gatheredPlansToDrive
    }*/

    fun calculateDemand(vehicles:List<Vehicle>): Int{
        var capacityDemand : Int = 0

        for (vehicle in vehicles){
            if(vehicle.wannaDrive)
            capacityDemand = capacityDemand + 1
            }
        return capacityDemand
    }


    fun checkForTrafficJam (demand : Int):Boolean{
        if (capacity < demand){
            return true
        }
        return false
    }


    fun simulateInternScenarioAndPrintToConsole(vehicleList: List<Vehicle>){
        val demand : Int = calculateDemand(vehicleList)
        val trafficJam:Boolean =  checkForTrafficJam(demand)

        if(trafficJam){
            for(vehicle in vehicleList){
                vehicle.gettingDelayed()
            }
        }
        for (vehicle in vehicleList) {
            println("Vehicle '${vehicle.id}' is delayed: ${vehicle.delayed}")
        }
    }

    /*fun delayVehicles(vehicleList: List<Vehicle>){
        for (vehicle in vehicleList){
            vehicle.delayed=true
        }
    }*/
}


