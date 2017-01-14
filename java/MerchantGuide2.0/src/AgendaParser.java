package src;

import src.instructions.GalacticRomanNote;
import src.instructions.Instruction;
import src.instructions.InvalidQuestion;

public class AgendaParser {

	public static Instruction parseInstruction(String instruction) {
		if (!instruction.contains("?")) {
			//gob is I
			if (!instruction.contains("Credits")) {
				return GalacticRomanNote.parse(instruction);
			}
			// glob prok Silver is 34 Credits
			else {
				EquationStringParser parser = new EquationStringParser();
				return parser.parse(instruction);
			}
		}
		else if (instruction.split(" is ").length < 2) {
			return new InvalidQuestion();
		}
		else{
			QuestionParser questionParser = new QuestionParser();
			return questionParser.parse(instruction);
		}

	}

	

}
