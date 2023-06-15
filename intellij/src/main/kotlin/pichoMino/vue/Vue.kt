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
import javafx.application.Application
import javafx.geometry.HPos
import javafx.scene.Scene
import javafx.scene.layout.ColumnConstraints
import javafx.stage.Stage


class Vue: VBox() {
    var buttonPlay : Button
    var imagelogo: Image
    var imageview: ImageView
    var username:TextField
     //var buttonConnect : Button
    var creatPartie : RadioButton
    // var nbJoueurText: Label
    var nbJoueur : ComboBox<Int>

    var joinPartie : RadioButton
    var gameKey : TextField
    var gameId : TextField

    var textPerso : Label
    var imagePersoJaune:Image
    var imageViewJaune:ImageView
    var imagePersoRouge:Image
    var imageViewRouge:ImageView
    var imagePersoVert:Image
    var imageViewVert:ImageView
    var imagePersoBleue:Image
    var imageViewBleue:ImageView


    init {
//        buttonConnect = Button("Connect")
//        buttonConnect.setMinSize(200.0, 100.0)
//        buttonConnect.setMaxSize(200.0, 100.0)
        this.imagelogo = Image("file:./image/pickomino_logo 1logo.png")
        this.imageview = ImageView(this.imagelogo)
        imageview.fitWidth = 100.0
        imageview.fitHeight = 100.0

        this.textPerso = Label("Choisis ton personnage")
        this.textPerso.style = ("-fx-font-size : 30px")
        this.textPerso.style = ("-fx-font-weight : bold")

        this.imagePersoJaune = Image("file:./image/Personnages/worm_yellow_cute1jaune.png")
        this.imageViewJaune = ImageView(this.imagePersoJaune)
        imageViewJaune.fitWidth = 100.0
        imageViewJaune.fitHeight = 100.0


        this.imagePersoBleue = Image("file:./image/Personnages/worm_blue_cute1.png")
        this.imageViewBleue = ImageView(this.imagePersoBleue)
        imageViewBleue.fitWidth = 100.0
        imageViewBleue.fitHeight = 100.0

        this.imagePersoVert = Image("file:./image/Personnages/worm_green_cute1.png")
        this.imageViewVert = ImageView(this.imagePersoVert)
        imageViewVert.fitWidth = 100.0
        imageViewVert.fitHeight = 100.0

        this.imagePersoRouge = Image("file:./image/Personnages/worm_red_cute1.png")
        this.imageViewRouge = ImageView(this.imagePersoRouge)
        imageViewRouge.fitWidth = 100.0
        imageViewRouge.fitHeight = 100.0



        var lbGId = Label("Addresse de la partie")
        gameId = TextField()
        gameId.setMaxSize(200.0, 100.0)

        var lbGKey = Label("Clé de la partie")
        gameKey = TextField()
        gameKey.setMaxSize(200.0, 100.0)
        var lbNbPartie = Label("Nombre de Partie")
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
        gridpane.add(lbGId, 0,5)
        gridpane.add(this.gameId, 0, 6)
        gridpane.add(lbGKey, 1, 5)
        gridpane.add(this.gameKey, 1, 6)
        gridpane.add(this.textPerso, 1, 2)
        // peut-être faire un deuxième gridpane dans le 1er
        var gridpane1 = GridPane()
        gridpane1.add(this.imageViewJaune, 0, 1)
        gridpane1.add(this.imageViewBleue, 1, 1)
        gridpane1.add(this.imageViewVert, 0, 2)
        gridpane1.add(this.imageViewRouge, 1, 2)
        gridpane.add(gridpane1, 1, 3)
        gridpane.vgap = 20.0
        gridpane.hgap = 20.0

        val colonne1 = ColumnConstraints()
        colonne1.percentWidth = 50.0
        colonne1.halignment = HPos.LEFT

        val colonne2 = ColumnConstraints()
        colonne2.percentWidth = 50.0
        colonne2.halignment = HPos.CENTER

        gridpane.columnConstraints.addAll(colonne1, colonne2)



        this.children.addAll(gridpane)
        this.padding = Insets(100.0)
    }
}