package lab2

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class BuilderTest {
    fun printCars(cars: MutableList<Transport>) {
        for (car in cars) {
            car.printTransport()
        }
    }

    @Test
    @Tag("Build")
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

        val cars = Transport.Builder(null, null, 0,
            null, drivers, passengers).buildBus()
        val cars1 = Transport.Builder(null, null, 0,
            null, drivers, passengers).buildTaxi()
        if (cars != null)
            printCars(cars)
        if (cars1 != null)
            printCars(cars1)
    }

}