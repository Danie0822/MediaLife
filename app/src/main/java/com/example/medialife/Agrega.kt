package com.example.medialife

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.PreparedStatement
import java.sql.SQLException
lateinit var Nombre: EditText
lateinit var Enfermo: EditText
lateinit var Peso: EditText
lateinit var altura: EditText
lateinit var Temp: EditText
lateinit var presion: EditText

lateinit var mandar: Button
lateinit var historial: Button

class Agrega : AppCompatActivity() {
    var clickedItem: String = ""
    private var connectSql = ConnectSql()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agrega)
        supportActionBar?.hide()
        Nombre = findViewById(R.id.nombre)
        Enfermo = findViewById(R.id.enfermeda)
        Peso = findViewById(R.id.peso)
        altura = findViewById(R.id.altura)
        Temp = findViewById(R.id.temperatura)
        presion = findViewById(R.id.presion)
        mandar = findViewById(R.id.queso)
        historial = findViewById(R.id.historial)

        historial.setOnClickListener{
            val intent12: Intent = Intent(this, nose::class.java)
            startActivity(intent12);
        }

        mandar.setOnClickListener {


            try {
                val addEstudiante: PreparedStatement =  connectSql.dbConn()?.prepareStatement("exec AgregarPaciente ?,?,?,?,?,?;")!!
                addEstudiante.setString(1, Nombre.text.toString())
                addEstudiante.setString(2, Enfermo.text.toString())
                addEstudiante.setString(3, Peso.text.toString())
                addEstudiante.setString(4, Temp.text.toString())
                addEstudiante.setString(5, presion.text.toString())
                addEstudiante.setString(6, altura.text.toString())
                addEstudiante.executeUpdate()

                Toast.makeText(this, "Paciente ingresado correctamente", Toast.LENGTH_SHORT).show()
                Nombre.clearFocus()
                Enfermo.clearFocus()
                Peso.clearFocus()
                Temp.clearFocus()
                presion.clearFocus()
                altura.clearFocus()


                //Para ocultar el teclado
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(mandar.windowToken, 0)

                Nombre.setText("")
                Enfermo.setText("")
                Peso.setText("")
                Temp.setText("")
                presion.setText("")
                altura.setText("")





            }catch (ex: SQLException){
                Toast.makeText(this, "Error al ingresar", Toast.LENGTH_SHORT).show()
            }

        }



    }
}