package tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.GalaxyAgendaApp;
import src.InvalidArgsException;

public class TestFromFileGalaxyApp{
	private ByteArrayOutputStream  outputStream;
	private PrintStream outPrintStream;
	private PrintStream defaultPrintStream;

	@Before
	public void setup() {
		outputStream = new ByteArrayOutputStream();
		outPrintStream = new PrintStream(outputStream);
		defaultPrintStream = System.out;
		System.setOut(outPrintStream);
	}

	@After
	public void tearDown() {
		System.setOut(defaultPrintStream);
	}

	@Test
	public void testGalaxyAppMainFromFileInput() throws IOException,
			InvalidArgsException {
		GalaxyAgendaApp.main(new String[] { "file", "./galaxyTests.txt" });
		assertEquals("pish tegj glob glob is 42", getOutputStreamLine(0));
		assertEquals("glob prok Silver is 68 Credits", getOutputStreamLine(1));
		assertEquals("glob prok Gold is 57800 Credits", getOutputStreamLine(2));
		assertEquals("glob prok Iron is 782 Credits", getOutputStreamLine(3));
		assertEquals("I have no idea what you are talking about",
				getOutputStreamLine(4));
	}
	private String getOutputStreamLine(int lineNumber) {
		return outputStream.toString().split("\n")[lineNumber];
	}


	
}
