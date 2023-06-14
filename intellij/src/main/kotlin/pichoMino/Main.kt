package pichoMino

import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.DICE
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.paint.Paint
import javafx.stage.Stage
import pichoMino.controleur.controllerPlay
import pichoMino.vue.Vue

class Main: Application() {
    override fun start(primaryStage: Stage) {
        val vue = Vue()
        val connect = Connector.factory("172.26.82.76", "8080")
        primaryStage.title="PickoMino"
        primaryStage.scene= Scene(vue, 950.0, 900.0,)
        var contrPlay = controllerPlay(vue,connect)
        vue.buttonPlay.onMouseClicked = contrPlay
        primaryStage.show()
    }
}

fun main() {
//    val id = identification.first
//    val key = identification.second
//    val currentGame = connect.gameState(id, key)
//    println("Nouvelle partie = $currentGame")
    Application.launch(Main::class.java)
}