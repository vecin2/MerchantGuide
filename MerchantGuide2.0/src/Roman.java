package src;

import java.util.HashMap;

public class Roman {

	private String stringRoman;
	private String[] separatedByDigits;
	private HashMap<String, Integer> romanSymbols;

	public Roman(String string) {
		initRomanSymbols();
		this.stringRoman = string;
		this.separatedByDigits = string.split(" ");
	}

	private void initRomanSymbols() {
		romanSymbols = new HashMap<String, Integer>();
		romanSymbols.put("I", 1);
		romanSymbols.put("V", 5);
		romanSymbols.put("X", 10);
		romanSymbols.put("L", 50);
	}

	public int value() {
		int result = 0;
		for (int i = 0; i < numberOfDigits(); i++) {
			if (digit(i) < digit(i + 1))
				result += -digit(i);
			else
				result += digit(i);
		}
		return result;
	}

	public int numberOfDigits() {
		return separatedByDigits.length;
	}

	private Integer digit(int index) {
		if (index < numberOfDigits())
			return romanSymbols.get(separatedByDigits[index]);
		return 0;
	}

	public static Roman build(String string) {
		return new Roman(string);
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
