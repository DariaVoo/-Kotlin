package lab4

import java.awt.*
import java.awt.event.MouseEvent
import java.io.File
import javax.imageio.ImageIO
import javax.swing.*
import javax.swing.SwingConstants.LEADING


class RealImageBox: ImageBox() {
    init {
        print("Init RealImageBox")
        createUI(title)
        this.addMouseListener(this)
    }

    override fun createUI(title: String) {
//        val im = ImageIO.read(File("src//lab4//m1.jpg"))
        setTitle(title)
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(640,640)
        setLocationRelativeTo(null)
        isVisible = true
        setImage("src//lab4//m1.jpg")
    }

    override fun setText() {
        val textArea = JTextArea()
        textArea.setText("Hello, Kotlin/Swing world")
        val scrollPane = JScrollPane(textArea)
        this.add(scrollPane, BorderLayout.CENTER)
    }

    override fun setImage(path:String) {
        val back = JLabel(ImageIcon(path))
        this.layout = BorderLayout()
        this.contentPane = back
        this.layout= FlowLayout()
        setSize(641,641)
        setSize(640,640)
    }

    override fun mouseClicked(p0: MouseEvent?) {
        if (p0 != null) {
            if (p0.clickCount == 2) {
                setTitle("KKKK")
                setImage("src//lab4//img.jpg")
            }
        }
    }

}