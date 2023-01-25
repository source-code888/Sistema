package main.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import static main.model.Conexion.*;

public class TiendaDAO{

    private final QueryRunner QR = new QueryRunner();
    private static TiendaDAO instance = null;
    private static List<Tienda> tiendas;

    private TiendaDAO() {
        tiendas();
    }

    private void tiendas() {
        Connection conn = null;
        try {
            conn = getConnection();
            tiendas = (List<Tienda>) QR.query(conn, "SELECT * FROM tienda",
                    new BeanListHandler(Tienda.class));
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
            String sqlCliente = "INSERT INTO tienda(nombre) VALUES(?)";
            QR.insert(conn, sqlCliente, new ColumnListHandler(), data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            tiendas();
        }
    }

    public void update(int idRegistro, Object[] data) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlUpdate = "UPDATE tienda SET nombre = ? WHERE id = " + idRegistro;
            QR.update(conn, sqlUpdate, data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            tiendas();
        }
    }

    public void remove(int idRegistro) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlRemove = "DELETE FROM `sistema_bd`.`tienda` WHERE (`id` = '" + idRegistro + "');";
            QR.execute(conn, sqlRemove);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            tiendas();
        }
    }

    public static TiendaDAO getInstance() {
        if (instance == null) {
            instance = new TiendaDAO();
        }
        return instance;
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

}
