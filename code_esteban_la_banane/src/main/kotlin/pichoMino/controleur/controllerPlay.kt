package pichoMino.controleur

import iut.info1.pickomino.Connector
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import pichoMino.vue.vueMenu

class controllerPlay(vueMenu : vueMenu, connect : Connector):  EventHandler<MouseEvent>{
    private val vueMenu : vueMenu
    private val connect : Connector

    init {
        this.vueMenu = vueMenu
        this.connect = connect
    }

    override fun handle(event: MouseEvent) {
        var identification =  connect.newGame(vueMenu.nbJoueur.value)
        var id = identification.first
        var key = identification.second
        vueMenu.gameId.text = id.toString()
        vueMenu.gameKey.text = key.toString()
        vueMenu.gameHasBeenCreated = true
    }
}