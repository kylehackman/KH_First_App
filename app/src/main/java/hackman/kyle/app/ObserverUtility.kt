package hackman.kyle.app

import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import hackman.kyle.logic.Observable

fun <T> Observable<T>.observe(fragment: Fragment, observer: (T) -> Unit) {
    addObserver(fragment.viewLifecycleOwner.lifecycle, this, observer)
}

private fun <T> addObserver(lifecycle: Lifecycle, observable: Observable<T>, observer: (T) -> Unit) {
    lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            observable.addObserver(observer)
        }

        override fun onDestroy(owner: LifecycleOwner) {
            observable.removeObserver(observer)
        }
    })
}

