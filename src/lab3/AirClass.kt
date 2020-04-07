package lab3


//Component
abstract class AirClass(
    var countPosition: Int = 0,
    var countRow: Int = 0,
    var overBagPassenger: MutableMap<Seat, Passenger?> = mutableMapOf<Seat, Passenger?>(),
    val seats: MutableMap<Seat, Passenger?> = mutableMapOf<Seat, Passenger?>()
) {


    /**
    * Аналог метода add
    * В идеале должен принимать примитивы и внутри метода определять какие это примитивы
    **/
    abstract fun boardPassenger(passengers: MutableList<Passenger>)

    /**
     * Аналог метода remove
     * В идеале должен принимать примитивы и внутри метода определять какие это примитивы
     * */
    abstract fun removeBag(currentWeight: Int, maxAirWeidth: Int = 0): Int

    abstract fun printNameClass()
    abstract fun printOverBag()

    fun setCountSeat(countPosition: Int, maxCountPosition: Int) {
        this.countPosition = countPosition
        if (countPosition != 0)
            this.countRow = maxCountPosition / countPosition
    }

    fun getWeightBag(): Int {
        var sum = 0

        for (key in seats.keys) {
            sum += seats[key]?.bag ?: 0
        }
        return sum
    }

    fun printPersonBySeat(seat: Seat) {
        print(seats[seat].toString())
    }

    fun printAirClass() {
        this.printNameClass()
        print(this.toString())
    }


    override fun toString(): String {
        var str = "\t"
        val formatTemplate = "%-4s\t"
        var i = 0
        var nRow = 1

        for (row in 1..countPosition) {
            str += "%5d".format(row)
        }
        str += "\n1\t"
        for (key in seats.keys) {
            str += formatTemplate.format(seats[key]?.name ?: "0")
            i++
            if (i == this.countPosition && nRow < this.countRow) {
                nRow++
                str += "\n${nRow}\t"
                i = 0
            }
        }
        str += "\n"
        return str
    }
}