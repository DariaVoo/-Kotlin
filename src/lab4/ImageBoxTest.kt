package lab4

import java.awt.EventQueue
import javax.swing.JFrame


private fun createAndShowGUI() {
    val Im = RealImageBox()
    Im.createUI("Hiii")

}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}

