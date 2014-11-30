package src;

public class GalacticRomanNote implements Instruction {
	private final String galactic;
	private final String roman;

	public GalacticRomanNote(String galactic, String roman){
		this.galactic = galactic;
		this.roman = roman;
	}
	public String run(ConversionTable conversionTable) {
		return conversionTable.put(galactic, roman);
	}
	public static Instruction parse(String instruction) {
		String[] arrayNote = instruction.split(" is ");
		return galacticRoman(arrayNote[0], arrayNote[1]);
	}
	private static GalacticRomanNote galacticRoman(String galactic, String roman) {
		return new GalacticRomanNote(galactic, roman);
	}
	

}
