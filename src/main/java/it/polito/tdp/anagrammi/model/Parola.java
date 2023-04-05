package it.polito.tdp.anagrammi.model;

public class Parola {

	private String nome;
	private boolean corretta;
	
	public Parola(String nome, boolean corretta) {
		this.nome = nome;
		this.corretta = corretta;
	}

	public String getNome() {
		return nome;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	@Override
	public String toString() {
		return "Parola [nome=" + nome + ", corretta=" + corretta + "]";
	}
	
	
}
