package Service;

import java.sql.*;

public class DbConnect {
    static String url = "jdbc:sqlserver://;serverName=localhost;databaseName=PRO1041;encrypt=true;trustServerCertificate=true";    
    static String username = "sa4";
    static String password = "1";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }
    
    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}
