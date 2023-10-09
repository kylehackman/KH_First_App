package hackman.kyle.logic

class Observable<T>(initialValue: T) {
    private val observers = mutableListOf<(T) -> Unit>()

    fun addObserver(observer: (T) -> Unit) {
        observers.add(observer)
    }

    fun removeAllObservers() {
        observers.clear()
    }

    fun update(value: T) {
        observers.forEach { observer ->
            observer(value)
        }
    }
}
