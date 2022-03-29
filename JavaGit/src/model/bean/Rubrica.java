package oop.dao.rubrica.model.bean;

public class Rubrica {

	private Contatto[] listaContatti;
	
	
	// costruttore - i
	public Rubrica (int dimensione){
		if(dimensione>100 || dimensione<0){
			System.out.println("Valore non consentito per la costruzione della rubrica");
		}else{
			listaContatti= new Contatto[dimensione];
		}
	}
	
	public Rubrica(){
		listaContatti= new Contatto[10];
	}

	
	// getters & setters
	public Contatto[] getListaContatti() {
		return listaContatti;
	}

	public void setListaContatti(Contatto[] listaContatti) {
		this.listaContatti = listaContatti;
	}
	
	
	// metodi OVERRIDE
	@Override
	public String toString() {
		String descrizione = "Contatti Rubrica :\n";
		
			for(int i=0; i<listaContatti.length;i++){
				if(listaContatti[i]!=null){
					descrizione +=listaContatti[i].toString();
				}
			}
		
		return descrizione;
	}
	
	
	
	// altre FUNZIONALITA'
	public boolean aggiungiContatto(Contatto nuovoContatto){
				
		for(int i=0;i<listaContatti.length;i++){
			if(listaContatti[i]==null){
				listaContatti[i]=nuovoContatto;
				return true; // uscita anticipata
			}
		}
		
		// sono uscito perchè ho finito il ciclo for --> lista piena
		return false;
	}
	
	public int cercaContatto(Contatto contattoDaRicercare){
		
		for(int i=0;i<listaContatti.length;i++){
			if(listaContatti[i].equals(contattoDaRicercare)){
				// il contatto è stato trovato
				return i;
			}
		}
		
		// ho finito il ciclo for --> elemento NON trovato
		return -1;
		
	}
	
	public boolean modificaContatto(Contatto contattoDaModificare, Contatto nuovoContatto){
		
		int posizione = this.cercaContatto(contattoDaModificare);
		
		if(posizione!=-1){
			listaContatti[posizione]= nuovoContatto;
			return true;
		}else{
			System.out.println("Impossibile modificare il contatto.");
			System.out.println("Contatto non presente");
			return false;
		}
		
	}
	
	/**
	 * Funzione che elimina un Contatto dalla Rubrica
	 * @param contattoDaEliminare : Contatto richiesto nel main
	 * @return 
	 * 		true : il contatto è stato eliminato
	 * 		false : il contatto non è presente nel sistema
	 */
	public boolean eliminaContatto(Contatto contattoDaEliminare){
		int posizione = this.cercaContatto(contattoDaEliminare);
		
		if(posizione!=-1){
			listaContatti[posizione]=null;
			return true;
		}
		
		return false;
	}
	
	
}
