package traffic_simulation

fun main(args: Array<String>) {

    scenario(testList, testRoad)
}

fun scenario(vehicleList: List<Vehicle>, road: RoadNetwork){
    road.calculateTraffic(vehicleList)
}


val testRoad: RoadNetwork = RoadNetwork(8.0)

// Creation of sufficient cars for local testing without using CSV input for now
val BMW     : Vehicle = Vehicle(1.0)
val AUDI    : Vehicle = Vehicle(1.0)
val VOLVO   : Vehicle = Vehicle(1.0)
val VW      : Vehicle = Vehicle(1.0)
val TESLA   : Vehicle = Vehicle(1.0)
val SUZUKI  : Vehicle = Vehicle(1.0)
val HONDA   : Vehicle = Vehicle(1.0)
val FERRARI : Vehicle = Vehicle(1.0)
val PORSCHE : Vehicle = Vehicle(1.0)
val DAIHATSU: Vehicle = Vehicle(1.0)
val FORD    : Vehicle = Vehicle(1.0)
val OPEL    : Vehicle = Vehicle(1.0)

val testList : List<Vehicle> = listOf(BMW, AUDI, VOLVO, VW, TESLA, SUZUKI, HONDA, FERRARI, PORSCHE, DAIHATSU, FORD, OPEL)