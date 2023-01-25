package main.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String dbName = "sistema_bd";
    private static final String URL = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&useTimezone=true";
    
    public Conexion() {
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, "root", "admin");
    }
    
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
