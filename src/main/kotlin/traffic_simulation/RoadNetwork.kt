package traffic_simulation

class RoadNetwork(var capacity: Int) {

    fun calculateDemandForTimestepAndCauseRandomDelays(timestep: Int, vehicleList: List<Vehicle>) {

        val demandAtTimestep: Int = calculateDemandAtTimestep(vehicleList, timestep)

        for (vehicle in vehicleList) {
            val randomDelay: Boolean = vehicle.randomDelayByCapacityAndDemand(demandAtTimestep, capacity)
            if (randomDelay) {
                vehicle.getDelayedAtHour(timestep)
            } else {
                vehicle.driveAtHour(timestep)
            }
        }
    }

    fun calculateDemandAtTimestep(vehicleList: List<Vehicle>, timestep: Int): Int {
        var demandAtTimestep: Int = 0
        for (vehicle in vehicleList) {
            if (vehicle.vehicleWantsToDriveAt(timestep)) {
                demandAtTimestep = demandAtTimestep + vehicle.capacityFactor
            }
        }
        return demandAtTimestep
    }

    fun simulateScenario(vehicleList: List<Vehicle>): List<Vehicle> {
        for (timestep in 1..24) {
            calculateDemandForTimestepAndCauseRandomDelays(timestep, vehicleList)
        }
        return vehicleList
    }

    fun setRoadCapacityTo(newCapacity :Int){
        capacity = newCapacity
    }
}
