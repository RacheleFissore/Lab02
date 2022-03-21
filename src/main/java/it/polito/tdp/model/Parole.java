package it.polito.tdp.model;

import java.util.*;

public class Parole {
	private String parolaAliena;
	private LinkedList<String> traduzione;
	
	public Parole(String parolaAliena) {
		super();
		this.parolaAliena = parolaAliena;
		this.traduzione = new LinkedList<String>();
	}

	public String getParolaAliena() {
		return parolaAliena;
	}

	public void setParolaAliena(String parolaAliena) {
		this.parolaAliena = parolaAliena;
	}

	public LinkedList<String> getTraduzione() {
		return traduzione;
	}

	public void setTraduzione(String trad) {
		this.traduzione.add(trad);
	}

	@Override
	public String toString() {
		return "Parole [parolaAliena=" + parolaAliena + ", traduzione=" + traduzione + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parolaAliena == null) ? 0 : parolaAliena.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parole other = (Parole) obj;
		if (parolaAliena == null) {
			if (other.parolaAliena != null)
				return false;
		} else if (!parolaAliena.equals(other.parolaAliena))
			return false;
		return true;
	}

	
}
