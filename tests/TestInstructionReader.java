package tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.InstructionReader;
import src.InvalidArgsException;

public class TestInstructionReader {
	InputStream backupSystemIn;
	private InstructionReader instructionReader;

	@Before
	public void setup() {
		backupSystemIn = System.in;
	}

	@After
	public void tearDown() {
		System.setIn(backupSystemIn);
	}

	@Test
	public void testReadInstructionFromStandardInput() throws InvalidArgsException, FileNotFoundException, IOException {
		ByteArrayInputStream stringInput = new ByteArrayInputStream("glob is I\nhow much is glob ?".getBytes());
		System.setIn(stringInput);
		instructionReader = InstructionReader.buildFromArgs(new String[] {});
		assertEquals("glob is I", instructionReader.readInstruction());
		assertEquals("how much is glob ?", instructionReader.readInstruction());
	}

}
