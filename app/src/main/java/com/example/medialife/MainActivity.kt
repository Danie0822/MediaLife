package com.example.medialife

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var Boton3: Button
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_paciente)
        supportActionBar?.hide()

//        Boton3 = findViewById(R.id.Bienvenido);
//        Boton3.setOnClickListener {
//          val intent: Intent = Intent(this, loginMedia::class.java)
//           startActivity(intent);
//
//
//        }

    }
}
