package hackman.kyle.logic

class Observable<T>(initialValue: T) {
    private val observers = mutableListOf<(T) -> Unit>()
    private var currentValue = initialValue

    fun addObserver(observer: (T) -> Unit) {
        observers.add(observer)
        observer(currentValue)
    }

    fun removeAllObservers() {
        observers.clear()
    }

    fun removeObserver(observer: (T) -> Unit){
        observers.remove(observer)
    }

    fun update(value: T) {
        currentValue = value
        observers.forEach { observer ->
            observer(value)
        }
    }
}
