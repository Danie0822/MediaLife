package com.example.medialife

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.sql.PreparedStatement
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

private var connectSql = ConnectSql()


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
        Contra.setOnClickListener {
            startActivity(intent1);
        }
        Boton.setOnClickListener {
            try {
                val statement = connectSql.dbConn()?.createStatement()
                val resultSet =statement?.executeQuery("SELECT Correo, contraseña from TbCredeciales Where Correo = '${Name.text.toString()}' and contraseña= '${Password.text.toString()}'")

                while (resultSet?.next() == true)
                {
                    val a1 = resultSet.getString("Correo")
                    val a2 = resultSet.getString("contraseña")

                    if (Name.text.toString() == a1 && Password.text.toString() == a2)
                    {
                        startActivity(intent1)
                        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            catch (ex: SQLException)
            {
                Toast.makeText(this, "Error al mostrar", Toast.LENGTH_SHORT).show()
            }

        }


    }
    }





