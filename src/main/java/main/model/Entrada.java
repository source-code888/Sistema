package main.model;

import java.io.Serializable;

public class Entrada implements Serializable, Comparable{

    private static final long serialVersionUID = 1L;
    private int idEntrada;
    private int cantidadEntrada;
    private String fechaEntrada;
    private int idMaterial;
    private int idEmpleado;

    public Entrada(int idEntrada, int cantidadEntrada, String fechaEntrada, int idMaterial, int idEmpleado) {
        this.idEntrada = idEntrada;
        this.cantidadEntrada = cantidadEntrada;
        this.fechaEntrada = fechaEntrada;
        this.idMaterial = idMaterial;
        this.idEmpleado = idEmpleado;
    }

    public Entrada(int cantidadEntrada, String fechaEntrada, int idMaterial, int idEmpleado) {
        this.cantidadEntrada = cantidadEntrada;
        this.fechaEntrada = fechaEntrada;
        this.idMaterial = idMaterial;
        this.idEmpleado = idEmpleado;
    }
    
    public Entrada(){
        
    }
    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(int cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Entrada{" + "idEntrada=" + idEntrada + ", cantidadEntrada=" + cantidadEntrada + ", fechaEntrada=" + fechaEntrada + ", idMaterial=" + idMaterial + ", idEmpleado=" + idEmpleado + '}';
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Entrada)) {
            throw new IllegalArgumentException("El objeto debe ser de tipo Entrada");
        }else {
            Entrada entrada = (Entrada) o;
            if (idEntrada < entrada.idEntrada) {
                return 1;
            } else if (idEntrada > entrada.idEntrada) {
                return -1;
            } else {
              return 0;  
            }
            
        }
    }

}
