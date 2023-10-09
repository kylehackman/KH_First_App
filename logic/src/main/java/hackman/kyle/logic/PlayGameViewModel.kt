package hackman.kyle.logic

object PlayGameViewModel {
    private var price = RandomVariable.randVar()
    private var score = 0

    private var asset = Database.assets[0]
        set(value) {
            field = value
            assetState.update(value)
        }

    private var assetIndex = 0
    val assetState = Observable(Database.assets[0])

    fun clickLower() {
        if (price > asset.actualPrice) {
            winner()
        } else {
            loser()
        }
    }

    fun clickHigher() {
        if (price < asset.actualPrice) {
            winner()
        } else {
            loser()
        }
    }

    private fun nextAsset() {
        if (assetIndex >= Database.assets.size - 1) {
            assetIndex = 0
        } else {
            assetIndex++
        }
        asset = Database.assets[assetIndex]
    }

    private fun loser() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.RECAP)
    }

    private fun winner() {
        score++
        nextAsset()
    }

    fun exit() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.START)
    }
}
