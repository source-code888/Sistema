package main.model;

import java.io.Serializable;

public class Entrada implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;
    private int idEntrada;
    private int cantidadEntrada;
    private String fechaEntrada;
    private String nombreMaterial;
    private String nombreEmpleado;

    public Entrada(EntradaBuilder builder) {
        this.idEntrada = builder.idEntrada;
        this.cantidadEntrada = builder.cantidadEntrada;
        this.fechaEntrada = builder.fechaEntrada;
        this.nombreMaterial = builder.nombreMaterial;
        this.nombreEmpleado = builder.nombreEmpleado;
    }

    public Entrada() {

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

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Entrada{");
        sb.append("idEntrada=").append(idEntrada);
        sb.append(", cantidadEntrada=").append(cantidadEntrada);
        sb.append(", fechaEntrada=").append(fechaEntrada);
        sb.append(", nombreMaterial=").append(nombreMaterial);
        sb.append(", nombreEmpleado=").append(nombreEmpleado);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Entrada)) {
            throw new IllegalArgumentException("El objeto debe ser de tipo Entrada");
        } else {
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

    public static class EntradaBuilder {

        private int idEntrada;
        private int cantidadEntrada;
        private String fechaEntrada;
        private String nombreMaterial;
        private String nombreEmpleado;

        public EntradaBuilder idEntrada(int idEntrada) {
            this.idEntrada = idEntrada;
            return this;
        }

        public EntradaBuilder cantidadEntrada(int cantidadEntrada) {
            this.cantidadEntrada = cantidadEntrada;
            return this;
        }

        public EntradaBuilder fechaEntrada(String fechaEntrada) {
            this.fechaEntrada = fechaEntrada;
            return this;
        }

        public EntradaBuilder nombreMaterial(String nombreMaterial) {
            this.nombreMaterial = nombreMaterial;
            return this;
        }

        public EntradaBuilder nombreEmpleado(String nombreEmpleado) {
            this.nombreEmpleado = nombreEmpleado;
            return this;
        }

        public Entrada build() {
            return new Entrada(this);
        }
    }
}
