package it.polito.tdp.anagrammi.model;

import java.util.*;

public class Model {

	private List<Anagramma> soluzione;
	
	public List<Anagramma> getAnagrammi(String parola) {
		
		int livello = 0;
		soluzione = new ArrayList<>();
		
		Anagramma a = new Anagramma(parola);
		
		Anagramma a1 = new Anagramma();
		
		this.ricorsiva(a, a1, livello);
		
		return soluzione;
	}

	private void ricorsiva(Anagramma a, Anagramma a1, int livello) {
		
		//System.out.println(a1.toString());
		
		if(livello==a.getLettere().size()) {
			
			soluzione.add(new Anagramma(a1));                    //deep-copy

			return;
		}
	
		for(int i=0; i<a.getLettere().size(); i++) {
			if(!a1.getLettere().contains(a.get(i))) {
			a1.add(a.get(i)); 
			ricorsiva(a, a1, livello+1);
			a1.removeLast();
			}
		}
		
	}
	

	
}
