package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.db.ParolaDAO;

public class Model {
	
	private ParolaDAO parolaDAO;
	List<String>stringheDizionario;
	
	public Model() {
		this.parolaDAO = new ParolaDAO();
		stringheDizionario = new ArrayList<String>(this.parolaDAO.getDizionario());
	}

	/**
	 * questo metodo crea anagrammi in modo ricorsivo a partire da una stringa 
	 * @param input è la parola inserita dall'utente
	 * @return una lista stringhe anagrammi 
	 */
	public List<String> calcolaAnagrammi(String input) {
		if(input.length()==1) {//caso triviale
			List<String>risultato = new LinkedList<String>();
			risultato.add(input);
			return risultato;
		}
		else {//altri casi
			List<String>risultato = new LinkedList<String>();
			
			for(int pos=0; pos<input.length();pos++) {
				char lettera = input.charAt(pos);
				String restanti = input.substring(0,pos)+input.substring(pos+1);
				
				List<String> anagrammiRestanti = calcolaAnagrammi(restanti);
				for(String soluzione : anagrammiRestanti) {
					risultato.add(lettera + soluzione);
				}
			}
			return risultato;
		}
		
	}
	/**
	 * questo metodo crea le parole partendo dalle stringhe nome
	 * @param anagrammi e una lista di stringhe corrispondenti agli attributi nome da attribuire alle parole rappresentanti gli anagrammi
	 * @return una lista di parole rappresentanti gli anagrammi con un attrib true se corretti e false se errati
	 */
	public List<Parola> creaParoleDaAnagrammi(List<String>anagrammi) {
		
		List<Parola>paroleAnagrammi = new ArrayList<Parola>();
		
		for(String x : anagrammi) {
			
			boolean corr = this.anagrammiCorretti(x);
			Parola p = new Parola(x, corr);
			paroleAnagrammi.add(p);
		}
		
		return paroleAnagrammi;
	}
	
	public boolean anagrammiCorretti(String s) {
		boolean a = false;
			if(this.stringheDizionario.contains(s.strip().toLowerCase())) {
				a = true;
			}
		return a;
	}
}
