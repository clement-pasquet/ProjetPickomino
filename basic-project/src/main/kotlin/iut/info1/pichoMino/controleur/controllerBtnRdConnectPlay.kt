package iut.info1.pichoMino.controleur

import iut.info1.pichoMino.Player
import iut.info1.pichoMino.vue.VueMenu
import iut.info1.pickomino.Connector
import javafx.event.EventHandler
import javafx.scene.control.RadioButton
import javafx.scene.input.MouseEvent
import javafx.stage.Stage

class controllerBtnRdConnectPlay(vueMenu: VueMenu, primaryStage : Stage, connect : Connector, player: Player) : EventHandler<MouseEvent>{
    private val vueMenu : VueMenu
    private val primaryStage : Stage
    private val connect : Connector
    private var player: Player

    init {
        this.vueMenu = vueMenu
        this.primaryStage = primaryStage
        this.connect = connect
        this.player = player
    }

    override fun handle(event: MouseEvent) {
        val eventSource : RadioButton = event.source as RadioButton
        if (eventSource.text == "Rejoindre partie"){
            vueMenu.buttonPlay.text = "Join"
        }else{
            vueMenu.buttonPlay.text = "Create"
        }
    }
}