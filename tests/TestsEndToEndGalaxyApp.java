package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.GalaxyAgenda;
import src.GalaxyAgendaApp;

public class TestsEndToEndGalaxyApp {
	ByteArrayOutputStream outputStream;
	PrintStream outPrintStream;
	private GalaxyAgendaApp galaxyAgendaApp;
	private PrintStream defaultPrintStream;
	@Before
	public void setup() {
		outputStream = new ByteArrayOutputStream(); 
		outPrintStream = new PrintStream(outputStream);
		defaultPrintStream =  System.out;
		System.setOut(outPrintStream);

	}

	@After
	public void tearDown() {
		System.setOut(defaultPrintStream);
	}

	@Test
	public void test() throws IOException {
		galaxyAgendaApp = new GalaxyAgendaApp(new GalaxyAgenda(), "galaxyTests.txt");
		galaxyAgendaApp.run();
		assertEquals("glob is 1", outputStream.toString().split("\n")[0]);
		
	}
}
