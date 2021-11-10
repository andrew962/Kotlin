package com.afam.cloudnotes

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnEnviar = findViewById<Button>(R.id.button_enviar)
        btnEnviar.setOnClickListener {
            this.onAlertDialog()
        }
    }

    private fun onAlertDialog() {
//        val dialog = LayoutInflater.from(this).inflate(R.layout.dialog_enter_code,null)
        val builder = AlertDialog.Builder(this)
        builder.setView(R.layout.dialog_enter_code)
        builder.setTitle("Verificacion")
        builder.setMessage("Introduce el codigo recibido.")
        builder.setPositiveButton(R.string.textBtn_check) { dialog, id ->
            Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }
}