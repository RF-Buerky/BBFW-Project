package traffic_simulation

class RoadNetwork(val capacity: Int) {
    var capacityDemand: MutableMap <Int , Int> = mutableMapOf()

    fun checkForTrafficJamInSingleHour(demand: MutableMap<Int , Int>, hour : Int): Boolean {
        val neededInt : Int = demand.get(hour)!! // The two !! made intelliJ by himself to be sure there comes in Int
        if (capacity < neededInt) {
            return true
        }
        return false
    }

    fun calculateDemandFor24Hours(vehicles: List<Vehicle>): MutableMap<Int , Int> {
        // At the beginning the capacity demand in every hour is 0
        // We start with an empty map and put every 24 hours with 0 demands in
        // The maps key is the hour - the value is the capacity Demand
        for (i in 1..24) {
            capacityDemand.put(i, 0)
        }

        for (vehicle in vehicles) {
            // We add 1 capacity demand in the hour if the vehicles wannaDriveInHours-list contains the hour
            for ((key, value) in capacityDemand) {
                if (vehicle.wannaDriveInHours.contains(key)) {
                    val newDemand: Int = value + 1
                    capacityDemand.replace(key, newDemand)
                }
            }
        }
        //Adjusting demand by traffic jams; when a vehicle is getting delayed, but plans to drive in the next hours the
        //desire to drive is extended to the first timestep the vehicle has no desire to drive
        for (i in 1..24) {
            if (checkForTrafficJamInSingleHour(capacityDemand, i)) {
                for (vehicle in vehicles) {
                    vehicle.gettingDelayedInSpecialHour(i)
                    if (vehicle.delayedInHours.contains(i)) {
                        if(!!vehicle.wannaDriveInHours.contains(i+1)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+2)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+3)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+4)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+5)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+6)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+7)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+8)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+9)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+10)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+11)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+12)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+13)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+14)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+15)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+16)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+17)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+18)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+19)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+20)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+21)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+22)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                        if(!!vehicle.wannaDriveInHours.contains(i+23)) {
                            var nextStepDemand = capacityDemand[i]
                            nextStepDemand = nextStepDemand!! + 1
                            capacityDemand.replace(i + 1, nextStepDemand)
                        }
                    }
                }
            }
        }
        return capacityDemand
    }

  /*  fun adjustDemandByDelayedVehicles(hour : Int,
                                               allVehicle: MutableList<Vehicle>,
                                               capacityDemand: MutableMap<Int , Int>){
        for(vehicle in allVehicle) {
            if (vehicle.delayedInHours.contains(hour)) {
                vehicle.expandDrivingDesireDueToTrafficJam(hour)
                for ((key, value) in capacityDemand) {
                    if (vehicle.wannaDriveInHours.contains(key)) {
                        val newDemand: Int = value + 1
                        capacityDemand.replace(key, newDemand)
                    }
                }
            }
        }
*/

    fun simulateScenario(vehicleList: List<Vehicle>): List<Vehicle> {
        val demand: MutableMap<Int , Int> = calculateDemandFor24Hours(vehicleList)

        for (hour in 1..24){
            val trafficJam: Boolean = checkForTrafficJamInSingleHour(demand, hour)

            if (trafficJam) {
                for (vehicle in vehicleList) {
                    if (vehicle.wannaDriveInHours.contains(hour)) {//A vehicle standing around with no desire to drive cannot be delayed
                        vehicle.gettingDelayedInSpecialHour(hour)
                    }
                }
            }
        }
        return vehicleList
    }

}