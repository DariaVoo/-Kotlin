package lab3

class EconomyClass(countPosition: Int,
                   val removedBags: MutableMap<Seat, Passenger?> = mutableMapOf<Seat, Passenger?>()):
    AirClass(countPosition)
{
    override fun boardPassenger(passengers: MutableList<Passenger>) {
        var i = 0

        this.setCountSeat(countPosition, MaxPassengers.Econom.lim)
        passengers.sortBy { it.money }
        for (row in 1..countRow) {
            for (position in 1..countPosition) {
                while (i < passengers.count()
                    && (passengers[i].money >= TicketPrice.Business.price
                            || passengers[i].money < TicketPrice.Econom.price))
                    i++
                if (i < passengers.count()) {
                    passengers[i].money -= TicketPrice.Econom.price
                    seats[Seat(row, position)] = passengers[i]
                    passengers.removeAt(i)
                    i--
                }
                else
                    seats[Seat(row, position)] = null
                i++
            }
        }
    }

    override fun removeBag(currentWeight: Int, maxAirWeidth: Int): Int {
        var cur = currentWeight

        this.overBagPassenger = seats.filterValues { it?.bag ?: 0 >= MaxWeight.Econom.lim } as MutableMap<Seat, Passenger?>
        this.overBagPassenger.mapValues { it.value!!.money - OverBagPrice.Business.price}
        //Если перевес, удаляем багаж которые превысили допустимый вес
        for (key in this.overBagPassenger.keys) {
            if (cur < maxAirWeidth)
                return cur
            cur -= this.overBagPassenger[key]!!.bag
            this.removedBags[key] = this.overBagPassenger[key]
        }
        //Если всё ещё перевес, удаляем багаж остальных
        val ooy = seats.filterValues { it?.bag ?: 0 < MaxWeight.Econom.lim } as MutableMap<Seat, Passenger?>
        if (cur >= maxAirWeidth) {
            for (key in ooy.keys) {
                if (cur < maxAirWeidth)
                    return cur
                cur -= ooy[key]!!.bag
                this.removedBags[key] = ooy[key]
            }
        }
        return cur
    }


    override fun printNameClass() {
        print("\tEconom Class\n")
    }

    override fun printOverBag() {
        this.printNameClass()
        println("These people paid ${OverBagPrice.Econom.price} for overweight Luggage")
        for (p in overBagPassenger)
            println("Seat: row:%d\tposition:%d\n Name: %5s Bag: %d kg\n".format(
                p.key.row, p.key.position,p.value!!.name, p.value!!.bag))
        println("The baggage of these people was removed from the flight")
        println("-------                                           --------")
        for (p in removedBags)
            println("Seat: row:%d\tposition:%d\n Name: %5s Bag: %d kg\n".format(
                p.key.row, p.key.position, p.value?.name, p.value?.bag))
    }
}
