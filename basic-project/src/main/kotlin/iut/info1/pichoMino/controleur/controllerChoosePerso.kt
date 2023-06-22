package iut.info1.pichoMino.controleur

import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent

class controllerChoosePerso() : EventHandler<MouseEvent> {
    var imageviewchoose: Int
    init{
        this.imageviewchoose = 0
    }
    override fun handle(event: MouseEvent?) {

        var index = event?.source as ImageView
        if (index.id != null) {
            this.imageviewchoose= index.id.toInt()-1
        }
    }
}