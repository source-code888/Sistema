package main.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import static main.model.Conexion.*;

public class UnidadDAO {

    private final QueryRunner QR = new QueryRunner();
    private static UnidadDAO instance = null;
    private static List<Unidad> unidades;

    private UnidadDAO() {
        unidades();
    }

    private void unidades() {
        Connection conn = null;
        try {
            conn = getConnection();
            unidades = (List<Unidad>) QR.query(conn, "SELECT * FROM unidad",
                    new BeanListHandler(Unidad.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(conn);
            } catch (Exception e) {
            }
        }
    }

    public void insert(Object[] data) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlCliente = "INSERT INTO unidad(nombre) VALUES(?)";
            QR.insert(conn, sqlCliente, new ColumnListHandler(), data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            unidades();
        }
    }

    public void update(int idRegistro, Object[] data) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlUpdate = "UPDATE unidad SET nombre = ? WHERE id = " + idRegistro;
            QR.update(conn, sqlUpdate, data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            unidades();
        }
    }

    public void remove(int idRegistro) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlRemove = "DELETE FROM `sistema_bd`.`unidad` WHERE (`id` = '" + idRegistro + "');";
            QR.execute(conn, sqlRemove);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            unidades();
        }
    }

    public static UnidadDAO getInstance() {
        if (instance == null) {
            instance = new UnidadDAO();
        }
        return instance;
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

}
