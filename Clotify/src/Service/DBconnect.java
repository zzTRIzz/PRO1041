/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author THE PC
 */
public class DBconnect {
        static String url = "jdbc:sqlserver://;serverName=localhost;databaseName=PRO1041;encrypt=true;trustServerCertificate=true";
    static  String username = "sa";
    static String password = "0973665656";
    
    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url, username, password);
    }
    
    
    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}
