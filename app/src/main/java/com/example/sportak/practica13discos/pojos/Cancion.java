package com.example.sportak.practica13discos.pojos;

import java.io.Serializable;

public class Cancion implements Serializable {
    private String nombreCancion;
    private String duracion;
    private String autor;
    private int numeroCancion;

    public Cancion(String nombreCancion, String duracion, String autor, int numeroCancion) {
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
        this.autor = autor;
        this.numeroCancion = numeroCancion;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "nombreCancion='" + nombreCancion + '\'' +
                ", duracion='" + duracion + '\'' +
                ", autor='" + autor + '\'' +
                ", numeroCancion=" + numeroCancion +
                '}';
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroCancion() {
        return numeroCancion;
    }

    public void setNumeroCancion(int numeroCancion) {
        this.numeroCancion = numeroCancion;
    }
}
