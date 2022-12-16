package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class ClasificacionDAO extends Conexion {

    private QueryRunner QR = new QueryRunner();

    public ClasificacionDAO() {
    }

    public List<Clasificacion> clasificaciones() {
        List<Clasificacion> clasificaciones = new ArrayList<>();
        try {
            clasificaciones = (List<Clasificacion>) QR.query(getConn(), "SELECT * FROM clasificacion",
                    new BeanListHandler(Clasificacion.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                getConn().close();
            } catch (Exception e) {
            }
        }
        return clasificaciones;
    }

    public void insert(Object[] data) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlCliente = "INSERT INTO clasificacion(nombre) VALUES(?)";
            qr.insert(getConn(), sqlCliente, new ColumnListHandler(), data);
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
            String sqlUpdate = "UPDATE clasificacion SET nombre = ? WHERE id = " + idRegistro;
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
            String sqlRemove = "DELETE FROM `sistema_bd`.`clasificacion` WHERE (`id` = '" + idRegistro + "');";
            qr.execute(getConn(), sqlRemove);
            getConn().commit();
        } finally {
            getConn().rollback();
            getConn().close();
        }
    }
}
