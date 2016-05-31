package src;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;

import src.intergalacticexpression.ExpressionSet;
import src.utils.InputDataReader;

public class MerchantsGuide {
	private PrintStream out;
	private StringBuilder sb = new StringBuilder();
	public IntergalacticUnitConverter converter = new IntergalacticUnitConverter();
	private InputDataReader inputDataReader;

	public MerchantsGuide(Reader reader, PrintStream out) throws IOException {
		this.out = out;
		inputDataReader = new InputDataReader(reader);
	}

	public void run() throws IOException, InvalidRomanException, InvalidIntergalacticUnitException {
		out.println("Welcome to Merchant's Guide to Galaxy!!");
		
		printInput();

		printOutput();

	}

	private void printInput() throws IOException {
		out.println("\nReading input data from 'inputData.txt' file within current folder("
				+ new File("").getAbsolutePath() + "):");
		out.print(inputDataReader.getAllContent());
	}

	private void printOutput()
			throws IOException, InvalidRomanException, InvalidIntergalacticUnitException {
		out.println("\nOutput:");
		ExpressionSet expressionSet = new ExpressionSet(inputDataReader.getAllContent());
		expressionSet.solve(converter, sb);
		out.print(sb.toString());
	}


}
