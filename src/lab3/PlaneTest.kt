package lab3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PlaneTest {

    fun createPlane(pilots: MutableList<Pilot>,
                    stawardess: MutableList<Stawardess>,
                    passengers: MutableList<Passenger>): Plane
    {
        val plane = Plane()
        plane.boardPilots(pilots)
        plane.boardStewardess(stawardess)
        plane.boardPassengers(passengers)
        plane.setWeights(300)
        return plane
    }

    @Test
    fun boardPassengers() {
        val pilots = mutableListOf<Pilot>(
            Pilot("Din", "pilot"),
            Pilot("Benedict", "pilot"),
            Pilot("Sokol", "pilot")
        )
        val stawardess = mutableListOf<Stawardess>(
            Stawardess("Mia", "stew"),
            Stawardess("Mia1", "stew"),
            Stawardess("Mia2", "stew"),
            Stawardess("Mia3", "stew"),
            Stawardess("Mia4", "stew"),
            Stawardess("Mia5", "stew")
        )

        val passengers: MutableList<Passenger> = mutableListOf(
            Passenger("Mia", 10000,5),
            Passenger("Kate2", 105, 18),//не попадёт на самолёт, т.к. нет денег
            Passenger("Kate3", 1050, 59),
            Passenger("Kate4", 1050, 50),
            Passenger("Kate5", 1050, 21),
            Passenger("Kate6", 1050, 22),
            Passenger("Kate7", 1050, 2),
            Passenger("Kate8", 1050, 19),
            Passenger("Kate9", 1050, 18),
            Passenger("Kate99", 1050, 18),
            Passenger("Kate", 1050, 18),
            Passenger( "Emma", 2500, 40),
            Passenger( "Lii", 2100, 45),
            Passenger( "Who", 5000, 40),
            Passenger( "Emma", 5000, 40),
            Passenger( "Den", 100000, 60)
        )
        val p = createPlane(pilots, stawardess, passengers)
        p.printPlane()
    }
}