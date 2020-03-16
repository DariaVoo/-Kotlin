package lab2

data class Passenger(val id: Long, val name: String, var money: Long, val age: Int)
data class Driver(val id: Long, val name: String, var license: String)

class Transport (
    val passengers: MutableList<Passenger>?, val driver: Driver?,
    var countPassenger: Int = 0, var babySeat: Boolean? = false) {

    fun printTransport() {
        println("Водитель: ${driver!!.name}\t${driver.license}")
        println("Наличие детского кресла: ${babySeat}")
        if (passengers != null)
            for (p in passengers)
                println("${p.name} money: ${p.money} age: ${p.age}")
    }

    open class Builder(
        private var passengers: MutableList<Passenger>? = null,
        private var driver: Driver?,
        private var countPassenger: Int = 0,
        private var babySeat: Boolean? = false,
        var drivers: MutableList<Driver>,
        var allPassengers: MutableList<Passenger>) {

        fun buildBus(
            ) : MutableList<Transport>? {
            val busBuilder = BusBuilder(drivers, allPassengers)
            val cars = busBuilder.boardDrivers()

            if (cars == null) {
                println("!!! No bus drivers")
                return null
            }

            busBuilder.boardPassengers(cars)
            for (car in cars) {
                if (car.countPassenger == 0)
                    cars.remove(car)
            }

            if (cars.isEmpty()) {
                println("!!! No bus passengers.")
                return null
            }
            return cars
        }

        fun buildTaxi() : MutableList<Transport>? {
            val taxiBuilder = TaxiBuilder(drivers, allPassengers)
            val cars = taxiBuilder.boardDrivers()

            if (cars == null) {
                println("!!! No taxi drivers")
                return null
            }
            taxiBuilder.boardPassengers(cars)
            for (car in cars) {
                if (car.countPassenger == 0)
                    cars.remove(car)
            }
            if (cars.isEmpty()) {
                println("!!! No taxi passengers.")
                return null
            }
            return cars
        }

        open fun boardPassengers(transports: MutableList<Transport>): MutableList<Transport>? = null
        open fun boardDrivers(): MutableList<Transport>? = null
    }
}



class BusBuilder(allDrivers: MutableList<Driver>, var passengers: MutableList<Passenger>):
        Transport.Builder(null, null, 0, null, allDrivers, passengers) {
    override fun boardPassengers(transports: MutableList<Transport>): MutableList<Transport>? {
        var buf: Passenger
        for (car in transports) {
            for (p in passengers) {
                if (p.money <= 100) {

                    if (car.passengers != null) {
                        buf = p.copy()
                        when (p.age) {
                            in 0..7     -> buf.money -= 0
                            in 8..23    -> buf.money -= 8
                            else        -> buf.money -= 10
                        }
                        car.passengers.add(buf)
                        car.countPassenger++
                    }
                    else
                        println("list if passengers is null!")
                }
                if (car.countPassenger == 30)
                    break
            }
        }
        return transports
    }

    override fun boardDrivers(): MutableList<Transport>? {
        drivers.sortBy { it.license}
        val cars: MutableList<Transport> =  mutableListOf<Transport>()

        for (driver in drivers) {
            if (driver.license.toLowerCase() == "bus") {
                println("Bus driver is found")
                cars.add(Transport(mutableListOf<Passenger>(), driver))
            }
        }
        return cars
    }
}

class TaxiBuilder(allDrivers: MutableList<Driver>,var passengers: MutableList<Passenger>):
    Transport.Builder(null, null, 0, null,  allDrivers, passengers) {
    override fun boardPassengers(
        transports: MutableList<Transport>): MutableList<Transport>? {
        var buf: Passenger
        for (car in transports) {
            for (p in passengers) {
                if (p.money > 100) {
                    buf = p.copy()
                    when (p.age) {
                        in 0..7     -> car.babySeat = true
                        else        -> buf.money -= 100
                    }
                    if (car.passengers != null) {
                        car.passengers.add(buf)
                        car.countPassenger++
                    }
                    else
                        println("list if passengers is null!")
                }
                if (car.countPassenger == 30)
                    break
            }
        }
        return transports
    }

    override fun boardDrivers(): MutableList<Transport>? {
        drivers.sortBy { it.license}
        val cars: MutableList<Transport> =  mutableListOf<Transport>()

        for (driver in drivers) {
            if (driver.license.toLowerCase() == "taxi") {
                println("Taxi driver is found")
                cars.add(Transport(mutableListOf<Passenger>(), driver))
            }
        }
        return cars
    }
}