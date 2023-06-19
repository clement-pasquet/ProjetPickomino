package pichoMino.controleur

import iut.info1.pickomino.Connector
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import pichoMino.vue.Vue

class controllerPlay(vue : Vue,connect : Connector):  EventHandler<MouseEvent>{
    private val vue : Vue
    private val connect : Connector

    init {
        this.vue = vue
        this.connect = connect
    }

    override fun handle(event: MouseEvent) {
        var identification =  connect.newGame(vue.nbJoueur.value)
        var id = identification.first
        var key = identification.second
        vue.gameId.text = id.toString()
        vue.gameKey.text = key.toString()
    }
}