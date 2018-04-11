package it.polito.tdp.anagrammi.model;

import java.util.*;

public class Anagramma {
	
	private List<Character> lettere;
	
	public Anagramma() {
		lettere = new LinkedList<>();
	}
	
	public void add(char c) {
		lettere.add(c);
	}

	@Override
	public String toString() {
		String res = "";
		for(char c: lettere)
			res += c;
		return res+"\n";
	}

	public List<Character> getLettere() {
		return lettere;
	}

	public void setLettere(List<Character> lettere) {
		this.lettere = lettere;
	}
	
	public char get(int i) {
		return this.lettere.get(i) ;
	}

	public void removeLast() {
		lettere.remove(lettere.size()-1);
		
	}
	
	

}
