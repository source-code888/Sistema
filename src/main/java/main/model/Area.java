package main.model;

import java.io.Serializable;

public class Area extends TablaBase implements Serializable {

    private static final long serialVersionUID = 1L;

    public Area(int id, String nombre) {
        super(id, nombre);
    }

    public Area() {
        super();
    }

    @Override
    public String toString() {
        return "Area{" +  "id=" + id + ", nombre=" + nombre +'}';
    }
    
}
