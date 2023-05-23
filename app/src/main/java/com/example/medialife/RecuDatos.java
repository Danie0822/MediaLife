package com.example.medialife;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecuDatos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_enfermera);

        recyclerView = findViewById(R.id.ListaContactos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Ejecuta la tarea asincrónica para recuperar los datos de SQL Server
        new RetrieveDataTask().execute();
    }

    private class RetrieveDataTask extends AsyncTask<Void, Void, List<DataModel>> {

        @Override
        protected List<DataModel> doInBackground(Void... voids) {
            List<DataModel> dataList = new ArrayList<>();

            try {


                // Establece la conexión con SQL Server
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://10.20.0.120:60732;databaseName=MediaLife;user=Alessandro;password=Gemelas2905";
                Connection conn = DriverManager.getConnection(url);

                // Realiza una consulta a la base de datos
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM TbPaciente");

                // Itera sobre los resultados y agrega los datos a la lista
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("Nombre");
                    String enfermedad = rs.getString("enfermeda");
                    String peso= rs.getString("peso");
                    String temperatura = rs.getString("temperatura");
                    String presion = rs.getString("presion");
                    String altura = rs.getString("altura");
                    // Otros campos...

                    DataModel data = new DataModel(id, nombre, enfermedad, peso, temperatura, presion, altura);
                    dataList.add(data);
                }

                // Cierra los recursos
                rs.close();
                stmt.close();
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            return dataList;
        }

        @Override
        protected void onPostExecute(List<DataModel> dataList) {
            super.onPostExecute(dataList);

            // Configura el adaptador para el RecyclerView
            dataAdapter = new DataAdapter(dataList);
            recyclerView.setAdapter(dataAdapter);
        }
    }
}
