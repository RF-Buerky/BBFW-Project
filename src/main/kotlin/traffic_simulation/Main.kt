package traffic_simulation

fun main(args: Array<String>) {

    scenario(testList, testRoad)
}

fun scenario(vehicleList: List<Vehicle>, road: RoadNetwork){
    if(road.checkForTrafficJam(road.calculateDemand(vehicleList))){
        println("All vehicles are being delayed")

    }else {
        println("No traffic jam - this is joyful driving")
    }
}