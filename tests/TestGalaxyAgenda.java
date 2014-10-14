package tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import src.ConversionTable;
import src.Equation;
import src.EquationStringParser;
import src.Galactic;
import src.GalacticCurrency;
import src.GalaxyAgenda;
import src.InvalidConversionKey;

public class TestGalaxyAgenda {
	ConversionTable conversionTable;

	@Before
	public void setup() {
		conversionTable = new ConversionTable();
	}

	/*
	 * @Test public void testAskGalactiNumberValue() { GalaxyAgenda agenda = new
	 * GalaxyAgenda(); agenda.addNote("glob is I"); agenda.addNote("pish is X");
	 * agenda.addNote("tegj is L");
	 * agenda.addNote("glob glob Silver is 34 Credits");
	 * assertEquals("pish tegj glob glob is 42",
	 * agenda.ask("how much is pish tegj glob glob ?")); //
	 * assertEquals("glob prok Silver is 68", //
	 * agenda.ask("how many Credits is glob prok Silver ?")); }
	 */
	@Test
	public void testGalacticValue() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		conversionTable.put("prok", "V");
		conversionTable.put("pish", "X");

		assertEquals(4, g("glob prok").value(conversionTable));
		assertEquals(14, g("pish glob prok").value(conversionTable));
	}

	@Test
	public void testGalacticToRoman() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		conversionTable.put("prok", "V");
		conversionTable.put("pish", "X");

		assertEquals("I V", g("glob prok").toRoman(conversionTable));
		assertEquals("X I V", g("pish glob prok").toRoman(conversionTable));
	}

	@Test
	public void testBuildEquation() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		EquationStringParser equationStringParser = new EquationStringParser();
		Equation equation = equationStringParser.parse("glob glob Silver is 34 Credits",
				conversionTable);
		assertEquals(g("glob glob"), equation.getCoeficient());
		assertEquals("Silver", equation.getVariable());
		assertEquals(d("34"), equation.getConstantDecimal());
	}

	private BigDecimal d(String decimalString) {
		return new BigDecimal(decimalString);
	}

	@Test
	public void testSolveEquation() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		Equation equation = new Equation(g("glob glob"), "Silver", 34);
		assertEquals(d("17"), equation.solve(conversionTable));
	}

	@Test
	public void testAddGalacticNote() throws InvalidConversionKey {
		GalaxyAgenda agenda = new GalaxyAgenda(conversionTable);
		agenda.addNote("glob is I");
		assertEquals("I", conversionTable.get("glob"));
	}

	@Test
	public void testAddEquationNote() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		conversionTable.put("prok", "V");
		conversionTable.put("pish", "X");
		GalaxyAgenda agenda = new GalaxyAgenda(conversionTable);
		agenda.addNote("glob prok Silver is 36 Credits");
		agenda.addNote("pish pish Iron is 3910 Credits");
		assertEquals("9", conversionTable.get("Silver"));
		assertEquals("195.5", conversionTable.get("Iron"));
	}

	@Test
	public void testAskGalactic() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		conversionTable.put("pish", "X");
		conversionTable.put("tegj", "L");
		GalaxyAgenda agenda = new GalaxyAgenda(conversionTable);

		assertEquals("pish tegj glob is 41", agenda.ask("how much is pish tegj glob ?"));
	}

	@Test
	public void testAskEquation() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		conversionTable.put("prok", "V");
		conversionTable.put("Silver", "17");
		conversionTable.put("Iron", "195.5");
		GalaxyAgenda agenda = new GalaxyAgenda(conversionTable);

		assertEquals("glob prok Silver is 68", agenda.ask("how many Credits is glob prok Silver ?"));
		assertEquals("glob prok Iron is 782", agenda.ask("how many Credits is glob prok Iron ?"));
	}

	@Test
	public void testParseGalacticCurrency() {
		EquationStringParser parser = new EquationStringParser();
		GalacticCurrency galaticCurrency = parser.parseGalacticCurrency("glob prok Silver");
		assertEquals(new GalacticCurrency("glob prok", "Silver"), galaticCurrency);
	}

	@Test
	public void testInvalidQuestion() throws InvalidConversionKey {
		GalaxyAgenda galaxyAgenda = new GalaxyAgenda(null);
		assertEquals(
				"I have no idea what you are talking about",
				galaxyAgenda.ask("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
	}

	private Galactic g(String string) {
		return Galactic.build(string);
	}
}
