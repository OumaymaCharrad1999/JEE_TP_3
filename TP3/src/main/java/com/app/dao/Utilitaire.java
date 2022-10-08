package com.app.dao;

import java.sql.*;

public class Utilitaire {
    
    private static Connection conn;
    static {
	try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/BaseUsers", "root", "1329566");
	} 
        catch (Exception e) {
            e.printStackTrace();
	}
    }
    public static Connection getConnection() {
	return conn;
    }
    
}