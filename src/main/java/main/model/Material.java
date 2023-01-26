package main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public Material(MaterialBuilder builder) {
        this.idMaterial = builder.idMaterial;
        this.nombreMaterial = builder.nombreMaterial;
        this.cantidad = builder.cantidad;
        this.limiteMinimo = builder.limiteMinimo;
        this.sku = builder.sku;
        this.fechaIngreso = builder.fechaIngreso;
        this.idUnidad = builder.idUnidad;
        this.idClasificacion = builder.idClasificacion;
        this.idTienda = builder.idTienda;
        this.idUsuario = builder.idUsuario;
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

    public List<Material> ordenamiento(List<Material> filter) {

        filter.sort(new Comparator<Material>() {
            @Override
            public int compare(Material o1, Material o2) {
                return o1.getNombreMaterial().compareToIgnoreCase(o2.getNombreMaterial());
            }

        });

        List<Material> ordenado = new ArrayList<>();

        for (int i = 0; i < filter.size(); i++) {
            if (filter.get(i).getCantidad() <= filter.get(i).getLimiteMinimo()) {
                ordenado.add(filter.get(i));
            }
        }
        for (int i = 0; i < filter.size(); i++) {
            if (!ordenado.contains(filter.get(i))) {
                ordenado.add(filter.get(i));
            }

        }
        return ordenado;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Material)) {
            throw new IllegalArgumentException("El objeto debe ser de tipo Salida");
        }
        Material mat = (Material) o;
        return nombreMaterial.compareToIgnoreCase(mat.nombreMaterial);

    }

    public static class MaterialBuilder {

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

        public MaterialBuilder() {

        }

        public MaterialBuilder idMaterial(int idMaterial) {
            this.idMaterial = idMaterial;
            return this;
        }

        public MaterialBuilder nombreMaterial(String nombreMaterial) {
            this.nombreMaterial = nombreMaterial;
            return this;
        }

        public MaterialBuilder cantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public MaterialBuilder limiteMinimo(int limiteMinimo) {
            this.limiteMinimo = limiteMinimo;
            return this;
        }

        public MaterialBuilder sku(String sku) {
            this.sku = sku;
            return this;
        }

        public MaterialBuilder fechaIngreso(String fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
            return this;
        }

        public MaterialBuilder idUnidad(int idUnidad) {
            this.idUnidad = idUnidad;
            return this;
        }

        public MaterialBuilder idClasificacion(int idClasificacion) {
            this.idClasificacion = idClasificacion;
            return this;
        }

        public MaterialBuilder idTienda(int idTienda) {
            this.idTienda = idTienda;
            return this;
        }

        public MaterialBuilder idUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public Material build() {
            return new Material(this);
        }
    }
}
