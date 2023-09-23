package hackman.kyle.logic

import kotlin.random.Random

object RandomVariable {

    fun randVar(): Int {
        val randomGenerator = Random.Default
        return randomGenerator.nextInt(5, 1000000)
    }
}
