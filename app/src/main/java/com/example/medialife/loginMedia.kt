package com.example.medialife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

lateinit var Boton: Button
lateinit var Contra: Button
lateinit var Password: EditText
lateinit var Name: EditText


class loginMedia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_media)
        supportActionBar?.hide()

        Boton = findViewById(R.id.btnIniciar);
        Password = findViewById(R.id.txt_Passr);
        Name = findViewById(R.id.txt_UserR);
        Contra = findViewById(R.id.button2);




        val intent: Intent = Intent(this, ResgiterActicity::class.java)
        val intent1: Intent = Intent(this, recuperacion::class.java)
        Contra.setOnClickListener{
            startActivity(intent1);
        }
        Boton.setOnClickListener{
            if(Password.text.toString() == "18" && Name.text.toString()  == "18"  ){



                startActivity(intent);
            }

            else if(Password.text.toString() == "12" && Name.text.toString()  == "12"){

                startActivity(intent);
            }

            else{

                Boton.setText("No es correcto" );
            }





        }
    }

}