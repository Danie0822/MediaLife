package com.example.medialife

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var Boton2: Button
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_enfermera)
        supportActionBar?.hide()

     //   Boton2 = findViewById(R.id.comienzo);
       // Boton2.setOnClickListener {
         //   val intent: Intent = Intent(this, loginMedia::class.java)
           // startActivity(intent);


        //}

    }
}