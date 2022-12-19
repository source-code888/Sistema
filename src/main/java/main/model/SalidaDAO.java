package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class SalidaDAO extends Conexion {

    private QueryRunner QR = new QueryRunner();

    public SalidaDAO() {
    }

    public List<Salida> salidas() {
        List<Salida> salidas = new ArrayList<>();
        try {
            salidas = (List<Salida>) QR.query(getConn(), "SELECT * FROM salida",
                    new BeanListHandler(Salida.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                getConn().close();
            } catch (Exception e) {
            }
        }
        return salidas;
    }

    public void insert(Object[] data) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlSalida = "INSERT INTO salida(cantidadSalida, conceptoSalida, fechaHoraSalida, idEmpleado, idArea, idMaterial, idUnidad, idUsuario)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            qr.insert(getConn(), sqlSalida, new ColumnListHandler(), data);
            getConn().commit();
        } finally {
            getConn().rollback();
            getConn().close();
        }
    }

    public void update(int idRegistro, Object[] data) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlUpdate = "UPDATE salida SET cantidadSalida = ?, conceptoSalida = ?, fechaHoraSalida = ?, idEmpleado = ?, idArea = ?, idMaterial = ?, idUnidad = ?, idUsuario = ? WHERE idSalida = " + idRegistro;
            qr.update(getConn(), sqlUpdate, data);
            getConn().commit();
        } finally {
            getConn().rollback();
            getConn().close();
        }
    }

    public void remove(int idRegistro) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlRemove = "DELETE FROM `sistema_bd`.`salida` WHERE (`idSalida` = '" + idRegistro + "');";
            qr.execute(getConn(), sqlRemove);
            getConn().commit();
        } finally {
            getConn().rollback();
            getConn().close();
        }
    }
}
