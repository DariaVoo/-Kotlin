package lab3

import org.junit.jupiter.engine.discovery.predicates.IsNestedTestClass

enum class MaxPassengers(val lim: Int) {
    Econom(150),
    Business(20),
    First(10)
}

enum class TicketPrice(val price: Int) {
    Econom(1000),
    Business(2000),
    First(3000)
}

enum class OverBagPrice(val price: Int) {
    Econom(2000),
    Business(3000),
    First(0)
}

enum class MaxWeight(val lim: Int) {
    Econom(20),
    Business(35),
    First(Int.MAX_VALUE)
}

//primitive
data class Pilot(val pilotName: String, var pilotLicense: String)

data class Stawardess(val stName: String, var stLicense: String)

data class Passenger(val name: String, var money: Long, var bag: Int)

data class Seat(val row: Int, val position: Int)