package iut.info1.pichoMino

import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.DICE
import iut.info1.pickomino.data.STATUS
import iut.info1.pickomino.exceptions.BadPickominoChosenException
import iut.info1.pickomino.exceptions.BadStepException
import iut.info1.pickomino.exceptions.DiceAlreadyKeptException

class Player {
    var playerId : Int
    var playerName : String
    var gameId : Int
    var gameKey : Int
    var connect : Connector

    init {
        playerId = 0
        playerName = "moustik"
        gameId = 0
        gameKey = 0
        connect = Connector.factory("172.26.82.76", "8080")
    }

    fun choiceDices(dices : List<DICE>) : List<DICE>?{
        try{
            return connect.choiceDices(gameId, gameKey, dices)
        }catch (ex : Exception){
            if (ex == BadStepException()){
                println("On ne peut pas appeler cette méthode à ce moment là du tour")
            }
            return null
        }
    }

    fun rollDices(): List<DICE> {
        return connect.rollDices(gameId, gameKey)
    }

    fun keepDices(dice: DICE) : Boolean{
        try {
            return connect.keepDices(gameId,gameKey,dice)
        }catch (ex : Exception){
            println(ex === DiceAlreadyKeptException())
            if (ex == BadStepException()){
                println("On ne peut pas appeler cette méthode à ce moment là du tour")
            }else if (ex == DiceAlreadyKeptException()){
                println("Ce pickomino a déjà été gardé")
            }
            return false
        }
    }

    fun takePickomino(pickomino: Int):Boolean{
        try {
            return connect.takePickomino(gameId,gameKey,pickomino)
        }catch (ex : Exception){
            if (ex == BadStepException()){
                println("On ne peut pas appeler cette méthode à ce moment là du tour")
            }else if (ex == BadPickominoChosenException()){
                println("Pickomino Incorrect")
            }
            return false
        }

    }
}