package src;

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
		//how much is glob prok ?
		else if (!instruction.contains("Credits")) {
		 return Galactic.parse(instruction);
		}
		//how many Credits is <<galactic expression>> ?
		else{
			QuestionParser questionParser = new QuestionParser();
			return (GalacticCurrency)questionParser.parse(instruction);
		}

	}

	

}
