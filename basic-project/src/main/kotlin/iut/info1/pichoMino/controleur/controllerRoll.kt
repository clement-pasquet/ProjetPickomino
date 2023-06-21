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

//            checkCanTakePickomino(dices,vuePrincipale)
//
//            var imgD1 = ImageView(Image(vuePrincipale.desImages[dices[0].ordinal]))
//            imgD1.fitHeight = 50.0
//            imgD1.fitWidth = 50.0
//            var imgD2 = ImageView(Image(vuePrincipale.desImages[dices[1].ordinal]))
//            imgD2.fitHeight = 50.0
//            imgD2.fitWidth = 50.0
//            var imgD3 = ImageView(Image(vuePrincipale.desImages[dices[2].ordinal]))
//            imgD3.fitHeight = 50.0
//            imgD3.fitWidth = 50.0
//            var imgD4 = ImageView(Image(vuePrincipale.desImages[dices[3].ordinal]))
//            imgD4.fitHeight = 50.0
//            imgD4.fitWidth = 50.0
//            var imgD5 = ImageView(Image(vuePrincipale.desImages[dices[4].ordinal]))
//            imgD5.fitHeight = 50.0
//            imgD5.fitWidth = 50.0
//            var imgD6 = ImageView(Image(vuePrincipale.desImages[dices[5].ordinal]))
//            imgD6.fitHeight = 50.0
//            imgD6.fitWidth = 50.0
//            var imgD7 = ImageView(Image(vuePrincipale.desImages[dices[6].ordinal]))
//            imgD7.fitHeight = 50.0
//            imgD7.fitWidth = 50.0
//            var imgD8 = ImageView(Image(vuePrincipale.desImages[dices[7].ordinal]))
//            imgD8.fitHeight = 50.0
//            imgD8.fitWidth = 50.0

//            vuePrincipale.db1.graphic = imgD1
//            vuePrincipale.db2.graphic = imgD2
//            vuePrincipale.db3.graphic = imgD3
//            vuePrincipale.db4.graphic = imgD4
//            vuePrincipale.db5.graphic = imgD5
//            vuePrincipale.db6.graphic = imgD6
//            vuePrincipale.db7.graphic = imgD7
//            vuePrincipale.db8.graphic = imgD8

            vuePrincipale.desBoxB.spacing = 7.50
            vuePrincipale.desBoxB.children.addAll(vuePrincipale.db1,vuePrincipale.db2,vuePrincipale.db3,vuePrincipale.db4,vuePrincipale.db5,vuePrincipale.db6,vuePrincipale.db7,vuePrincipale.db8,vuePrincipale.pb)


        }
    }
}