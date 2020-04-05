package lab3

//Composite first class
class firstClass(countRow: Int, countPosition: Int, seats: MutableMap<Seat, Passenger>):
    AirClass(countRow, countPosition, seats)
{

    override fun boardPassenger(passengers: MutableList<Passenger>) {
        TODO("Not yet implemented")
    }

    override fun removeBag(currentWeight: Int, maxWeight: MaxWeight): MutableList<Passenger> {
        TODO("Not yet implemented")
    }

    override fun getWeightBag(): Int {
        TODO("Not yet implemented")
    }

}
