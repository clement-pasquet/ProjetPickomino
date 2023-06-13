package pichoMino

import iut.info1.pickomino.Connector
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import pichoMino.vue.Vue

class Main: Application() {
    override fun start(primaryStage: Stage) {
        val vue = Vue()

        primaryStage.title="eho lalalalou"
        primaryStage.scene= Scene(vue, 350.0, 90.0)
        primaryStage.show()

    }
}

fun main() {
//    println("Hello students !!!")
//    val connect = Connector.factory("172.26.82.76", "8080")
//    println("Parties actives sur le serveur = ${connect.listOfGameIds()}")
//    val identification = connect.newGame(3)
//    val id = identification.first
//    val key = identification.second
//    val currentGame = connect.gameState(id, key)
//    println("Nouvelle partie = $currentGame")
    Application.launch(Main::class.java)
}