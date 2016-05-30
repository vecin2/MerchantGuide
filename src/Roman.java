package src;

import java.util.HashMap;

public class Roman {

	private String stringRoman;

	private HashMap<String, Integer> romanToArabicConversionTable;

	public Roman(String string) throws InvalidRomanException {
		initConversionTable();
		this.stringRoman = string;
		checkValidRoman(string);
	}

	private  void checkValidRoman(String string) throws InvalidRomanException {
		char[] romanSymbolArray = getRomanSymbolArray();
		for(char romanSymbol: romanSymbolArray){
			if(romanSymbolAtIndex(romanSymbol)==null)
				throw new InvalidRomanException("'"+string+"' is not a valid roman number");
		}

	}

	private char[] getRomanSymbolArray() {
		return stringRoman.replaceAll("\\s+","").toCharArray();
	}

	private Integer romanSymbolAtIndex(char romanSymbol) {
		return romanToArabicConversionTable.get(romanSymbol+"");
	}

	private void initConversionTable() {
		romanToArabicConversionTable = new HashMap<String, Integer>();
		romanToArabicConversionTable.put("I", 1);
		romanToArabicConversionTable.put("V", 5);
		romanToArabicConversionTable.put("X", 10);
		romanToArabicConversionTable.put("L", 50);
	}

	public int value() {
		int result = 0;
		for (int i = 0; i < numberOfSymbols(); i++) {
			if (arabicValueAtIndex(i) < arabicValueAtIndex(i + 1))
				result += -arabicValueAtIndex(i);
			else
				result += arabicValueAtIndex(i);
		}
		return result;
	}

	private int numberOfSymbols() {
		return getRomanSymbolArray().length;
	}

	private Integer arabicValueAtIndex(int index) {
		if (index < numberOfSymbols())
			return  romanSymbolAtIndex(getRomanSymbolArray()[index]);
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stringRoman == null) ? 0 : stringRoman.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		Roman other = (Roman) obj;
		return stringRoman.equals(other.stringRoman);
	}

	public String romanValue() {
		return stringRoman;
	}
}
