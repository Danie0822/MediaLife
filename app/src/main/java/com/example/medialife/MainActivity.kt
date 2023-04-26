package com.example.medialife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var Boton2: Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        Boton2 = findViewById(R.id.Registrar);
        Boton2.setOnClickListener {
            val intent: Intent = Intent(this, ResgiterActicity::class.java)
            startActivity(intent);


        }
    }
}