package lab1

class Singleton private constructor() {
    /*private constructor() используется для того, чтобы гарантировать,
    * что объект данного класса будет создан только внутри этого класса*/

    var b: String? = null

    //Будет вызван при первом вызове Singlenton.instance
    init {
        println("This ($this) is a Singleton")
    }
    //используется для создания единственного экземпляра класса
    private object Holder {
        val INSTANCE = Singleton()
    }


    /*by lazy - делегирование свойства
    * при первом получении доступа функция используется для инициализации свойства,
    * а при дальнейших обращениях она просто возвращается.*/
    companion object {
        val instance: Singleton by lazy { Holder.INSTANCE }
    }

}
