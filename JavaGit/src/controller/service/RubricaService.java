package oop.dao.rubrica.controller.service;

import java.sql.SQLException;

import io.Console;
import oop.dao.rubrica.model.bean.Contatto;
import oop.dao.rubrica.model.dao.RubricaDAO;

public class RubricaService {

	
	// NUOVO CONTATTO
	public static void inserisciContatto() {
		
		// cosa mi serve per inserire un contatto?
		String numeroCasa = null;
		System.out.println("Inserire il nome");
		String nome = Console.leggiString();
		System.out.println("Inserire il cognome");
		String cognome = Console.leggiString();
		System.out.println("Inserire il numero di cellulare");
		String numeroCell= Console.leggiString();
		System.out.println("Si vuole inserire il numero di casa? (y/n)");
		char decisione = Console.leggiChar();
		if(decisione=='y') {
			System.out.println("Inserire il numero di casa");
			numeroCasa = Console.leggiString();
		}
		
		// creazione del contatto da inviare al DAO
		Contatto nuovoContatto = new Contatto(nome, cognome, numeroCell, numeroCasa);
		
		
		try {
			// mi serve il DB per inserire un contatto? SI
			RubricaDAO.insertContatto(nuovoContatto);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// MODIFICA CONTATTO
	
	
	// CERCA CONTATTO 
	public static int cercaContattoPerCognome() {
		
		System.out.println("Inserire il cognome per iniziare la ricerca");
		String cognome = Console.leggiString();
		try {
			int indice = RubricaDAO.cercaContattoCognome(cognome);
			if(indice!=-1) {
				System.out.println("Il contatto è presente nel sistema\n");
				System.out.println("L'identificativo del contatto è " +indice);
				return indice;
			}else {
				System.out.println("Il contatto non è presente nel sistema");
				return -1;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	// ELIMINA CONTATTO
	
	
	// VEDI TUTTI I CONTATTI
	
	
	
	
	
	
	
	
	
}
