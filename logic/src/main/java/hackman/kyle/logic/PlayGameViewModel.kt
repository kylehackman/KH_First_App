package hackman.kyle.logic

object PlayGameViewModel {

    var price = RandomVariable.randVar()
    var score = 0
    var message = "Loser!"

    fun clickLower() {
        if (price > Asset.actualPrice) {
            score++
        } else {
            NavigationViewModel.navigateTo(NavigationViewModel.Screen.END)
        }
    }
}

    fun clickHigher() {
        if (price < Asset.actualPrice) {
            score++
        } else {
            NavigationViewModel.navigateTo(NavigationViewModel.Screen.END)
        }
    }

    fun exit() {
        NavigationViewModel.navigateTo(NavigationViewModel.Screen.START)
    }
}
