package pichoMino.controleur

import iut.info1.pickomino.Connector
import javafx.event.EventHandler
import javafx.scene.control.RadioButton
import javafx.scene.input.MouseEvent
import javafx.stage.Stage
import pichoMino.vue.vueMenu
import pichoMino.vue.vuePlayer

class controllerPlay(vueMenu : vueMenu, connect : Connector, primaryStage : Stage):  EventHandler<MouseEvent>{
    private val vueMenu : vueMenu
    private val connect : Connector
    private val primaryStage : Stage


    init {
        this.vueMenu = vueMenu
        this.connect = connect
        this.primaryStage = primaryStage
    }

    override fun handle(event: MouseEvent) {
        val selectedButton = vueMenu.toggleGroup.selectedToggle as RadioButton?

        if (selectedButton == vueMenu.joinPartie){
            // var contrConnect = controllerConnect(vueMenu,vuePlayer,primaryStage,connect,playerUserName)
            println("connexion choisie")
            var contrConnect = controllerConnect(vueMenu, vuePlayer(),primaryStage,connect,vueMenu.playerNumber.text)
            vueMenu.buttonPlay.onMouseClicked = contrConnect
        }
        if (selectedButton == vueMenu.creatPartie){
            println("Nouvelle partie choisie")
            var identification =  connect.newGame(vueMenu.nbJoueur.value)
            var id = identification.first
            var key = identification.second
            vueMenu.gameId.text = id.toString()
            vueMenu.gameKey.text = key.toString()
            vueMenu.gameHasBeenCreated = true
            var contrConnect = controllerConnect(vueMenu, vuePlayer(),primaryStage,connect,vueMenu.playerNumber.text)
            vueMenu.buttonPlay.onMouseClicked = contrConnect
        }

    }
}