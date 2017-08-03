package traffic_simulation

class vehicle(val ID :Int,
              var wannaDrive : Boolean,
              val capacityFactor :Double,
              var delayed :Boolean){
    //Methods to be added here soon

}

// Creation of sufficient cars for local testing without using CSV input for now
val BMW     : vehicle = vehicle(1  ,true,1.0,false)
val AUDI    : vehicle = vehicle(2  ,true,1.0,false)
val VOLVO   : vehicle = vehicle(3  ,true,1.0,false)
val VW      : vehicle = vehicle(4  ,true,1.0,false)
val TESLA   : vehicle = vehicle(5  ,true,1.0,false)
val SUZUKI  : vehicle = vehicle(6  ,true,1.0,false)
val HONDA   : vehicle = vehicle(7  ,true,1.0,false)
val FERRARI : vehicle = vehicle(8  ,true,1.0,false)
val PORSCHE : vehicle = vehicle(9  ,true,1.0,false)
val DAIHATSU: vehicle = vehicle(10 ,true,1.0,false)
val FORD    : vehicle = vehicle(11 ,true,1.0,false)
val OPEL    : vehicle = vehicle(12 ,true,1.0,false)

val testList : MutableList<vehicle> = mutableListOf(BMW, AUDI, VOLVO, VW, TESLA, SUZUKI, HONDA, FERRARI, PORSCHE, DAIHATSU, FORD, OPEL)