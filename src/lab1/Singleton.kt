package lab1

class Singleton private constructor() {
    /*private constructor() используется для того, чтобы гарантировать,
    * что объект данного класса будет создан только внутри этого класса*/

    var b: String? = null

    //Будет вызван при первом вызове Singlenton.instance
    /*Инициализаторы — это некий блок кода, обязательно выполняемый
     * при создании объекта независимо от того,
     * с помощью какого конструктора этот объект создаётся.*/
    init {
        println("This ($this) is a lab1.Singleton")
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
/*
fun main(args: Array<String>) {
    var first = Singleton.instance
    first.b = "Hiiii!"
    var second = Singleton.instance
    println(second.b)
}*/