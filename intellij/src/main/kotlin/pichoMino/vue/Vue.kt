package pichoMino.vue

import javafx.collections.FXCollections
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.RadioButton
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color



class Vue: VBox() {
    var buttonPlay : Button
    var image: Image
    var imageview: ImageView
    var username:TextField
     //var buttonConnect : Button
    var creatPartie : RadioButton
    var nbJoueur : ComboBox<Int>

    var joinPartie : RadioButton
    var gameKey : TextField
    var gameId : TextField


    init {
//        buttonConnect = Button("Connect")
//        buttonConnect.setMinSize(200.0, 100.0)
//        buttonConnect.setMaxSize(200.0, 100.0)
        this.image = Image("file:./image/Domino/Group 11domino34.png")
        this.imageview = ImageView(this.image)

        var lbGId = Label("Addresse de la partie")
        gameId = TextField()
        gameId.setMaxSize(200.0, 100.0)

        var lbGKey = Label("Clé de la partie")
        gameKey = TextField()
        gameKey.setMaxSize(200.0, 100.0)
        var lbNbPartie = Label("Nombre de partie")
        var l = FXCollections.observableArrayList<Int>(2,3,4)
        nbJoueur = ComboBox(l)
        nbJoueur.selectionModel.selectFirst()
        buttonPlay = Button("Play")
        buttonPlay.setMinSize(200.0, 100.0)
        buttonPlay.setMaxSize(200.0, 100.0)

        this.creatPartie = RadioButton("Créer une partie")
        this.creatPartie.style = ("-fx-font-size : 200px") // j'ai l'impression que la taille de police sur le texte radiobt ne fais rien
        this.creatPartie.style = ("-fx-font-family: sans-serif")
        this.creatPartie.textFill = Color.WHITE

        this.joinPartie = RadioButton("Rejoindre une partie")
        this.joinPartie.style = ("-fx-font-size : 200px")
        this.joinPartie.style = ("-fx-font-family: sans-serif")
        this.joinPartie.textFill = Color.WHITE

        this.style = ("-fx-background-color : #8E7FEE")

        this.username = TextField()
        this.username.promptText = "Username"
        this.gameId = TextField()
        this.gameId.promptText = "Id de la partie"
        this.gameKey = TextField()
        this.gameKey.promptText = "Code de partie"

        var gridpane = GridPane()

        gridpane.add(this.buttonPlay, 0, 0)
        gridpane.add(this.imageview, 1, 0) //mettre le logo
        gridpane.add(this.username, 0, 1)
        gridpane.add(this.creatPartie, 0, 2)
        gridpane.add(this.nbJoueur, 0, 3)
        gridpane.add(this.joinPartie, 0, 4)
        gridpane.add(this.gameId, 0, 5)
        gridpane.add(this.gameKey, 1, 5)
        gridpane.vgap = 20.0
        gridpane.hgap = 20.0


        this.children.addAll(gridpane)
        this.padding = Insets(100.0)
    }
}
