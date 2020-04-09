package lab6


class Teacher(
    val name: String
): IObservable {
    lateinit var report: Grades
    private val observers = mutableListOf<IObserver>()

    override fun registerObserver(o: IObserver) {
        observers.add(o)
    }

    override fun removeObserver(o: IObserver) {
        observers.remove(o)
    }

    override fun notifyObservers() {
        var i = 0
        var buf_size = observers.size

        while (i < buf_size) {
            observers[i].update(this)
            if (buf_size == observers.size)
                i++
            else buf_size = observers.size
        }
    }

    fun makeReport(grades: Grades) {
        this.report = grades
        notifyObservers()
    }
}