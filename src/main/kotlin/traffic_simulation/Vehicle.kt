package traffic_simulation

class Vehicle(val ID :Int,
              var wannaDrive : Boolean,
              val capacityFactor :Double,
              var delayed :Boolean){
    //Methods to be added here soon

}

// Creation of sufficient cars for local testing without using CSV input for now
val BMW     : Vehicle = Vehicle(1  ,true,1.0,false)
val AUDI    : Vehicle = Vehicle(2  ,true,1.0,false)
val VOLVO   : Vehicle = Vehicle(3  ,true,1.0,false)
val VW      : Vehicle = Vehicle(4  ,true,1.0,false)
val TESLA   : Vehicle = Vehicle(5  ,true,1.0,false)
val SUZUKI  : Vehicle = Vehicle(6  ,true,1.0,false)
val HONDA   : Vehicle = Vehicle(7  ,true,1.0,false)
val FERRARI : Vehicle = Vehicle(8  ,true,1.0,false)
val PORSCHE : Vehicle = Vehicle(9  ,true,1.0,false)
val DAIHATSU: Vehicle = Vehicle(10 ,true,1.0,false)
val FORD    : Vehicle = Vehicle(11 ,true,1.0,false)
val OPEL    : Vehicle = Vehicle(12 ,true,1.0,false)

val testList : List<Vehicle> = listOf(BMW, AUDI, VOLVO, VW, TESLA, SUZUKI, HONDA, FERRARI, PORSCHE, DAIHATSU, FORD, OPEL)