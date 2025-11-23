package com.ejemplo.agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private static final String URL = "jdbc:mysql://localhost:3306/agenda";
    private static final String USER = "root";
    private static final String PASS = "root";  

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a la BD");
        } catch (Exception e) {
            System.out.println("Error conectando: " + e.getMessage());
        }

        return conn;
    }
}
