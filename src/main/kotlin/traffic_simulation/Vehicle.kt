package traffic_simulation

import java.util.*

class Vehicle(val id: Int, val wannaDriveInHours: MutableList<Int>) {

    val gotNewDelayInHours: MutableList<Int> = mutableListOf()
    val droveWithoutNewDelayInHours: MutableList<Int> = mutableListOf()
    var delay = 0

    fun vehicleWantsToDriveAt(timestep :Int):Boolean{
        // the vehicle wants to drive if its drive plan says so
        // or if it got previously delayed
        return wannaDriveInHours.contains(timestep) || delay > 0
    }

    fun getDelayedAtHour(timestep: Int) {
        // if the vehicle wanted to drive, its delay increased
        // (otherwise it just waited an hour, not reducing its delay)
        if (wannaDriveInHours.contains(timestep)) {
            delay += 1
            this.gotNewDelayInHours.add(timestep)
            this.gotNewDelayInHours.sort()
        }
    }

    fun driveAtHour(timestep: Int) {
        // if the vehicle wanted to drive, it is still as delayed as before
        // (otherwise it just gained an hour, thus reducing delay)
        if (!wannaDriveInHours.contains(timestep)) {
            delay -= 1
        }

        this.droveWithoutNewDelayInHours.add(timestep)
        this.droveWithoutNewDelayInHours.sort()

    }

    fun probability(demandX: Int, capacity: Int): Boolean{
        var probabilityOfDelay: Int = 0
        val percentOfCapacityUsage: Int = ((demandX.toDouble() / capacity.toDouble()) * 100).toInt()
        when (percentOfCapacityUsage) {
            in 0..49 -> probabilityOfDelay = 5
            in 50..69 -> probabilityOfDelay = 10
            in 70..89 -> probabilityOfDelay = 20
            in 90..109 -> probabilityOfDelay = 30
            in 110..124 -> probabilityOfDelay = 50
            in 125..149 -> probabilityOfDelay = 70
            in 150..Int.MAX_VALUE -> probabilityOfDelay = 90
        }
        val delayed: Boolean = Random().nextInt(100) + 1 <= probabilityOfDelay
        return delayed
    }

}
