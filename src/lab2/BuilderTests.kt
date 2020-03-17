package lab2

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

internal class BuilderTest {
    fun printCars(cars: MutableList<Transport>) {
        for (car in cars) {
            car.printTransport()
            println()
        }
        println()
    }

    fun printShips(ships: MutableList<Transport>) {
        for (s in ships) {
            s.printTransport_Ship()
            println()
        }
        println()
    }

    @Test
    @Tag("Bus_and_Taxi")
    fun testBuild_Bus_and_Taxi() {
        val passengers: MutableList<Passenger> = mutableListOf(
            Passenger(1, "Mia", 1000,5),
            Passenger(1, "Kate", 10, 18),
            Passenger(1, "Emma", 50, 40),
            Passenger(1, "Den", 1000, 26)
        )
        val drivers:  MutableList<Driver> = mutableListOf(
            Driver(1, "Daive", "bus"),
            Driver(1, "Kit", "taxi")
        )

        val cars = Transport.Builder(drivers = drivers, allPassengers =passengers).buildBus()
        val cars1 = Transport.Builder(drivers = drivers, allPassengers = passengers).buildTaxi()
        if (cars != null)
            printCars(cars)
        if (cars1 != null)
            printCars(cars1)
    }

    @Test
    @Tag("Bus_and_NOTaxi")
    fun testBuild_Bus_and_noTaxiDriver() {
        val passengers: MutableList<Passenger> = mutableListOf(
            Passenger(1, "Mia", 1000,5),
            Passenger(1, "Kate", 10, 18),
            Passenger(1, "Emma", 50, 40),
            Passenger(1, "Den", 1000, 26)
        )
        val drivers:  MutableList<Driver> = mutableListOf(
            Driver(1, "Daive", "bus")
        )

        val cars = Transport.Builder(drivers = drivers, allPassengers =passengers).buildBus()
        val cars1 = Transport.Builder(drivers = drivers, allPassengers = passengers).buildTaxi()
        if (cars != null)
            printCars(cars)
        if (cars1 != null)
            printCars(cars1)
    }

    @Test
    @Tag("Bus_and_NOTaxi")
    fun testBuild_Bus_and_noTaxiPassenger() {
        val passengers: MutableList<Passenger> = mutableListOf(
            Passenger(1, "Mia", 1000,5),
            Passenger(1, "Kate", 10, 18),
            Passenger(1, "Emma", 50, 40),
            Passenger(1, "Den", 1000, 26)
        )
        val drivers:  MutableList<Driver> = mutableListOf(
            Driver(1, "Daive", "bus"),
            Driver(1, "Kit", "taxi"))

        val cars = Transport.Builder(drivers = drivers, allPassengers =passengers).buildBus()
        val cars1 = Transport.Builder(drivers = drivers, allPassengers = passengers).buildTaxi()
        if (cars != null)
            printCars(cars)
        if (cars1 != null)
            printCars(cars1)
    }

    @Test
    @Tag("Ship")
    fun testBuild_Ship() {
        val passengers: MutableList<Passenger> = mutableListOf(
            Passenger(1, "Mia", 1000,5),
            Passenger(1, "Kate", 10, 18),
            Passenger(1, "Emma", 50, 40),
            Passenger(1, "Den", 1000, 26)
        )
        val drivers:  MutableList<Driver> = mutableListOf(
            Driver(1, "Daive", "ship"),
            Driver(1, "Kit", "sailor"),
            Driver(1, "Daive", "sailor"),
            Driver(1, "Kit", "sailor")
        )


        val ships = Transport.Builder(drivers = drivers, allPassengers = passengers).buildShip()
        if (ships!= null)
            printShips(ships)
    }

    @Test
    @Tag("Ship")
    fun testBuild_Ship_noPassengers() {
        val passengers: MutableList<Passenger> = mutableListOf(
        )
        val drivers:  MutableList<Driver> = mutableListOf(
            Driver(1, "Daive", "ship"),
            Driver(1, "Kit", "sailor"),
            Driver(1, "Daive", "sailor"),
            Driver(1, "Kit", "sailor")
        )


        val ships = Transport.Builder(drivers = drivers, allPassengers = passengers).buildShip()
        if (ships!= null)
            printShips(ships)
    }

    @Test
    @Tag("Ship_noDriver")
    fun testBuild_Ship_noDriver() {
        val passengers: MutableList<Passenger> = mutableListOf(
            Passenger(1, "Mia", 1000,5),
            Passenger(1, "Kate", 10, 18),
            Passenger(1, "Emma", 50, 40),
            Passenger(1, "Den", 1000, 26)
        )
        val drivers:  MutableList<Driver> = mutableListOf(
            Driver(1, "Kit", "sailor"),
            Driver(1, "Daive", "sailor"),
            Driver(1, "Kit", "sailor")
        )


        val ships = Transport.Builder(drivers = drivers, allPassengers = passengers).buildShip()
        if (ships!= null)
            printShips(ships)
    }

    @Test
    @Tag("Ship_noSailors")
    fun testBuild_Ship_noSailors() {
        val passengers: MutableList<Passenger> = mutableListOf(
            Passenger(1, "Mia", 1000,5),
            Passenger(1, "Kate", 10, 18),
            Passenger(1, "Emma", 50, 40),
            Passenger(1, "Den", 1000, 26)
        )
        val drivers:  MutableList<Driver> = mutableListOf(
            Driver(1, "Daive", "ship")
        )

        val ships = Transport.Builder(drivers = drivers, allPassengers = passengers).buildShip()
        if (ships!= null)
            printShips(ships)
    }
}