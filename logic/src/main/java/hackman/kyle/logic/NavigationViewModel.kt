package hackman.kyle.logic

object NavigationViewModel {

    enum class Screen {
        START, PLAY_GAME, RECAP
    }

    private var currentScreen = Screen.START
        set(value) {
            field = value
            screenState.update(value)
        }
    val screenState = Observable(currentScreen)

    fun navigateTo(nextScreen: Screen) {
        currentScreen = nextScreen
    }

    fun shouldOverrideBackPressed() = currentScreen != Screen.START

    fun onBackPressed() {
        when (currentScreen) {
            Screen.START -> Unit
            Screen.PLAY_GAME -> navigateTo(Screen.START)
            Screen.RECAP -> RecapViewModel.systemBack()
        }
    }
}
