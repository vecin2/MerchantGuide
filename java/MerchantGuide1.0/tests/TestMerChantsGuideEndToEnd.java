package tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import src.InvalidIntergalacticUnitException;
import src.InvalidRomanException;
import src.MerchantsGuide;

public class TestMerChantsGuideEndToEnd {

	@Test
	public void testEndToEnd() throws IOException, InvalidRomanException, InvalidIntergalacticUnitException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		FileReader fileReader = new FileReader(new File("tests/fullTestInputData.txt"));
		MerchantsGuide merchantsGuide = new MerchantsGuide(fileReader, printStream);
		merchantsGuide.run();
		String output ="pish tegj glob glob is 42\n"+
				"glob prok Silver is 68 Credits\n"+
				"glob prok Gold is 57800 Credits\n"+
				"glob prok Iron is 782 Credits\n"+
				"I have no idea what you are talking about\n";
		assertEquals("The application should print the solution",true, outputStream.toString().contains(output));
		}

}
