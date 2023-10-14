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
}
