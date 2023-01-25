package main.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import static main.model.Conexion.*;

public class EntradaDAO extends Conexion {

    private final QueryRunner QR = new QueryRunner();
    private static EntradaDAO instance;
    private static List<Entrada> entradas;

    private EntradaDAO() {
        entradas();
    }

    private void entradas() {
        Connection conn = null;
        try {
            conn = getConnection();
            entradas = (List<Entrada>) QR.query(conn, "SELECT * FROM entrada",
                    new BeanListHandler(Entrada.class));
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
            String sqlEntrada = "INSERT INTO entrada(cantidadEntrada, fechaEntrada, nombreMaterial, nombreEmpleado) VALUES(?, ?, ?, ?)";
            QR.insert(conn, sqlEntrada, new ColumnListHandler(), data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            entradas();
        }
    }

    public void update(int idRegistro, Object[] data) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlUpdate = "UPDATE entrada SET cantidadEntrada = ?, fechaEntrada = ?, nombreMaterial = ?, idEmpleado = ? WHERE idEntrada = " + idRegistro;
            QR.update(conn, sqlUpdate, data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            entradas();
        }
    }

    public void remove(int idRegistro) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlRemove = "DELETE FROM `sistema_bd`.`entrada` WHERE (`idEntrada` = '" + idRegistro + "');";
            QR.execute(conn, sqlRemove);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            entradas();
        }
    }

    public static EntradaDAO getInstance() {
        if (instance == null) {
            instance = new EntradaDAO();
        }
        return instance;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

}
