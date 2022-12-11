package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class Consult extends Conexion {

    private QueryRunner QR = new QueryRunner();

    public Consult() {
        super();
    }

    public List<Cuenta> clientes() {
        List<Cuenta> cuentas = new ArrayList<>();
        try {
            cuentas = (List<Cuenta>) QR.query(getConn(), "SELECT * FROM cuenta",
                    new BeanListHandler(Cuenta.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return cuentas;
    }

}
