package pichoMino.vue

import javafx.collections.FXCollections
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.geometry.Insets
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.application.Application
import javafx.geometry.HPos
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.Priority
import javafx.scene.text.Font
import javafx.stage.Stage


class vueMenu: VBox() {
    var buttonPlay : Button
    var imagelogo: Image
    var imageview: ImageView
    var username:TextField
    //var buttonConnect : Button
    var creatPartie : RadioButton
    var nbJoueurText: Label
    var nbJoueur : ComboBox<Int>

    var joinPartie : RadioButton
    var gameKey : TextField
    var gameId : TextField
    var playerNumber : TextField

    var toggleGroup = ToggleGroup()

    var textPerso : Label
    var textPerso2 : Label
    var imagePersoJaune:Image
    var imageViewJaune:ImageView
    var imagePersoRouge:Image
    var imageViewRouge:ImageView
    var imagePersoVert:Image
    var imageViewVert:ImageView
    var imagePersoBleue:Image
    var imageViewBleue:ImageView

    var gameHasBeenCreated : Boolean


    init {
        val jockeyOneFont = Font.loadFont("file:./font/JockeyOne-Regular.ttf",20.0)
        this.gameHasBeenCreated = true
        this.imagelogo = Image("file:./image/pickomino_logo 1logo.png")
        this.imageview = ImageView(this.imagelogo)
        imageview.fitWidth = 100.0
        imageview.fitHeight = 100.0

        val jockeyOneFontBig = Font.loadFont("file:./font/JockeyOne-Regular.ttf",50.0)

        this.textPerso = Label("Choisis ton")
        this.textPerso.font = jockeyOneFontBig
        this.textPerso.textFill = Color.WHITE


        this.textPerso2 = Label("personnage :")
        this.textPerso2.font = jockeyOneFontBig
        this.textPerso2.textFill = Color.WHITE


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



        var lbGId = Label("Adresse de la partie")
        lbGId.font = jockeyOneFont
        lbGId.textFill = Color.WHITE

        gameId = TextField()
        gameId.setMaxSize(200.0, 100.0)

        var lbGKey = Label("Clé de la partie")
        lbGKey.font = jockeyOneFont
        lbGKey.textFill = Color.WHITE
        gameKey = TextField()
        gameKey.setMaxSize(200.0, 100.0)
        this.nbJoueurText = Label("Nombre de joueur")
        this.nbJoueurText.textFill = Color.WHITE
        nbJoueurText.font = jockeyOneFont
        var l = FXCollections.observableArrayList<Int>(2,3,4)
        nbJoueur = ComboBox(l)
        nbJoueur.selectionModel.selectFirst()
        buttonPlay = Button("Play")
        buttonPlay.setMinSize(200.0, 100.0)
        buttonPlay.setMaxSize(200.0, 100.0)
        buttonPlay.font = jockeyOneFontBig
        buttonPlay.textFill = Color.WHITESMOKE



        this.creatPartie = RadioButton("Créer une partie")
        this.creatPartie.textFill = Color.WHITE
        creatPartie.toggleGroup = toggleGroup
        creatPartie.isSelected = true // le radio button est selec. par défaut
        this.creatPartie.font = jockeyOneFont

        this.joinPartie = RadioButton("Rejoindre une partie")
        this.joinPartie.textFill = Color.WHITE
        joinPartie.toggleGroup = toggleGroup
        this.joinPartie.font = jockeyOneFont

        this.style = ("-fx-background-color : #8E7FEE")

        this.username = TextField()
        this.username.promptText = "Username"
        this.username.font = jockeyOneFont
        this.username.style = "-fx-background-radius: 10;"
        this.gameId = TextField()
        this.gameId.promptText = "Id de la partie"
        this.gameId.style = "-fx-background-radius: 10;"
        this.gameId.font = jockeyOneFont
        this.gameKey = TextField()
        this.gameKey.promptText = "Code de partie"
        this.gameKey.font = jockeyOneFont
        this.gameKey.style ="-fx-background-radius:10;"

        this.playerNumber = TextField()
        this.playerNumber.promptText = "Numéro de joueur"
        this.playerNumber.font = jockeyOneFont
        this.playerNumber.style ="-fx-background-radius:10;"


        var gridpane = GridPane()

        gridpane.add(this.buttonPlay, 0, 0)
        gridpane.add(this.imageview, 2, 0) //mettre le logo
        gridpane.add(this.username, 0, 1)
        gridpane.add(this.creatPartie, 0, 2)
        gridpane.add(this.nbJoueurText, 1, 1)
        gridpane.add(this.nbJoueur, 2, 1)
        gridpane.add(this.joinPartie, 0, 4)
        gridpane.add(lbGId, 0,6)
        gridpane.add(this.gameId, 0, 7)
        gridpane.add(lbGKey, 1, 6)
        gridpane.add(this.gameKey, 1, 7)
        gridpane.add(this.textPerso, 1, 2)
        gridpane.add(this.textPerso2, 1, 4)
        gridpane.add(this.playerNumber,0,8)

        // peut-être faire un deuxième gridpane dans le 1er
        var gridpane1 = GridPane()
        gridpane1.add(this.imageViewJaune, 0, 1)
        gridpane1.add(this.imageViewBleue, 1, 1)
        gridpane1.add(this.imageViewVert, 0, 2)
        gridpane1.add(this.imageViewRouge, 1, 2)


        val colonne1_1 = ColumnConstraints()
        colonne1_1.halignment = HPos.CENTER
        val colonne1_2 = ColumnConstraints()
        colonne1_2.halignment = HPos.CENTER
        gridpane1.columnConstraints.addAll(colonne1_1, colonne1_2)

        val colonne1 = ColumnConstraints()
        colonne1.percentWidth = 50.0
        colonne1.hgrow = Priority.ALWAYS
        colonne1.halignment = HPos.LEFT

        val colonne2 = ColumnConstraints()
        colonne2.percentWidth = 35.0
        colonne2.hgrow= Priority.ALWAYS
        colonne2.halignment = HPos.LEFT

        gridpane.columnConstraints.addAll(colonne1, colonne2)

        gridpane.add(gridpane1, 1, 5)
        gridpane.hgap = 10.0  // Ajuster l'espacement horizontal entre les colonnes
        gridpane.vgap = 10.0  // Ajuster l'espacement vertical entre les lignes


        this.children.addAll(gridpane)
        this.padding = Insets(20.0)
        this.minHeight = 800.0
        this.minWidth = 800.0
    }
}
