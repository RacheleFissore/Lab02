package it.polito.tdp.model;

import java.util.*;

public class Dizionario {
	List<Parole> listaParole;

	public Dizionario() {
		super();
		this.listaParole = new LinkedList<Parole>();
	}
	
	public boolean addParola(Parole p) {
		this.listaParole.add(p);
		return true;
	}
	
	public LinkedList<String> traduci(String s) {
		//List<String> res = new LinkedList<String>();
		for(Parole p : this.listaParole) {
			if(p.getParolaAliena().equals(s)) {
				return p.getTraduzione();
			}
		}
		
		return null;
	}
}
