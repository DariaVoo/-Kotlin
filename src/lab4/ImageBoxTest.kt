package lab4


import java.awt.EventQueue
import javax.swing.JFrame


private fun createAndShowGUI() {
    val Im = Proxy()
    println("Wait")
    Thread.sleep(3_000) // wait for 3 seconds
    Im.createUI("Hiii")
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}

