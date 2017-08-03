package traffic_simulation

// Import for parsing library
import com.univocity.parsers.CsvParser
import com.univocity.parsers.csv.CsvParserSettings

fun main (args: Array<String>){


    // The information of vehicles, their 
    // Setup of the parsing like symbol of separation etc.
    // in this case mostly the default settings so just a few things have to be set
    val settings = CsvParserSettings()
    settings.format.setLineSeparator("\n")
    settings.isHeaderExtractionEnable = true
        // this is to make the parser ignoring the first line in the csv-file


}
