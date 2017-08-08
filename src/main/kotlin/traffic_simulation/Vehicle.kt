package traffic_simulation

class Vehicle(val id: Int, val wannaDriveInHours: MutableList<Int>) {
    val delayedInHours: MutableList<Int> = mutableListOf() //no vehicle is delayedInHours by default

    val newHourlyDrivingPlanWithTraffic: MutableList<Int> = wannaDriveInHours

    fun vehicleWantsToDriveAt(timestep :Int):Boolean{
        if(newHourlyDrivingPlanWithTraffic.contains(timestep)){
            return true
        }else{
            return false
        }
    }

    fun createNewDrivingPlanDueToTrafficJam(delayedHour:Int){
        if(!wannaDriveInHours.contains(delayedHour+1)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+1)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+2)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+2)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+3)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+3)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+4)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+4)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+5)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+5)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+6)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+6)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+7)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+7)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+8)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+8)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+9)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+9)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+10)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+10)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+11)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+11)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+12)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+12)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+13)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+13)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+14)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+14)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+15)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+15)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+16)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+16)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+17)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+17)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+18)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+18)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+19)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+19)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+20)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+20)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+21)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+21)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+22)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+22)
            newHourlyDrivingPlanWithTraffic.sort()
        }
        else if(!wannaDriveInHours.contains(delayedHour+23)){
            newHourlyDrivingPlanWithTraffic.add(delayedHour+23)
            newHourlyDrivingPlanWithTraffic.sort()
        }
    }

    fun gettingDelayedInSpecialHour(hour : Int) {
        this.delayedInHours.add(hour)
        delayedInHours.sort()
        createNewDrivingPlanDueToTrafficJam(hour)
    }


}