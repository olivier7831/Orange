package cimpa.td.java;

public class Main {

	public static void main(String[] args) throws Exception {
		Panier p = new Panier(4);
		p.ajoute(new Orange(0.8, "Maroc"));
		p.ajoute(new Orange(0.8, "Espagne"));
		p.ajoute(new Orange(0.9, "Floride"));
		System.out.println(p.toString());
		
		p.boycotteOrigine("Maroc");
		System.out.println(p.toString());
		p.retire();
		System.out.println(p.toString());
	}

}
