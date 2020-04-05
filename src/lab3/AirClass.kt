package lab3


//Component
abstract class AirClass(
    val countRow: Int,
    val countPosition: Int,
    private val seats: MutableMap<Seat, Passenger>
) {
    fun printPersonBySeat(seat: Seat) {
        print(seats[seat].toString())
    }

    abstract fun boardPassenger(passengers: MutableList<Passenger>)
    abstract fun removeBag(currentWeight: Int, maxWeight: MaxWeight): MutableList<Passenger>
    abstract fun getWeightBag(): Int

}