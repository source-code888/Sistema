package main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class MaterialDAO extends Conexion{
    
    private QueryRunner QR = new QueryRunner();
    
    public MaterialDAO(){
        super();
    }
    public List<Material> materiales() {
        List<Material> materiales = new ArrayList<>();
        try {
            materiales = (List<Material>) QR.query(getConn(), "SELECT * FROM material",
                    new BeanListHandler(Material.class));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return materiales;
    }
}
