package src;

public class InvalidQuestion implements Instruction {

	@Override
	public String run(ConversionTable conversionTable) {
		return "I have no idea what you are talking about";
	}

}
