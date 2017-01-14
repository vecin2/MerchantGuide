package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import src.InvalidRomanException;
import src.Roman;

public class TestRoman {

	@Test
	public void testRoman() throws InvalidRomanException {
		assertRomanValue(1,"I");
		assertRomanValue(2,"II");
		assertRomanValue(3,"III");
		assertRomanValue(4,"IV");
		assertRomanValue(5,"V");
		assertRomanValue(6,"VI");
		assertRomanValue(7,"VII");
		assertRomanValue(8,"VIII");
		assertRomanValue(9,"IX");
		assertRomanValue(10,"X");
		assertRomanValue(29,"XXIX");
		assertRomanValue(48,"XLVIII");
		assertRomanValue(50,"L");
	}
	@Test(expected=InvalidRomanException.class)
	public void testInvalidRoman() throws InvalidRomanException{
		new Roman("glob prok");
		
	}


	private void assertRomanValue(int arabic, String roman) throws InvalidRomanException {
		assertEquals(arabic, new Roman(roman).value());
	}


	

}
