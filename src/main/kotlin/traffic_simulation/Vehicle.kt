package traffic_simulation

import java.util.*

class Vehicle(val id: Int, val wannaDriveInHours: MutableList<Int>) {
    var delayedInHours: MutableList<Int> = mutableListOf() //no vehicle is delayedInHours by default

    fun expandDrivingDesireDueToTrafficJam(delayedHour:Int){
        if(!wannaDriveInHours.contains(delayedHour+1)){
            wannaDriveInHours.add(delayedHour+1)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+2)){
            wannaDriveInHours.add(delayedHour+2)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+3)){
            wannaDriveInHours.add(delayedHour+3)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+4)){
            wannaDriveInHours.add(delayedHour+4)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+5)){
            wannaDriveInHours.add(delayedHour+5)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+6)){
            wannaDriveInHours.add(delayedHour+6)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+7)){
            wannaDriveInHours.add(delayedHour+7)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+8)){
            wannaDriveInHours.add(delayedHour+8)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+9)){
            wannaDriveInHours.add(delayedHour+9)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+10)){
            wannaDriveInHours.add(delayedHour+10)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+11)){
            wannaDriveInHours.add(delayedHour+11)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+12)){
            wannaDriveInHours.add(delayedHour+12)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+13)){
            wannaDriveInHours.add(delayedHour+13)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+14)){
            wannaDriveInHours.add(delayedHour+14)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+15)){
            wannaDriveInHours.add(delayedHour+15)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+16)){
            wannaDriveInHours.add(delayedHour+16)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+17)){
            wannaDriveInHours.add(delayedHour+17)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+18)){
            wannaDriveInHours.add(delayedHour+18)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+19)){
            wannaDriveInHours.add(delayedHour+19)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+20)){
            wannaDriveInHours.add(delayedHour+20)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+21)){
            wannaDriveInHours.add(delayedHour+21)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+22)){
            wannaDriveInHours.add(delayedHour+22)
            wannaDriveInHours.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+23)){
            wannaDriveInHours.add(delayedHour+23)
            wannaDriveInHours.sort()
        }
    }

    
    fun gettingDelayedInSpecialHour(hour : Int) {
        this.delayedInHours.add(hour)
        delayedInHours.sort()
        expandDrivingDesireDueToTrafficJam(hour)
    }


}