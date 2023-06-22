package iut.info1.pichoMino.controleur

import iut.info1.pichoMino.vue.vuePrincipale
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent


class controllerChoosePickomino(vuePrincipale: vuePrincipale) : EventHandler<MouseEvent> {
    var vuePrincipale : vuePrincipale

    init {
        this.vuePrincipale = vuePrincipale
    }

    override fun handle(event: MouseEvent) {
        println(vuePrincipale.connect.gameState(vuePrincipale.player.gameId,vuePrincipale.player.gameKey).current.status)

        var btn = event.source as Button
        var imgV = btn.graphic as ImageView
        println(imgV.image.url.split("Domino/")[1].split(".")[0].toInt())
        vuePrincipale.player.takePickomino(imgV.image.url.split("Domino/")[1].split(".")[0].toInt())
        updatePiles(vuePrincipale)
    }
}