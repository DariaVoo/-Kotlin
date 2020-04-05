package lab2

data class Passenger(val id: Long, val name: String, var money: Long, val age: Int)
data class Driver(val id: Long, val name: String, var license: String)

class Transport (
    val passengers: MutableList<Passenger>?, val driver: Driver?,
    val sailors: MutableList<Driver>?,
    var countPassenger: Int = 0, var babySeat: Boolean? = false) {

    fun printTransport() {
        println("Водитель: ${driver!!.name}\t${driver.license}")
        println("Наличие детского кресла: ${babySeat}")
        if (passengers != null)
            for (p in passengers)
                println("${p.name} money: ${p.money} age: ${p.age}")
    }

    fun printTransport_Ship() {
        println("Водитель: ${driver!!.name}\t${driver.license}")
        if (passengers != null) {
            for (p in passengers)
                println("${p.name} money: ${p.money} age: ${p.age}")
            if (sailors != null)
                for (s in sailors)
                    println("${s.license}\t${s.name}")
        }
    }

    open class Builder(
        private var passengers: MutableList<Passenger>? = null, private var driver: Driver? = null,
        private var countPassenger: Int = 0, private var babySeat: Boolean? = false,
        var drivers: MutableList<Driver>, var sailors: MutableList<Driver>? = null,
        var allPassengers: MutableList<Passenger>) {

        fun buildShip() : MutableList<Transport>? {
            val shipBuilder = ShipBuilder(drivers, allPassengers)

            val ships = shipBuilder.boardDrivers()
            if (ships.isNullOrEmpty()) {
                println("!!! No ship captain")
                return null
            }
            shipBuilder.boardSailor(ships)
            //Удаляем суда без матросов
            ships.removeIf{ i -> i !=null && i.sailors!!.isEmpty()}
            if (ships.isEmpty()) {
                println("!!! No sailors")
                return null
            }

            shipBuilder.boardPassengers(ships)
            //Удаляем суда без пассажиров
            ships.removeIf{ i -> i !=null && i.passengers!!.isEmpty()}
            if (ships.isEmpty()) {
                println("!!! No ship passengers.")
                return null
            }
            return ships
        }

        fun buildBus() : MutableList<Transport>? {
            val busBuilder = BusBuilder(drivers, allPassengers)
            val cars = busBuilder.boardDrivers()

            if (cars.isNullOrEmpty()) {
                println("!!! No bus drivers")
                return null
            }

            busBuilder.boardPassengers(cars)
            cars.removeIf { it -> it.passengers != null && it.passengers.isEmpty()}
            if (cars.isEmpty()) {
                println("!!! No bus passengers")
                return null
            }

            return cars
        }

        fun buildTaxi() : MutableList<Transport>? {
            val taxiBuilder = TaxiBuilder(drivers, allPassengers)
            val cars = taxiBuilder.boardDrivers()

            if (cars.isNullOrEmpty()) {
                println("!!! No taxi drivers")
                return null
            }
            taxiBuilder.boardPassengers(cars)
            cars.removeIf { it -> it.passengers != null && it.passengers.isEmpty()}
            if (cars.isEmpty()) {
                println("!!! No bus passengers")
                return null
            }
            taxiBuilder.setBabySeat(cars)
            return cars
        }

        open fun boardPassengers(transports: MutableList<Transport>): MutableList<Transport>? = null
        open fun boardDrivers(): MutableList<Transport>? = null
        open fun setBabySeat(transports: MutableList<Transport>): MutableList<Transport>? = null
        open fun boardSailor(transports: MutableList<Transport>): MutableList<Transport>? = null
    }
}

class ShipBuilder(allDrivers: MutableList<Driver>, var passengers: MutableList<Passenger>):
    Transport.Builder(drivers = allDrivers, allPassengers = passengers) {
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
        val ships: MutableList<Transport> =  mutableListOf<Transport>()

        for (captain in drivers) {
            if (captain.license.toLowerCase() == "ship") {
                println("Ship driver is found")
                ships.add(Transport(mutableListOf<Passenger>(), captain, mutableListOf<Driver>()))
            }
        }
        return ships
    }

    override fun boardSailor(transports: MutableList<Transport>): MutableList<Transport>? {
        var buf: Driver
        for (ship in transports) {
            for (d in drivers) {
                if (d.license.toLowerCase() == "sailor") {
                    buf = d.copy()
                    if (ship.sailors != null) {
                        ship.sailors.add(buf)
                        if (ship.sailors.count() == 15)
                            break
                    }
                    else
                        println("list if sailors is null!")
                }
            }
        }
        return transports
    }
}

class BusBuilder(allDrivers: MutableList<Driver>, var passengers: MutableList<Passenger>):
    Transport.Builder(drivers = allDrivers, allPassengers = passengers) {
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
                cars.add(Transport(passengers = mutableListOf<Passenger>(), driver = driver,
                    sailors = mutableListOf<Driver>()
                ))
            }
        }
        return cars
    }
}


class TaxiBuilder(allDrivers: MutableList<Driver>,var passengers: MutableList<Passenger>):
    Transport.Builder(drivers = allDrivers, allPassengers = passengers) {
    override fun boardPassengers(
        transports: MutableList<Transport>): MutableList<Transport>? {
        var buf: Passenger
        for (car in transports) {
            for (p in passengers) {
                if (p.money > 100) {
                    buf = p.copy()
                    if (car.passengers != null) {
                        car.passengers.add(buf)
                        car.countPassenger++
                    }
                    else
                        println("list if passengers is null!")
                }
                if (car.countPassenger == 4)
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
                cars.add(Transport(passengers = mutableListOf<Passenger>(), driver = driver,
                    sailors = mutableListOf<Driver>()))
            }
        }
        return cars
    }

    override fun setBabySeat(transports: MutableList<Transport>): MutableList<Transport>? {
        for (t in transports) {
            if (t.passengers != null)
                for (p in t.passengers) {
                    when (p.age) {
                        in 0..7     -> t.babySeat = true
                        else        -> p.money -= 100
                    }
                }
        }
        return transports
    }
}