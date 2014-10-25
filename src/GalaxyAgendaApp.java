package src;

import java.io.BufferedReader;
import java.io.FileReader;
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

	public GalaxyAgendaApp(GalaxyAgenda galaxyAgenda, InstructionReader instructionReader) {
		this.galaxyAgenda = galaxyAgenda;
		this.instructionReader = instructionReader;
	}

	public void run(String instruction) {
		try {
			if (!instruction.contains("?")) {
				galaxyAgenda.addNote(instruction);
			} else {
				System.out.println(galaxyAgenda.ask(instruction));
			}

		} catch (InvalidConversionKey e) {
			System.out.println("I have no idea what you are talking about: " + e.getMessage());
		}
	}

	public void run() throws IOException {
		runInstructions();

	}

	public static void main(String[] args) throws IOException, InvalidArgsException {
		InstructionReader instructionReader = InstructionReader.buildFromArgs(args);
		GalaxyAgendaApp app = new GalaxyAgendaApp(new GalaxyAgenda(), instructionReader);
		app.runInstructions();
	}

	private void runInstructions() throws IOException {
		ArrayList<String> instructionList = instructionReader.readInstructions();
		for (String instruction : instructionList) {
			run(instruction);
		}
	}
}
