package oop.dao.rubrica.controller;

import io.Console;
import oop.dao.rubrica.controller.service.RubricaService;

public class TestRubrica {

	public static void main(String[] args) {

		
			int scelta=0;

			do {
				System.out.println("RUBRICA DB");
				System.out.println("1. Inserire un nuovo contatto");
				System.out.println("2. Ricerca contatto per cognome");
				System.out.println("0. Per uscire");
				scelta = Console.leggiInt();		

				switch (scelta) {
				case 1:
					RubricaService.inserisciContatto();
					break;
				case 2:
					RubricaService.cercaContattoPerCognome();
					break;
				case 0:
					System.out.println("Uscita dal programma...");		
					break;
				default:
					System.out.println("Inserimento non riconosciuto..riprovare");
					break;
				}
			}while(scelta!=0);

			System.out.println("Chiusura programma..");
	}

}
