package pichoMino.vue

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.VBox


class Vue: VBox() {
     var buttonPlay : Button
     var buttonConnect : Button
     var gameId : TextField
     var gameKey : TextField
     var nbJoueur : ComboBox<Int>
    init {
        buttonConnect = Button("Connect")
        buttonConnect.setMinSize(200.0, 100.0)
        buttonConnect.setMaxSize(200.0, 100.0)

        var lbGId = Label("Addresse de la partie")
        gameId = TextField()
        gameId.setMaxSize(200.0, 100.0)

        var lbGKey = Label("Clé de la partie")
        gameKey = TextField()
        gameKey.setMaxSize(200.0, 100.0)

        var l = FXCollections.observableArrayList<Int>(2,3,4)
        nbJoueur = ComboBox(l)
        nbJoueur.selectionModel.selectFirst()
        buttonPlay = Button("Play")
        buttonPlay.setMinSize(200.0, 100.0)
        buttonPlay.setMaxSize(200.0, 100.0)

//        this.style = ("-fx-background-color : green")
        this.children.addAll(buttonPlay,nbJoueur,buttonConnect,lbGId,gameId,lbGKey,gameKey)
    }
}
