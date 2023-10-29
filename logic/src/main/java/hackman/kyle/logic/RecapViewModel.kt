package hackman.kyle.logic

object RecapViewModel {

    private var recapScore = 0
        set(value) {
            field = value
            recapScoreState.update(value)
        }
    val recapScoreState = Observable(recapScore)

    fun clickBack() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.PLAY_GAME)
        PlayGameViewModel.nextAsset()
        PlayGameViewModel.resetScore()
    }

    fun setScore(score: Int) {
        recapScore = score
    }
}
