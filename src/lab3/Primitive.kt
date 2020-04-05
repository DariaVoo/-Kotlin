package lab3

enum class MaxPassengers(val lim: Int) {
    Econom(150),
    Business(20),
    First(10)
}

enum class MaxWeight(val lim: Int) {
    Econom(20),
    Business(35),
    First(5)
}

//primitive
data class Pilot(val pilotName: String, var pilotLicense: String)

data class Stawardess(val stName: String, var stLicense: String)

data class Passenger(val name: String, var money: Long, var bag: Int)

data class Seat(val row: Int, val position: Int)