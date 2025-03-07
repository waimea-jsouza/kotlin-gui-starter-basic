/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI

}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var helloButton: JButton
    private lateinit var goodbyeButton: JButton
    private lateinit var textField: JTextField
    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null // Prevents the pack function to specify the location of components and makes the creator
                      // give specific coordinates/ dimensions

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        greetingLabel = JLabel("Click a button...!")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 25, 500, 50)
        greetingLabel.font = defaultFont
        add(greetingLabel)

        textField = JTextField()
        textField.bounds = Rectangle(100, 100, 400, 75)
        textField.font = defaultFont
        textField.addActionListener(this)
        textField.addKeyListener(this)
        add(textField)

        helloButton = JButton("Hello!")
        helloButton.bounds = Rectangle(25,200,250,100)
        helloButton.addActionListener(this)     // Handle any clicks
        helloButton.font = defaultFont
        add(helloButton)

        goodbyeButton = JButton("Goodbye!")
        goodbyeButton.bounds = Rectangle(325,200,250,100)
        goodbyeButton.addActionListener(this)     // Handle any clicks
        goodbyeButton.font = defaultFont
        add(goodbyeButton)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            textField ->{
                println("Text field has been changed")
            }
            helloButton -> {
                println("Hello Button Pressed")
                var noName = "......"
                if (textField.text.isNotBlank()) noName = textField.text
                greetingLabel.text = "You clicked the button ${noName}!"
                textField.background = Color.BLUE
            }
            goodbyeButton -> {
                println("Goodbye Button Pressed")
                var noName = "......"
                if (textField.text.isNotBlank()) noName = textField.text
                greetingLabel.text = "See you soon ${noName}!"
                textField.background = Color.RED
            }


        }
    }

    override fun keyTyped(e: KeyEvent?) {
        println("Key TYPED: ${e?.keyChar}")
    }

    override fun keyPressed(e: KeyEvent?) {
        println("Key PRESSED${e?.keyCode}")

        if (e?.keyCode in KeyEvent.VK_A..KeyEvent.VK_Z) {
            println("Letter Key!")
        }
        else {
            e?.consume()
        }
    }
    override fun keyReleased(e: KeyEvent?) {
        println("Key RELEASED${e?.keyCode}")
    }

}

