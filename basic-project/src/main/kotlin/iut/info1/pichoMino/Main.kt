package iut.info1.pichoMino

import iut.info1.pickomino.Connector
import iut.info1.pichoMino.preloader.ApplicationPreloader
import javafx.application.Application
import javafx.application.Platform
import javafx.scene.Scene
import javafx.stage.Stage
import iut.info1.pichoMino.controleur.controleurPersoChoose
import iut.info1.pichoMino.controleur.controllerPlay
import iut.info1.pichoMino.controleur.controllerPlayerIdButton
import iut.info1.pichoMino.vue.vueMenu
import iut.info1.pichoMino.vue.vuePlayer
import iut.info1.pichoMino.vue.vuePrincipale


class Main: Application() {

    val vuePlayer = vuePlayer()
    private lateinit var conn: Connector

    override fun init() {
        Platform.runLater {
            ApplicationPreloader.LABEL.text = "Initialisation en cours..."
        }
        this.conn = Connector.factory("172.26.82.76", "8080")
        Platform.runLater {
            ApplicationPreloader.LABEL.text = this.conn.listOfGameIds().toString()
        }
        Thread.sleep(3000)
    }
    override fun start(primaryStage: Stage) {
        val vueMenu = vueMenu()

        val vuePlayer = vuePlayer

        val vuePrincipale = vuePrincipale()

        val playerUserName  = "Clément" //parceque c'est le meilleur
        val playerId = 0

        primaryStage.title="PickoMino"
        primaryStage.scene= Scene(vuePrincipale, 1600.0, 900.0,)
        val contrPlay = controllerPlay(vueMenu, conn, primaryStage)
        vueMenu.buttonPlay.onMouseClicked = contrPlay

        val contrPlayerId = controllerPlayerIdButton(vuePlayer,primaryStage,playerId,playerUserName)
        vuePlayer.j1.onMouseClicked = contrPlayerId
        vuePlayer.j2.onMouseClicked = contrPlayerId
        vuePlayer.j3.onMouseClicked = contrPlayerId
        vuePlayer.j4.onMouseClicked = contrPlayerId

        val controleyrChoosePerso = controleurPersoChoose(vueMenu)
        vueMenu.onMouseClicked = controleyrChoosePerso

        primaryStage.show()
    }
}

fun main() {
    System.setProperty("javafx.preloader", ApplicationPreloader::class.java.canonicalName)
    Application.launch(Main::class.java)
}