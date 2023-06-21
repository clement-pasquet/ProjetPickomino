package iut.info1.pichoMino.controleur

import iut.info1.pichoMino.vue.vuePrincipale
import iut.info1.pickomino.data.DICE
import javafx.scene.image.Image
import javafx.scene.image.ImageView

fun checkCanTakePickomino(dices : List<DICE>,vuePrincipale: vuePrincipale) {
    var hasWorm = false
    var score = 0

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

    if( score > 20 ){
        for (i in 0 until vuePrincipale.listPickominos.size){
            var imgV = vuePrincipale.listPickominos[i].graphic as ImageView
            if (imgV.image.url.split("Domino/")[1].split(".")[0].toInt() == score){
                vuePrincipale.listPickominos[i].isDisable = false
                var contrChooseP = controllerChoosePickomino(vuePrincipale)
                vuePrincipale.listPickominos[i].onMouseClicked = contrChooseP
            }else{
                vuePrincipale.listPickominos[i].isDisable = true
            }
        }
    }

}