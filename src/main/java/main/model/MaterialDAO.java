package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class MaterialDAO extends Conexion {

    private QueryRunner QR = new QueryRunner();

    public MaterialDAO() {
        super();
    }

    public List<Material> materiales() {
        List<Material> materiales = new ArrayList<>();
        try {
            materiales = (List<Material>) QR.query(getConn(), "SELECT * FROM material",
                    new BeanListHandler(Material.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                getConn().close();
            } catch (Exception e) {
            }
        }
        return materiales;
    }

    public void insert(Object[] data) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlMaterial = "INSERT INTO "
                    + "material(nombreMaterial, cantidad, limiteMinimo, sku, fechaIngreso, idUnidad, idClasificacion, idTienda, idUsuario)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            qr.insert(getConn(), sqlMaterial, new ColumnListHandler(), data);
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
            String sqlUpdate = "UPDATE material SET nombreMaterial = ?, cantidad = ?, limiteMinimo = ?, sku = ?, "
                    + "fechaIngreso = ?, idUnidad = ?, idClasificacion = ?, idTienda = ?, idUsuario = ? WHERE idMaterial = " + idRegistro;
            qr.update(getConn(), sqlUpdate, data);
            getConn().commit();
        } finally {
            getConn().rollback();
            getConn().close();
        }
    }

    public void updateCantidad(int idRegistro, Object[] data, boolean usuarioYFecha) throws SQLException {
        if (usuarioYFecha) {
            try {
                final QueryRunner qr = new QueryRunner();
                getConn().setAutoCommit(false);
                String sqlUpdate = "UPDATE material SET cantidad = ?, fechaIngreso = ?, idUsuario = ? WHERE idMaterial = " + idRegistro;
                qr.update(getConn(), sqlUpdate, data);
                getConn().commit();
            } finally {
                getConn().rollback();
                getConn().close();
            }
        }else{
            try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlUpdate = "UPDATE material SET cantidad = ? WHERE idMaterial = " + idRegistro;
            qr.update(getConn(), sqlUpdate, data);
            getConn().commit();
        } finally {
            getConn().rollback();
            getConn().close();
        }
        }
    }

    public void remove(int idRegistro) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlRemove = "DELETE FROM `sistema_bd`.`material` WHERE (`idMaterial` = '" + idRegistro + "');";
            qr.execute(getConn(), sqlRemove);
            getConn().commit();
        } finally {
            getConn().rollback();
            getConn().close();
        }
    }
}
