package traffic_simulation

// Imports for parsing library
import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import com.univocity.parsers.csv.CsvWriter
import com.univocity.parsers.csv.CsvWriterSettings

fun main(args: Array<String>) {
    val testRoad : RoadNetwork = RoadNetwork(capacity = 20)

    //The following line simulates traffic from an intern list
    testScenarioWithInternList(testRoad)

    //The following lines simulates a complete scenario with the testRoad as road;
    // in next release (or as NP says) i want to enable feeding in road data, so a user can simulate more than the test road,
    //but can choose from a bunch of roads
    simulateCSV(testRoad)


    //The following lines are not needed, but kept here in case of restoring needs occurring
    //val vehiclesInterests : MutableList<Vehicle> = parseInputOfCSV(fileName = "driveInterest.csv")
    //val simulationResults : List<Vehicle> = testRoad.simulateInternScenarioAndPrintToConsole(vehiclesInterests)
    //for (result in simulationResults) {
    //    println("Vehicle '${result.id}' is delayed: ${result.delayed}")
   // printResultsToCSV(simulationResults, "results.csv")
}

fun testScenarioWithInternList(road: RoadNetwork) {

    // Creation of sufficient cars for local testing without using CSV input for now
    val BMW1: Vehicle = Vehicle(id = 1, wannaDrive = true)
    val BMW2: Vehicle = Vehicle(id = 2, wannaDrive = true)
    val BMW3: Vehicle = Vehicle(id = 3, wannaDrive = true)
    val BMW4: Vehicle = Vehicle(id = 4, wannaDrive = true)
    val BMW5: Vehicle = Vehicle(id = 5, wannaDrive = true)
    val BMW6: Vehicle = Vehicle(id = 6, wannaDrive = true)
    val BMW7: Vehicle = Vehicle(id = 7, wannaDrive = true)
    val BMW8: Vehicle = Vehicle(id = 8, wannaDrive = true)
    val BMW9: Vehicle = Vehicle(id = 9, wannaDrive = true)
    val BMW10: Vehicle = Vehicle(id = 10, wannaDrive = true)
    val BMW11: Vehicle = Vehicle(id = 11, wannaDrive = true)
    val BMW12: Vehicle = Vehicle(id = 12, wannaDrive = true)
    val testList: List<Vehicle> = listOf(BMW1, BMW2, BMW3, BMW4, BMW5, BMW6, BMW7, BMW8, BMW9, BMW10, BMW11, BMW12)

    road.simulateInternScenarioAndPrintToConsole(testList)
}

fun parseInputOfCSV ( fileName : String ): MutableList<Vehicle>{
    val vehicleListCSV : MutableList<Vehicle> = mutableListOf()

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

    // analyze (parse) of the csv given
    val allRows: MutableList<Record> = csvParser.parseAllRecords(reader)

    // insert the parsed information of csv-file in usable lists and use them in functions
    for (record in allRows) {
        val id_String : String = record.values[0]
        val wannaDrive_String : String = record.values[1]

        val id_Int : Int = id_String.toInt()
        val wannaDrive_Boolean : Boolean = wannaDrive_String.toBoolean()

        vehicleListCSV.add ( Vehicle(id = id_Int , wannaDrive = wannaDrive_Boolean ) )
    }
    return vehicleListCSV
}

fun printResultsToCSV(results : List<Vehicle>, outputFile :String = "results.csv") {
    val writer = FileAccess().getWriter(outputFile)

    val csvWriter = CsvWriter(writer, CsvWriterSettings())

    // Write the record headers of this file
    val vehicleRows: MutableList<Array<Any>> = mutableListOf()
    val id = "VehicleID"
    val delay = "Delayed?"
    val row: Array<Any> = arrayOf(id, delay)
    vehicleRows.add(row)

    for (result in results) {
        val id = result.id.toString()
        val delay = result.delayed.toString()
        val row: Array<Any> = arrayOf(id, delay)
        vehicleRows.add(row)
    }
    csvWriter.writeRowsAndClose(vehicleRows)
}

fun simulateCSV(road: RoadNetwork){
    val vehiclesFromCSV : List<Vehicle> = parseInputOfCSV(fileName = "driveInterest.csv")
    val capacityDemand = road.calculateDemand(vehiclesFromCSV)
    val trafficJam = road.checkForTrafficJam(capacityDemand)

    if(trafficJam){
        for (vehicle in vehiclesFromCSV)
            vehicle.gettingDelayed()
    }
    printResultsToCSV(vehiclesFromCSV)
}
