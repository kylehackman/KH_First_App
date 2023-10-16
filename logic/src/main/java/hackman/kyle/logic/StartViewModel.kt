package hackman.kyle.logic

object StartViewModel {

    fun clickStart() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.PLAY_GAME)

    }
}
