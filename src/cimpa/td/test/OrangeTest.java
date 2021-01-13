package cimpa.td.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cimpa.td.java.Orange;
import cimpa.td.java.UnsupportedOperationException;

public class OrangeTest {
	private Orange o1;
	private Orange o2;
	private Orange o3;
	private Orange o4;
	private Orange o5;

	@Before
	public void init() throws UnsupportedOperationException {
		o1 = new Orange(0.8, "France");
		o2 = new Orange(0.8, "Espagne");
		o3 = new Orange(0.9, "France");
		o5 = new Orange(0.8, "France");
		o4 = null;
	}
	
	@Test
	public void testEqualityWithNullOrange() {
		assertFalse(o1.equals(o4));
	}
	
	@Test
	public void testEqualityOrangeWithDifferentPrices() {
		assertFalse(o1.equals(o3));
	}
	
	@Test
	public void testEqualityOrangeWithDifferentOrigins() {
		assertFalse(o1.equals(o2));
	}
	
	@Test
	public void testEquality() {
		assertTrue(o1.equals(o5));
	}
}
