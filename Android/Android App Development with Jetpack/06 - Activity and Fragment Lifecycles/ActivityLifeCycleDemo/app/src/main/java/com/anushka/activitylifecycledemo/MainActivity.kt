package com.anushka.activitylifecycledemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private val backPressInterval: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("MainActivity onCreate::::::::::::::::::::::::::::::::::::::::::::;")

        setContentView(R.layout.activity_main)
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.etName)
        val submitButton = findViewById<Button>(R.id.btnSubmit)
        val offersButton = findViewById<Button>(R.id.btnOffers)
        var enteredName = ""
        submitButton.setOnClickListener {
            enteredName = inputField.text.toString()
            if (enteredName == ""){
                offersButton.visibility = View.INVISIBLE
                greetingTextView.text = ""
                Toast.makeText(
                    this@MainActivity,
                    "Please, enter your name!",
                    Toast.LENGTH_SHORT
                ).show()
            }else {
                val message = "Welcome $enteredName"
                greetingTextView.text = message
                inputField.text.clear()
                offersButton.visibility = View.VISIBLE
            }
        }

        offersButton.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("USER",enteredName)
            startActivity(intent)
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        println("MainActivity onStart::::::::::::::::::::::::::::::::::::::::::::;")
    }

    override fun onResume() {
        super.onResume()
        println("MainActivity onResume::::::::::::::::::::::::::::::::::::::::::::;")
    }

    override fun onPause() {
        super.onPause()
        println("MainActivity onPause::::::::::::::::::::::::::::::::::::::::::::;")
    }

    override fun onStop() {
        super.onStop()
        println("MainActivity onStop::::::::::::::::::::::::::::::::::::::::::::;")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("MainActivity onDestroy::::::::::::::::::::::::::::::::::::::::::::;")
    }

    override fun onBackPressed() {
        if (backPressedTime + backPressInterval > System.currentTimeMillis()) {
            super.onBackPressed()
            return
        } else {
            Toast.makeText(this, "Pressione novamente para sair", Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }

}