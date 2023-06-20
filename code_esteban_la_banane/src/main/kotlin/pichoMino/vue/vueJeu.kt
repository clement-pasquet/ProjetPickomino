package pichoMino.vue

import iut.info1.pickomino.data.Game
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import pichoMino.Player

class vueJeu(player: Player): HBox() {

    var player : Player
    var buttonRoll : Button
    var rolled :  Label

    init {
        this.player = player
        this.rolled = Label("Dés")
        var lbUsn = Label(this.player.playerName)
        var lbId =Label(this.player.playerId.toString())
        this.buttonRoll = Button("Roll")
        this.spacing= 10.0
        this.children.addAll(lbUsn,lbId,buttonRoll,rolled)
    }

}