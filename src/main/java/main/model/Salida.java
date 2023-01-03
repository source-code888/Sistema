package main.model;

import java.io.Serializable;

public class Salida implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;
    private int idSalida;
    private int cantidadSalida;
    private String conceptoSalida;
    private String fechaHoraSalida;
    private String nombreEmpleado;
    private String areaEmpleado;
    private String nombreMaterial;
    private String unidadMaterial;
    private int idUsuario;

    public Salida(int idSalida, int cantidadSalida, String conceptoSalida, String fechaHoraSalida, String nombreEmpleado, String areaEmpleado, String nombreMaterial, String unidadMaterial, int idUsuario) {
        this.idSalida = idSalida;
        this.cantidadSalida = cantidadSalida;
        this.conceptoSalida = conceptoSalida;
        this.fechaHoraSalida = fechaHoraSalida;
        this.nombreEmpleado = nombreEmpleado;
        this.areaEmpleado = areaEmpleado;
        this.nombreMaterial = nombreMaterial;
        this.unidadMaterial = unidadMaterial;
        this.idUsuario = idUsuario;
    }

    public Salida() {
    }

    public Salida(int cantidadSalida, String conceptoSalida, String fechaHoraSalida, String nombreEmpleado, String areaEmpleado, String nombreMaterial, String unidadMaterial, int idUsuario) {
        this.cantidadSalida = cantidadSalida;
        this.conceptoSalida = conceptoSalida;
        this.fechaHoraSalida = fechaHoraSalida;
        this.nombreEmpleado = nombreEmpleado;
        this.areaEmpleado = areaEmpleado;
        this.nombreMaterial = nombreMaterial;
        this.unidadMaterial = unidadMaterial;
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

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getAreaEmpleado() {
        return areaEmpleado;
    }

    public void setAreaEmpleado(String areaEmpleado) {
        this.areaEmpleado = areaEmpleado;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getUnidadMaterial() {
        return unidadMaterial;
    }

    public void setUnidadMaterial(String unidadMaterial) {
        this.unidadMaterial = unidadMaterial;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Salida)) {
            throw new IllegalArgumentException("El objeto debe ser de tipo Salida");
        }
        Salida salida = (Salida) o;
        if (idSalida < salida.idSalida) {
            return 1;
        } else if (idSalida > salida.idSalida) {
            return -1;
        } else {
            return 0;
        }
    }

}
