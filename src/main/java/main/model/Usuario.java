package main.model;

import java.io.Serializable;

public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    private int idUsuario;
    private String usuario;
    private String password;
    private int idEmpleado;

    public Usuario() {
    }

    public Usuario(int idUsuario, String usuario, String password, int idEmpleado) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.idEmpleado = idEmpleado;
    }

    public Usuario(String usuario, String password, int idEmpleado) {
        this.usuario = usuario;
        this.password = password;
        this.idEmpleado = idEmpleado;
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
    
}
