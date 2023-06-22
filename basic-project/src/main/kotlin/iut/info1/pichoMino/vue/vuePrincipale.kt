package iut.info1.pichoMino.vue

import iut.info1.pichoMino.Player
import iut.info1.pichoMino.controleur.controllerChoosePickomino
import iut.info1.pichoMino.controleur.controllerKeepDices
import iut.info1.pickomino.Connector
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.paint.Color

class vuePrincipale(player: Player,connector : Connector) : VBox() {
    var player : Player
    var connect : Connector
    var pickominoImages : List<String>
    var desImages : List<String>
    var buttonRollDice : Button

    var p21 : Button
    var p22 : Button
    var p23 : Button
    var p24 : Button
    var p25 : Button
    var p26 : Button
    var p27 : Button
    var p28 : Button
    var p29 : Button
    var p30 : Button
    var p31 : Button
    var p32 : Button
    var p33 : Button
    var p34 : Button
    var p35 : Button
    var p36 : Button

    var listPickominos : List<Button>

    var db1 : Button
    var db2 : Button
    var db3 : Button
    var db4 : Button
    var db5 : Button
    var db6 : Button
    var db7 : Button
    var db8 : Button
    var pb : Button

    var listBoutonB : List<Button>

    var dg1 : Button
    var dg2 : Button
    var dg3 : Button
    var dg4 : Button
    var dg5 : Button
    var dg6 : Button
    var dg7 : Button
    var dg8 : Button
    var pg : Button

    var dd1 : Button
    var dd2 : Button
    var dd3 : Button
    var dd4 : Button
    var dd5 : Button
    var dd6 : Button
    var dd7 : Button
    var dd8 : Button
    var pd : Button

    var dh1 : Button
    var dh2 : Button
    var dh3 : Button
    var dh4 : Button
    var dh5 : Button
    var dh6 : Button
    var dh7 : Button
    var dh8 : Button
    var ph : Button


