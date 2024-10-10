package com.anushka.activitylifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    private var backPressedTime: Long = 0
    private val backPressInterval: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("SecondActivity onCreate::::::::::::::::::::::::::::::::::::::::::::;")

        setContentView(R.layout.activity_second)
        val userName = intent.getStringExtra("USER")
        val textView = findViewById<TextView>(R.id.tvOffer)
        val message = "$userName ,you will get  free access to all the content for one month "
        textView.text = message
    }

    override fun onStart() {
        super.onStart()
        println("SecondActivity onStart::::::::::::::::::::::::::::::::::::::::::::;")
    }

    override fun onResume() {
        super.onResume()
        println("SecondActivity onResume::::::::::::::::::::::::::::::::::::::::::::;")
    }

    override fun onPause() {
        super.onPause()
        println("SecondActivity onPause::::::::::::::::::::::::::::::::::::::::::::;")
    }

    override fun onStop() {
        super.onStop()
        println("SecondActivity onStop::::::::::::::::::::::::::::::::::::::::::::;")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("SecondActivity onDestroy::::::::::::::::::::::::::::::::::::::::::::;")
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