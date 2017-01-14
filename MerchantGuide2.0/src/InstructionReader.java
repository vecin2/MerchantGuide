package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InstructionReader {
	String filePath;
	FileReader fileReader;
	String inputMethod;
	private BufferedReader br;

	public InstructionReader(String inputMethod, String filePath) throws FileNotFoundException {
		this.filePath = filePath;
		if (filePath != null)
			this.fileReader = new FileReader(filePath);
		this.inputMethod = inputMethod;
	}

	public ArrayList<String> readInstructions() throws IOException {
		ArrayList<String> instructions = new ArrayList<String>();
		try {
			String instruction = readInstruction();
			while (instruction != null && !instruction.isEmpty()) {
				instructions.add(instruction);
				instruction = readInstruction();
			}
		} finally {
			if (getBufferReader() != null)
				getBufferReader().close();
		}

		return instructions;
	}

	public boolean isFileType() {
		return "file" == inputMethod;
	}

	public static InstructionReader buildFromArgs(String[] args) throws InvalidArgsException,
			FileNotFoundException {
		if (args.length > 0 && args[0] != "standard" && args[0] != "file")
			throw new InvalidArgsException(args[0] + " is not a valid input method");
		if (args.length > 1)
			return new InstructionReader(args[0], args[1]);
		else {
			return new InstructionReader("standard", null);
		}
	}

	public boolean isStandardType() {
		return "standard" == inputMethod;
	}

	public String readInstruction() throws FileNotFoundException, IOException {
		return getBufferReader().readLine();
	}
	
	private BufferedReader getBufferReader() throws FileNotFoundException {
		if (br == null) {
			br = new BufferedReader(getInputReader());
		}
		return br;
	}

	private InputStreamReader getInputReader() throws FileNotFoundException {
		InputStreamReader inputReader;
		if (inputMethod == "standard") {
			inputReader = new InputStreamReader(System.in);
		} else {
			inputReader = fileReader;
		}
		return inputReader;
	}
}
