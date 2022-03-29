package oop.dao.rubrica.model.bean;

public class Contatto {

	private String nome;
	private String cognome;
	private String cell;
	private String numeroCasa;
	
	// costruttore di default
	public Contatto(){
		
	}
	
	public Contatto(String nome, String cognome, String cell){
		this.nome=nome;
		this.cognome=cognome;
		this.cell=cell;
	}
	
	public Contatto(String nome, String cognome, String cell, String casa){
		this.nome=nome;
		this.cognome=cognome;
		this.cell=cell;
		this.numeroCasa=casa;
	}
	
	// set e get
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setCognome(String cognome){
		this.cognome=cognome;
	}
	
	public String getCognome(){
		return this.cognome;
	}
	
	public void setCell(String cellulare){
		cell=cellulare;
	}
	
	public String getCell(){
		return this.cell;
	}
	
	
	
	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String stato() {
		String descrizione = "Nome :" +this.nome+"\n";
		descrizione += "Cognome : " +cognome+"\n";
		descrizione += "Numero Cell : " +this.cell;
		
		return descrizione;
	}
	
	
}
