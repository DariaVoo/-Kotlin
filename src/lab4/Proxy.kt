package lab4

import java.awt.event.MouseEvent

class Proxy(): ImageBox() {
    private val realImageBox: RealImageBox by lazy {
        RealImageBox()
    }

    override fun createUI(title: String) {
        realImageBox.createUI(title)
    }

    override fun setText() {
        realImageBox.setText()
    }

    override fun setImage(path:String) {
        realImageBox.setImage(path)
    }

    override fun mouseClicked(p0: MouseEvent?) {
        realImageBox.mouseClicked(p0)
    }

}