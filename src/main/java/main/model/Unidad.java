package main.model;

import java.io.Serializable;

public class Unidad extends TablaBase implements Serializable {

    private static final long serialVersionUID = 1L;

    public Unidad(int idUnidad, String nombre) {
        super(idUnidad, nombre);
    }

    public Unidad() {
    }

    @Override
    public String toString() {
        return "Unidad{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
