package com.example.activitylesson

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class SecondActivity : AppCompatActivity() {

    private lateinit var receivedValue: String
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById<TextView>(R.id.myTextView)
        receivedValue = intent.getStringExtra(EXTRA_DATA).toString()
        textView.text = receivedValue

        println("SecondActivity onCreate")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("SAVED_TEXT_KEY", receivedValue)

        println("SecondActivity onSaveInstanceState")
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val userText = savedInstanceState.getString("SAVED_TEXT_KEY")
        receivedValue  = userText.toString()
        textView.text = receivedValue

        println("SecondActivity onRestoreInstanceState")
    }

    override fun onRestart() {
        super.onRestart()
        println("SecondActivity onRestart")
    }

    override fun onStart() {
        super.onStart()
        println("SecondActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        println("SecondActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        println("SecondActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        println("SecondActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("SecondActivity onDestroy")
    }

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
        private const val SAVED_TEXT_KEY = "SAVED_TEXT_KEY"

        fun createIntent(context: Context, data: String): Intent {
            return Intent(context, SecondActivity::class.java)
                .putExtra(EXTRA_DATA, data)
        }
    }
}
