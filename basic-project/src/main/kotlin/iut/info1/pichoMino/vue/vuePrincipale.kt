package iut.info1.pichoMino.vue

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.paint.Color

class vuePrincipale : VBox() {
    init {

        val pickominoImages = listOf(
            "Domino/Group 11domino34.png",
            "Domino/Group 21domino22.png",
            "Domino/Group 22domino23.png",
            "Domino/Group 23domino24.png",
            "Domino/Group 24domino25.png",
            "Domino/Group 19domino26.png",
            "Domino/Group 18domino27.png",
            "Domino/Group 17domino28.png",
            "Domino/Group 16domino29.png",
            "Domino/Group 40domino30.png",
            "Domino/Group 39domino31.png",
            "Domino/Group 37domino32.png",
            "Domino/Group 12domino33.png",
            "Domino/Group 11domino34.png",
            "Domino/Group 36domino35.png",
            "Domino/Group 35domino36.png"
        )

        val desImages = listOf(
            "Des/Des1.png",
            "Des/Des2.png",
            "Des/Des3.png",
            "Des/Des4.png",
            "Des/Des5.png",
            "Des/DesVers.png")


        // Création de la grille pour afficher les pickominos
        val gridPane = GridPane()
        gridPane.alignment = Pos.CENTER
        gridPane.hgap = 10.0
        gridPane.vgap = 10.0
        gridPane.padding = Insets(20.0)

        // Ajout des pickominos à la grille avec une taille de 40% de leur taille d'origine
        var column = 0
        var row = 0
        for (imagePath in pickominoImages) {
            val button = Button()
            button.style = "-fx-background-color: transparent; -fx-border-color: null;"
            val image = Image(imagePath)
            val imageView = ImageView(image)
            imageView.fitWidth = image.width * 0.5
            imageView.fitHeight = image.height * 0.5
            button.graphic = imageView

            button.setOnAction {
                // Code à exécuter lorsque le bouton est cliqué
                println("Pickomino cliqué : ")
            }
            gridPane.add(button, column, row)
            column++
            if (column == 8) {
                column = 0
                row++
            }
        }


        val layout = BorderPane()

        val buttonRollDice = Button()
        buttonRollDice.style = "-fx-background-color: transparent; -fx-border-color: null;"
        val lancerDes = Image("roll_dice.png")
        val lancerDesView = ImageView(lancerDes)
        lancerDesView.fitWidth = lancerDes.width * 0.3
        lancerDesView.fitHeight = lancerDes.height * 0.3
        buttonRollDice.graphic = lancerDesView
        buttonRollDice.setOnAction {
            println("Dés lancés")
        }



        layout.padding = Insets(40.0)

        val pickominoBox = VBox(10.0)

        pickominoBox.alignment = Pos.CENTER


        pickominoBox.children.addAll(gridPane, buttonRollDice)
        layout.center = pickominoBox

//------------------------------------------------------------------------------------------------------------------------------------------------------------
        val cornerRadii = CornerRadii(10.0)
        val borderWidth = 5.0
        val borderColor = Color.WHITE
        val border = Border(BorderStroke(borderColor, BorderStrokeStyle.SOLID, cornerRadii, BorderWidths(borderWidth)))
        // Fond à gauche

        val leftPane = Pane()
        leftPane.minWidth = 100.0
        leftPane.maxWidth = 100.0
        leftPane.minHeight = 600.0
        leftPane.maxHeight = 600.0
        leftPane.background = Background(BackgroundFill(Color.rgb(255, 243, 179), cornerRadii, null))
        leftPane.border = border
        BorderPane.setAlignment(leftPane, Pos.CENTER)

        val desBoxR = VBox(15.0)
        desBoxR.alignment = Pos.CENTER

        for (i in 1..8) {
            val button = Button()
            button.style = "-fx-background-color: transparent; -fx-border-color: null;"
            val image = Image("Des/DesVers.png")
            val imageView = ImageView(image)
            imageView.fitWidth = 50.0
            imageView.fitHeight = 50.0
            button.graphic = imageView

            button.setOnAction {
                // Code à exécuter lorsque le bouton est cliqué
                println("Bouton Des cliqué")
            }

            desBoxR.children.add(button)
        }

        val buttonR = Button()
        buttonR.style = "-fx-background-color: transparent; -fx-border-color: null;"
        val imageR = Image("Domino/Group 20domino21.png")
        val imageViewR = ImageView(imageR)
        imageViewR.fitWidth = imageR.width * 0.3
        imageViewR.fitHeight = imageR.height * 0.3
        imageViewR.rotate = 90.0
        buttonR.graphic = imageViewR

        buttonR.setOnAction {
            // Code à exécuter lorsque le bouton est cliqué
            println("Bouton Domino cliqué")
        }

        desBoxR.children.add(buttonR)
        leftPane.children.add(desBoxR)

        layout.left = leftPane

//------------------------------------------------------------------------------------------------------------------------------------------------------------
        //fond jaune en bas
        val bottomRightPane = Pane()
        bottomRightPane.minWidth = 600.0
        bottomRightPane.maxWidth = 600.0
        bottomRightPane.minHeight = 100.0
        bottomRightPane.maxHeight = 100.0
        bottomRightPane.background = Background(BackgroundFill(Color.rgb(255, 206, 171), cornerRadii, null))
        bottomRightPane.border = border
        BorderPane.setAlignment(bottomRightPane, Pos.CENTER)

        val desBoxJ = HBox(15.0)
        desBoxJ.alignment = Pos.CENTER

        for (i in 1..8) {
            val button = Button()
            button.style = "-fx-background-color: transparent; -fx-border-color: null;"
            val imageJ = Image("Des/DesVers.png")
            val imageViewJ = ImageView(imageJ)
            imageViewJ.fitWidth = 50.0
            imageViewJ.fitHeight = 50.0
            button.graphic = imageViewJ
            desBoxJ.alignment = Pos.CENTER // Aligner l'image au centre du ImageView
            desBoxJ.children.add(imageViewJ)
        }

        val buttonJ = Button()
        buttonJ.style = "-fx-background-color: transparent; -fx-border-color: null;"
        val imageJ = Image("Domino/Group 20domino21.png")
        val imageViewJ = ImageView(imageJ)
        imageViewJ.fitWidth = imageJ.width * 0.3
        imageViewJ.fitHeight = imageJ.height * 0.3
        desBoxJ.children.add(imageViewJ)

        bottomRightPane.children.add(desBoxJ)

        layout.bottom = bottomRightPane


//------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Fond à droite
        val rightPane = Pane()
        rightPane.minWidth = 100.0
        rightPane.maxWidth = 100.0
        rightPane.minHeight = 600.0
        rightPane.maxHeight = 600.0
        rightPane.background = Background(BackgroundFill(Color.rgb(163, 203, 255), cornerRadii, null))
        rightPane.border = border
        BorderPane.setAlignment(rightPane, Pos.CENTER)
        val desBox = VBox(15.0)
        desBox.alignment = Pos.CENTER

        for (i in 1..8) {
            val button = Button()
            button.style = "-fx-background-color: transparent; -fx-border-color: null;"
            val image = Image("Des/DesVers.png")
            val imageView = ImageView(image)
            imageView.fitWidth = 50.0
            imageView.fitHeight = 50.0
            button.graphic = imageView
            desBox.alignment = Pos.CENTER // Aligner l'image au centre du ImageView
            desBox.children.add(imageView)
        }
        val buttonG = Button()
        buttonG.style = "-fx-background-color: transparent; -fx-border-color: null;"
        val image = Image("Domino/Group 20domino21.png")
        val imageView = ImageView(image)
        imageView.fitWidth = image.width * 0.3
        imageView.fitHeight = image.height * 0.3
        imageView.rotate = - 90.0
        desBox.children.add(imageView)

        rightPane.children.add(desBox)
        layout.right = rightPane
//------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Fond en haut
        val topRightPane = Pane()
        topRightPane.minWidth = 600.0
        topRightPane.maxWidth = 600.0
        topRightPane.minHeight = 100.0
        topRightPane.maxHeight = 100.0
        topRightPane.background = Background(BackgroundFill(Color.rgb(158, 240, 172), cornerRadii, null))
        topRightPane.border = border
        BorderPane.setAlignment(topRightPane, Pos.CENTER)
        val desBoxB = HBox(15.0)
        desBoxB.alignment = Pos.CENTER

        for (i in 1..8) {
            val button = Button()
            button.style = "-fx-background-color: transparent; -fx-border-color: null;"
            val imageB = Image("Des/DesVers.png")
            val imageViewB = ImageView(imageB)
            imageViewB.fitWidth = 50.0
            imageViewB.fitHeight = 50.0
            button.graphic = imageViewB
            desBoxB.alignment = Pos.CENTER // Aligner l'image au centre du ImageView
            desBoxB.children.add(imageViewB)
        }
        val buttonB = Button()
        buttonB.style = "-fx-background-color: transparent; -fx-border-color: null;"
        val imageB = Image("Domino/Group 20domino21.png")
        val imageViewB = ImageView(imageB)
        imageViewB.fitWidth = imageB.width * 0.3
        imageViewB.fitHeight = imageB.height * 0.3
        desBoxB.children.add(imageViewB)

        topRightPane.children.add(desBoxB)

        layout.top = topRightPane
//------------------------------------------------------------------------------------------------------------------------------------------------------------

        layout.style = "-fx-background-color: #8E7FEE"

        val scene = Scene(layout, 800.0, 600.0)
        style = "-fx-background-color: #8E7FEE;"
        // Configuration de la vue
        this.children.add(scene.root)
// Création de la scène et ajout du BorderPane


    }
}
