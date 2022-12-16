package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class UnidadDAO extends Conexion {

    private QueryRunner QR = new QueryRunner();

    public UnidadDAO() {
    }

    public List<Unidad> unidades() {
        List<Unidad> unidades = new ArrayList<>();
        try {
            unidades = (List<Unidad>) QR.query(getConn(), "SELECT * FROM unidad",
                    new BeanListHandler(Unidad.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return unidades;
    }

    public void insert(Object[] data) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlCliente = "INSERT INTO unidad(nombre) VALUES(?)";
            qr.insert(getConn(), sqlCliente, new ColumnListHandler(), data);
            getConn().commit();
        } catch (SQLException ex) {
            getConn().rollback();
            ex.printStackTrace(System.out);
        }
    }

    public void update(int idRegistro, Object[] data) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlUpdate = "UPDATE unidad SET nombre = ? WHERE id = " + idRegistro;
            qr.update(getConn(), sqlUpdate, data);
            getConn().commit();
        } catch (SQLException ex) {
            getConn().rollback();
            ex.printStackTrace(System.out);
        }
    }

    public void remove(int idRegistro) throws SQLException {
        final QueryRunner qr = new QueryRunner();
        getConn().setAutoCommit(false);
        String sqlRemove = "DELETE FROM `sistema_bd`.`unidad` WHERE (`id` = '" + idRegistro + "');";
        qr.execute(getConn(), sqlRemove);
        getConn().commit();
    }
}
