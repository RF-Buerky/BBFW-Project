package traffic_simulation

class RoadNetwork(val capacity: Int) {

    fun calculateDemandForTimestepAndCauseTrafficJam(timestep :Int, vehicleList: List<Vehicle>){

        val demandAtTimestep :Int = calculateDemandAtTimestep(vehicleList , timestep)


        for(vehicle in vehicleList){
            val randomDelay : Boolean = vehicle.randomDelayByCapacityAndDemand(demandAtTimestep, capacity)
                    if(randomDelay){
                        delayVehiclesInTimestep(vehicleList , timestep)
                    } else {
                        vehiclesDrivingInTimestep(vehicleList , timestep)
                }
        }

    }

    fun calculateDemandAtTimestep (vehicleList : List<Vehicle> , timestep : Int):Int{
        var demandAtTimestep : Int = 0
        for(vehicle in vehicleList){
            if(vehicle.vehicleWantsToDriveAt(timestep)){
                demandAtTimestep = demandAtTimestep +1
            }
        }
        return demandAtTimestep
    }

    fun delayVehiclesInTimestep (vehicleList : List<Vehicle> , timestep : Int){
        for(vehicle in vehicleList){
            vehicle.getDelayedAtHour(timestep)
        }
    }

    fun vehiclesDrivingInTimestep (vehicleList: List<Vehicle>, timestep: Int){
        for(vehicle in vehicleList){
            vehicle.driveAtHour(timestep)
        }
    }

    fun simulateScenario(vehicleList: List<Vehicle>): List<Vehicle> {
        for(timestep in 1..24){
            calculateDemandForTimestepAndCauseTrafficJam(timestep, vehicleList)
        }
        return vehicleList
    }
}
