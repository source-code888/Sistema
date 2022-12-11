package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
        }
        return empleados;
    }
}
