import iut.info1.pickomino.Connector

fun main() {
    println("Hello students !!!")
    val connect = Connector.factory("172.26.82.76", "8080")
    println("Parties actives sur le serveur = ${connect.listOfGameIds()}")
    val identification = connect.newGame(3)
    val id = identification.first
    val key = identification.second
    val currentGame = connect.gameState(id, key)
    println("Nouvelle partie = $currentGame")
}