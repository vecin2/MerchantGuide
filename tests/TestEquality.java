package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEquality {

	@Test
	public void test() {
		assertEquals(new GTObject("test"), new GTObject("test"));
	}

}
