package main.model;

import java.io.Serializable;

public class Material implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;
    private int idMaterial;
    private String nombreMaterial;
    private int cantidad;
    private int limiteMinimo;
    private String sku;
    private String fechaIngreso;
    private int idUnidad;
    private int idClasificacion;
    private int idTienda;
    private int idUsuario;

    public Material(int idMaterial, String nombreMaterial, int cantidad, int limiteMinimo, String sku,
            String fechaIngreso, int idUnidad, int idClasificacion, int idTienda, int idUsuario) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.cantidad = cantidad;
        this.limiteMinimo = limiteMinimo;
        this.sku = sku;
        this.fechaIngreso = fechaIngreso;
        this.idUnidad = idUnidad;
        this.idClasificacion = idClasificacion;
        this.idTienda = idTienda;
        this.idUsuario = idUsuario;
    }

    public Material(String nombreMaterial, int cantidad, int limiteMinimo, String sku, String fechaIngreso,
            int idUnidad, int idClasificacion, int idTienda, int idUsuario) {
        this.nombreMaterial = nombreMaterial;
        this.cantidad = cantidad;
        this.limiteMinimo = limiteMinimo;
        this.sku = sku;
        this.fechaIngreso = fechaIngreso;
        this.idUnidad = idUnidad;
        this.idClasificacion = idClasificacion;
        this.idTienda = idTienda;
        this.idUsuario = idUsuario;
    }

    public Material(int idMaterial, String nombreMaterial, int cantidad, int idUnidad, int idUsuario) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.cantidad = cantidad;
        this.idUnidad = idUnidad;
        this.idUsuario = idUsuario;
    }

    public Material(int idMaterial, String sku) {
        this.idMaterial = idMaterial;
        this.sku = sku;
    }

    public Material(String sku) {
        this.sku = sku;
    }

    public Material() {
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getLimiteMinimo() {
        return limiteMinimo;
    }

    public void setLimiteMinimo(int limiteMinimo) {
        this.limiteMinimo = limiteMinimo;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Material{" + "idMaterial=" + idMaterial + ", nombreMaterial=" + nombreMaterial + ", cantidad="
                + cantidad + ", limiteMinimo=" + limiteMinimo + ", sku=" + sku + ", fechaIngreso=" + fechaIngreso
                + ", idUnidad=" + idUnidad + ", idClasificacion=" + idClasificacion + ", idTienda=" + idTienda
                + ", idUsuario=" + idUsuario + '}';
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Material)) {
            throw new IllegalArgumentException("El objeto debe ser de tipo Salida");
        }
        Material mat = (Material) o;
        return nombreMaterial.compareToIgnoreCase(mat.nombreMaterial);
    }

}
