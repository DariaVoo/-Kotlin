package lab4

import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JFrame

abstract class ImageBox(): MouseListener, JFrame() {
    abstract fun createUI(title: String)

    abstract fun setText()

    abstract fun setImage(path:String)

    override fun mouseReleased(p0: MouseEvent?) {

    }

    override fun mouseEntered(p0: MouseEvent?) {

    }

    override fun mouseExited(p0: MouseEvent?) {

    }

    override fun mousePressed(p0: MouseEvent?) {

    }

}