package com.afam.nrandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var randomNumber: Int = 0
    // late-init allows initializing a not-null property outside of a constructor

    // TextView
    private lateinit var gameOver: TextView
    private lateinit var gameOverDescription: TextView
    private lateinit var numGenerated: TextView
    private lateinit var lifes: TextView

    // EditText
    private lateinit var numToVerify: EditText

    // Buttons
    private lateinit var playAgain: Button
    private lateinit var checkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomNumber = this.randomNumberFun()
        checkButton = findViewById(R.id.check_button)
        playAgain = findViewById(R.id.play_again_button)
        gameOver = findViewById(R.id.textView_game_over)
        gameOverDescription = findViewById(R.id.textView_gameover_desc)
        numGenerated = findViewById(R.id.textView_num_generated)
        numToVerify = findViewById(R.id.editText_num_to_verify)
        lifes = findViewById(R.id.text_vidas)

        playAgain.isEnabled = false
        gameOver.visibility = View.INVISIBLE
        gameOverDescription.visibility = View.INVISIBLE
        numGenerated.visibility = View.INVISIBLE

        // Action button
        checkButton.setOnClickListener { this.checkButtonFun() }
        playAgain.setOnClickListener { this.playAgainFun(false) }
        println(randomNumber)
    }

    private fun checkButtonFun() {
        if (numToVerify.text.toString() != "") {
            if (numToVerify.text.toString().toInt() == randomNumber) {
                this.showToastMessage("Encontraste el numero!")
                // Reset input empty
                numToVerify.setText("")
                this.playAgainFun(true)
            } else {
                if (lifes.text.toString().toInt() != 0) {
                    val message: String = if (numToVerify.text.toString().toInt() > randomNumber) {
                        "Muy alto"
                    } else {
                        "Muy bajo"
                    }
                    this.showToastMessage(message)
                }
                numToVerify.setText("")
                lifes.text = (lifes.text.toString().toInt() - 1).toString()
            }
        } else {
            this.showToastMessage("Introduce un numero")
        }
        if (lifes.text.toString().toInt() == 0) {
            gameOverDescription.visibility = View.VISIBLE
            gameOver.visibility = View.VISIBLE
            numGenerated.visibility = View.VISIBLE
            numGenerated.text = randomNumber.toString()

            // Disabled button "Otra Ronda"
            playAgain.isEnabled = true
            // Disabled button "Verificar"
            checkButton.isEnabled = false
            // Disabled input
            numToVerify.isEnabled = false
        }
    }

    private fun playAgainFun(success: Boolean?) {
        if (lifes.text.toString().toInt() == 0 || success == true) {
            lifes.text = "5"
            numToVerify.isEnabled = true
            numToVerify.setText("")
            randomNumber = this.randomNumberFun()
            checkButton.isEnabled = true
            playAgain.isEnabled = false
            gameOverDescription.visibility = View.INVISIBLE
            gameOver.visibility = View.INVISIBLE
            numGenerated.visibility = View.INVISIBLE
        }
    }

    private fun randomNumberFun(): Int {
        return (0..100).random()
    }

    private fun showToastMessage(message: String) {
        return Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}