package lab3

import java.text.ParsePosition

//Composite first class
class FirstClass(countPosition: Int):
    AirClass(countPosition)
{
    override fun boardPassenger(passengers: MutableList<Passenger>) {
        var i = 0

        this.setCountSeat(countPosition, MaxPassengers.First.lim)
        passengers.sortBy { it.money }
        for (row in 1..countRow) {
            for (position in 1..countPosition) {
                while (i < passengers.count() && passengers[i].money < TicketPrice.First.price)
                    i++
                if (i < passengers.count()) {
                    passengers[i].money -= TicketPrice.First.price
                    seats[Seat(row, position)] = passengers[i]
                    passengers.removeAt(i)
                    i -=2
                }
                else
                    seats[Seat(row, position)] = null
                i++
            }
        }
        this.removeBag(0, 0)
    }

    override fun removeBag(currentWeight: Int, maxAirWeidth: Int): Int {
        this.overBagPassenger = seats.filterValues { it?.bag ?: 0 >= MaxWeight.First.lim }
                                        as MutableMap<Seat, Passenger?>
        this.overBagPassenger.mapValues { it.value!!.money - OverBagPrice.First.price}
        return 0
    }

    override fun printNameClass() {
        print("\tFirst Class\n")
    }

    override fun printOverBag() {
        this.printNameClass()
        println("These people paid ${OverBagPrice.First.price} for overweight Luggage")
        for (p in overBagPassenger)
            println("Seat: row:%d\tposition:%d\n Name: %5s Bag: %d kg".format(
                p.key.row, p.key.position,p.value!!.name, p.value!!.bag))
    }
}

