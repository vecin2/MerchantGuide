package src;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringBufferInputStream;

public class GalaxyAgendaApp {
	GalaxyAgenda galaxyAgenda;
	PrintStream printStream;
	String fileInputPath;

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
		FileReader fileReader = new FileReader(fileInputPath);
		BufferedReader br = new BufferedReader(fileReader);
		String instruction = br.readLine();
		while (instruction != null) {
			run(instruction);
			instruction = br.readLine();
		}
		
	}

}
