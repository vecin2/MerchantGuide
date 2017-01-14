package tests;

import java.io.FileNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import src.InstructionReader;
import src.InvalidArgsException;

public class TestInstructionReaderBuilder {
	private InstructionReader instructionReader;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testInstructionReaderBuildFileTypeFromArgs()
			throws InvalidArgsException, FileNotFoundException {
		instructionReader = InstructionReader.buildFromArgs(new String[] {
				"file", "galaxyTests.txt" });
		assert (instructionReader.isFileType());
	}

	@Test
	public void testInstructionReaderBuildStandardTypeFromArgs()
			throws InvalidArgsException, FileNotFoundException {
		instructionReader = InstructionReader
				.buildFromArgs(new String[] { "standard" });
		assert (instructionReader.isStandardType());
	}
	//this test is redundant, same test in testInstructionReader
	@Test
	public void testCreatesAnStandardTypeWhenNoArgsArePassed()
			throws InvalidArgsException, FileNotFoundException {
		instructionReader = InstructionReader.buildFromArgs(new String[] {});
		assert (instructionReader.isStandardType());
	}

	@Test
	public void testThrowsExceptionIfInputMethodTypeIsNotCorrect()
			throws InvalidArgsException, FileNotFoundException {
		thrown.expect(InvalidArgsException.class);
		thrown.expectMessage("pepe is not a valid input method");
		InstructionReader instructionReader = InstructionReader
				.buildFromArgs(new String[] { "pepe" });
	}
}
