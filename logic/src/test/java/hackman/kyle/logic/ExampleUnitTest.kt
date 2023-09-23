package hackman.kyle.logic

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun `start screen test`() {
        StartViewModel.clickStart()
        assertEquals(NavigationViewModel.Screen.PLAY_GAME, NavigationViewModel.currentScreen)
    }
}
