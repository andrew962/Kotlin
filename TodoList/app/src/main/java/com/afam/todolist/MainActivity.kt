package com.afam.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.afam.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController)

    }
}