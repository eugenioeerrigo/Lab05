package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO anDao;
	private Set<Anagramma> soluzione;
	
	public Set<Anagramma> getAnagrammi(String parola) {
		
		int livello = 0;
		soluzione = new HashSet<Anagramma>();
		
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
			//if(!a1.getLettere().contains(a.get(i))) {                        //FUNZIONA SOLO SE a NON CONTIENE 2 LETTERE UGUALI
			if(charCounter(a1, a.get(i)) < charCounter(a, a.get(i))) {         //FUNZIONA MA MI RIPETE PIU' VOLTE LE PAROLE ANAGRAMMATE SE HO 2 LETTERE UGUALI
			a1.add(a.get(i)); 
			ricorsiva(a, a1, livello+1);
			a1.removeLast();
			}
		}
		
	}

	public boolean isCorrect(Anagramma a) {
		anDao = new AnagrammaDAO();
		return anDao.isCorrect(a);
	}
	
	private static int charCounter(Anagramma a, char c){
		int count = 0;
	    for (int i=0; i < a.getLettere().size(); i++)
	    {
	        if (a.get(i) == c)
	        {
	             count++;
	        }
	    }
	    return count;
	}
	
}
