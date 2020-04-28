package lab6


class Faculty(
    val name: String,
    var teachers: MutableList<IObservable>
): IObservable, IObserver {
    private val reports = mutableListOf<Grades>()
    lateinit var dean: Dean

    init {
        for (teacher in teachers)
            teacher.registerObserver(this)
    }

    override fun update(obj: Any) {
        val teacher = obj as Teacher

        reports.add(teacher.report)
        println("Faculty ${this.name} get report from ${teacher.name}:\t${teacher.report.toString()}")
        notifyObservers()
        if (!dean.responce) {
            println("${this.name} get response from dean: dismiss\n")
            dismissTeacher(teacher)
        }
        else
            println("${this.name} get response from dean: OK\n")
    }

    //Уволить учителя (отписка)
    fun dismissTeacher(o: Teacher) {
        if (teachers.contains(o)) {
            o.removeObserver(this)
        }
        teachers.remove(o)
        println("_______________________________________________________")
        println("!!${o.report.subject} teacher - ${o.name} is DISMISS")
        println("_______________________________________________________")
    }

    override fun registerObserver(o: IObserver) {
        this.dean = o as Dean
    }

    override fun removeObserver(o: IObserver) {
        for (teacher in teachers)
            teacher.removeObserver(this)
        println("----------------------------------------")
        println("!!!The faculty ${this.name} disbanded!!!")
        println("----------------------------------------")
    }

    override fun notifyObservers() {
        dean.update(reports.last())
    }

}