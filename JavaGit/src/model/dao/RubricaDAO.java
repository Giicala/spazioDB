package oop.dao.rubrica.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oop.dao.rubrica.model.bean.Contatto;

public class RubricaDAO {

	
	/**
	 * Funzione che ci permette l'inserimento di un nuovo contatto
	 * @param nuovoContatto
	 * @return se l'esito è OK o KO
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void insertContatto(Contatto nuovoContatto) throws ClassNotFoundException, SQLException {
		
		// recupero la connessione
		Connection miaConnessione = DBConnection.getConnection();
		
		// creo lo statement
//		Statement  st = miaConnessione.createStatement();
		
		
		// creo lo scipt
//		String sql = "INSERT INTO contatto (nome, cognome, numeroCell, numeroCasa) VALUES ('"+nuovoContatto.getNome()+"', '"+nuovoContatto.getCognome()+"', '"+nuovoContatto.getCell()+"', '"+nuovoContatto.getNumeroCasa()+"')";
		
		
		// eseguo lo script
//		int rowAffected = st.executeUpdate(sql);
//		if(rowAffected==1) {
//			return true;
//		}else { 
//			return false;
//		}
		
		// creo lo script sql
		String sql ="INSERT INTO contatto (nome, cognome, numeroCell, numeroCasa) VALUES (?,?,?,?)";
		
		// creo il preparedStatement
		PreparedStatement pst = miaConnessione.prepareStatement(sql);
		
		// sostituisco i punti interrogativi
		pst.setString(1, nuovoContatto.getNome());
		pst.setString(2, nuovoContatto.getCognome());
		pst.setString(3, nuovoContatto.getCell());
		pst.setString(4, nuovoContatto.getNumeroCasa());
		
		int row = pst.executeUpdate();
		if(row==1) {
			System.out.println("Inserimento avvenuto con successo");
		}else {
			System.out.println("Errore durante l'inserimento");
		}
		
	}
	
	/**
	 * Funzione che ricerca un contatto per cognome
	 * @param cognome
	 * @return id del Contatto trovato
	 * 		   -1 in caso negativo
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int cercaContattoCognome(String cognome) throws ClassNotFoundException, SQLException {
		
		// recuperare la connessione
		Connection connessione = DBConnection.getConnection();
		String sql ="SELECT idcontatto FROM contatto WHERE cognome=?";
		PreparedStatement pst= connessione.prepareStatement(sql);
		pst.setString(1, cognome);
		ResultSet risultato = pst.executeQuery();
		if(risultato.next()) {
			int id = risultato.getInt(1);
			return id;
		}else {
			return -1;
		}
	}
}
