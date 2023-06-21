package iut.info1.pichoMino

import iut.info1.pickomino.Connector
import iut.info1.pichoMino.preloader.ApplicationPreloader
import javafx.application.Application
import javafx.application.Platform
import javafx.scene.Scene
import javafx.stage.Stage
import iut.info1.pichoMino.controleur.controllerBtnRdConnectPlay
import iut.info1.pichoMino.vue.vueMenu
import pichoMino.controleur.controllerPlay


class Main: Application() {

    private lateinit var conn: Connector

    override fun init() {
        Platform.runLater {
            ApplicationPreloader.LABEL.text = "Initialisation en cours..."
        }
        this.conn = Connector.factory("172.26.82.76", "8080")
        Platform.runLater {
            ApplicationPreloader.LABEL.text = this.conn.listOfGameIds().toString()
        }
        Thread.sleep(3)
    }
    override fun start(primaryStage: Stage) {
        val vueMenu = vueMenu()

        var player = Player()
        primaryStage.title="PickoMino"
        primaryStage.scene= Scene(vueMenu, 1280.0, 720.0,)
        var contrPlay = controllerPlay(vueMenu,conn, primaryStage,player)
        vueMenu.buttonPlay.onMouseClicked = contrPlay


        var contrRdBtn = controllerBtnRdConnectPlay(vueMenu,primaryStage,conn,player)
        vueMenu.creatPartie.onMouseClicked = contrRdBtn
        vueMenu.joinPartie.onMouseClicked = contrRdBtn
        primaryStage.show()
    }
}

fun main() {
    System.setProperty("javafx.preloader", ApplicationPreloader::class.java.canonicalName)
    Application.launch(Main::class.java)
}