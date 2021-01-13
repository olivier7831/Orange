package cimpa.td.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Panier {
	public static final String NEGATIVECAPACITY = "Negative capacity not allowed";
	public static final String UNSUFFIENTCAPACITY = "Unsuffient capacity";
	public static final String EMPTYCART = "Empty cart";

	private ArrayList<Orange> oranges;
	private int capacity;

	public Panier(int capacity) throws UnsupportedOperationException {
		super();
		oranges = new ArrayList<>();
		if (capacity < 0)
			throw new UnsupportedOperationException(NEGATIVECAPACITY);
		this.capacity = capacity;
	}
	
	protected ArrayList<Orange> getOranges() {
		return oranges;
	}
	
	public int size() {
		return oranges.size();
	}

	public boolean estPlein() {
		return (oranges.size() >= capacity);
	}

	public boolean estVide() {
		return (oranges.isEmpty());
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		for (Orange orange : oranges) {
			result.append(orange.toString());
		}

		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + ((oranges == null) ? 0 : oranges.hashCode());
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
		if (((Panier)obj).size() != this.size()) {
			return false;
		} else {
			ArrayList<Orange> monPanier = (ArrayList<Orange>) oranges.clone();
			ArrayList<Orange> objSorted = (ArrayList<Orange>) ((Panier)obj).getOranges().clone();
			Collections.sort(monPanier, new PanierComparator());
			Collections.sort(objSorted, new PanierComparator());
			return monPanier.equals(objSorted);
		}
	}

	public void ajoute(Orange o) throws UnsupportedOperationException {
		if (estPlein())
			throw new UnsupportedOperationException(UNSUFFIENTCAPACITY);
		else
			oranges.add(o);
	}

	public void retire() throws UnsupportedOperationException {
		if (estVide())
			throw new UnsupportedOperationException(EMPTYCART);
		else
			oranges.remove(oranges.size() - 1);
	}

	public double getPrix() {
		double price = 0;

		for (Orange orange : oranges) {
			price += orange.getPrix();
		}

		return price;
	}

	public void boycotteOrigine(String origine) {
		Iterator<Orange> iterator = oranges.iterator();
		Orange o = null;

		while (iterator != null && iterator.hasNext()) {
			o = iterator.next();
			if (o.getOrigine().equals(origine))
				iterator.remove();
		}
	}
}
