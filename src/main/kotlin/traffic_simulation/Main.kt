package traffic_simulation

// Imports for parsing library
import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import java.io.*

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


// This class is needet for parsing
class FileAccess {

        fun getReader(path: String):Reader {
                return InputStreamReader(this.javaClass.getResourceAsStream(path), "UTF-8")
            }
    
    /*    fun getWriter(path: String): Writer {
        val file = File(path)
        return FileWriter(file)
    }*/
    }