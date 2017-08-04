package traffic_simulation

// Imports for parsing library
import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings

fun main(args: Array<String>) {

    val testRoad : RoadNetwork = RoadNetwork(capacity = 8.0)

    val driveInterest : MutableList<Car> = parseInputOfCSV(fileName = "driveInterest.csv")



   // scenario(testList, testRoad)
}

fun scenario(vehicleList: List<Car>, road: RoadNetwork){
    road.calculateTraffic(vehicleList)
}

// Creation of sufficient cars for local testing without using CSV input for now
val BMW1: Car = Car (id = 1 , wannaDrive = true )
val BMW2 : Car = Car (id = 2 , wannaDrive = true )
val BMW3 : Car = Car (id = 3 , wannaDrive = true )
val BMW4 : Car = Car (id = 4 , wannaDrive = true )
val BMW5 : Car = Car (id = 5 , wannaDrive = true )
val BMW6 : Car = Car (id = 6 , wannaDrive = true )
val BMW7 : Car = Car (id = 7 , wannaDrive = true )
val BMW8 : Car = Car (id = 8 , wannaDrive = true )
val BMW9 : Car = Car (id = 9 , wannaDrive = true )
val BMW10 : Car = Car (id = 10 , wannaDrive = true )
val BMW11 : Car = Car (id = 11 , wannaDrive = true )
val BMW12 : Car = Car (id = 12 , wannaDrive = true )
val testList : List<Car> = listOf(BMW1, BMW2, BMW3, BMW4, BMW5, BMW6, BMW7, BMW8, BMW9, BMW10, BMW11, BMW12)



fun parseInputOfCSV ( fileName : String ): MutableList<Car>{

    val driveInterest : MutableList<Car> = mutableListOf()

    // The information of vehicles and their interest to drive is given in a csv-file
    // Therefore we use a library to parse

    // Setup of the parsing like symbol of separation etc.
    // in this case mostly the default settings so just a few things have to be set
    val settings = CsvParserSettings()
    settings.format.setLineSeparator("\n")
    settings.isHeaderExtractionEnabled = true
    // this is to make the parser ignoring the first line in the csv-file

    // creating a parser with the former made settings
    val csvParser = CsvParser(settings)

    // reading of the csv-file
    val reader = FileAccess().getReader("/" + fileName)

    // analyze (parse) of the readed csv
    val allRows: MutableList<Record> = csvParser.parseAllRecords(reader)

    // insert the parsed information of csv-file in usable lists and use them in functions
    for (record in allRows) {

        val id_String : String = record.values.get(0)
        val wannaDrive_String : String = record.values.get(1)

        val id_Int : Int = id_String.toInt()
        val wannaDrive_Boolean : Boolean = wannaDrive_String.toBoolean()

        driveInterest.add ( Car(id = id_Int , wannaDrive = wannaDrive_Boolean ) )

    }

    return driveInterest
}