package lab3

//Client
class Plane(
    var pilots: Pair<Pilot, Pilot>? = null,
    val stewardess: MutableList<Stawardess> = mutableListOf<Stawardess>(),
    var firstClass: FirstClass = FirstClass(2),
    val businessClass: BusinessClass = BusinessClass(3),
    val economyClass: EconomyClass = EconomyClass(4),
    var weight: Int = 0
) {
    fun boardPassengers(passengers: MutableList<Passenger>) {
        businessClass.boardPassenger(passengers)
        firstClass.boardPassenger(passengers)
        economyClass.boardPassenger(passengers)

    }

    fun boardPilots(pilots: MutableList<Pilot>) {
        for (i in 0 until pilots.size) {
            if (i + 1 < pilots.size)
                if (pilots[i].pilotLicense == "pilot" && pilots[i + 1].pilotLicense == "pilot") {
                    this.pilots = Pair(pilots[i], pilots[i + 1])
                    break
                }
        }
    }

    fun boardStewardess(stews: MutableList<Stawardess>) {
        for (s in stews) {
            this.stewardess.add(s)
            if (this.stewardess.count() == 6)
                break
        }
    }

    fun setWeights(limWeigth: Int) {
        this.weight += firstClass.getWeightBag()
        this.weight += businessClass.getWeightBag()
        this.weight += economyClass.getWeightBag()
        this.weight = economyClass.removeBag(this.weight, limWeigth)
    }

    fun printOverBag() {
        this.firstClass.printOverBag()
        println("-------------------------------------------\n")
        this.businessClass.printOverBag()
        println("-------------------------------------------\n")
        this.economyClass.printOverBag()
    }

    fun printStaff() {
        println("\t\tPilots")
        println(pilots?.first?.pilotName)
        println(pilots?.second?.pilotName)
        println("\t\tStawardess")
        for (s in this.stewardess)
            println(s.stName)
    }

    fun printPlane() {
        this.printStaff()
        firstClass.printAirClass()
        businessClass.printAirClass()
        economyClass.printAirClass()
        this.printOverBag()
    }

}