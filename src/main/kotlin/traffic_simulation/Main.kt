package traffic_simulation

// Imports for parsing library
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings

fun main (args: Array<String>){


    // The information of vehicles, their
    // Setup of the parsing like symbol of separation etc.
    // in this case mostly the default settings so just a few things have to be set
    val settings = CsvParserSettings()
    settings.format.setLineSeparator("\n")
    settings.isHeaderExtractionEnable = true
        // this is to make the parser ignoring the first line in the csv-file

    // creating a parser with the former made settings
    val csvParser = CsvParser(settings)

    // reading of the csv-file
    val reader = FileAccess().getReader("/driveInterest.csv")

    // analyze (parse) of the readed csv
    val allRows: MutableList<Record> = csvParser.parseAllRecords(reader)

    for (record in allRows){
        println(record)
    }
}
