package hackman.kyle.logic

object PlayGameViewModel {

    var price = RandomVariable.randVar()
    var score = 0
    var message = "Loser!"
    val asset = DataBase.assets[0]

    fun clickLower() {
        if (price > asset.actualPrice) {
            score++
        } else {
            NavigationViewModel.navigateTo(NavigationViewModel.Screen.RECAP)
        }
    }


    fun clickHigher() {
        if (price < asset.actualPrice) {
            score++
        } else {
            NavigationViewModel.navigateTo(NavigationViewModel.Screen.RECAP)
        }
    }

    fun exit() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.START)
    }
}
