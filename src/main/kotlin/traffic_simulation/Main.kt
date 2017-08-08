package traffic_simulation

// Imports for parsing library
import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import com.univocity.parsers.csv.CsvWriter
import com.univocity.parsers.csv.CsvWriterSettings

fun main(args: Array<String>) {
    //The following line simulates traffic from an intern list and prints it to console

    testScenarioWithInternList()

    //The following lines simulates a complete scenario and prints into results.csv;
    // in next release (or as NP says) i want to enable feeding in road data, so a user can simulate more than the test road,
    //but can choose from a bunch of roads
    simulateCSV()
}

fun testScenarioWithInternList() {
    val road: RoadNetwork = RoadNetwork(capacity = 7)
    // Creation of sufficient cars for local testing without using CSV input for now
    val BMW1: Vehicle = Vehicle(id = 1, wannaDriveInHours = mutableListOf(1,2,3,4,5,6,7,8,9,10,16,17,18,19,20,21,22,23,24))
    val BMW2: Vehicle = Vehicle(id = 2, wannaDriveInHours = mutableListOf(1,2,3,4,5,6,7,8,9,10,15,19,20,21,22,23,24))
    val BMW3: Vehicle = Vehicle(id = 3, wannaDriveInHours = mutableListOf(3,5,6,7,8,9,10,11,12,13,14))
    val BMW4: Vehicle = Vehicle(id = 4, wannaDriveInHours = mutableListOf(3,5,6,7,8,9,10,11,12,13,14,15,16,17))
    val BMW5: Vehicle = Vehicle(id = 5, wannaDriveInHours = mutableListOf(3,7,8,11,12,19,20,23,24))
    val BMW6: Vehicle = Vehicle(id = 6, wannaDriveInHours = mutableListOf(1,2,3,4,12,13,14,15,16,17,18,19,20,21))
    val BMW7: Vehicle = Vehicle(id = 7, wannaDriveInHours = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,22,23,24))
    val BMW8: Vehicle = Vehicle(id = 8, wannaDriveInHours = mutableListOf(1,2,3,4,5,6,7,8,9,13,14,15,16,17,18,19,20,21,22,23,24))
    val BMW9: Vehicle = Vehicle(id = 9, wannaDriveInHours = mutableListOf(3,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24))
    val BMW10: Vehicle = Vehicle(id = 10, wannaDriveInHours = mutableListOf(3,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24))
    val BMW11: Vehicle = Vehicle(id = 11, wannaDriveInHours = mutableListOf(1,2,3,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24))
    val BMW12: Vehicle = Vehicle(id = 12, wannaDriveInHours = mutableListOf(1,2,3,4,11,12,13,14,15,19,20,21,22,23,24))
    val testList: List<Vehicle> = listOf(BMW1, BMW2, BMW3, BMW4, BMW5, BMW6, BMW7, BMW8, BMW9, BMW10, BMW11, BMW12)

    for (vehicle in road.simulateScenario(testList)) {
        println("Vehicle '${vehicle.id}' is delayed: ${vehicle.delayedInHours}")
    }
}

fun parseInputOfCSV(fileName: String): MutableList<Vehicle> {
    val vehicleListCSV: MutableList<Vehicle> = mutableListOf()

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
        val id_String: String = record.values[0]
        val wannaDrive_String: String = record.values[1]

        val id_Int: Int = id_String.toInt()
        val wannaDrive_List: MutableList<Int> = mutableListOf()

        val separator : Char = '/'
        val splittedWannaDrive : List<String> = wannaDrive_String.split(separator)

        for (hour in splittedWannaDrive){
            val newHour_Int : Int = hour.toInt()
            wannaDrive_List.add(newHour_Int)
        }

        wannaDrive_List.sort()
        vehicleListCSV.add(Vehicle(id = id_Int, wannaDriveInHours = wannaDrive_List))
    }
    return vehicleListCSV
}

fun printResultsToCSV(results: List<Vehicle>, outputFile: String = "results.csv") {
    val writer = FileAccess().getWriter(outputFile)

    val csvWriter = CsvWriter(writer, CsvWriterSettings())

    // Write the record headers of this file
    val vehicleRows: MutableList<Array<Any>> = mutableListOf()
    val id = "VehicleID"
    val delay = "Delayed in hours"
    val row: Array<Any> = arrayOf(id, delay)
    vehicleRows.add(row)

    for (result in results) {
        val id = result.id.toString()
        val delay = result.delayedInHours.toString()
        val row: Array<Any> = arrayOf(id, delay)
        vehicleRows.add(row)
    }
    csvWriter.writeRowsAndClose(vehicleRows)
}

fun simulateCSV() {
    val road: RoadNetwork = RoadNetwork(capacity = 7)
    val vehiclesFromCSV: List<Vehicle> = parseInputOfCSV(fileName = "driveInterest.csv")

    printResultsToCSV(road.simulateScenario(vehiclesFromCSV))
}
