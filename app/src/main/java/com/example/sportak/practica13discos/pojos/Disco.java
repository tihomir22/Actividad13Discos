package com.example.sportak.practica13discos.pojos;

import java.io.Serializable;
import java.util.ArrayList;

public class Disco implements Serializable {
    private String nombreDiscos;
    private int portadaDisco;
    private ArrayList<Cancion>listaCanciones;

    public Disco(String nombreDiscos, int portadaDisco, ArrayList<Cancion> listaCanciones) {
        this.nombreDiscos = nombreDiscos;
        this.portadaDisco = portadaDisco;
        this.listaCanciones = listaCanciones;
    }

    public String getNombreDiscos() {
        return nombreDiscos;
    }

    public void setNombreDiscos(String nombreDiscos) {
        this.nombreDiscos = nombreDiscos;
    }

    public int getPortadaDisco() {
        return portadaDisco;
    }

    public void setPortadaDisco(int portadaDisco) {
        this.portadaDisco = portadaDisco;
    }

    public ArrayList<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(ArrayList<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    @Override
    public String toString() {
        return "Disco{" +
                "nombreDiscos='" + nombreDiscos + '\'' +
                ", portadaDisco=" + portadaDisco +
                ", listaCanciones=" + listaCanciones +
                '}';
    }
}
