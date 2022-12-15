
package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class TiendaDAO extends Conexion{
    private QueryRunner QR = new QueryRunner();

    public  TiendaDAO() {
    }

    public List<Tienda> tiendas() {
        List<Tienda> tiendas = new ArrayList<>();
        try {
            tiendas = (List<Tienda>) QR.query(getConn(), "SELECT * FROM tienda",
                    new BeanListHandler(Tienda.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return tiendas;
    }
    
    public void insert(Object[] data) throws SQLException{
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlCliente = "INSERT INTO tienda(nombre) VALUES(?)";
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
            String sqlUpdate = "UPDATE tienda SET nombre = ? WHERE id = " + idRegistro;
            qr.update(getConn(), sqlUpdate, data);
            getConn().commit();
        } catch (SQLException ex) {
            getConn().rollback();
            ex.printStackTrace(System.out);
        }
    }
}
