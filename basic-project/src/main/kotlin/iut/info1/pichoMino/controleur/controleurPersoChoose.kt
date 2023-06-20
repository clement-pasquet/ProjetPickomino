package iut.info1.pichoMino.controleur

import javafx.event.EventHandler
import javafx.scene.image.Image
import javafx.scene.input.MouseEvent
import iut.info1.pichoMino.vue.vueMenu

class controleurPersoChoose(vueMenu: vueMenu): EventHandler<MouseEvent> {
    var vueMenu : vueMenu
    init{
        this.vueMenu = vueMenu
    }
    override fun handle(event: MouseEvent?) {
        if (event?.eventType == MouseEvent.MOUSE_CLICKED) {
            var type = event?.source

            if (type is Image) {
                println("You're an asticot ?")
                vueMenu.imagePersoJaune
            }
        }
    }
}