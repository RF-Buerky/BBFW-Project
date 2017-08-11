package traffic_simulation

import java.util.*

//<<<<<<< HEAD
/*class Vehicle(val id: Int, val wannaDriveInHours: MutableList<Int>) {
    val capacityFactor : Int = 1
    val gotNewDelayInHours: MutableList<Int> = mutableListOf()
    val droveWithoutNewDelayInHours: MutableList<Int> = mutableListOf()
    var delay = 0 */
//=======
interface Vehicle {

    val gotNewDelayInHours: MutableList<Int>
    val droveWithoutNewDelayInHours: MutableList<Int>
    var delay: Int
//>>>>>>> 0e32e30412264812adbead12cf8a64195d89da89

    fun getClass(): String
    fun getID(): Int
    fun vehicleWantsToDriveAt(timestep: Int): Boolean
    fun getDelayedAtHour(timestep: Int)
    fun driveAtHour(timestep: Int)
    fun randomDelayByCapacityAndDemand(demandX: Int, capacity: Int): Boolean
    fun getCapacityFactor():Int //given capacities have been multiplied by 10 to continue with the use of Integers, relative scales remain the same
}

class Car(val id: Int, val wannaDriveInHours: MutableList<Int>) : Vehicle {
    override fun getCapacityFactor(): Int {
        val capacityFactor = 10
        return capacityFactor
    }

    override val gotNewDelayInHours: MutableList<Int> = mutableListOf()
    override val droveWithoutNewDelayInHours: MutableList<Int> = mutableListOf()
    override var delay = 0

    override fun getClass(): String {
        return "Car"
    }

    override fun getID(): Int {
        return id
    }

    override fun vehicleWantsToDriveAt(timestep: Int): Boolean {
        // the vehicle wants to drive if its drive plan says so
        // or if it got previously delayed
        return wannaDriveInHours.contains(timestep) || delay > 0
    }

    override fun getDelayedAtHour(timestep: Int) {
        // if the vehicle wanted to drive, its delay increased
        // (otherwise it just waited an hour, not reducing its delay)
        if (wannaDriveInHours.contains(timestep)) {
            delay += 1
            this.gotNewDelayInHours.add(timestep)
            this.gotNewDelayInHours.sort()
        }
    }

    override fun driveAtHour(timestep: Int) {
        // if the vehicle wanted to drive, it is still as delayed as before
        // (otherwise it just gained an hour, thus reducing delay)
        if (!wannaDriveInHours.contains(timestep)) {
            delay -= 1
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
    override fun getCapacityFactor(): Int {
        val capacityFactor = 50
        return capacityFactor
    }

    override val gotNewDelayInHours: MutableList<Int> = mutableListOf()
    override val droveWithoutNewDelayInHours: MutableList<Int> = mutableListOf()
    override var delay = 0

    override fun getClass(): String {
        return "Tram"
    }

    override fun getID(): Int {
        return id
    }

    override fun vehicleWantsToDriveAt(timestep: Int): Boolean {
        // the vehicle wants to drive if its drive plan says so
        // or if it got previously delayed
        return wannaDriveInHours.contains(timestep) || delay > 0
    }

    override fun getDelayedAtHour(timestep: Int) {
        // if the vehicle wanted to drive, its delay increased
        // (otherwise it just waited an hour, not reducing its delay)
        if (wannaDriveInHours.contains(timestep)) {
            delay += 1
            this.gotNewDelayInHours.add(timestep)
            this.gotNewDelayInHours.sort()
        }
    }

    override fun driveAtHour(timestep: Int) {
        // if the vehicle wanted to drive, it is still as delayed as before
        // (otherwise it just gained an hour, thus reducing delay)
        if (!wannaDriveInHours.contains(timestep)) {
            delay -= 1
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

class Truck(val id: Int, val wannaDriveInHours: MutableList<Int>) : Vehicle {
    override fun getCapacityFactor(): Int {
        val capacityFactor = 30
        return capacityFactor
    }

    override val gotNewDelayInHours: MutableList<Int> = mutableListOf()
    override val droveWithoutNewDelayInHours: MutableList<Int> = mutableListOf()
    override var delay = 0

    override fun getClass(): String {
        return "Truck"
    }

    override fun getID(): Int {
        return id
    }

    override fun vehicleWantsToDriveAt(timestep: Int): Boolean {
        // the vehicle wants to drive if its drive plan says so
        // or if it got previously delayed
        return wannaDriveInHours.contains(timestep) || delay > 0
    }

    override fun getDelayedAtHour(timestep: Int) {
        // if the vehicle wanted to drive, its delay increased
        // (otherwise it just waited an hour, not reducing its delay)
        if (wannaDriveInHours.contains(timestep)) {
            delay += 1
            this.gotNewDelayInHours.add(timestep)
            this.gotNewDelayInHours.sort()
        }
    }

    override fun driveAtHour(timestep: Int) {
        // if the vehicle wanted to drive, it is still as delayed as before
        // (otherwise it just gained an hour, thus reducing delay)
        if (!wannaDriveInHours.contains(timestep)) {
            delay -= 1
        }

        this.droveWithoutNewDelayInHours.add(timestep)
        this.droveWithoutNewDelayInHours.sort()

    }

    override fun randomDelayByCapacityAndDemand(demandX: Int, capacity: Int): Boolean {
        var probabilityOfDelay: Int = 0
        val percentOfCapacityUsage_Double: Double = (demandX.toDouble() / capacity.toDouble()) * 100
        val percentOfCapacityUsage: Int = percentOfCapacityUsage_Double.toInt()
        when (percentOfCapacityUsage) {
            !in 0..Int.MAX_VALUE -> println("Weird capacity!")
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

class Bike(val id: Int, val wannaDriveInHours: MutableList<Int>) : Vehicle {
    override fun getCapacityFactor(): Int {
        val capacityFactor = 1
        return capacityFactor
    }

    override val gotNewDelayInHours: MutableList<Int> = mutableListOf()
    override val droveWithoutNewDelayInHours: MutableList<Int> = mutableListOf()
    override var delay = 0

    override fun getClass(): String {
        return "Bike"
    }

    override fun getID(): Int {
        return id
    }

    override fun vehicleWantsToDriveAt(timestep: Int): Boolean {
        // the vehicle wants to drive if its drive plan says so
        // or if it got previously delayed
        return wannaDriveInHours.contains(timestep) || delay > 0
    }

    override fun getDelayedAtHour(timestep: Int) {
        // if the vehicle wanted to drive, its delay increased
        // (otherwise it just waited an hour, not reducing its delay)
        if (wannaDriveInHours.contains(timestep)) {
            delay += 1
            this.gotNewDelayInHours.add(timestep)
            this.gotNewDelayInHours.sort()
        }
    }

    override fun driveAtHour(timestep: Int) {
        // if the vehicle wanted to drive, it is still as delayed as before
        // (otherwise it just gained an hour, thus reducing delay)
        if (!wannaDriveInHours.contains(timestep)) {
            delay -= 1
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
