package main.model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idUsuario;
    private String usuario;
    private String password;
    private boolean administrador;
    private int idEmpleado;

    public Usuario() {
        
    }

    public Usuario(UsuarioBuilder builder) {
        this.idUsuario = builder.idUsuario;
        this.usuario = builder.usuario;
        this.password = builder.password;
        this.administrador = builder.administrador;
        this.idEmpleado = builder.idEmpleado;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" + password + ", idEmpleado=" + idEmpleado + '}';
    }

    public static class UsuarioBuilder {

        private int idUsuario;
        private String usuario;
        private String password;
        private boolean administrador;
        private int idEmpleado;

        public UsuarioBuilder idUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public UsuarioBuilder usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        public UsuarioBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UsuarioBuilder administrador(boolean administrador) {
            this.administrador = administrador;
            return this;
        }

        public UsuarioBuilder idEmpleado(int idEmpleado) {
            this.idEmpleado = idEmpleado;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
}
