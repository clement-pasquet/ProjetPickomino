package iut.info1.pichoMino.preloader

import javafx.application.Preloader
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.Background
import javafx.scene.layout.BorderPane
import javafx.scene.paint.Color
import javafx.stage.Stage
import javafx.stage.StageStyle


class ApplicationPreloader : Preloader() {

    companion object {
        val LABEL: Label = Label("Initialisation")
    }

    lateinit var stage: Stage
    override fun start(primaryStage: Stage?) {
        if (primaryStage != null) {
            this.stage = primaryStage
        }
        val root = BorderPane()
        root.background = Background.EMPTY

        // Chargement de l'image du preloader
        val image = Image("pickomino_logo 1logo.png")
        val preloaderImage = ImageView(image)
        preloaderImage.fitHeight = 400.0
        preloaderImage.fitWidth = 400.0
        root.center = preloaderImage
        root.bottom = LABEL

        // L'affichage de la scene
        val preloaderScene = Scene(root,900.0,600.0)
        preloaderScene.fill = Color.TRANSPARENT
        primaryStage?.initStyle( StageStyle.TRANSPARENT)
        primaryStage?.scene = preloaderScene
        primaryStage?.show()
    }
    override fun handleStateChangeNotification(info: StateChangeNotification?) {
        println(info?.type)
        if (info?.type==StateChangeNotification.Type.BEFORE_START)
            this.stage.close()
    }
}