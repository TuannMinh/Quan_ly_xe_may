/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

//import Utilities.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBconnection {
    static String usename = "sa";
    static String pass = "123";
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=A_TestXeMay;encrypt=true;trustServerCertificate=true";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {

        Connection cn = null;
        try {
            cn = DriverManager.getConnection(url, usename, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }

    public static void main(String[] args) {
        Connection cn = getConnection();

        if (cn!= null) {
            System.out.println("thanh cong");
        } else {
            System.out.println("that bai");

        }
    }
}
