package iut.info1.pichoMino.controleur

import iut.info1.pichoMino.vue.vuePrincipale
import iut.info1.pickomino.data.DICE
import iut.info1.pickomino.data.STATUS
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent

class controllerKeepDices(vuePrincipale: vuePrincipale) : EventHandler<MouseEvent> {
    var vuePrincipale: vuePrincipale

    init {
        this.vuePrincipale = vuePrincipale
    }

    override fun handle(event: MouseEvent) {
        var gamestate = vuePrincipale.connect.gameState(vuePrincipale.player.gameId, vuePrincipale.player.gameKey).current.status
        if (gamestate == STATUS.KEEP_DICE) {
            var source = event.source as Button
            var imgV = source.graphic as ImageView
            var img = imgV.image
            var finalString = img.url.split("Des/")[1]
            var value: DICE
            if (finalString == "d1.png") {
                value = DICE.d1
            } else if (finalString == "d2.png") {
                value = DICE.d2
            } else if (finalString == "d3.png") {
                value = DICE.d3
            } else if (finalString == "d4.png") {
                value = DICE.d4
            } else if (finalString == "d5.png") {
                value = DICE.d5
            } else {
                value = DICE.worm
            }

            var possible = vuePrincipale.player.keepDices(value)
            if (possible) {
                for (bouton in vuePrincipale.listBoutonB) {
                    var imgVBt = bouton.graphic as ImageView
                    if (imgVBt.image.url.split("Des/")[1] == finalString) {
                        bouton.isDisable = true
                        vuePrincipale.player.keptDices+=value
                    }
                }
            }
        }
        checkCanTakePickomino(vuePrincipale.player.keptDices,vuePrincipale)
    }
}