package it.polito.tdp.anagrammi.model;

import java.util.*;

public class Anagramma {
	
	private List<Character> lettere;
	
	public Anagramma() {
		lettere = new ArrayList<>();
	}
	
	//clone constructor
	public Anagramma(Anagramma other) {
		this.lettere = new ArrayList<>(other.lettere);
	}
	
	public Anagramma(String string) {
		lettere = new ArrayList<>();
		for(int i=0; i<string.length(); i++) 
			this.lettere.add(string.charAt(i));
	}

	public void add(char c) {
		lettere.add(c);
	}

	@Override
	public String toString() {
		String res = "";
		for(char c: lettere)
			res += c;
		return res;
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
