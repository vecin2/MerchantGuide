package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import src.IntergalacticUnitConverter;
import src.InvalidIntergalacticUnitException;
import src.InvalidRomanException;
import src.intergalacticexpression.ExpressionSet;

public class TestMerchantsGuide {
	private StringBuilder sb;
	private ExpressionSet merchantsGuideExpressions;
	private IntergalacticUnitConverter converter;

	@Before
	public void setup() {
		sb = new StringBuilder();
		converter = new IntergalacticUnitConverter();
	}

	@Test
	public void testHowMuchIsGlob() throws IOException, InvalidRomanException, InvalidIntergalacticUnitException   {
		assertOuput("glob is 1\n","glob is I\n" + "how much is glob ?\n");
	}

	@Test
	public void testHowMuchIsPishTegjGlobGlob() throws IOException, InvalidRomanException, InvalidIntergalacticUnitException  {
		assertOuput("pish tegj glob glob is 42\n", "glob is I\n" + 
												   "prok is V\n" + 
												   "pish is X\n" + "tegj is L\n" + 
												   "how much is pish tegj glob glob ?\n");
	}

	@Test
	public void testHowManyCreditsIsGlobProkSilver() throws IOException, InvalidRomanException, InvalidIntergalacticUnitException  {
		assertOuput("glob prok Silver is 68 Credits\n", "glob is I\n" +
	                                                    "prok is V\n" + 
	                                                    "glob glob Silver is 34 Credits\n" + 
	                                                    "how many Credits is glob prok Silver ?");
	}

	@Test
	public void testHowManyCreditsIsGlobProkGold() throws IOException, InvalidRomanException, InvalidIntergalacticUnitException  {
		assertOuput("glob prok Gold is 57800 Credits\n", "glob is I\n" +
													      "prok is V\n" + 
													      "glob prok Gold is 57800 Credits\n" +
													 	"how many Credits is glob prok Gold ?");
	}

	@Test
	public void testHowManyCreditsIsGlobProkIron() throws IOException, InvalidRomanException, InvalidIntergalacticUnitException {
		assertOuput("glob prok Iron is 782 Credits\n", "glob is I\n" +
													   "prok is V\n" +
													   "pish is X\n" +
													   "pish pish Iron is 3910 Credits\n" +
													 	"how many Credits is glob prok Iron ?");
	}
	
	@Test
	public void testHowMuchWoodCouldAWoodchuckChuckIfAWoodChuckCouldChuckWood()
			throws IOException, InvalidRomanException, InvalidIntergalacticUnitException
			 {
		assertOuput("I have no idea what you are talking about\n",
				    "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
	}
	@Test
	public void testAllInputData()
			throws IOException, InvalidRomanException, InvalidIntergalacticUnitException
			 {
		String expressionLines ="glob is I\n" +
							   "prok is V\n" +
							   "pish is X\n" +
							   "tegj is L\n"+
							   "glob glob Silver is 34 Credits\n"+
							   "glob prok Gold is 57800 Credits\n"+
							   "pish pish Iron is 3910 Credits\n" +
							   "how much is pish tegj glob glob ?\n"+
							   "how many Credits is glob prok Silver ?\n"+
							   "how many Credits is glob prok Gold ?\n"+
							   "how many Credits is glob prok Iron ?\n"+
							   "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?\n";
		String expected ="pish tegj glob glob is 42\n"+
				"glob prok Silver is 68 Credits\n"+
				"glob prok Gold is 57800 Credits\n"+
				"glob prok Iron is 782 Credits\n"+
				"I have no idea what you are talking about\n";	
		assertOuput(expected, expressionLines);
	}
	private void assertOuput(String expected, String expressionLines) throws InvalidRomanException, InvalidIntergalacticUnitException {
		merchantsGuideExpressions = new ExpressionSet(expressionLines);
		merchantsGuideExpressions.solve(converter, sb);
		assertEquals(expected, sb.toString());
	}


}
