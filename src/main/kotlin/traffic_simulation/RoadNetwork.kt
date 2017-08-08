package traffic_simulation

class RoadNetwork(val capacity: Int) {

    fun calculateDemandForTimestepAndCauseTrafficJam(timestep :Int, vehicleList: List<Vehicle>): Int{
        var demandAtTimestep :Int =0

        for(vehicle in vehicleList){
            if(vehicle.vehicleWantsToDriveAt(timestep)){
                demandAtTimestep = demandAtTimestep +1
            }
        }
        if(demandAtTimestep>capacity){
            for(vehicle in vehicleList){
                vehicle.getDelayedAtHour(timestep)
            }
        } else {
            for(vehicle in vehicleList){
                vehicle.driveAtHour(timestep)
            }
        }
       return demandAtTimestep
    }

    fun simulateScenario(vehicleList: List<Vehicle>): List<Vehicle> {
        for(timestep in 1..24){
            calculateDemandForTimestepAndCauseTrafficJam(timestep, vehicleList)
        }
        return vehicleList
    }
}