    var desBoxG : VBox
    var desBoxB : HBox
    var desBoxD : VBox
    var desBoxH : HBox
    init {
        connect = connector
        this.player = player
        pickominoImages = listOf(
            "Domino/21.png",
            "Domino/22.png",
            "Domino/23.png",
            "Domino/24.png",
            "Domino/25.png",
            "Domino/26.png",
            "Domino/27.png",
            "Domino/28.png",
            "Domino/29.png",
            "Domino/30.png",
            "Domino/31.png",
            "Domino/32.png",
            "Domino/33.png",
            "Domino/34.png",
            "Domino/35.png",
            "Domino/36.png"
        )

        desImages = listOf(
            "Des/d1.png",
            "Des/d2.png",
            "Des/d3.png",
            "Des/d4.png",
            "Des/d5.png",
            "Des/worm.png")


        // Création de la grille pour afficher les pickominos
        val gridPane = GridPane()
        gridPane.alignment = Pos.CENTER
        gridPane.hgap = 10.0
        gridPane.vgap = 10.0
        gridPane.padding = Insets(20.0)

        p21 = Button()
        p22 = Button()
        p23 = Button()
        p24 = Button()
        p25 = Button()
        p26 = Button()
        p27 = Button()
        p28 = Button()
        p29 = Button()
        p30 = Button()
        p31 = Button()
        p32 = Button()
        p33 = Button()
        p34 = Button()
        p35 = Button()
        p36 = Button()

        listPickominos = listOf(p21, p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36)

        for (pick in listPickominos){
            pick.isDisable = true
        }

        // Ajout des pickominos à la grille avec une taille de 50% de leur taille d'origine
        var column = 0
        var row = 0

        var contrPick = controllerChoosePickomino(this)
        for (i in 0 until listPickominos.size ) {
            listPickominos[i].style = "-fx-background-color: transparent; -fx-border-color: null;"
            val image = Image(pickominoImages[i])
            val imageView = ImageView(image)
            imageView.fitWidth = image.width * 0.5
            imageView.fitHeight = image.height * 0.5
            listPickominos[i].graphic = imageView
            listPickominos[i].padding = Insets(0.0,0.0,0.0,0.0)

            listPickominos[i].onMouseClicked = contrPick
            gridPane.add(listPickominos[i], column, row)
            column++
            if (column == 8) {
                column = 0
                row++
            }
        }

        gridPane.padding = Insets(0.0)
        val layout = BorderPane()

        buttonRollDice = Button()
        buttonRollDice.style = "-fx-background-color: transparent; -fx-border-color: null;"
        val lancerDes = Image("roll_dice.png")
        val lancerDesView = ImageView(lancerDes)
        lancerDesView.fitWidth = lancerDes.width * 0.3
        lancerDesView.fitHeight = lancerDes.height * 0.3
        buttonRollDice.graphic = lancerDesView
        buttonRollDice.padding = Insets(0.0)


        layout.padding = Insets(40.0)

        val pickominoBox = VBox(10.0)
        pickominoBox.padding = Insets(0.0)

        pickominoBox.alignment = Pos.CENTER


        pickominoBox.children.addAll(gridPane, buttonRollDice)
        layout.center = pickominoBox

//------------------------------------------------------------------------------------------------------------------------------------------------------------
        val cornerRadii = CornerRadii(10.0)
        val borderWidth = 5.0
        val borderColor = Color.WHITE
        val border = Border(BorderStroke(borderColor, BorderStrokeStyle.SOLID, cornerRadii, BorderWidths(borderWidth)))
        // Fond à gauche


        val bottomPane = Pane()
        bottomPane.minWidth = 600.0
        bottomPane.maxWidth = 600.0
        bottomPane.minHeight = 100.0
        bottomPane.maxHeight = 100.0
        bottomPane.background = Background(BackgroundFill(Color.rgb(255, 206, 171), cornerRadii, null))
        bottomPane.border = border
        BorderPane.setAlignment(bottomPane, Pos.CENTER)


        desBoxG = VBox(15.0)
        desBoxG.alignment = Pos.CENTER

        var image = Image("Des/worm.png")

        var imageViewB1 = ImageView(image)
        imageViewB1.fitWidth = 50.0
        imageViewB1.fitHeight = 50.0

        var imageViewB2 = ImageView(image)
        imageViewB2.fitWidth = 50.0
        imageViewB2.fitHeight = 50.0


        var imageViewB3 = ImageView(image)
        imageViewB3.fitWidth = 50.0
        imageViewB3.fitHeight = 50.0

        var imageViewB4 = ImageView(image)
        imageViewB4.fitWidth = 50.0
        imageViewB4.fitHeight = 50.0

        var imageViewB5 = ImageView(image)
        imageViewB5.fitWidth = 50.0
        imageViewB5.fitHeight = 50.0

        var imageViewB6 = ImageView(image)
        imageViewB6.fitWidth = 50.0
        imageViewB6.fitHeight = 50.0

        var imageViewB7 = ImageView(image)
        imageViewB7.fitWidth = 50.0
        imageViewB7.fitHeight = 50.0

        var imageViewB8 = ImageView(image)
        imageViewB8.fitWidth = 50.0
        imageViewB8.fitHeight = 50.0

        var imageBackPickomino = Image("Domino/0.png")
        var imageViewBackPickominoB = ImageView(imageBackPickomino)
        imageViewBackPickominoB.fitWidth = imageBackPickomino.width * 0.5
        imageViewBackPickominoB.fitHeight = imageBackPickomino.height * 0.5

        var contrDice = controllerKeepDices(this)
        db1 = Button()
        db1.padding = Insets(0.0,15.0,50.0,20.0)
        db1.style= "-fx-background-color: transparent; -fx-border-color: null;"
        db1.graphic = imageViewB1
        db1.onMouseClicked= contrDice

        db2 = Button()
        db2.padding = Insets(0.0,15.0,50.0,0.0)
        db2.style= "-fx-background-color: transparent; -fx-border-color: null;"
        db2.graphic = imageViewB2
        db2.onMouseClicked= contrDice

        db3 = Button()
        db3.padding = Insets(0.0,15.0,50.0,0.0)
        db3.style= "-fx-background-color: transparent; -fx-border-color: null;"
        db3.graphic = imageViewB3
        db3.onMouseClicked= contrDice

        db4 = Button()
        db4.padding = Insets(0.0,15.0,50.0,0.0)
        db4.style= "-fx-background-color: transparent; -fx-border-color: null;"
        db4.graphic = imageViewB4
        db4.onMouseClicked= contrDice

        db5 = Button()
        db5.padding = Insets(0.0,15.0,50.0,0.0)
        db5.style= "-fx-background-color: transparent; -fx-border-color: null;"
        db5.graphic = imageViewB5
        db5.onMouseClicked= contrDice

        db6 = Button()
        db6.padding = Insets(0.0,15.0,50.0,0.0)
        db6.style= "-fx-background-color: transparent; -fx-border-color: null;"
        db6.graphic = imageViewB6
        db6.onMouseClicked= contrDice

        db7 = Button()
        db7.padding = Insets(0.0,15.0,50.0,0.0)
        db7.style= "-fx-background-color: transparent; -fx-border-color: null;"
        db7.graphic = imageViewB7
        db7.onMouseClicked= contrDice

        db8 = Button()
        db8.padding = Insets(0.0,20.0,50.0,0.0)
        db8.style= "-fx-background-color: transparent; -fx-border-color: null;"
        db8.graphic = imageViewB8
        db8.onMouseClicked= contrDice

        listBoutonB = listOf(db1,db2,db3,db4,db5,db6,db7,db8)

        pb = Button()
        pb.padding = Insets(0.0,0.0,0.0,0.0)
        pb.style= "-fx-background-color: transparent; -fx-border-color: null;"
        pb.graphic = imageViewBackPickominoB

        desBoxB = HBox(7.50)
        desBoxB.alignment = Pos.CENTER
        desBoxB.children.addAll(db1,db2,db3,db4,db5,db6,db7,db8,pb)

        bottomPane.children.add(desBoxB)

        layout.bottom = bottomPane

//---------------------------------------GAUCHE-----------------------------------------------------------------------------------------
        val leftPane = Pane()
        leftPane.minWidth = 100.0
        leftPane.maxWidth = 100.0
        leftPane.minHeight = 600.0
        leftPane.maxHeight = 600.0
        leftPane.background = Background(BackgroundFill(Color.rgb(255, 243, 179), cornerRadii, null))
        leftPane.border = border
        BorderPane.setAlignment(leftPane, Pos.CENTER)


        var imageBackPickominoG = Image("Domino/0.png")
        var imageViewBackPickominoG = ImageView(imageBackPickominoG)
        imageViewBackPickominoG.fitWidth = imageBackPickomino.width * 0.5
        imageViewBackPickominoG.fitHeight = imageBackPickomino.height * 0.5
        imageViewBackPickominoG.rotate = -90.0


        var imageViewG1 = ImageView(image)
        imageViewG1.fitWidth = 50.0
        imageViewG1.fitHeight = 50.0

        var imageViewG2 = ImageView(image)
        imageViewG2.fitWidth = 50.0
        imageViewG2.fitHeight = 50.0


        var imageViewG3 = ImageView(image)
        imageViewG3.fitWidth = 50.0
        imageViewG3.fitHeight = 50.0

        var imageViewG4 = ImageView(image)
        imageViewG4.fitWidth = 50.0
        imageViewG4.fitHeight = 50.0

        var imageViewG5 = ImageView(image)
        imageViewG5.fitWidth = 50.0
        imageViewG5.fitHeight = 50.0

        var imageViewG6 = ImageView(image)
        imageViewG6.fitWidth = 50.0
        imageViewG6.fitHeight = 50.0

        var imageViewG7 = ImageView(image)
        imageViewG7.fitWidth = 50.0
        imageViewG7.fitHeight = 50.0

        var imageViewG8 = ImageView(image)
        imageViewG8.fitWidth = 50.0
        imageViewG8.fitHeight = 50.0

        dg1 = Button()
        dg1.padding = Insets(25.0,0.0,21.0,0.0)
        dg1.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dg1.graphic = imageViewG1

        dg2 = Button()
        dg2.padding = Insets(0.0,0.0,21.0,0.0)
        dg2.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dg2.graphic = imageViewG2

        dg3 = Button()
        dg3.padding = Insets(0.0,0.0,21.0,0.0)
        dg3.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dg3.graphic = imageViewG3

        dg4 = Button()
        dg4.padding = Insets(0.0,0.0,21.0,0.0)
        dg4.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dg4.graphic = imageViewG4

        dg5 = Button()
        dg5.padding = Insets(0.0,0.0,21.0,0.0)
        dg5.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dg5.graphic = imageViewG5

        dg6 = Button()
        dg6.padding = Insets(0.0,0.0,21.0,0.0)
        dg6.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dg6.graphic = imageViewG6

        dg7 = Button()
        dg7.padding = Insets(0.0,0.0,21.0,0.0)
        dg7.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dg7.graphic = imageViewG7

        dg8 = Button()
        dg8.padding = Insets(0.0,0.0,0.0,0.0)
        dg8.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dg8.graphic = imageViewG8

        pg = Button()
        pg.padding = Insets(0.0,0.0,0.0,0.0)
        pg.style= "-fx-background-color: transparent; -fx-border-color: null;"
        pg.graphic = imageViewBackPickominoG

        desBoxG = VBox(0.0)
        desBoxG.alignment = Pos.CENTER
        desBoxG.children.addAll(dg1,dg2,dg3,dg4,dg5,dg6,dg7,dg8,pg)


        leftPane.children.add(desBoxG)

        layout.left = leftPane

//---------------------------------------DROITE-----------------------------------------------------------------------------------------
        val rightPane = Pane()
        rightPane.minWidth = 100.0
        rightPane.maxWidth = 100.0
        rightPane.minHeight = 600.0
        rightPane.maxHeight = 600.0
        rightPane.background = Background(BackgroundFill(Color.rgb(163, 203, 255), cornerRadii, null))
        rightPane.border = border
        BorderPane.setAlignment(rightPane, Pos.CENTER)

        var imageD = Image("Des/worm.png")

        var imageViewD1 = ImageView(imageD)
        imageViewD1.fitWidth = 50.0
        imageViewD1.fitHeight = 50.0

        var imageViewD2 = ImageView(imageD)
        imageViewD2.fitWidth = 50.0
        imageViewD2.fitHeight = 50.0


        var imageViewD3 = ImageView(imageD)
        imageViewD3.fitWidth = 50.0
        imageViewD3.fitHeight = 50.0

        var imageViewD4 = ImageView(imageD)
        imageViewD4.fitWidth = 50.0
        imageViewD4.fitHeight = 50.0

        var imageViewD5 = ImageView(imageD)
        imageViewD5.fitWidth = 50.0
        imageViewD5.fitHeight = 50.0

        var imageViewD6 = ImageView(imageD)
        imageViewD6.fitWidth = 50.0
        imageViewD6.fitHeight = 50.0

        var imageViewD7 = ImageView(imageD)
        imageViewD7.fitWidth = 50.0
        imageViewD7.fitHeight = 50.0

        var imageViewD8 = ImageView(imageD)
        imageViewD8.fitWidth = 50.0
        imageViewD8.fitHeight = 50.0

        var imageViewBackPickominoD = ImageView(imageBackPickomino)
        imageViewBackPickominoD.fitWidth = imageBackPickomino.width * 0.5
        imageViewBackPickominoD.fitHeight = imageBackPickomino.height * 0.5
        imageViewBackPickominoD.rotate = 90.0

        dd1 = Button()
        dd1.padding = Insets(25.0,0.0,21.0,0.0)
        dd1.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dd1.graphic = imageViewD1

        dd2 = Button()
        dd2.padding = Insets(0.0,0.0,21.0,0.0)
        dd2.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dd2.graphic = imageViewD2

        dd3 = Button()
        dd3.padding = Insets(0.0,0.0,21.0,0.0)
        dd3.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dd3.graphic = imageViewD3

        dd4 = Button()
        dd4.padding = Insets(0.0,0.0,21.0,0.0)
        dd4.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dd4.graphic = imageViewD4

        dd5 = Button()
        dd5.padding = Insets(0.0,0.0,21.0,0.0)
        dd5.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dd5.graphic = imageViewD5

        dd6 = Button()
        dd6.padding = Insets(0.0,0.0,21.0,0.0)
        dd6.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dd6.graphic = imageViewD6

        dd7 = Button()
        dd7.padding = Insets(0.0,0.0,21.0,0.0)
        dd7.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dd7.graphic = imageViewD7

        dd8 = Button()
        dd8.padding = Insets(0.0,0.0,21.0,0.0)
        dd8.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dd8.graphic = imageViewD8

        pd = Button()
        pd.padding = Insets(0.0,0.0,0.0,0.0)
        pd.style= "-fx-background-color: transparent; -fx-border-color: null;"
        pd.graphic = imageViewBackPickominoD

        desBoxD = VBox(0.0)
        desBoxD.alignment = Pos.CENTER
        desBoxD.children.addAll(dd1,dd2,dd3,dd4,dd5,dd6,dd7,dd8,pd)


        rightPane.children.add(desBoxD)
        layout.right = rightPane

//-----------------------------------------------------HAUT-------------------------------------------------------------------------------------------------------

        // Fond en haut
        val topPane = Pane()
        topPane.minWidth = 600.0
        topPane.maxWidth = 600.0
        topPane.minHeight = 100.0
        topPane.maxHeight = 100.0
        topPane.background = Background(BackgroundFill(Color.rgb(158, 240, 172), cornerRadii, null))
        topPane.border = border
        BorderPane.setAlignment(topPane, Pos.CENTER)
        desBoxH = HBox(15.0)
        desBoxH.alignment = Pos.CENTER

        desBoxH = HBox(7.50)
        desBoxH.alignment = Pos.CENTER

        var imageH = Image("Des/worm.png")

        var imageViewH1 = ImageView(imageH)
        imageViewH1.fitWidth = 50.0
        imageViewH1.fitHeight = 50.0

        var imageViewH2 = ImageView(imageH)
        imageViewH2.fitWidth = 50.0
        imageViewH2.fitHeight = 50.0


        var imageViewH3 = ImageView(imageH)
        imageViewH3.fitWidth = 50.0
        imageViewH3.fitHeight = 50.0

        var imageViewH4 = ImageView(imageH)
        imageViewH4.fitWidth = 50.0
        imageViewH4.fitHeight = 50.0

        var imageViewH5 = ImageView(imageH)
        imageViewH5.fitWidth = 50.0
        imageViewH5.fitHeight = 50.0

        var imageViewH6 = ImageView(imageH)
        imageViewH6.fitWidth = 50.0
        imageViewH6.fitHeight = 50.0

        var imageViewH7 = ImageView(imageH)
        imageViewH7.fitWidth = 50.0
        imageViewH7.fitHeight = 50.0

        var imageViewH8 = ImageView(imageH)
        imageViewH8.fitWidth = 50.0
        imageViewH8.fitHeight = 50.0

        var imageBackPickominoH = Image("Domino/0.png")
        var imageViewBackPickominoH = ImageView(imageBackPickominoH)
        imageViewBackPickominoH.fitWidth = imageBackPickominoH.width * 0.5
        imageViewBackPickominoH.fitHeight = imageBackPickominoH.height * 0.5

        dh1 = Button()
        dh1.padding = Insets(-50.0,15.0,0.0,20.0)
        dh1.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dh1.graphic = imageViewH1

        dh2 = Button()
        dh2.padding = Insets(-50.0,15.0,0.0,0.0)
        dh2.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dh2.graphic = imageViewH2

        dh3 = Button()
        dh3.padding = Insets(-50.0,15.0,0.0,0.0)
        dh3.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dh3.graphic = imageViewH3

        dh4 = Button()
        dh4.padding = Insets(-50.0,15.0,0.0,0.0)
        dh4.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dh4.graphic = imageViewH4

        dh5 = Button()
        dh5.padding = Insets(-50.0,15.0,0.0,0.0)
        dh5.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dh5.graphic = imageViewH5

        dh6 = Button()
        dh6.padding = Insets(-50.0,15.0,0.0,0.0)
        dh6.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dh6.graphic = imageViewH6

        dh7 = Button()
        dh7.padding = Insets(-50.0,15.0,0.0,0.0)
        dh7.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dh7.graphic = imageViewH7

        dh8 = Button()
        dh8.padding = Insets(-50.0,15.0,0.0,0.0)
        dh8.style= "-fx-background-color: transparent; -fx-border-color: null;"
        dh8.graphic = imageViewH8

        ph = Button()
        ph.padding = Insets(0.0,0.0,0.0,0.0)
        ph.style= "-fx-background-color: transparent; -fx-border-color: null;"
        ph.graphic = imageViewBackPickominoH

        desBoxH = HBox(7.50)
        desBoxH.alignment = Pos.CENTER
        desBoxH.children.addAll(dh1,dh2,dh3,dh4,dh5,dh6,dh7,dh8,ph)

        topPane.children.add(desBoxH)

        layout.top = topPane
//------------------------------------------------------------------------------------------------------------------------------------------------------------

        layout.style = "-fx-background-color: #8E7FEE"

        val scene = Scene(layout, 800.0, 600.0)
        style = "-fx-background-color: #8E7FEE;"
        // Configuration de la vue
        this.children.add(scene.root)
// Création de la scène et ajout du BorderPane


    }
}
