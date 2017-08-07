package traffic_simulation

class Vehicle(val id: Int, val wannaDriveInHours: MutableList<Int>) {
    var delayed: Boolean = false //no vehicle is delayed by default

    fun gettingDelayed() {
        this.delayed = true
    }

}

