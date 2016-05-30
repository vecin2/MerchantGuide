package src;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import src.intergalacticexpression.HowManyCreditsMetalExpression;
import src.intergalacticexpression.HowMuchIntergalacticNumberExpresion;
import src.intergalacticexpression.IntergalacticRomanNumberAssigmentExpression;
import src.intergalacticexpression.InvalidIntergalacticExpression;
import src.intergalacticexpression.MetalCreditsAssignmentExpression;

public class MerchantsGuide {

	private Reader reader;
	private PrintStream out;
	private StringBuilder sb = new StringBuilder();
	public IntergalacticUnitConverter converter = new IntergalacticUnitConverter(new HashMap<String, String>(), new HashMap<String, String>());

	public MerchantsGuide(Reader reader, PrintStream out) {
		this.out = out;
		this.reader = reader;
	}

	public void run() throws IOException, InvalidRomanException {
		InputDataReader inputDataReader = new InputDataReader(reader);
		ArrayList<String> instructions = inputDataReader.getInputData();
		for (String instruction : instructions) {
			processInstruction(instruction);
		}
		out.println(sb.toString());

	}

	private void processInstruction(String instruction) throws InvalidRomanException {
		if (instruction.contains("how much is")) {
			HowMuchIntergalacticNumberExpresion howMuchInterglacticNumberExpression = new HowMuchIntergalacticNumberExpresion(
					instruction);
			howMuchInterglacticNumberExpression.solve(converter, sb);
		} else if (instruction.contains("how many Credits is")) {
			HowManyCreditsMetalExpression howManyCreditMetalExpresstion = new HowManyCreditsMetalExpression(
					instruction);
			howManyCreditMetalExpresstion.solve(converter, sb);

		} else if (instruction.contains("Credits")) {
			MetalCreditsAssignmentExpression metalCreditAssigmentExpression = new MetalCreditsAssignmentExpression(
					instruction);
			metalCreditAssigmentExpression.solve(converter);

		} else if (instruction.contains("is")) {
			IntergalacticRomanNumberAssigmentExpression intergalacticRomanNumberAssigment = new IntergalacticRomanNumberAssigmentExpression(
					instruction);
			intergalacticRomanNumberAssigment.solve(converter);

		} else {
			InvalidIntergalacticExpression invalidIntergalacticExpression = new InvalidIntergalacticExpression(
					instruction);
			invalidIntergalacticExpression.solve(sb);

		}
	}



}
