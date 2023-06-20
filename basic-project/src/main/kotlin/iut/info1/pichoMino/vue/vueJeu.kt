package iut.info1.pichoMino.vue

import javafx.scene.control.Label
import javafx.scene.layout.HBox

class vueJeu(playerUsername : String,playerId : Int): HBox() {

    var playerUsername :  String
    var playerId : Int

    init {
        this.playerUsername= playerUsername
        this.playerId = playerId
        var lbUsn = Label(this.playerUsername)
        var lbId =Label(this.playerId.toString())
        this.children.addAll(lbUsn,lbId)
    }

}