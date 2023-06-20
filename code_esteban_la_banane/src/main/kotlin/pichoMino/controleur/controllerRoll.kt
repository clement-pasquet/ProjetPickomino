package pichoMino.controleur

import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.STATUS
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import pichoMino.vue.vueJeu

class controllerRoll(vueJeu: vueJeu,connect: Connector): EventHandler<MouseEvent> {
    private val vueJeu : vueJeu
    private val connect : Connector


    init {
        this.vueJeu = vueJeu
        this.connect = connect
    }

    override fun handle(event: MouseEvent) {
        var gameId = vueJeu.player.gameId
        var gameKey = vueJeu.player.gameKey
        if (connect.gameState(gameId,gameKey).current.status== STATUS.ROLL_DICE || connect.gameState(gameId,gameKey).current.status== STATUS.ROLL_DICE_OR_TAKE_PICKOMINO) {
            var rolled = vueJeu.player.rollDices()
            println("rolling dices...")
            println(rolled)
            vueJeu.rolled.text = rolled?.joinToString()
        }
    }
}