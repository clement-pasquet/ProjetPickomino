package pichoMino

import iut.info1.pickomino.Connector
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import pichoMino.controleur.controllerBtnRdConnectPlay
import pichoMino.controleur.controllerPlay
import pichoMino.vue.vueMenu

class Main: Application() {



    override fun start(primaryStage: Stage) {
        val vueMenu = vueMenu()


        var player = Player()
        val connect = Connector.factory("172.26.82.76", "8080")
        primaryStage.title="PickoMino"
        primaryStage.scene= Scene(vueMenu, 1280.0, 720.0,)
        var contrPlay = controllerPlay(vueMenu,connect, primaryStage,player)
        vueMenu.buttonPlay.onMouseClicked = contrPlay

        var contrRdBtn = controllerBtnRdConnectPlay(vueMenu,primaryStage,connect,player)
        vueMenu.creatPartie.onMouseClicked = contrRdBtn
        vueMenu.joinPartie.onMouseClicked = contrRdBtn

        primaryStage.show()

    }
}

fun main() {
    Application.launch(Main::class.java)

}