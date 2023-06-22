package iut.info1.pichoMino.controleur

import iut.info1.pichoMino.vue.vuePrincipale
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import java.lang.reflect.Field


class controllerChoosePickomino(vuePrincipale: vuePrincipale) : EventHandler<MouseEvent> {
    var vuePrincipale : vuePrincipale

    init {
        this.vuePrincipale = vuePrincipale
    }

    override fun handle(event: MouseEvent) {
        var gameId = vuePrincipale.player.gameId
        var gameKey = vuePrincipale.player.gameKey
        var btn = event.source as Button
        var imgV = btn.graphic as ImageView
        println(imgV.image.url.split("Domino/")[1].split(".")[0].toInt())
        vuePrincipale.player.takePickomino(imgV.image.url.split("Domino/")[1].split(".")[0].toInt())
        var pickName = "p" + imgV.image.url.split("Domino/")[1].split(".")[0]
        val field: Field = vuePrincipale.javaClass.getDeclaredField(pickName)
        field.isAccessible = true
        val value: Button = field.get(vuePrincipale) as Button
        value.isVisible = false
        value.isDisable = true
        updatePiles(vuePrincipale)
        updatePickos(vuePrincipale,vuePrincipale.connect)
    }
}