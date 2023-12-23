package com.example.activitylesson


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val activityButton = findViewById<Button>(R.id.activity_button)
        val telButton = findViewById<Button>(R.id.tel_button)



        activityButton.setOnClickListener {
            startSecondActivity()
        }
        telButton.setOnClickListener {
            sendImplicitIntent()
        }
        println("MainActivity onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        println("MainActivity onRestart")
    }

    override fun onStart() {
        super.onStart()
        println("MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        println("MainActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        println("MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        println("MainActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("MainActivity onDestroy")

    }

     private fun startSecondActivity() {
        // starting explicit intents with data
         val textData = findViewById<EditText>(R.id.text_data)


         val intent = SecondActivity.createIntent(this, textData.text.toString())
        startActivity(intent)
    }
    private fun sendImplicitIntent() {
        val telData = findViewById<EditText>(R.id.tel_data)
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:" + telData.text.toString())
        }
        startActivity(intent)
    }


}