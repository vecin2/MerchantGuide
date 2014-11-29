package src;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class GalaxyAgendaApp {
	GalaxyAgenda galaxyAgenda;
	PrintStream printStream;
	String fileInputPath;
	private InstructionReader instructionReader;

	public GalaxyAgendaApp(GalaxyAgenda galaxyAgenda, String fileInputPath) {
		this.galaxyAgenda = galaxyAgenda;
		this.fileInputPath = fileInputPath;
	}

	public GalaxyAgendaApp(GalaxyAgenda galaxyAgenda, PrintStream printStream) {
		this.galaxyAgenda = galaxyAgenda;
		this.printStream = printStream;
	}

	public GalaxyAgendaApp(GalaxyAgenda galaxyAgenda) {
		this.galaxyAgenda = galaxyAgenda;
	}

	public GalaxyAgendaApp(GalaxyAgenda galaxyAgenda,
			InstructionReader instructionReader) {
		this.galaxyAgenda = galaxyAgenda;
		this.instructionReader = instructionReader;
	}

	public void run(String instruction) {
		String toPrint = galaxyAgenda.run(instruction);
		if (toPrint != null) {
			printOutput(galaxyAgenda.run(instruction));
		}
	}

	private void printOutput(String toPrint) {
		if (printStream != null)
			printStream.println(toPrint);
		else
			System.out.println(toPrint);
	}

	public void run() throws IOException {
		runInstructions();

	}

	public static void main(String[] args) throws IOException,
			InvalidArgsException {
		InstructionReader instructionReader = InstructionReader
				.buildFromArgs(args);
		GalaxyAgendaApp app = new GalaxyAgendaApp(new GalaxyAgenda(),
				instructionReader);
		if (instructionReader.isFileType()) {
			app.runInstructions();
		} else {
			String instruction = instructionReader.readInstruction();
			while (instruction != null && !instruction.isEmpty()) {
				app.run(instruction);
				instruction = instructionReader.readInstruction();
			}
		}
	}

	private void runInstructions() throws IOException {
		ArrayList<String> instructionList = instructionReader
				.readInstructions();
		for (String instruction : instructionList) {
			run(instruction);
		}
	}

}
