package iut.info1.pichoMino.controleur

import iut.info1.pichoMino.vue.vuePrincipale
import iut.info1.pickomino.Connector

fun updatePickos(vuePrincipale: vuePrincipale,connect : Connector) {
    var gameId = vuePrincipale.player.gameId
    var gameKey = vuePrincipale.player.gameKey
    var availablePickos = connect.gameState(gameId,gameKey).accessiblePickos()
    var actualPickos = listOf(vuePrincipale.p21,vuePrincipale.p22,vuePrincipale.p23,vuePrincipale.p24,vuePrincipale.p25,vuePrincipale.p26,vuePrincipale.p27,vuePrincipale.p28,vuePrincipale.p29,vuePrincipale.p30,vuePrincipale.p31,vuePrincipale.p32,vuePrincipale.p33,vuePrincipale.p34,vuePrincipale.p35,vuePrincipale.p36)

    vuePrincipale.listPickominos = listOf()

    for (indice in availablePickos){
        vuePrincipale.listPickominos += actualPickos[indice-21]
    }

}