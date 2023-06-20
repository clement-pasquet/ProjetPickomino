package iut.info1.pichoMino.vue

import javafx.scene.control.Button
import javafx.scene.layout.HBox

class vuePlayer : HBox() {
    var j1 : Button
    var j2 : Button
    var j3 : Button
    var j4 : Button
    init {
        j1 = Button("P1")
        j2 = Button("P2")
        j3 = Button("P3")
        j4 = Button("P4")
        this.children.addAll(j1,j2,j3,j4)
    }
}