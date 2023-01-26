package main.model;

import java.io.Serializable;

public class Empleado implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;
    private int idEmpleado;
    private String nid;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String email;
    private boolean contratado;
    private int idArea;

    public Empleado() {
    }

    public Empleado(EmpleadoBuilder builder) {
        this.idEmpleado = builder.idEmpleado;
        this.nid = builder.nid;
        this.nombre = builder.nombre;
        this.apellidoPaterno = builder.apellidoPaterno;
        this.apellidoMaterno = builder.apellidoMaterno;
        this.telefono = builder.telefono;
        this.email = builder.email;
        this.contratado = builder.contratado;
        this.idArea = builder.idArea;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isContratado() {
        return contratado;
    }

    public void setContratado(boolean contratado) {
        this.contratado = contratado;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nid=" + nid + ", nombre=" + nombre + ", apellidoPaterno="
                + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + ", email="
                + email + ", contratado=" + contratado + ", idArea=" + idArea + '}';
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Empleado)) {
            throw new IllegalArgumentException("Argumento inválido");
        }
        return nombre.compareToIgnoreCase(((Empleado) o).nombre);
    }

    public static class EmpleadoBuilder {

        private int idEmpleado;
        private String nid;
        private String nombre;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String telefono;
        private String email;
        private boolean contratado;
        private int idArea;

        public EmpleadoBuilder idEmpleado(int idEmpleado) {
            this.idEmpleado = idEmpleado;
            return this;
        }

        public EmpleadoBuilder nid(String nid) {
            this.nid = nid;
            return this;
        }

        public EmpleadoBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public EmpleadoBuilder apellidoPaterno(String apellidoPaterno) {
            this.apellidoPaterno = apellidoPaterno;
            return this;
        }

        public EmpleadoBuilder apellidoMaterno(String apellidoMaterno) {
            this.apellidoMaterno = apellidoMaterno;
            return this;
        }

        public EmpleadoBuilder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public EmpleadoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public EmpleadoBuilder contratado(boolean contratado) {
            this.contratado = contratado;
            return this;
        }

        public EmpleadoBuilder idArea(int idArea) {
            this.idArea = idArea;
            return this;
        }

        public Empleado build() {
            return new Empleado(this);
        }
    }
}
