package traffic_simulation

class Vehicle(val id: Int, val wannaDriveInHours: MutableList<Int>) {
    var delayedInHours: MutableList<Int> = mutableListOf() //no vehicle is delayedInHours by default

    fun expandDrivingDesireDueToTrafficJam(delayedHour:Int){
        if(!wannaDriveInHours.contains(delayedHour+1)){
            wannaDriveInHours.add(delayedHour+1)
            wannaDriveInHours.sort()
        }
    }

    fun gettingDelayedInSpecialHour(hour : Int) {
        this.delayedInHours.add(hour)
        delayedInHours.sort()
        expandDrivingDesireDueToTrafficJam(hour)
    }


}