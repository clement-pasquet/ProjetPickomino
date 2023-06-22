package iut.info1.pichoMino.vue

import javafx.collections.FXCollections
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.text.Font

import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import javax.sound.sampled.LineEvent
import javax.sound.sampled.LineListener



class VueMenu: HBox() {
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

        try {
            var filePath = "/Musique/Sonus_Ad_Astra_wav.wav"
            val audioInputStream: AudioInputStream = AudioSystem.getAudioInputStream(this::class.java.getResource("/Musique/Sonus_Ad_Astra_wav.wav"))
            val clip: Clip = AudioSystem.getClip()
            clip.open(audioInputStream)
            clip.loop(Clip.LOOP_CONTINUOUSLY)

            print("met la musique charly !")

            clip.addLineListener(object : LineListener {
                override fun update(event: LineEvent) {
                    if (event.type == LineEvent.Type.STOP) {
                        clip.loop(Clip.LOOP_CONTINUOUSLY)
                    }
                }
            })

            clip.loop(Clip.LOOP_CONTINUOUSLY)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        var font1 = javaClass.getResourceAsStream("/font/JockeyOne-Regular.ttf")
        var font3 = javaClass.getResourceAsStream("/font/JockeyOne-Medium.ttf")
        var font4 = javaClass.getResourceAsStream("/font/JockeyOne-Little.ttf")
        var jockeyOneFont = Font.loadFont(font1,20.0)
        var jockeyOneFontMedium = Font.loadFont(font3,30.0)
        var jockeyOneFontLittle = Font.loadFont(font4,17.0)
        this.gameHasBeenCreated = true
        this.imagelogo = Image("pickomino_logo 1logo.png")

        this.imageview = ImageView(this.imagelogo)
        imageview.fitWidth = 100.0
        imageview.fitHeight = 100.0
        var font2 = javaClass.getResourceAsStream("/font/JockeyOne-Fat.ttf")
        var jockeyOneFontBig = Font.loadFont(font2,60.0)

        this.textPerso = Label("Choisis ton")
        this.textPerso.font = jockeyOneFontMedium
        this.textPerso.textFill = Color.WHITE

        this.textPerso2 = Label("personnage :")
        this.textPerso2.font = jockeyOneFontBig
        this.textPerso2.textFill = Color.WHITE

        this.imagePersoJaune = Image("Personnages/worm_yellow_cute1jaune.png")
        this.imageViewJaune = ImageView(this.imagePersoJaune)
        imageViewJaune.fitWidth = 100.0
        imageViewJaune.fitHeight = 100.0

        this.imagePersoBleue = Image("Personnages/worm_blue_cute1.png")
        this.imageViewBleue = ImageView(this.imagePersoBleue)
        imageViewBleue.fitWidth = 100.0
        imageViewBleue.fitHeight = 100.0

        this.imagePersoVert = Image("Personnages/worm_green_cute1.png")
        this.imageViewVert = ImageView(this.imagePersoVert)
        imageViewVert.fitWidth = 100.0
        imageViewVert.fitHeight = 100.0

        this.imagePersoRouge = Image("Personnages/worm_red_cute1.png")
        this.imageViewRouge = ImageView(this.imagePersoRouge)
        imageViewRouge.fitWidth = 100.0
        imageViewRouge.fitHeight = 100.0

        val lbGId = Label("Adresse de la partie")
        lbGId.textFill = Color.WHITE
        lbGId.font = jockeyOneFont

        gameId = TextField()
        gameId.setMaxSize(200.0, 100.0)

        var lbGKey = Label("Clé de la partie")
        lbGKey.textFill = Color.WHITE
        lbGKey.font = jockeyOneFont
        gameKey = TextField()

        this.nbJoueurText = Label("Nombre de joueurs")
        this.nbJoueurText.textFill = Color.WHITE
        nbJoueurText.font = jockeyOneFontMedium

        nbJoueur = ComboBox()
        var l = FXCollections.observableArrayList<Int>(2,3,4)
        nbJoueur.items = l
        nbJoueur.selectionModel.selectFirst()
        nbJoueur.style = "-fx-background-radius:10; -fx-background-color: #FFFFF;"

        buttonPlay = Button("Create")
        buttonPlay.setMinSize(200.0, 100.0)
        buttonPlay.setMaxSize(200.0, 100.0)
        buttonPlay.font = jockeyOneFontMedium
        buttonPlay.textFill = Color.WHITE
        buttonPlay.style = "-fx-background-radius:15;"

        this.creatPartie = RadioButton("Créer partie")
        this.creatPartie.textFill = Color.WHITE
        creatPartie.toggleGroup = toggleGroup
        creatPartie.isSelected = true // le radio button est selec. par défaut
        this.creatPartie.font = jockeyOneFontLittle

        this.joinPartie = RadioButton("Rejoindre partie")
        this.joinPartie.textFill = Color.WHITE
        joinPartie.toggleGroup = toggleGroup
        this.joinPartie.font = jockeyOneFontLittle

        this.style = ("-fx-background-color : #8E7FEE")

        this.username = TextField()
        this.username.promptText = "Username"
        this.username.font = jockeyOneFont
        this.username.style = "-fx-background-radius: 10;"
        this.username.setMaxSize(300.0, 50.0)
        this.username.setPrefSize(300.0, 50.0)
        this.gameId = TextField()
        this.gameId.promptText = "Id de la partie"
        this.gameId.style = "-fx-background-radius: 10;"
        this.gameId.font = jockeyOneFont
        this.gameId.setMaxSize(300.0, 50.0)
        this.gameId.setPrefSize(300.0, 50.0)
        this.gameKey = TextField()
        this.gameKey.promptText = "Code de partie"
        this.gameKey.font = jockeyOneFont
        this.gameKey.style ="-fx-background-radius:10;"
        this.gameKey.setMaxSize(300.0, 50.0)
        this.gameKey.setPrefSize(300.0, 50.0)

        this.playerNumber = TextField()
        this.playerNumber.setMaxSize(300.0, 50.0)
        this.playerNumber.setPrefSize(300.0, 50.0)
        this.playerNumber.promptText = "Numéro de joueur"
        this.playerNumber.font = jockeyOneFont
        this.playerNumber.style ="-fx-background-radius:10;"

        var vBox1 = VBox()
        vBox1.alignment = Pos.CENTER
        vBox1.spacing = 20.0
        this.imageview.fitWidth = 250.0
        this.imageview.fitHeight = 250.0
        var hBox3 = HBox()
        hBox3.spacing = 20.0 ///////////////////////////////
        hBox3.children.addAll(this.creatPartie, this.joinPartie)
        vBox1.children.addAll(this.imageview, hBox3, this.username, this.playerNumber, buttonPlay)
        var gridpane1 = GridPane()

        this.imageViewBleue.fitHeight = 170.0
        this.imageViewBleue.fitWidth = 170.0
        this.imageViewJaune.fitWidth = 170.0
        this.imageViewJaune.fitHeight = 170.0
        this.imageViewVert.fitWidth = 170.0
        this.imageViewVert.fitHeight = 170.0
        this.imageViewRouge.fitHeight = 150.0
        this.imageViewRouge.fitWidth = 150.0

        gridpane1.add(this.imageViewJaune, 0,0)
        gridpane1.add(this.imageViewRouge, 1, 0)
        gridpane1.add(this.imageViewBleue, 0,1)
        gridpane1.add(this.imageViewVert, 1, 1)
        gridpane1.hgap = 60.0
        gridpane1.vgap = 60.0
        var vBox2 = VBox()
        vBox2.spacing = 20.0
        var vBox2_1 = VBox()
        vBox2_1.alignment = Pos.CENTER_LEFT
        vBox2_1.spacing = -30.0
        vBox2_1.children.addAll(this.textPerso, this.textPerso2)
        var hBoxmini = HBox()
        hBoxmini.children.addAll(this.nbJoueurText, this.nbJoueur)
        hBoxmini.spacing = 20.0
        hBoxmini.alignment = Pos.CENTER_LEFT
        vBox2.children.addAll(hBoxmini, vBox2_1, gridpane1)

        var vBox0 = VBox()
        vBox0.spacing = 20.0
        vBox0.children.addAll( lbGId, this.gameId, lbGKey,this.gameKey)

        this.children.addAll(vBox0,vBox1, vBox2)

        this.padding = Insets(100.0)
        this.spacing = 80.0
        this.minHeight = 800.0
        this.minWidth = 800.0
    }
}
