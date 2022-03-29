package oop.dao.rubrica.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// costanti per la connessione
	
	// per mysql 5.7
	//private final static String DB_DRIVER_CLASS="com.mysql.jdbc.Driver";
	
	// per mysql 8
	private final static String DB_DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
	private final static String USER="root";
	private final static String PASSWORD="root";
	private final static String NOME_SCHEMA ="rubrica";
	private final static String PROPERTY ="?useLegacyDatetimeCode=false&useSSL=false&serverTimezone=Europe/Amsterdam";
	private final static String URL="jdbc:mysql://localhost:3306/" +NOME_SCHEMA+PROPERTY;
	
	private static Connection connessione;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{

		if(connessione==null){		

			// carico il driver
			Class.forName(DB_DRIVER_CLASS);
			
			// creo la connessione 
			connessione = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connessione avviata con successo");
		
		}

		return connessione;
	}
	
}
