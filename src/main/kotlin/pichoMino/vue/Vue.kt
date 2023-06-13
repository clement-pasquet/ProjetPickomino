package pichoMino.vue

import javafx.scene.control.Label
import javafx.scene.layout.FlowPane


class Vue: FlowPane() {
    private val labelJeu: Label
    private val labelI:Label
    init{
        this.labelJeu=Label("PichoMino")
        this.labelI=Label("PM")
        this.children.addAll(labelJeu, labelI)
    }
}
