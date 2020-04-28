package lab6

import java.time.LocalDate


class Dean(
    var faculty: MutableList<IObservable>
): IObserver {
    var responce: Boolean = true

    init {
        for (f in faculty)
            f.registerObserver(this)
    }

    override fun update(obj: Any) {
        val grades = obj as Grades
        val currentDate = LocalDate.now()

        println("Dean get report:\t${grades.toString()}")
        println("Current date:\t${currentDate.toString()}")

        responce = ((grades.date.month == currentDate.month)
                && (grades.date.year == currentDate.year) && (currentDate.dayOfMonth - grades.date.dayOfMonth < 7))

    }

    //Расформировать факультет
    fun deliteFaculty(f: Faculty) {
        this.faculty.remove(f)
        f.removeObserver(this)
    }

    fun addFaculty(f: Faculty) {
        this.faculty.add(f)
        f.registerObserver(this)
    }
}