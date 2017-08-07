package traffic_simulation

class RoadNetwork(val capacity: Int) {

    fun calculateDemand(vehicles: List<Vehicle>): Int {
        var capacityDemand: Int = 0

        for (vehicle in vehicles) {
            if (vehicle.wannaDrive)
                capacityDemand = capacityDemand + 1
        }
        return capacityDemand
    }


    fun checkForTrafficJam(demand: Int): Boolean {
        if (capacity < demand) {
            return true
        }
        return false
    }


    fun simulateScenario(vehicleList: List<Vehicle>): List<Vehicle> {
        val demand: Int = calculateDemand(vehicleList)
        val trafficJam: Boolean = checkForTrafficJam(demand)

        if (trafficJam) {
            for (vehicle in vehicleList) {
                if (vehicle.wannaDrive) {//A vehicle standing around with no desire to drive cannot be delayed
                    vehicle.gettingDelayed()
                }
            }
        }
        return vehicleList
    }

}