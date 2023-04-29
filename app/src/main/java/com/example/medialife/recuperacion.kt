package com.example.medialife

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var Enviar: Button
class recuperacion : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacion)
        supportActionBar?.hide()
        Enviar = findViewById(R.id.Enviar);
        Enviar.setOnClickListener {
            val intent: Intent = Intent(this, Recuperacio::class.java)
            startActivity(intent);


        }
    }
}