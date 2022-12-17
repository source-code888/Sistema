package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class EmpleadoDAO extends Conexion {

    private QueryRunner QR = new QueryRunner();

    public EmpleadoDAO() {
    }

    public List<Empleado> empleados() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            empleados = (List<Empleado>) QR.query(getConn(), "SELECT * FROM empleado",
                    new BeanListHandler(Empleado.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                getConn().close();
            } catch (Exception e) {
            }
        }
        return empleados;
    }
    
    public void insert(Object[] data) throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner();
            getConn().setAutoCommit(false);
            String sqlEmpleado = "INSERT INTO "
                    + "empleado(nombre, apellidoPaterno, apellidoMaterno, telefono, email, idArea)"
                    + "VALUES(?, ?, ?, ?, ?, ?)";
            qr.insert(getConn(), sqlEmpleado, new ColumnListHandler(), data);
            getConn().commit();
        } finally {
            getConn().rollback();
            getConn().close();
        }
    }
}
