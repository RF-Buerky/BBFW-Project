package traffic_simulation

class Vehicle(val id: Int, val wannaDriveInHours: MutableList<Int>) {

    val delayedInHours : MutableList<Int> = mutableListOf()
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
            this.delayedInHours.add(timestep)
            this.delayedInHours.sort()
            this.wannaDriveInHours.add(timestep + 1)
        }
    }

    fun driveAtHour(timestep: Int) {
        // if the vehicle wanted to drive, it is still as delayed as before
        // (otherwise it just gained an hour, thus reducing delay)
        if (!wannaDriveInHours.contains(timestep)) {
            delay -= 1
        }
    }

}
