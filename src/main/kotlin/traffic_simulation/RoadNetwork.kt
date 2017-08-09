package traffic_simulation

import java.util.*

class RoadNetwork(val capacity: Int) {

    fun calculateDemandForTimestepAndCauseTrafficJam(timestep: Int, vehicleList: List<Vehicle>): Int {
        var demandAtTimestep: Int = 0

        for (vehicle in vehicleList) {
            if (vehicle.vehicleWantsToDriveAt(timestep)) {
                demandAtTimestep = demandAtTimestep + 1
            }
        }

        val probabilityOfDelay: Int
        val percentOfCapacityUsage: Int = (demandAtTimestep / capacity) * 100
        when (percentOfCapacityUsage) {
            !in Int.MIN_VALUE..Int.MAX_VALUE -> println("insane road")
            in 0..49 -> probabilityOfDelay = 5
            in 50..69 -> probabilityOfDelay = 10
            in 70..89 -> probabilityOfDelay = 20
            in 90..109 -> probabilityOfDelay = 30
            in 110..124 -> probabilityOfDelay = 50
            in 125..149 -> probabilityOfDelay = 70
            in 150..Int.MAX_VALUE -> probabilityOfDelay = 90
        }

        fun DelayedByProbability(probability: Int): Boolean {
            val result: Boolean
            val probabilityList: MutableList<Int> = mutableListOf()
            for (r in 1..probability) {
                probabilityList.add(r)
            }
            val randomNumber = Random().nextInt(100) + 1
            result = probabilityList.contains(randomNumber)
            return result
        }

        if (demandAtTimestep > capacity) {
            for (vehicle in vehicleList) {
                vehicle.getDelayedAtHour(timestep)
            }
        } else {
            for (vehicle in vehicleList) {
                vehicle.driveAtHour(timestep)
            }
        }
        return demandAtTimestep
    }

    fun simulateScenario(vehicleList: List<Vehicle>): List<Vehicle> {
        for (timestep in 1..24) {
            calculateDemandForTimestepAndCauseTrafficJam(timestep, vehicleList)
        }
        return vehicleList
    }
}
