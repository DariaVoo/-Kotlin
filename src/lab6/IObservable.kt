package lab6

//Subject
interface IObservable {
    fun registerObserver(o: IObserver)
    fun removeObserver(o: IObserver)
    fun notifyObservers()
}