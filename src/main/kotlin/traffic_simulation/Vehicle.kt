package traffic_simulation

import java.util.*


interface Vehicle {

    val gotNewDelayInHours: List<Int>
    val droveWithoutNewDelayInHours: List<Int>
    val capacityFactor: Int


    fun getClass(): String
    fun getID(): Int
    fun vehicleWantsToDriveAt(timestep: Int): Boolean
    fun getDelayedAtHour(timestep: Int)
    fun driveAtHour(timestep: Int)
    fun randomDelayByCapacityAndDemand(demandX: Int, capacity: Int): Boolean
}

class Car(val id: Int, val wannaDriveInHours: MutableList<Int>) : Vehicle {
    override val capacityFactor = 10
    override val gotNewDelayInHours: MutableList<Int> = mutableListOf()
    override val droveWithoutNewDelayInHours: MutableList<Int> = mutableListOf()
    var lagTillDestination = 0

    override fun getClass(): String {
        return "Car"
    }

    override fun getID(): Int {
        return id
    }

    override fun vehicleWantsToDriveAt(timestep: Int): Boolean {
        // the vehicle wants to drive if its drive plan says so
        // or if it got previously delayed
        return wannaDriveInHours.contains(timestep) || lagTillDestination > 0
    }

    override fun getDelayedAtHour(timestep: Int) {
        // if the vehicle wanted to drive, its lagTillDestination increased
        // (otherwise it just waited an hour, not reducing its lagTillDestination)
        if (wannaDriveInHours.contains(timestep)) {
            lagTillDestination += 1
            this.gotNewDelayInHours.add(timestep)
            this.gotNewDelayInHours.sort()
        }
    }

    override fun driveAtHour(timestep: Int) {
        // if the vehicle wanted to drive, it is still as delayed as before
        // (otherwise it just gained an hour, thus reducing lagTillDestination)
        if (!wannaDriveInHours.contains(timestep)) {
            lagTillDestination -= 1
        }

        this.droveWithoutNewDelayInHours.add(timestep)
        this.droveWithoutNewDelayInHours.sort()
    }

    override fun randomDelayByCapacityAndDemand(demandX: Int, capacity: Int): Boolean {
        var probabilityOfDelay: Int = 0
        val percentOfCapacityUsage_Double: Double = (demandX.toDouble() / capacity.toDouble()) * 100
        val percentOfCapacityUsage: Int = percentOfCapacityUsage_Double.toInt()
        when (percentOfCapacityUsage) {
            in 0..49 -> probabilityOfDelay = 5
            in 50..69 -> probabilityOfDelay = 10
            in 70..89 -> probabilityOfDelay = 20
            in 90..109 -> probabilityOfDelay = 30
            in 110..124 -> probabilityOfDelay = 50
            in 125..149 -> probabilityOfDelay = 70
            in 150..Int.MAX_VALUE -> probabilityOfDelay = 90
        }
        if (capacity == 0) {
            probabilityOfDelay = 100
        }
        val delayed: Boolean = Random().nextInt(100) + 1 <= probabilityOfDelay
        return delayed
    }

}

class Tram(val id: Int, val wannaDriveInHours: MutableList<Int>) : Vehicle {
    override val capacityFactor = 50
    override val gotNewDelayInHours: MutableList<Int> = mutableListOf()
    override val droveWithoutNewDelayInHours: MutableList<Int> = mutableListOf()
    var lagTillDestination = 0

    override fun getClass(): String {
        return "Tram"
    }

    override fun getID(): Int {
        return id
    }

    override fun vehicleWantsToDriveAt(timestep: Int): Boolean {
        // the vehicle wants to drive if its drive plan says so
        // or if it got previously delayed
        return wannaDriveInHours.contains(timestep) || lagTillDestination > 0
    }

    override fun getDelayedAtHour(timestep: Int) {
        // if the vehicle wanted to drive, its lagTillDestination increased
        // (otherwise it just waited an hour, not reducing its lagTillDestination)
        if (wannaDriveInHours.contains(timestep)) {
            lagTillDestination += 1
            this.gotNewDelayInHours.add(timestep)
            this.gotNewDelayInHours.sort()
        }
    }

    override fun driveAtHour(timestep: Int) {
        // if the vehicle wanted to drive, it is still as delayed as before
        // (otherwise it just gained an hour, thus reducing lagTillDestination)
        if (!wannaDriveInHours.contains(timestep)) {
            lagTillDestination -= 1
        }

        this.droveWithoutNewDelayInHours.add(timestep)
        this.droveWithoutNewDelayInHours.sort()

    }

    override fun randomDelayByCapacityAndDemand(demandX: Int, capacity: Int): Boolean {
        var probabilityOfDelayInTwoHundred: Int = 0
        val percentOfCapacityUsage_Double: Double = (demandX.toDouble() / capacity.toDouble()) * 100
        val percentOfCapacityUsage: Int = percentOfCapacityUsage_Double.toInt()
        when (percentOfCapacityUsage) {
            in 0..49 -> probabilityOfDelayInTwoHundred = 5
            in 50..69 -> probabilityOfDelayInTwoHundred = 10
            in 70..89 -> probabilityOfDelayInTwoHundred = 20
            in 90..109 -> probabilityOfDelayInTwoHundred = 30
            in 110..124 -> probabilityOfDelayInTwoHundred = 50
            in 125..149 -> probabilityOfDelayInTwoHundred = 70
            in 150..Int.MAX_VALUE -> probabilityOfDelayInTwoHundred = 90
        }
        if (capacity == 0) {
            probabilityOfDelayInTwoHundred = 200
        }
        val delayed: Boolean = Random().nextInt(200) + 1 <= probabilityOfDelayInTwoHundred
        return delayed
    }

}

