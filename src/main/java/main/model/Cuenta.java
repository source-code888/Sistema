package main.model;

import java.io.Serializable;

public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String usuario;
    private String password;
    private int idUsuario;

    public Cuenta(int id, String usuario, String password, int idUsuario) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.idUsuario = idUsuario;
    }

    public Cuenta(String usuario, String password, int idUsuario) {
        this.usuario = usuario;
        this.password = password;
        this.idUsuario = idUsuario;
    }

    public Cuenta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", usuario=" + usuario + ", password=" + password + ", empleado=" + idUsuario + '}';
    }
}
