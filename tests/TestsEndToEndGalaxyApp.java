package tests;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.GalaxyAgenda;
import src.GalaxyAgendaApp;
import src.InstructionReader;
import src.InvalidArgsException;

public class TestsEndToEndGalaxyApp {
	ByteArrayOutputStream outputStream;
	PrintStream outPrintStream;
	private GalaxyAgendaApp galaxyAgendaApp;
	private PrintStream defaultPrintStream;
	private InputStream defaultInputStream;

	@Before
	public void setup() {
		outputStream = new ByteArrayOutputStream();
		outPrintStream = new PrintStream(outputStream);
		defaultPrintStream = System.out;
		defaultInputStream = System.in;
		System.setOut(outPrintStream);

	}

	@After
	public void tearDown() {
		System.setOut(defaultPrintStream);
		System.setIn(defaultInputStream);
	}

	@Test
	public void testGalaxyAppFromFile() throws IOException {
		galaxyAgendaApp = new GalaxyAgendaApp(new GalaxyAgenda(), new InstructionReader("file",
				"galaxyTests.txt"));
		galaxyAgendaApp.run();
		assertEquals("pish tegj glob glob is 42", getOutputStreamLine(0));
		assertEquals("glob prok Silver is 68 Credits", getOutputStreamLine(1));
		assertEquals("glob prok Gold is 57800 Credits", getOutputStreamLine(2));
		assertEquals("glob prok Iron is 782 Credits", getOutputStreamLine(3));
		assertEquals("I have no idea what you are talking about", getOutputStreamLine(4));
	}

	@Test
	public void testGalaxyAppMainFromFileInput() throws IOException, InvalidArgsException {
		GalaxyAgendaApp.main(new String[] { "file", "./galaxyTests.txt" });
		assertEquals("pish tegj glob glob is 42", getOutputStreamLine(0));
		assertEquals("glob prok Silver is 68 Credits", getOutputStreamLine(1));
		assertEquals("glob prok Gold is 57800 Credits", getOutputStreamLine(2));
		assertEquals("glob prok Iron is 782 Credits", getOutputStreamLine(3));
		assertEquals("I have no idea what you are talking about", getOutputStreamLine(4));
	}

	@Test
	public void testGalaxyAppMainFromStandardInput() throws IOException, InvalidArgsException {
		String input = "glob is I\n how much is glob ?\n how many Credits is glboabosd ?";
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(byteArrayInputStream);
		GalaxyAgendaApp.main(new String[] { "standard" });
		assertEquals("glob is 1", getOutputStreamLine(0));
		assertEquals(true, getOutputStreamLine(1).contains("I have no idea what you are talking about"));
	}

	private String getOutputStreamLine(int lineNumber) {
		return outputStream.toString().split("\n")[lineNumber];
	}
}
