
package main.model;

import java.io.Serializable;

public class Tienda extends TablaBase implements Serializable {
    private static final long serialVersionUID = 1L;

    public Tienda(int idTienda, String nombre) {
        super(idTienda, nombre);
    }

    public Tienda() {
    }

    @Override
    public String toString() {
        return "Tienda{" +  "id=" + id + ", nombre=" + nombre +'}';
    }
}