class Truck(val id: Int, val wannaDriveInHours: MutableList<Int>) : Vehicle {
    override val capacityFactor = 30
    override val gotNewDelayInHours: MutableList<Int> = mutableListOf()
    override val droveWithoutNewDelayInHours: MutableList<Int> = mutableListOf()
    var lagTillDestination = 0

    override fun getClass(): String {
        return "Truck"
    }

    override fun getID(): Int {
        return id
    }

    override fun vehicleWantsToDriveAt(timestep: Int): Boolean {
        // the vehicle wants to drive if its drive plan says so
        // or if it got previously delayed
        return wannaDriveInHours.contains(timestep) || lagTillDestination > 0
    }

    override fun getDelayedAtHour(timestep: Int) {
        // if the vehicle wanted to drive, its lagTillDestination increased
        // (otherwise it just waited an hour, not reducing its lagTillDestination)
        if (wannaDriveInHours.contains(timestep)) {
            lagTillDestination += 1
            this.gotNewDelayInHours.add(timestep)
            this.gotNewDelayInHours.sort()
        }
    }

    override fun driveAtHour(timestep: Int) {
        // if the vehicle wanted to drive, it is still as delayed as before
        // (otherwise it just gained an hour, thus reducing lagTillDestination)
        if (!wannaDriveInHours.contains(timestep)) {
            lagTillDestination -= 1
        }

        this.droveWithoutNewDelayInHours.add(timestep)
        this.droveWithoutNewDelayInHours.sort()

    }

    override fun randomDelayByCapacityAndDemand(demandX: Int, capacity: Int): Boolean {
        var probabilityOfDelay: Int = 0
        val percentOfCapacityUsage_Double: Double = (demandX.toDouble() / capacity.toDouble()) * 100
        val percentOfCapacityUsage: Int = percentOfCapacityUsage_Double.toInt()
        when (percentOfCapacityUsage) {
            in 0..49 -> probabilityOfDelay = 10
            in 50..69 -> probabilityOfDelay = 15
            in 70..89 -> probabilityOfDelay = 25
            in 90..109 -> probabilityOfDelay = 35
            in 110..124 -> probabilityOfDelay = 55
            in 125..149 -> probabilityOfDelay = 75
            in 150..Int.MAX_VALUE -> probabilityOfDelay = 95
        }
        if (capacity == 0) {
            probabilityOfDelay = 100
        }
        val delayed: Boolean = Random().nextInt(100) + 1 <= probabilityOfDelay
        return delayed
    }

}

class Bike(val id: Int, val wannaDriveInHours: MutableList<Int>) : Vehicle {
    override val capacityFactor = 1
    override val gotNewDelayInHours: MutableList<Int> = mutableListOf()
    override val droveWithoutNewDelayInHours: MutableList<Int> = mutableListOf()
    var lagTillDestination = 0

    override fun getClass(): String {
        return "Bike"
    }

    override fun getID(): Int {
        return id
    }

    override fun vehicleWantsToDriveAt(timestep: Int): Boolean {
        // the vehicle wants to drive if its drive plan says so
        // or if it got previously delayed
        return wannaDriveInHours.contains(timestep) || lagTillDestination > 0
    }

    override fun getDelayedAtHour(timestep: Int) {
        // if the vehicle wanted to drive, its lagTillDestination increased
        // (otherwise it just waited an hour, not reducing its lagTillDestination)
        if (wannaDriveInHours.contains(timestep)) {
            lagTillDestination += 1
            this.gotNewDelayInHours.add(timestep)
            this.gotNewDelayInHours.sort()
        }
    }

    override fun driveAtHour(timestep: Int) {
        // if the vehicle wanted to drive, it is still as delayed as before
        // (otherwise it just gained an hour, thus reducing lagTillDestination)
        if (!wannaDriveInHours.contains(timestep)) {
            lagTillDestination -= 1
        }

        this.droveWithoutNewDelayInHours.add(timestep)
        this.droveWithoutNewDelayInHours.sort()

    }

    override fun randomDelayByCapacityAndDemand(demandX: Int, capacity: Int): Boolean {
        var probabilityOfDelay: Int = 0
        val percentOfCapacityUsage_Double: Double = (demandX.toDouble() / capacity.toDouble()) * 100
        val percentOfCapacityUsage: Int = percentOfCapacityUsage_Double.toInt()
        when (percentOfCapacityUsage) {
            in 0..149 -> probabilityOfDelay = 5
            in 150..Int.MAX_VALUE -> probabilityOfDelay = 10
        }
        if (capacity == 0) {
            probabilityOfDelay = 100
        }
        val delayed: Boolean = Random().nextInt(100) + 1 <= probabilityOfDelay
        return delayed
    }
}
