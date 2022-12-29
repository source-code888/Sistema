package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class EntradaDAO extends Conexion {

    private QueryRunner QR = new QueryRunner();

    public EntradaDAO() {
    }

    public List<Entrada> entradas() {
        List<Entrada> entradas = new ArrayList<>();
        try {
            entradas = (List<Entrada>) QR.query(getConn(), "SELECT * FROM entrada",
                    new BeanListHandler(Entrada.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(getConn());
            } catch (Exception e) {
            }
        }
        return entradas;
    }

    public void insert(Object[] data) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlEntrada = "INSERT INTO entrada(cantidadEntrada, fechaEntrada, idMaterial, idEmpleado) VALUES(?, ?, ?, ?)";
            qr.insert(getConn(), sqlEntrada, new ColumnListHandler(), data);
            getConn().commit();
        } catch (SQLException ex) {
            getConn().rollback();
            throw ex;
        } finally {
            close(getConn());
        }
    }

    public void update(int idRegistro, Object[] data) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlUpdate = "UPDATE entrada SET cantidadEntrada = ?, fechaEntrada = ?, idMaterial = ?, idEmpleado = ? WHERE idEntrada = " + idRegistro;
            qr.update(getConn(), sqlUpdate, data);
            getConn().commit();
        } catch (SQLException ex) {
            getConn().rollback();
            throw ex;
        } finally {
            close(getConn());
        }
    }

    public void remove(int idRegistro) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlRemove = "DELETE FROM `sistema_bd`.`entrada` WHERE (`idEntrada` = '" + idRegistro + "');";
            qr.execute(getConn(), sqlRemove);
            getConn().commit();
        } catch (SQLException ex) {
            getConn().rollback();
            throw ex;
        } finally {
            close(getConn());
        }
    }
}
