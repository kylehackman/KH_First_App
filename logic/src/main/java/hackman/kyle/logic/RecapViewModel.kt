package hackman.kyle.logic

object RecapViewModel {

    fun clickBack() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.PLAY_GAME)
    }
}
