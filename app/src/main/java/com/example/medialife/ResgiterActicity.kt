package com.example.medialife

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.sql.PreparedStatement
import java.sql.SQLException

lateinit var CajitaNombre: EditText
lateinit var Contraseña1: EditText
lateinit var Contraseña2: EditText
lateinit var Correo: EditText
lateinit var Spinner: Spinner

lateinit var BotonRegistar: Button


class ResgiterActicity : AppCompatActivity() {

    var clickedItem: String = ""
    private var connectSql = ConnectSql()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resgiter_acticity)
        supportActionBar?.hide()

        CajitaNombre = findViewById(R.id.Nombre)
        Contraseña1 = findViewById(R.id.Contraseña)
        Correo = findViewById(R.id.Correo)
        Spinner = findViewById(R.id.ComboBox)
        BotonRegistar = findViewById(R.id.Regis)
        Contraseña2 = findViewById(R.id.Confirmar)

        BotonRegistar.setOnClickListener {


            try {
                if(Contraseña2.text.toString() == Contraseña1.text.toString())
                {
                    val Contraseña = md5(Contraseña2.text.toString());
                val addEstudiante: PreparedStatement =  connectSql.dbConn()?.prepareStatement("exec AgregarCredenciales ?,?,?,?;")!!
                addEstudiante.setString(1, CajitaNombre.text.toString())
                addEstudiante.setString(2, Correo.text.toString())
                addEstudiante.setInt(3, 1)
                addEstudiante.setString(4, Contraseña)
                addEstudiante.executeUpdate()

                Toast.makeText(this, "Estudiante ingresado correctamente", Toast.LENGTH_SHORT).show()
                Contraseña1.clearFocus()
                CajitaNombre.clearFocus()
                Contraseña2.clearFocus()
                Correo.clearFocus()

                //Para ocultar el teclado
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(BotonRegistar.windowToken, 0)

                CajitaNombre.setText("")
                Contraseña2.setText("")
                Contraseña1.setText("")
                Correo.setText("")
                }
                else {
                    Toast.makeText(this, "Error al ingresar", Toast.LENGTH_SHORT).show()
                }

            }catch (ex: SQLException){
                Toast.makeText(this, "Error al ingresar", Toast.LENGTH_SHORT).show()
            }

        }



    }
}

fun md5(s: String): String {
    val MD5 = "MD5"
    try {
        // Create MD5 Hash
        val digest: MessageDigest = MessageDigest
            .getInstance(MD5)
        digest.update(s.toByteArray())
        val messageDigest: ByteArray = digest.digest()

        // Create Hex String
        val hexString = StringBuilder()
        for (aMessageDigest in messageDigest) {
            var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
            while (h.length < 2) h = "0$h"
            hexString.append(h)
        }
        return hexString.toString()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""
}

