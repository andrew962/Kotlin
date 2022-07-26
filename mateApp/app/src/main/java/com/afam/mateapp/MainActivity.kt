package com.afam.mateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.afam.mateapp.adapter.MatOptionAdapter
import com.afam.mateapp.databinding.ActivityMainBinding
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    /**
     * Primero: crear el RecyclerView .xml como se hizo en el activity_main.xml.
     * Segundo: crear el data class model.
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = binding.recyclerMatOption
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter =
            MatOptionAdapter(
                MatOptionProvider.matOptionList,
                { matOption -> onItemSelected(matOption) })
    }

    private fun onItemSelected(matOption: MatOption) {
        val intent = Intent(this, BasicOperationActivity::class.java)
        intent.putExtra("INTENT_DATA", matOption as Serializable)
        startActivity(intent)
    }
}