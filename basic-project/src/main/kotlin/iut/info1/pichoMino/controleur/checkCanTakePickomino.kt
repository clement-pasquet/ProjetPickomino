package iut.info1.pichoMino.controleur

import iut.info1.pichoMino.vue.vuePrincipale
import iut.info1.pickomino.data.DICE
import javafx.scene.image.Image
import javafx.scene.image.ImageView

fun checkCanTakePickomino(dices : List<DICE>,vuePrincipale: vuePrincipale) {
    var hasWorm = false
    var score = 0

    for (dice in dices){
        score += dice.ordinal

        if (dice == DICE.worm){
            hasWorm = true
        }
    }
    vuePrincipale.listPickominos

    if( score > 20 ){
        var isSuperior = true
        var i =0
        while (isSuperior){
            var imgV = vuePrincipale.listPickominos[i].graphic as ImageView
            if (imgV.image.url.split("Des/")[1].split(".")[0].toInt() <= score){
                vuePrincipale.listPickominos[i].isDisable = false
                i += 1
            }else{
                isSuperior = false
            }
        }
    }

}