package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class AreaDAO extends Conexion {

    private QueryRunner QR = new QueryRunner();

    public AreaDAO() {
    }

    public List<Area> areas() {
        List<Area> areas = new ArrayList<>();
        try {
            areas = (List<Area>) QR.query(getConn(), "SELECT * FROM area",
                    new BeanListHandler(Area.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                getConn().close();
            } catch (Exception e) {
            }
        }
        return areas;
    }

    public void insert(Object[] data) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlCliente = "INSERT INTO area(nombre) VALUES(?)";
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
            String sqlUpdate = "UPDATE area SET nombre = ? WHERE id = " + idRegistro;
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
            String sqlRemove = "DELETE FROM `sistema_bd`.`area` WHERE (`id` = '" + idRegistro + "');";
            qr.execute(getConn(), sqlRemove);
            getConn().commit();
        } finally {
            getConn().rollback();
            getConn().close();
        }
    }
}
