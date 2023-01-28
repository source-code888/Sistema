package main.model;

import java.io.Serializable;

public class TablaBase implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;
    protected int id;
    protected String nombre;

    public TablaBase(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TablaBase() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TablaBase{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof TablaBase)) {
            throw new IllegalArgumentException("El objeto debe ser de tipo Salida");
        }
        TablaBase tablaBase = (TablaBase) o;
        if (id < tablaBase.id) {
            return 1;
        } else if (id > tablaBase.id) {
            return -1;
        } else {
            return 0;
        }
    }

}
