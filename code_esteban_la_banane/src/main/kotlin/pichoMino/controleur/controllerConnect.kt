package pichoMino.controleur

import iut.info1.pickomino.Connector
import iut.info1.pickomino.exceptions.IncorrectKeyException
import iut.info1.pickomino.exceptions.UnknownIdException
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.input.MouseEvent
import javafx.stage.Stage
import pichoMino.Main
import pichoMino.vue.vueMenu
import pichoMino.vue.vuePlayer

class controllerConnect(vueMenu: vueMenu,vuePlayer : vuePlayer,primaryStage : Stage, connect : Connector,playerUserName : String): EventHandler<MouseEvent> {
    private val vueMenu : vueMenu
    private val primaryStage : Stage
    private val connect : Connector
    private var vuePlayer : vuePlayer
    private var playerUsername : String

    init {
        this.vueMenu = vueMenu
        this.vuePlayer = vuePlayer
        this.primaryStage = primaryStage
        this.connect = connect
        this.playerUsername = playerUserName
    }

    override fun handle(event: MouseEvent) {
        if (vueMenu.gameKey.text == "" || vueMenu.gameId.text== ""){
            val alert = Alert(Alert.AlertType.WARNING)
            alert.title = "Avertissement"
            alert.headerText = "Clé et ID sont vides"
            alert.contentText = "Veuillez saisir une clé ET un identifiant de jeu s'il-vous-plaît."
            alert.showAndWait()
            println("Please indicate Key AND game ID")
        }else {
            try {
                var gameState = connect.gameState(vueMenu.gameId.text.toInt(), vueMenu.gameKey.text.toInt())
                var username = vueMenu.username.text
                if (username==""){
                    println("Please enter a name!")
                    val alert = Alert(Alert.AlertType.WARNING)
                    alert.title = "Avertissement"
                    alert.headerText = "Nom manquant"
                    alert.contentText = "Veuillez entrer votre nom avant de continuer."
                    alert.showAndWait()
                }else {
                    playerUsername = username
                    var nbJoueurMax = gameState.score().size
                    if (vueMenu.gameHasBeenCreated){
                        vuePlayer.j1.isDisable = false
                        vuePlayer.j2.isDisable = true
                        vuePlayer.j3.isDisable = true
                        vuePlayer.j4.isDisable = true
                        if (nbJoueurMax==3){
                            vuePlayer.j2.isVisible = true
                            vuePlayer.j3.isVisible = true
                            vuePlayer.j4.isVisible = false
                        }else if (nbJoueurMax==2){
                            vuePlayer.j2.isVisible = true
                            vuePlayer.j3.isVisible = false
                            vuePlayer.j4.isVisible = false
                        }else{
                            vuePlayer.j2.isVisible = true
                            vuePlayer.j3.isVisible = true
                            vuePlayer.j4.isVisible = true
                        }
                    }else{
                        vuePlayer.j1.isDisable = true
                        if (nbJoueurMax==4){
                            vuePlayer.j2.isDisable = false
                            vuePlayer.j3.isDisable = false
                            vuePlayer.j4.isDisable = false
                        }else if (nbJoueurMax==3){
                            vuePlayer.j2.isDisable = false
                            vuePlayer.j3.isDisable = false
                            vuePlayer.j4.isDisable = true
                            vuePlayer.j4.isVisible = false
                        }else{
                            vuePlayer.j2.isDisable = false
                            vuePlayer.j3.isDisable = true
                            vuePlayer.j3.isVisible = false
                            vuePlayer.j4.isDisable = true
                            vuePlayer.j4.isVisible = false
                        }

                    }
                    primaryStage.scene = Scene(vuePlayer, 950.0, 900.0)
                }
            } catch (ex: Exception) {
                if (ex is NumberFormatException) {
                    val alert = Alert(Alert.AlertType.WARNING)
                    alert.title = "Avertissement"
                    alert.headerText = "Clé et ID ne sont pas des nombres"
                    alert.contentText = "Veuillez entrer votre Clé et/ou votre id sous forme de nombres avant de continuer."
                    alert.showAndWait()
                }
                if (ex is UnknownIdException) {
                    val alert = Alert(Alert.AlertType.WARNING)
                    alert.title = "Avertissement"
                    alert.headerText = "ID incorrect"
                    alert.showAndWait()
                } else if (ex is IncorrectKeyException) {
                    val alert = Alert(Alert.AlertType.WARNING)
                    alert.title = "Avertissement"
                    alert.headerText = "Clé incorrect"
                    alert.showAndWait()
                }
            }
        }
    }
}