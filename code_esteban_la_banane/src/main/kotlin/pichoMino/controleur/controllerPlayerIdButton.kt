package pichoMino.controleur

import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import javafx.stage.Stage
import pichoMino.vue.vueJeu
import pichoMino.vue.vuePlayer


class controllerPlayerIdButton(vuePlayer: vuePlayer,primaryStage: Stage,playerId : Int,playerUsername : String) :EventHandler<MouseEvent> {
    var vuePlayer : vuePlayer
    var primaryStage : Stage
    var playerId : Int
    var playerUsername : String

    init {
        this.vuePlayer = vuePlayer
        this.primaryStage = primaryStage
        this.playerId = playerId
        this.playerUsername = playerUsername
    }

    override fun handle(event: MouseEvent) {
        if (event.source is Button) {
            val button: Button = event.source as Button
            playerId = button.text[1].digitToInt()
            var vueJeu = vueJeu(playerUsername,playerId)
            primaryStage.scene = Scene(vueJeu,950.0,900.0)
        }
    }
}