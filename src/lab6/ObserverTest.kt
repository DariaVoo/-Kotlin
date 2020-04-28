package lab6

import org.junit.jupiter.api.Test
import java.time.LocalDate


internal class ObserverTest {
    @Test
    fun check() {
        val date1 = LocalDate.parse("2020-04-01")
        val date2 = LocalDate.parse("2020-03-20")
        val date3 = LocalDate.parse("2020-04-20")
        val date4 = LocalDate.parse("2020-01-08")
        //Reports
        val rep1 = Grades(date1, "Python", mutableListOf("Petrov;33;sucess"))
        val rep2 = Grades(date2, "NumPy", mutableListOf("Petrov;33;sucess"))
        val rep3 = Grades(date3, "Pandas", mutableListOf("Petrov;33;sucess"))
        val rep4 = Grades(date4, "Magic", mutableListOf("Petrov;33;sucess"))
        //Teachers
        val t1 = Teacher("Kate")
        val t2 = Teacher("William")
        val t3 = Teacher("Mikasa")
        val t4 = Teacher("Kit")
        val t5 = Teacher("Kat")
        val t6 = Teacher("Lili")
        //Faculty
        val ipovs = Faculty("IPOVS", mutableListOf(t1, t2, t3))
        val vm = Faculty("VM", mutableListOf(t4, t5, t6))
        //Dean
        val dean = Dean(mutableListOf(ipovs, vm))

        t1.makeReport(rep1)
        t5.makeReport(rep2)
        t3.makeReport(rep3)
        t6.makeReport(rep1)
        t4.makeReport(rep3)
        t2.makeReport(rep4)

        dean.deliteFaculty(ipovs)

        val spintech = Faculty("SPINTECH", mutableListOf(t1, t2, t3))
        dean.addFaculty(spintech)
        t3.makeReport(rep3)
    }
}