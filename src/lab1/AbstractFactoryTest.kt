package lab1

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

internal class AbstractFactoryTest {
    fun printCars(cars: MutableList<Car>) {
        for (car in cars) {

            println(car.driver.printDriver())
            for (p in car.passengers)
                println("${p.name} money: ${p.money}")
        }
    }

    @Test
    @Tag("AbstractNull")
    fun testAbstract_Bus_and_Taxi() {
        val passengers: MutableList<Passenger> = mutableListOf(
            Passenger(1, "Mia", 1000),
            Passenger(1, "Kate", 10),
            Passenger(1, "Emma", 50),
            Passenger(1, "Den", 1000)
        )
        val drivers:  MutableList<Driver> = mutableListOf(
            Driver(1, "Daive", "bus"),
            Driver(1, "Kit", "taxi")
        )

        val cars = TransportFactory(passengers,drivers).createBus()
        val cars1 = TransportFactory(passengers,drivers).createTaxi()
        if (cars != null)
            printCars(cars)
        if (cars1 != null)
            printCars(cars1)
    }

    @Test
    @Tag("AbstractNull")
    fun testAbstract_NoBusDriver() {
        val passengers: MutableList<Passenger> = mutableListOf(
            Passenger(1, "Mia", 1000),
            Passenger(1, "Kate", 10),
            Passenger(1, "Emma", 50),
            Passenger(1, "Den", 1000)
        )
        val drivers:  MutableList<Driver> = mutableListOf(
            Driver(1, "Kit", "taxi")
        )

        val cars = TransportFactory(passengers,drivers).createBus()
        val cars1 = TransportFactory(passengers,drivers).createTaxi()
        if (cars != null)
            printCars(cars)
        if (cars1 != null)
            printCars(cars1)
    }

    @Test
    @Tag("AbstractNull")
    fun testAbstract_NoTaxiDriver() {
        val passengers: MutableList<Passenger> = mutableListOf(
            Passenger(1, "Mia", 1000),
            Passenger(1, "Kate", 10),
            Passenger(1, "Emma", 50),
            Passenger(1, "Den", 1000)
        )
        val drivers:  MutableList<Driver> = mutableListOf(
            Driver(1, "Kit", "bus")
        )

        val cars = TransportFactory(passengers,drivers).createBus()
        val cars1 = TransportFactory(passengers,drivers).createTaxi()
        if (cars != null)
            printCars(cars)
        if (cars1 != null)
            printCars(cars1)
    }

    @Test
    @Tag("AbstractNull")
    fun testAbstract_NoDrivers() {
        val passengers: MutableList<Passenger> = mutableListOf(
            Passenger(1, "Mia", 1000),
            Passenger(1, "Kate", 10),
            Passenger(1, "Emma", 50),
            Passenger(1, "Den", 1000)
        )
        val drivers:  MutableList<Driver> = mutableListOf(

        )

        val cars = TransportFactory(passengers,drivers).createBus()
        val cars1 = TransportFactory(passengers,drivers).createTaxi()
        if (cars != null)
            printCars(cars)
        if (cars1 != null)
            printCars(cars1)
    }
}