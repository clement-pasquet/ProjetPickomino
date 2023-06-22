package iut.info1.pichoMino.controleur

import iut.info1.pichoMino.vue.vuePrincipale
import javafx.scene.image.Image
import javafx.scene.image.ImageView

fun updatePiles(vuePrincipale: vuePrincipale) {
    var gameId = vuePrincipale.player.gameId
    var gameKey = vuePrincipale.player.gameKey
    var topOfPile =  vuePrincipale.connect.gameState(gameId,gameKey).pickosStackTops()

    var imgB : Image
    imgB = Image("Domino/" + topOfPile[0].toString() + ".png")
    var imgBView = ImageView(imgB)
    imgBView.fitHeight = imgB.height * 0.5
    imgBView.fitWidth = imgB.width * 0.5

    vuePrincipale.pb.graphic = imgBView


    var imgH : Image
    imgH = Image("Domino/" + topOfPile[1].toString() + ".png")
    var imgHView = ImageView(imgH)
    imgHView.fitHeight = imgH.height * 0.5
    imgHView.fitWidth = imgH.width * 0.5

    vuePrincipale.ph.graphic = imgHView

    if (topOfPile.size == 4){
        var imgG : Image
        imgG = Image("Domino/" + topOfPile[2].toString() + ".png")
        var imgGView = ImageView(imgG)
        imgGView.fitHeight = imgG.height * 0.5
        imgGView.fitWidth = imgG.width * 0.5

        vuePrincipale.pg.graphic = imgGView

        var imgD : Image
        imgD = Image("Domino/" + topOfPile[3].toString() + ".png")
        var imgDView = ImageView(imgD)
        imgDView.fitHeight = imgD.height * 0.5
        imgDView.fitWidth = imgD.width * 0.5

        vuePrincipale.pg.graphic = imgDView
    }else if (topOfPile.size== 3 ){
        var imgG : Image
        imgG = Image("Domino/" + topOfPile[2].toString() + ".png")
        var imgGView = ImageView(imgG)
        imgGView.fitHeight = imgG.height * 0.5
        imgGView.fitWidth = imgG.width * 0.5

        vuePrincipale.pg.graphic = imgGView
    }


}