package pichoMino

import iut.info1.pickomino.Connector
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import pichoMino.controleur.controllerConnect
import pichoMino.controleur.controllerPlay
import pichoMino.controleur.controllerPlayerIdButton
import pichoMino.vue.vueJeu
import pichoMino.vue.vueMenu
import pichoMino.vue.vuePlayer

class Main: Application() {
    override fun start(primaryStage: Stage) {
        val vueMenu = vueMenu()
        var vuePlayer = vuePlayer()
        var playerUserName  = ""
        var playerId = 0
        val connect = Connector.factory("172.26.82.76", "8080")
        primaryStage.title="PickoMino"
        primaryStage.scene= Scene(vueMenu, 950.0, 900.0,)
        var contrPlay = controllerPlay(vueMenu,connect)
        vueMenu.buttonPlay.onMouseClicked = contrPlay
        var contrConnect = controllerConnect(vueMenu,vuePlayer,primaryStage,connect,playerUserName)
        vueMenu.buttonPlay.onMouseClicked = contrConnect

        var contrPlayerId = controllerPlayerIdButton(vuePlayer,primaryStage,playerId,playerUserName)
        vuePlayer.j1.onMouseClicked = contrPlayerId
        vuePlayer.j2.onMouseClicked = contrPlayerId
        vuePlayer.j3.onMouseClicked = contrPlayerId
        vuePlayer.j4.onMouseClicked = contrPlayerId

        primaryStage.show()

    }
}

fun main() {
    Application.launch(Main::class.java)

}