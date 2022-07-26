package com.afam.mateapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afam.mateapp.databinding.ActivityBasicOperationBinding
import kotlin.math.pow
import kotlin.math.roundToInt

class BasicOperationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBasicOperationBinding
    private lateinit var selected: MatOption
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasicOperationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getActionData()
        binding.btnCalcular.setOnClickListener { btnCalculate() }
    }

    private fun getActionData() {
        val bundle = intent.extras
        val data = bundle?.get("INTENT_DATA") as? MatOption
        if (data != null) {
            opcSelected(data)
        }
    }

    private fun opcSelected(selected: MatOption) {
        this.selected = selected
        binding.clContainer.setBackgroundColor(Color.parseColor(selected.color))
        when (selected.operation) {
            1 -> binding.tvSigno.text = "+"
            2 -> binding.tvSigno.text = "-"
            3 -> binding.tvSigno.text = "x"
            4 -> binding.tvSigno.text = "/"
        }
    }

    private fun btnCalculate() {
        val num1 = binding.etNum1.text.toString().toFloat()
        val num2 = binding.etNum2.text.toString().toFloat()
        var result = 0F
        when (this.selected.operation) {
            1 -> {
                result = num1 + num2
            }
            2 -> {
                result = num1 - num2
            }
            3 -> {
                result = num1 * num2
            }
            4 -> {
                result = num1 / num2
            }
            5 -> {
                result = num1.pow(num2)
            }
        }
        binding.tvResult.text = result.toString()
    }
}
