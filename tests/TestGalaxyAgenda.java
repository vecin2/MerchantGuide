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
import src.expressions.Expression;

public class TestGalaxyAgenda {
	ConversionTable conversionTable;

	@Before
	public void setup() {
		conversionTable = new ConversionTable();
	}

	@Test
	public void testAskGalactiNumberValue() throws InvalidConversionKey {
		GalaxyAgenda agenda = new GalaxyAgenda();
		agenda.run("glob is I");
		agenda.run("prok is V");
		agenda.run("pish is X");
		agenda.run("tegj is L");
		agenda.run("glob glob Silver is 34 Credits");
		agenda.run("glob prok Gold is 57800 Credits");
		assertEquals("pish tegj glob glob is 42", agenda.run("how much is pish tegj glob glob ?"));
		assertEquals("glob prok Gold is 57800 Credits",
				agenda.run("how many Credits is glob prok Gold ?"));
		assertEquals("glob prok Silver is 68 Credits",
				agenda.run("how many Credits is glob prok Silver ?"));
		assertEquals(
				"I have no idea what you are talking about",
				agenda.run("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
	}

//From here tests are finer grain and could be deleted if they fail
	@Test
	public void testGalacticToRoman() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		conversionTable.put("prok", "V");
		conversionTable.put("pish", "X");

		assertEquals("I V", g("glob prok").toRoman(conversionTable));
		assertEquals("X I V", g("pish glob prok").toRoman(conversionTable));
	}

	@Test
	public void testGalacticValue() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		conversionTable.put("prok", "V");
		conversionTable.put("pish", "X");

		assertEquals(4, g("glob prok").value(conversionTable));
		assertEquals(14, g("pish glob prok").value(conversionTable));
	}

	@Test
	public void testAddGalacticNote() throws InvalidConversionKey {
		GalaxyAgenda agenda = new GalaxyAgenda(conversionTable);
		agenda.run("glob is I");
		assertEquals("I", conversionTable.get("glob"));
	}

	@Test
	public void testAddEquationNote() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		conversionTable.put("prok", "V");
		conversionTable.put("pish", "X");
		GalaxyAgenda agenda = new GalaxyAgenda(conversionTable);
		agenda.run("glob prok Silver is 36 Credits");
		agenda.run("pish pish Iron is 3910 Credits");
		assertEquals("9", conversionTable.get("Silver"));
		assertEquals("195.5", conversionTable.get("Iron"));
	}
		
	@Test
	public void testBuildEquation() throws InvalidConversionKey {
		EquationStringParser equationStringParser = new EquationStringParser();
		Equation equation = (Equation)equationStringParser.parse("glob glob Silver is 34 Credits");
		assertEquals(g("glob glob"), equation.getCoeficient());
		assertEquals("Silver", equation.getVariable());
		assertEquals(d("34"), equation.getConstantDecimal());
	}

	@Test
	public void testParseGalacticCurrency() {
		Expression galaticCurrency = GalacticCurrency.parse("how many Credits is glob prok Silver ?");
		assertEquals(new GalacticCurrency("glob prok", "Silver"), galaticCurrency);
	}

	
	@Test
	public void testSolveEquation() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		Equation equation = new Equation(g("glob glob"), "Silver", 34);
		assertEquals(d("17"), equation.solve(conversionTable));
	}
	
	@Test
	public void testAskGalactic() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		conversionTable.put("pish", "X");
		conversionTable.put("tegj", "L");
		GalaxyAgenda agenda = new GalaxyAgenda(conversionTable);

		assertEquals("pish tegj glob is 41", agenda.run("how much is pish tegj glob ?"));
	}

	@Test
	public void testAskEquation() throws InvalidConversionKey {
		conversionTable.put("glob", "I");
		conversionTable.put("prok", "V");
		conversionTable.put("Silver", "17");
		conversionTable.put("Iron", "195.5");
		GalaxyAgenda agenda = new GalaxyAgenda(conversionTable);

		assertEquals("glob prok Silver is 68 Credits",
				agenda.run("how many Credits is glob prok Silver ?"));
		assertEquals("glob prok Iron is 782 Credits",
				agenda.run("how many Credits is glob prok Iron ?"));
	}
	
	@Test
	public void testInvalidQuestion() throws InvalidConversionKey {
		GalaxyAgenda galaxyAgenda = new GalaxyAgenda(null);
		assertEquals(
				"I have no idea what you are talking about",
				galaxyAgenda
						.run("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
	}
	

	private BigDecimal d(String decimalString) {
		return new BigDecimal(decimalString);
	}
	private Galactic g(String string) {
		return Galactic.build(string);
	}
	
}
