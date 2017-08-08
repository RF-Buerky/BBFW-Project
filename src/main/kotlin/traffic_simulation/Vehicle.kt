package traffic_simulation

class Vehicle(val id: Int, val wannaDriveInHours: MutableList<Int>) {
    var delayedInHours: MutableList<Int> = mutableListOf() //no vehicle is delayedInHours by default

    fun gettingDelayedInSpecialHour(hour : Int) {
        this.delayedInHours.add(hour)
        delayedInHours.sort()
    }

}