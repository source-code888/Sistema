package main.model;

import java.io.Serializable;

public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idArea;
    private String nombre;

    public Area() {
    }

    public Area(int idArea, String nombre) {
        this.idArea = idArea;
        this.nombre = nombre;
    }

    public Area(String nombre) {
        this.nombre = nombre;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Area{" + "idArea=" + idArea + ", nombre=" + nombre + '}';
    }
}
