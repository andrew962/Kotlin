package com.afam.mateapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afam.mateapp.databinding.ActivityBasicOperationBinding
import com.afam.mateapp.databinding.ActivityMainBinding
import com.google.gson.Gson
import org.json.JSONObject

class BasicOperationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBasicOperationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasicOperationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getActionData()
    }

    fun getActionData() {
        val bundle = intent.extras
        val data = bundle?.get("INTENT_DATA") as? MatOption
        if (data != null) {
            opcSelected(data)
        }
    }

    fun opcSelected(selected: MatOption) {
        binding.clContainer.setBackgroundColor(Color.parseColor(selected.color))
        when (selected.operation) {
            1 -> binding.tvSigno.text = "+"
            2 ->  binding.tvSigno.text = "-"
            3 -> binding.tvSigno.text = "x"
            4 -> binding.tvSigno.text = "/"
        }
    }
}
