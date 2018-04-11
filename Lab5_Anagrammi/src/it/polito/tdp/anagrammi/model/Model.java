package it.polito.tdp.anagrammi.model;

import java.util.*;

public class Model {

	private List<Anagramma> soluzione;
	
	public List<Anagramma> getAnagrammi(String parola) {
		
		int livello = 0;
		soluzione = new ArrayList<>();
		
		Anagramma a = new Anagramma();
		for(int i=0; i<parola.length(); i++) {
			a.add(parola.charAt(i));
			
		}
		
		Anagramma a1 = new Anagramma();
		
		this.ricorsiva(a, a1, livello);
		
		return soluzione;
	}

	private void ricorsiva(Anagramma a, Anagramma a1, int livello) {
		
		if(livello==a.getLettere().size()) {
			soluzione.add(a1);
			return;
		}
	
		a1.add(a.get(livello));
		ricorsiva(a, a1, livello+1);
		a1.removeLast();
		
	}

	

}
