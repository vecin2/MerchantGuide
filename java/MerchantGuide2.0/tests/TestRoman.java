package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import src.Roman;

public class TestRoman {

	@Test
	public void testRoman() {
		assertEquals(1, r("I").value());
		assertEquals(11, r("X I").value());
		assertEquals(9, r("I X").value());
		assertEquals(4, r("X X I X").numberOfDigits());
		assertEquals(29, r("X X I X").value());
		assertEquals(47, r("X L V I I").value());
	}


	public static Roman r(String string) {
		return Roman.build(string);
	}

}
