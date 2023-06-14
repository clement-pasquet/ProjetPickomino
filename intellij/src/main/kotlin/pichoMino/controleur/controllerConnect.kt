package pichoMino.controleur

import iut.info1.pickomino.Connector
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import pichoMino.vue.Vue

class controllerConnect(vue : Vue, connect : Connector): EventHandler<MouseEvent> {
    private val vue : Vue
    private val connect : Connector

    init {
        this.vue = vue
        this.connect = connect
    }

    override fun handle(event: MouseEvent) {
    }
}