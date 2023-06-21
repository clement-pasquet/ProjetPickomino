package pichoMino.controleur

import iut.info1.pichoMino.Player
import iut.info1.pichoMino.controleur.controllerRoll
import iut.info1.pichoMino.vue.VueMenu
import iut.info1.pichoMino.vue.vuePrincipale
import iut.info1.pickomino.Connector
import iut.info1.pickomino.exceptions.IncorrectKeyException
import iut.info1.pickomino.exceptions.UnknownIdException
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.RadioButton
import javafx.scene.input.MouseEvent
import javafx.stage.Stage

class controllerPlay(vueMenu : VueMenu, connect : Connector, primaryStage : Stage, player: Player):  EventHandler<MouseEvent>{
    private val vueMenu : VueMenu
    private val connect : Connector
    private val primaryStage : Stage
    private var player : Player


    init {
        this.vueMenu = vueMenu
        this.connect = connect
        this.primaryStage = primaryStage
        this.player= player
    }

    override fun handle(event: MouseEvent) {
        val selectedButton = vueMenu.toggleGroup.selectedToggle as RadioButton?

        if (selectedButton == vueMenu.joinPartie){

            if (vueMenu.gameKey.text == "" || vueMenu.gameId.text== ""){
                val alert = Alert(Alert.AlertType.WARNING)
                alert.title = "Avertissement"
                alert.headerText = "Clé ou ID est vide"
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

                    }else if (vueMenu.playerNumber.text==""){
                        println("Please enter a player number!")
                        val alert = Alert(Alert.AlertType.WARNING)
                        alert.title = "Avertissement"
                        alert.headerText = "Numéro de joueur manquant"
                        alert.contentText = "Veuillez entrer votre numéro avant de continuer."
                        alert.showAndWait()
                    }else {
                        player.playerName = vueMenu.username.text
                        player.playerId = vueMenu.playerNumber.text.toInt()
                        player.gameId = vueMenu.gameId.text.toInt()
                        player.gameKey = vueMenu.gameKey.text.toInt()
                        var vuePrincipale = vuePrincipale(player,connect)
                        var controllerRoll = controllerRoll(vuePrincipale,connect)
                        vuePrincipale.buttonRollDice.onMouseClicked = controllerRoll
                        primaryStage.scene = Scene(vuePrincipale,1600.0,900.0)
                    }
                } catch (ex: Exception) {
                    if (ex is NumberFormatException) {
                        val alert = Alert(Alert.AlertType.WARNING)
                        alert.title = "Avertissement"
                        alert.headerText = "Clé ou ID n'est pas un nombre"
                        alert.contentText = "Veuillez entrer votre Clé et/ou votre ID sous forme de nombres avant de continuer."
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
        if (selectedButton == vueMenu.creatPartie){
            println("Nouvelle partie choisie")
            var identification =  connect.newGame(vueMenu.nbJoueur.value)
            var id = identification.first
            var key = identification.second
            vueMenu.gameId.text = id.toString()
            vueMenu.gameKey.text = key.toString()
            vueMenu.gameHasBeenCreated = true
        }

    }
}