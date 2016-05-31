package src.utils;

import java.util.Arrays;
import java.util.List;

public class Line {
	
	
	private String stringLine;
	private List<String> words;

	public Line(String stringLine) {
		this.stringLine = stringLine;
		words = Arrays.asList(stringLine.split(" "));
	}

	public String wordsInBetween(String firstRegExp, String lastRegExp) {
		return stringLine.split(lastRegExp)[0].split(firstRegExp)[1].trim();
	}

	public String lastWord() {
		return words.get(words.size()-1);
	}

	public String previousWord(String fromWord) {
		return  words.get(words.indexOf(fromWord) - 1);
	}

	public String previousText(String metalName) {
		return stringLine.split(metalName)[0];
	}

	public String textAfter(String word) {
		return stringLine.split(word)[1];
	}

	public List<String> getLines() {
		return Arrays.asList(stringLine.split("\n"));
	}

}
