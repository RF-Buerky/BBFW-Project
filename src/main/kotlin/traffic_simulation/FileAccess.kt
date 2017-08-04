package traffic_simulation

import java.io.InputStreamReader
import java.io.Reader

/**
 * This class is just for parsing
 */

class FileAccess {

    fun getReader(path: String): Reader {
        return InputStreamReader(this.javaClass.getResourceAsStream(path), "UTF-8")
    }

    /*    fun getWriter(path: String): Writer {
        val file = File(path)
        return FileWriter(file)
    }*/
}