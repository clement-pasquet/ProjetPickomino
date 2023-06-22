package iut.info1.pichoMino.controleur

import iut.info1.pichoMino.vue.vuePrincipale
import iut.info1.pickomino.data.DICE
import javafx.scene.image.Image
import javafx.scene.image.ImageView

fun checkCanTakePickomino(dices : List<DICE>,vuePrincipale: vuePrincipale) {
    var hasWorm = false
    var score = 0
    var gameId = vuePrincipale.player.gameId
    var gameKey = vuePrincipale.player.gameKey

    for (dice in dices){
        if (dice != DICE.worm) {
            score += dice.ordinal+1
        }
        else{
            score += dice.ordinal
            hasWorm = true
        }
    }

    println(dices)
    println(score)
    if (hasWorm) {
        if (score > 20) {
            for (i in 0 until vuePrincipale.listPickominos.size) {
                var imgV = vuePrincipale.listPickominos[i].graphic as ImageView
                if (imgV.image.url.split("Domino/")[1].split(".")[0].toInt() == score) {
                    vuePrincipale.listPickominos[i].isDisable = false
                    var contrChooseP = controllerChoosePickomino(vuePrincipale)
                    vuePrincipale.listPickominos[i].onMouseClicked = contrChooseP
                } else {
                    vuePrincipale.listPickominos[i].isDisable = true
                }
            }
            var topPiles =  vuePrincipale.connect.gameState(gameId,gameKey).pickosStackTops()
            for (i in 0 until topPiles.size){
                if (topPiles[i]==score){
                    if (i != vuePrincipale.connect.gameState(gameId,gameKey).current.player){
                        vuePrincipale.listPickominos[topPiles[i]-21].isDisable = false
                    }
                }else{
                    vuePrincipale.listPickominos[topPiles[i]-21].isDisable = true
                    var contrChooseP = controllerChoosePickomino(vuePrincipale)
                    vuePrincipale.listPickominos[topPiles[i]-21].onMouseClicked = contrChooseP
                }
            }
        }
    }
}