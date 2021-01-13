package cimpa.td.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cimpa.td.java.Orange;
import cimpa.td.java.Panier;
import cimpa.td.java.UnsupportedOperationException;

public class PanierTest {
	private Orange o1;
	private Orange o2;
	private Orange o3;
	private Orange o4;
	private Panier p1;
	private Panier p2;
	private Panier p3;
	private Panier p4;

	@Before
	public void init() throws UnsupportedOperationException {
		o1 = new Orange(0.8, "France");
		o2 = new Orange(0.8, "Espagne");
		o3 = new Orange(0.9, "France");
		o4 = new Orange(0.8, "France");
		p1 = new Panier(5);
		p2 = new Panier(6);
		p3 = new Panier(7);
		p4 = null;
		p1.ajoute(o1);
		p1.ajoute(o2);
		p1.ajoute(o3);
		p1.ajoute(o4);
		p2.ajoute(o2);
		p2.ajoute(o1);
		p2.ajoute(o4);
		p2.ajoute(o3);
		p3.ajoute(o1);
		p3.ajoute(o2);
		p3.ajoute(o3);
		
		
	}
	
	@Test
	public void testEqualityWithNullPanier() {
		assertFalse(p1.equals(p4));
	}
	
	@Test
	public void testEqualityWithDifferentSorting() {
		assertTrue(p1.equals(p2));
	}
	
	@Test
	public void testEqualityWithDifferentPanier() {
		assertFalse(p1.equals(p3));
	}
	
}
