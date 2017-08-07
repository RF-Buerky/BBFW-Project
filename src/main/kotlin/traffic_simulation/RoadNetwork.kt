package traffic_simulation

class RoadNetwork(val capacity : Int){

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

}


