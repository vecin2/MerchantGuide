package tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.Test;

import src.InvalidRomanException;
import src.MerchantsGuide;

public class TestMerchantsGuide {

	@Test
	public void testHowMuchIsGlob() throws IOException, InvalidRomanException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		StringReader stringReader = new StringReader("glob is I\n" + "how much is glob ?");
		MerchantsGuide merchantsGuide = new MerchantsGuide(stringReader, printStream);
		merchantsGuide.run();
		assertEquals("glob is 1\n", outputStream.toString());
	}

	@Test
	public void testHowMuchIsPishTegjGlobGlob() throws IOException, InvalidRomanException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		StringReader stringReader = new StringReader(
				"glob is I\n" + "prok is V\n" + "pish is X\n" + "tegj is L\n" + "how much is pish tegj glob glob ?");
		MerchantsGuide merchantsGuide = new MerchantsGuide(stringReader, printStream);
		merchantsGuide.run();
		assertEquals("pish tegj glob glob is 42\n", outputStream.toString());
	}

	@Test
	public void testHowManyCreditsIsGlobProkSilver() throws IOException, InvalidRomanException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		StringReader stringReader = new StringReader("glob is I\n" + "prok is V\n" + "glob glob Silver is 34 Credits\n"
				+ "how many Credits is glob prok Silver ?");
		MerchantsGuide merchantsGuide = new MerchantsGuide(stringReader, printStream);
		merchantsGuide.run();
		assertEquals("glob prok Silver is 68 Credits\n", outputStream.toString());
	}

	@Test
	public void testHowMuchWoodCouldAWoodchuckChuckIfAWoodChuckCouldChuckWood()
			throws IOException, InvalidRomanException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		StringReader stringReader = new StringReader(
				"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
		MerchantsGuide merchantsGuide = new MerchantsGuide(stringReader, printStream);
		merchantsGuide.run();
		assertEquals("I have no idea what you are talking about\n", outputStream.toString());
	}

}
