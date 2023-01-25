package main.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import static main.model.Conexion.*;

public class EmpleadoDAO extends Conexion {

    private final QueryRunner QR = new QueryRunner();
    private static EmpleadoDAO instance = null;
    private static List<Empleado> empleados;

    private EmpleadoDAO() {
        empleados();
    }

    private void empleados() {
        Connection conn = null;
        try {
            conn = getConnection();
            empleados = (List<Empleado>) QR.query(conn, "SELECT * FROM empleado",
                    new BeanListHandler(Empleado.class));
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
            String sqlEmpleado = "INSERT INTO "
                    + "empleado(nid, nombre, apellidoPaterno, apellidoMaterno, telefono, email, contratado, idArea)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            QR.insert(conn, sqlEmpleado, new ColumnListHandler(), data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            empleados();
        }
    }

    public void update(int idRegistro, Object[] data) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlUpdate = "UPDATE empleado SET nid = ?, nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, telefono = ?, "
                    + "email = ?, contratado = ?,  idArea = ? WHERE idEmpleado = " + idRegistro;
            QR.update(conn, sqlUpdate, data);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            empleados();
        }
    }

    public void remove(int idRegistro) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlRemove = "DELETE FROM `sistema_bd`.`empleado` WHERE (`idEmpleado` = '" + idRegistro + "');";
            QR.execute(conn, sqlRemove);
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            close(conn);
            empleados();
        }
    }

    public static EmpleadoDAO getInstance() {
        if (instance == null) {
            instance = new EmpleadoDAO();
        }
        return instance;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

}
