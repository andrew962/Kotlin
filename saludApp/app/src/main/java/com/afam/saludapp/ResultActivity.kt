package com.afam.saludapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afam.saludapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**
         * Boton para regresar al home.
         */
        binding.btnBackToHome.setOnClickListener { onBackPressed() }
        getActionName()
    }

    fun getActionName(){
        /**
         * Creamos una variable bundle donde la instaciaremos con los valores que
         * esten en la clase intent en sus extras alli estaran los datos traidos
         * desde el otro activity.
         */
        val bundle = intent.extras

        /**
         * Obtenemos los datos haciendo un "?.get(<"key">)" donde key es la llave
         * que le asociamos nuestros valores en al activity anterior.
         */
        val name = bundle?.get("INTENT_NAME")
        /**
         * Al final trabajamos con los datos como nosotros queramos.
         */
        binding.tVResult.setText("Hola ${name.toString()}")
    }
}