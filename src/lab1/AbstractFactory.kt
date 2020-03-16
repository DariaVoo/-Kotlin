package lab1

data class Passenger(val id: Long, val name: String, var money: Long)
data class Car(var passengers: MutableList<Passenger>,
               val driver: IDriver, var countPassenger: Int = 0)
data class Driver(val id: Long, val name: String, var license: String)

//Итерфейс для водителей
interface IDriver {
    fun getDriver(driver: Driver): Driver?
    fun printDriver()
}

class BusDriver(private val driver: Driver) : IDriver {

    override fun getDriver(driver: Driver): Driver? {
        if (driver.license.toLowerCase() == "bus") {
            println("Bus driver is found")
            return driver
        } else
            return null
    }

    override fun printDriver() {
        println("Водитель автобуса: ${driver.name}\t${driver.license}")
    }

}

class TaxiDriver(private val driver: Driver): IDriver {

    override fun getDriver(driver: Driver): Driver? {
        if (driver.license.toLowerCase() == "taxi") {
            println("Taxi driver is found")
            return driver
        } else
            return null
    }

    override fun printDriver() {
        println("Водитель такси: ${driver.name}\t${driver.license}")
    }
}

class TransportFactory(var passengers:  MutableList<Passenger>,
                       var drivers:  MutableList<Driver>) {
    fun createBus() : MutableList<Car>? {
        val BusFactory = BusFactory(this.passengers, this.drivers)
        val cars: MutableList<Car> = BusFactory.boardBusDriver()

        if (cars.isEmpty()) {
            println("!!! No bus drivers")
            return null
        }

        BusFactory.boardPassenger(cars)
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

    fun createTaxi() : MutableList<Car>? {
        val TaxiFactory = TaxiFactory(this.passengers, this.drivers)
        val cars: MutableList<Car> = TaxiFactory.boardTaxiDriver()

        if (cars.isEmpty()) {
            println("!!! No Taxi drivers")
            return null
        }

        TaxiFactory.boardPassenger(cars)
        for (car in cars) {
            if (car.countPassenger == 0)
                cars.remove(car)
        }

        if (cars.isEmpty()) {
            println("!!! No Taxi passengers")
            return null
        }
        return cars
    }
}

class BusFactory(
    val passengers: MutableList<Passenger>,
    val drivers: MutableList<Driver>) {

    fun boardBusDriver() : MutableList<Car>
    {
        this.drivers.sortBy { it.license}
        var busD: BusDriver
        val cars: MutableList<Car> =  mutableListOf<Car>()

        for (driver in this.drivers) {
            busD = BusDriver(driver)
            if (busD.getDriver(driver) != null)
                cars.add(Car(mutableListOf<Passenger>(), busD))
        }
        return cars
    }

    fun boardPassenger(cars: MutableList<Car>)
    {
        for (car in cars) {
            for (p in this.passengers) {
                if (p.money <= 100) {
                    car.passengers.add(p)
                    car.countPassenger++
                }
                if (car.countPassenger > 30)
                    break
            }
        }
    }
}

class TaxiFactory(
    val passengers: MutableList<Passenger>,
    val drivers: MutableList<Driver>) {

    fun boardTaxiDriver() : MutableList<Car>
    {
        this.drivers.sortBy { it.license}
        var busD: TaxiDriver
        val cars: MutableList<Car> =  mutableListOf<Car>()

        for (driver in this.drivers) {
            busD = TaxiDriver(driver)
            if (busD.getDriver(driver) != null)
                cars.add(Car(mutableListOf<Passenger>(), busD))
        }
        return cars
    }

    fun boardPassenger(cars: MutableList<Car>)
    {
        for (car in cars) {
            for (p in this.passengers) {
                if (p.money > 100) {
                    car.passengers.add(p)
                    car.countPassenger++
                }
                if (car.countPassenger > 4)
                    break
            }
        }
    }
}