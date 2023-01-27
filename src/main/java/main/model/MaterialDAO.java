package main.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import static main.model.Conexion.*;

public class MaterialDAO {

    private final QueryRunner QR = new QueryRunner();
    private static MaterialDAO instance;
    private static List<Material> materiales;

    private MaterialDAO() {
        materiales();
    }

    private void materiales() {
        Connection conn = null;
        try {
            conn = getConnection();
            materiales = (List<Material>) QR.query(conn, "SELECT * FROM material",
                    new BeanListHandler(Material.class));
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
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlMaterial = "INSERT INTO "
                    + "material(nombreMaterial, cantidad, limiteMinimo, sku, fechaIngreso, idUnidad, idClasificacion, idTienda, idUsuario)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            QR.insert(conn, sqlMaterial, new ColumnListHandler(), data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            materiales();
        }
    }

    public void update(int idRegistro, Object[] data) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlUpdate = "UPDATE material SET nombreMaterial = ?, cantidad = ?, limiteMinimo = ?, sku = ?, "
                    + "fechaIngreso = ?, idUnidad = ?, idClasificacion = ?, idTienda = ?, idUsuario = ? WHERE idMaterial = "
                    + idRegistro;
            QR.update(conn, sqlUpdate, data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            materiales();
        }
    }

    public void updateCantidad(int idRegistro, Object[] data, boolean usuarioYFecha) throws SQLException {
        Connection conn = null;
        if (usuarioYFecha) {
            try {
                conn = getConnection();
                conn.setAutoCommit(false);
                String sqlUpdate = "UPDATE material SET cantidad = ?, fechaIngreso = ?, idUsuario = ? WHERE idMaterial = "
                        + idRegistro;
                QR.update(conn, sqlUpdate, data);
                conn.commit();
            } catch (SQLException ex) {
                conn.rollback();
                throw ex;
            } finally {
                close(conn);
                materiales();
            }
        } else {
            try {
                conn = getConnection();
                conn.setAutoCommit(false);
                String sqlUpdate = "UPDATE material SET cantidad = ? WHERE idMaterial = " + idRegistro;
                QR.update(conn, sqlUpdate, data);
                conn.commit();
            } catch (SQLException ex) {
                conn.rollback();
                throw ex;
            } finally {
                close(conn);
                materiales();
            }
        }
    }

    public void remove(int idRegistro) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlRemove = "DELETE FROM `sistema_bd`.`material` WHERE (`idMaterial` = '" + idRegistro + "');";
            QR.execute(conn, sqlRemove);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            materiales();
        }
    }

    public static MaterialDAO getInstance() {
        if (instance == null) {
            instance = new MaterialDAO();
        }
        return instance;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

}
