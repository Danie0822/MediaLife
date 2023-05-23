package com.example.medialife;

public class DataModel {
    private int id;
    private String nombre;
    private String enfermedad;
    private String peso;
    private String temperatura;
    private String presion;
    private String altura;

    public DataModel(int id, String nombre, String enfermedad, String peso, String temperatura, String presion, String altura) {
        this.id = id;
        this.nombre = nombre;
        this.enfermedad=enfermedad;
        this.peso=peso;
        this.temperatura=temperatura;
        this.presion=presion;
        this.altura=altura;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public String getPeso() {
        return peso;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getPresion() {
        return presion;
    }

    public String getAltura() {
        return altura;
    }
}

