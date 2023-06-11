import iut.info1.pickomino.Connector

fun main() {
    println("Hello students !!!")

    val connect = Connector.factory("0.0.0.0", "8080")
    println(connect.listOfGameIds())
}