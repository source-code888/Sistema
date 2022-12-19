package main.model;

import java.io.Serializable;

public class Salida implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idSalida;
    private int cantidadSalida;
    private String conceptoSalida;
    private String fechaHoraSalida;
    private int idEmpleado;
    private int idArea;
    private int idMaterial;
    private int idUnidad;
    private int idUsuario;

    public Salida() {
    }

    public Salida(int idSalida, int cantidadSalida, String conceptoSalida, String fechaHoraSalida, int idEmpleado, int idArea, int idMaterial, int idUnidad, int idUsuario) {
        this.idSalida = idSalida;
        this.cantidadSalida = cantidadSalida;
        this.conceptoSalida = conceptoSalida;
        this.fechaHoraSalida = fechaHoraSalida;
        this.idEmpleado = idEmpleado;
        this.idArea = idArea;
        this.idMaterial = idMaterial;
        this.idUnidad = idUnidad;
        this.idUsuario = idUsuario;
    }

    public Salida(int cantidadSalida, String conceptoSalida, String fechaHoraSalida, int idEmpleado, int idArea, int idMaterial, int idUnidad, int idUsuario) {
        this.cantidadSalida = cantidadSalida;
        this.conceptoSalida = conceptoSalida;
        this.fechaHoraSalida = fechaHoraSalida;
        this.idEmpleado = idEmpleado;
        this.idArea = idArea;
        this.idMaterial = idMaterial;
        this.idUnidad = idUnidad;
        this.idUsuario = idUsuario;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public int getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(int cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public String getConceptoSalida() {
        return conceptoSalida;
    }

    public void setConceptoSalida(String conceptoSalida) {
        this.conceptoSalida = conceptoSalida;
    }

    public String getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(String fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Salida{" + "idSalida=" + idSalida + ", cantidadSalida=" + cantidadSalida + ", conceptoSalida=" + conceptoSalida + ", fechaHoraSalida=" + fechaHoraSalida + ", idEmpleado=" + idEmpleado + ", idArea=" + idArea + ", idMaterial=" + idMaterial + ", idUnidad=" + idUnidad + ", idUsuario=" + idUsuario + '}';
    }

}
