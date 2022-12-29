package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class UsuarioDAO extends Conexion {

    private QueryRunner QR = new QueryRunner();

    public UsuarioDAO() {
        super();
    }

    public List<Usuario> usuarios() {
        List<Usuario> cuentas = new ArrayList<>();
        try {
            cuentas = (List<Usuario>) QR.query(getConn(), "SELECT * FROM usuario",
                    new BeanListHandler(Usuario.class));
        } catch (SQLException ex) {
        } finally {
            try {
                close(getConn());
            } catch (Exception e) {
            }
        }
        return cuentas;
    }
}
