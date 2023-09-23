package hackman.kyle.logic

object NavigationViewModel {

    var currentScreen = Screen.START

    enum class Screen {
        START, PLAY_GAME, END
    }

    fun navigateTo(nextScreen: Screen) {
        currentScreen = nextScreen
    }
}
