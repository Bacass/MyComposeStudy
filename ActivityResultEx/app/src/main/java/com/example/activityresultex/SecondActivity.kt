package com.example.activityresultex

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var etUserName: EditText
    private lateinit var etUserAge: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        etUserName = findViewById<EditText>(R.id.etUserName)
        etUserAge = findViewById<EditText>(R.id.etUserAge)
        button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val resultIntent = Intent()
            val name = etUserName.text.toString()
            val age = etUserAge.text.toString()

            resultIntent.putExtra("NAME", name)
            resultIntent.putExtra("AGE", age)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}