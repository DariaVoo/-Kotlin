package lab3


class Plane(
    val pilots: Pair<Pilot, Pilot>,
    val stewardess: MutableList<Stawardess>,
    val firstClass: MutableList<Passenger>,
    val businessClass: MutableList<Passenger>,
    val economyClass: MutableList<Passenger>,
    var bags: Int = 0,
    val removedBag: MutableList<Pair<Passenger, Int>>
) {
    fun boardPassengers(passengers: MutableList<lab3.Passenger>) = null
    fun boardPilots(pilots: MutableList<Pilot>) = null
    fun boardStewardess(stews: MutableList<Stawardess>) = null
    fun setBags() = null

}