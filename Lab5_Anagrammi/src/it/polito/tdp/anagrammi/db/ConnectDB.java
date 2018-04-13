package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private final static String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=eugi&useSSL=false";
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
			
			try {
				if(conn==null || conn.isClosed()) 
					conn = DriverManager.getConnection(jdbcURL);
			} catch (SQLException e) {
				System.err.println("Errore di connessione al DB");
				throw new RuntimeException(e);
			}
		
			return conn;
	}
}