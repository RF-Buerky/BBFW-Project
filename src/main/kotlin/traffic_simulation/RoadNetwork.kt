package traffic_simulation

class RoadNetwork(val capacity: Int) {

    fun calculateDemandForTimestep(timestep :Int, vehicleList: List<Vehicle>): Int{
        var demandAtTimestep :Int =0
        for(vehicle in vehicleList){
            if(vehicle.wannaDriveInHours.contains(timestep)){
                demandAtTimestep = demandAtTimestep +1
            }
        }
        if(demandAtTimestep>capacity){
            for(vehicle in vehicleList){
                vehicle.gettingDelayedInSpecialHour(timestep)
            }
        }
       return demandAtTimestep
    }

    fun simulateScenario(vehicleList: List<Vehicle>): List<Vehicle> {
        for(timestep in 1..24){
            calculateDemandForTimestep(timestep, vehicleList)
        }
        return vehicleList
    }
}