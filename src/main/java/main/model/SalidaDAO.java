package main.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class SalidaDAO extends Conexion {

    private final QueryRunner QR = new QueryRunner();
    private static SalidaDAO instance = null;
    private static List<Salida> salidas;

    private SalidaDAO() {
        salidas();
    }

    private void salidas() {
        Connection conn = null;
        try {
            conn = getConnection();
            salidas = (List<Salida>) QR.query(conn, "SELECT * FROM salida",
                    new BeanListHandler(Salida.class));
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
            String sqlSalida = "INSERT INTO salida(cantidadSalida, conceptoSalida, fechaHoraSalida, nombreEmpleado, areaEmpleado,"
                    + " nombreMaterial, unidadMaterial, idUsuario)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            QR.insert(conn, sqlSalida, new ColumnListHandler(), data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            salidas();
        }
    }

    public void update(int idRegistro, Object[] data) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlUpdate = "UPDATE salida SET cantidadSalida = ?, conceptoSalida = ?, fechaHoraSalida = ?, idEmpleado = ?, idArea = ?, idMaterial = ?, idUnidad = ?, idUsuario = ? WHERE idSalida = " + idRegistro;
            QR.update(conn, sqlUpdate, data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            salidas();
        }
    }

    public void remove(int idRegistro) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlRemove = "DELETE FROM `sistema_bd`.`salida` WHERE (`idSalida` = '" + idRegistro + "');";
            QR.execute(conn, sqlRemove);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            salidas();
        }
    }

    public static SalidaDAO getInstance() {
        if (instance == null) {
            instance = new SalidaDAO();
        }
        return instance;
    }

    public List<Salida> getSalidas() {
        return salidas;
    }

}
