package main.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import static main.model.Conexion.*;

public class AreaDAO {

    private final QueryRunner QR = new QueryRunner();
    private static List<Area> areas;
    private static AreaDAO instance = null;

    private AreaDAO() {
        areas();
    }

    private void areas() {
        areas = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            areas = (List<Area>) QR.query(conn, "SELECT * FROM area",
                    new BeanListHandler(Area.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(conn);
            } catch (SQLException e) {
            }
        }
    }

    public void insert(Object[] data) throws SQLException {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            conn.setAutoCommit(false);
            String sqlCliente = "INSERT INTO area(nombre) VALUES(?)";
            QR.insert(conn, sqlCliente, new ColumnListHandler(), data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            areas();
        }
    }

    public void update(int idRegistro, Object[] data) throws SQLException {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            conn.setAutoCommit(false);
            String sqlUpdate = "UPDATE area SET nombre = ? WHERE id = " + idRegistro;
            QR.update(conn, sqlUpdate, data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            areas();
        }
    }

    public void remove(int idRegistro) throws SQLException {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            conn.setAutoCommit(false);
            String sqlRemove = "DELETE FROM `sistema_bd`.`area` WHERE (`id` = '" + idRegistro + "');";
            QR.execute(conn, sqlRemove);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            areas();
        }
    }

    public List<Area> getAreas() {
        return areas;
    }

    public static AreaDAO getInstance() {
        if (instance == null) {
            instance = new AreaDAO();
        }
        return instance;
    }

}
