package iut.info1.pichoMino.controleur

import iut.info1.pichoMino.vue.vuePrincipale
import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.STATUS
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent

class controllerRoll(vuePrincipale: vuePrincipale, connect: Connector): EventHandler<MouseEvent> {
    private val vuePrincipale : vuePrincipale
    private val connect : Connector


    init {
        this.vuePrincipale = vuePrincipale
        this.connect = connect
    }

    override fun handle(event: MouseEvent) {
        var gameId = vuePrincipale.player.gameId
        var gameKey = vuePrincipale.player.gameKey
        if (connect.gameState(gameId,gameKey).current.status== STATUS.ROLL_DICE || connect.gameState(gameId,gameKey).current.status== STATUS.ROLL_DICE_OR_TAKE_PICKOMINO) {
            updatePiles(vuePrincipale)
            var rolled =vuePrincipale.player.rollDices()
            var kept = connect.gameState(gameId,gameKey).current.keptDices

            vuePrincipale.player.keptDices = kept

            checkCanTakePickomino(kept,vuePrincipale)

            vuePrincipale.desBoxB.children.clear()

            var listImages = listOf<ImageView>()
            var listImagesKept = listOf<ImageView>()
            var listDices = listOf(vuePrincipale.db1,vuePrincipale.db2,vuePrincipale.db3,vuePrincipale.db4,vuePrincipale.db5,vuePrincipale.db6,vuePrincipale.db7,vuePrincipale.db8)

            for (dice in rolled){
                var imgV = ImageView(Image(vuePrincipale.desImages[dice.ordinal]))
                imgV.fitWidth = 50.0
                imgV.fitHeight = 50.0
                listImages+= imgV
            }
            for (dice in kept) {
                var imgV = ImageView(Image(vuePrincipale.desImages[dice.ordinal]))
                imgV.fitWidth = 50.0
                imgV.fitHeight = 50.0
                listImagesKept += imgV
            }

            var i = 0
            while (i<listImages.size){
                listDices[i].graphic = listImages[i]
                listDices[i].isDisable = false
                i+=1
            }
            if (i<8){
                while (i-listImages.size<listImagesKept.size){
                    listDices[i].graphic = listImagesKept[i-listImages.size]
                    listDices[i].isDisable = true
                    i++
                }
            }

            vuePrincipale.desBoxB.spacing = 7.50
            vuePrincipale.desBoxB.children.addAll(vuePrincipale.db1,vuePrincipale.db2,vuePrincipale.db3,vuePrincipale.db4,vuePrincipale.db5,vuePrincipale.db6,vuePrincipale.db7,vuePrincipale.db8,vuePrincipale.pb)


        }
    }
}