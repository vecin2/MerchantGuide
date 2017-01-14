package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import src.utils.Line;

public class TestLine {

	@Test
	public void testRemoveLastWord() {
		Line expected = new Line("glob glob");
		Line line = new Line("glob glob Silver");
		Line result = line.removeLastWord();
		assertEquals(expected, result);
	}

}
