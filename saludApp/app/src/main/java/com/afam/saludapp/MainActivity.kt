package com.afam.saludapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.afam.saludapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Se crea un binding para poder hacer referencia al codigo xml mas facil.
    private lateinit var binding: ActivityMainBinding

    // La funcion on create se llama cada ves que se carga la pantalla
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Se inicializa la variable binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        // y se cambia el R.<>.activity_main por binding.root
        setContentView(binding.root)

        binding.btnShowName.setOnClickListener {
            // Se valida si el texto del campo esta vacio
            if (binding.etName.text.isNotEmpty()){
                redirectToNewAct()
            } else{
                showError()
            }
        }
    }

    fun redirectToNewAct(){
        /** Para pasar a una nueva actividad debemos crear un intent
        donde le pasaremos "this" seria nuestro contexto,
        "<Activity>::class" el activity que vamos a cargar
        */
        val intent = Intent(this,ResultActivity::class.java)
        /**
         * Luego instanciamos intent y llamamos a ".putExtras()" donde le pasaremos,
         * como primer valor una key que sera usada como identificador
         * y luego el valor o la data a pasar.
         */
        intent.putExtra("INTENT_NAME",binding.etName.text)
        /**
         * Por ultimo carmamos el activity.
         */
        startActivity(intent)
    }
    fun showError(){
        Toast.makeText(this, "El nombre esta vacio.", Toast.LENGTH_LONG).show()
    }
}
