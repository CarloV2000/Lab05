package it.polito.tdp.anagrammi.model;

import java.util.Objects;

public class Parola {

	private String nome;
	private boolean corretta;
	
	public Parola(String nome, boolean corretta) {
		this.nome = nome;
		this.corretta = false;
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
	
	
}
