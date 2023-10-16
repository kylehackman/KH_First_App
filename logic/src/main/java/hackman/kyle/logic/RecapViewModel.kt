package hackman.kyle.logic

object RecapViewModel {

    var recapScore = PlayGameViewModel.score
        set(value) {
            field = value
            recapScoreState.update(value)
        }
    val recapScoreState = Observable(recapScore)

    fun clickBack() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.PLAY_GAME)
        PlayGameViewModel.score = 0
        PlayGameViewModel.nextAsset()
    }
}
