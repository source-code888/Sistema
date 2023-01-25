package main.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import static main.model.Conexion.*;

public class ClasificacionDAO{

    private final QueryRunner QR = new QueryRunner();
    private static ClasificacionDAO instance = null;
    private static List<Clasificacion> clasificaciones;

    private ClasificacionDAO() {
        clasificaciones();
    }

    private void clasificaciones() {
        Connection conn = null;
        try {
            conn = getConnection();
            clasificaciones = (List<Clasificacion>) QR.query(conn, "SELECT * FROM clasificacion",
                    new BeanListHandler(Clasificacion.class));
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
            String sqlCliente = "INSERT INTO clasificacion(nombre) VALUES(?)";
            QR.insert(conn, sqlCliente, new ColumnListHandler(), data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            clasificaciones();
        }
    }

    public void update(int idRegistro, Object[] data) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlUpdate = "UPDATE clasificacion SET nombre = ? WHERE id = " + idRegistro;
            QR.update(conn, sqlUpdate, data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            clasificaciones();
        }
    }

    public void remove(int idRegistro) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlRemove = "DELETE FROM `sistema_bd`.`clasificacion` WHERE (`id` = '" + idRegistro + "');";
            QR.execute(conn, sqlRemove);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            clasificaciones();
        }
    }

    public static ClasificacionDAO getInstance() {
        if (instance == null) {
            instance = new ClasificacionDAO();
        }
        return instance;
    }

    public List<Clasificacion> getClasificaciones() {
        return clasificaciones;
    }

}
