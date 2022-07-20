package com.afam.practica1

import android.inputmethodservice.Keyboard
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import android.app.Activity
import android.widget.*


class MainActivity : AppCompatActivity() {

    private val db = Firebase.firestore

    // TextView
    private lateinit var firstName: TextView
    private lateinit var lastName: TextView

    // Buttons
    private lateinit var newBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstName = findViewById(R.id.input_firstname)
        lastName = findViewById(R.id.input_lastname)
        newBtn = findViewById(R.id.new_btn)
        newBtn.setOnClickListener { this.newBtnFun() }
        getUsers()
    }

    private fun newBtnFun() {
        val user = hashMapOf(
            "first" to firstName.text.toString(),
            "last" to lastName.text.toString()
        )
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                this.snackBar(
                    findViewById(R.id.activity_main_layout),
                    "DocumentSnapshot added with ID: ${documentReference.id}"
                )
                getUsers()
            }
            .addOnFailureListener { e ->
                this.snackBar(findViewById(R.id.activity_main_layout), "Error adding document")
                println("Error adding document")
            }
    }

    private fun getUsers() {
        var nameListView = findViewById<ListView>(R.id.names_listView)
        db.collection("users").get().addOnSuccessListener { result ->
            val listItems = arrayOfNulls<Any>(result.size())
            for (i in 0 until result.size()) {
                listItems[i] = result.documents[i].data?.get("first")
            }
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
            nameListView.adapter = adapter
        }
    }

    private fun snackBar(view: View, text: String) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
//        .setBackgroundTint(R.color.design_default_color_error.toInt())
            .show()
    }
}