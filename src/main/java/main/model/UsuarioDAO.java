package main.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import static main.model.Conexion.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class UsuarioDAO {

    private final QueryRunner QR = new QueryRunner();
    private static UsuarioDAO instance = null;
    private static List<Usuario> usuarios;

    private UsuarioDAO() {
        usuarios();
    }

    private void usuarios() {
        Connection conn = null;
        try {
            conn = getConnection();
            usuarios = (List<Usuario>) QR.query(conn, "SELECT * FROM usuario",
                    new BeanListHandler(Usuario.class));
        } catch (SQLException ex) {
        } finally {
            try {
                close(conn);
            } catch (Exception e) {
            }
        }
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

}
