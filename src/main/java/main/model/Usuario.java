package main.model;

public class Usuario {

    private static final long serialVersionUID = 1L;
    private int idUsuario;
    private String usuario;
    private String password;
    private int id;

    public Usuario(int idUsuario, String usuario, String password, int id) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.id = id;
    }

    public Usuario() {
    }

    public Usuario(String usuario, String password, int id) {
        this.usuario = usuario;
        this.password = password;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" + password + ", id=" + id + '}';
    }

}
