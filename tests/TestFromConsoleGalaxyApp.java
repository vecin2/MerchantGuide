package tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.AppRunner;
import src.GalaxyAgendaApp;
import src.InvalidArgsException;

public class TestFromConsoleGalaxyApp implements Runnable{
	AppRunner appRunner; 

	@Before
	public void setup() throws IOException {
		appRunner= new AppRunner(this);
	}

	@After
	public void tearDown() {
		appRunner.tearDown();
	}

	@Test
	public void testGalaxyAppFromStandardInput() throws IOException {
		appRunner.start();
		appRunner.enterInstruction("glob is I");
		appRunner.enterInstruction("prok is V");
		appRunner.enterInstruction("pish is X");
		appRunner.enterInstruction("tegj is L");
		appRunner.enterInstruction("how much is pish tegj glob glob ?");
		appRunner.hasPrinted("pish tegj glob glob is 42");	
		
		appRunner.enterInstruction("glob glob Silver is 34 Credits");
		appRunner.enterInstruction("how many Credits is glob prok Silver ?");
		appRunner.hasPrinted("glob prok Silver is 68 Credits");
			
		appRunner.enterInstruction("pish pish Iron is 3910 Credits");
		appRunner.enterInstruction("how many Credits is glob prok Iron ?");
		appRunner.hasPrinted("glob prok Iron is 782 Credits");
				
		appRunner.enterInstruction("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
		appRunner.hasPrinted("I have no idea what you are talking about");
		appRunner.enterInstruction("");
	}

	@Override
	public void run() {
		try {
			GalaxyAgendaApp.main(new String[] {"standard" });
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidArgsException e) {
			e.printStackTrace();
		} 
	}
}
