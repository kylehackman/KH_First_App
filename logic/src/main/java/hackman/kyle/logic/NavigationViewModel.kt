package hackman.kyle.logic

object NavigationViewModel {

    var currentScreen = Screen.START

    enum class Screen {
        START, PLAY_GAME, RECAP
    }

    fun navigateTo(nextScreen: Screen) {
        currentScreen = nextScreen
    }
}
