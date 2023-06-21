package iut.info1.pichoMino.controleur

import iut.info1.pichoMino.vue.vuePrincipale
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent


class controllerChoosePickomino(vuePrincipale: vuePrincipale) : EventHandler<MouseEvent> {
    var vuePrincipale : vuePrincipale

    init {
        this.vuePrincipale = vuePrincipale
    }

    override fun handle(event: MouseEvent) {
        println("click")
    }
}