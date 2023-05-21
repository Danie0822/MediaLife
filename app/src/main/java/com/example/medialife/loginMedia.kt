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
private val ip="192.168.1.23:60732"
private val db="MediaLife"
private val username="Alessandro"
private val password="Gemelas2905"

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
                val Contraseña12 = md5(Password.text.toString());
                val connection = getConnection()
                if (isValidUser(connection, Name.text.toString(), Contraseña12)) {
                    println("Inicio de sesión exitoso.")
                    startActivity(intent1);
                } else {
                    println("Credenciales inválidas.")
                }

                connection.close()


                //Para ocultar el teclado
                val inputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(BotonRegistar.windowToken, 0)

                CajitaNombre.setText("")
                Contraseña2.setText("")
                Contraseña1.setText("")


            } catch (ex: SQLException){
            Toast.makeText(this, "Error al ingresar", Toast.LENGTH_SHORT).show()
        }


    }
    }
    fun getConnection(): Connection {

            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            var conn: Connection? = null
            val connString: String
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
                connString =
                    "jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$username;password=$password"
                conn = DriverManager.getConnection(connString)


            } catch (ex: SQLException) {

                Log.e("Error: ", ex.message!!)
            } catch (ex1: ClassNotFoundException) {
                Log.e("Error: ", ex1.message!!)
            } catch (ex2: Exception) {
                Log.e("Error: ", ex2.message!!)
            }
           return getConnection()
        }


        fun isValidUser(connection: Connection, username: String, password: String): Boolean {
            val query = "SELECT COUNT(*) FROM TbCredeciales WHERE Correo = ? AND contraseña = ?;"
            val preparedStatement = connection.prepareStatement(query)
            preparedStatement.setString(1, username)
            preparedStatement.setString(2, password)

            val resultSet = preparedStatement.executeQuery()
            resultSet.next()
            val count = resultSet.getInt(1)

            return count > 0
        }
    }
