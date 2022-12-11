package main.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private static final String dbName = "procidatabase";
    private static final String URL = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&useTimezone=true";
    private Connection conn;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", "admin");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public Connection getConn() {
        return conn;
    }

    public static Connection getConnectionD() throws SQLException {
        return DriverManager.getConnection(URL, "root", "admin");
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(PreparedStatement stmt) throws SQLException {
        stmt.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
