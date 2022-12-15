
package main.model;

import java.io.Serializable;

public class Clasificacion extends TablaBase implements Serializable{
    private static final long serialVersionUID = 1L;

    public Clasificacion(int idClasificacion, String nombre) {
        super(idClasificacion, nombre);
    }


    public Clasificacion() {
    }

    @Override
    public String toString() {
        return "Clasificacion{" +  "id=" + id + ", nombre=" + nombre +'}';
    }
}
