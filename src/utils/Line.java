package src.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {

	private String stringLine;

	public Line(String stringLine) {
		this.stringLine = stringLine;
	}

	public Line(ArrayList<String> words) {
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.append(word + " ");
		}
		this.stringLine = sb.toString().trim();
	}

	private List<String> words() {
		return Arrays.asList(stringLine.split(" "));
	}

	public Line wordsInBetween(String firstRegExp, String lastRegExp) {
		return new Line(stringLine.split(lastRegExp)[0].split(firstRegExp)[1].trim());
	}

	public String lastWord() {
		return words().get(words().size() - 1);
	}

	public String previousWord(String fromWord) {
		return words().get(words().indexOf(fromWord) - 1);
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

	public Line removeLastWord() {
		ArrayList<String> copyWords = new ArrayList<String>();
		copyWords.addAll(words());
		copyWords.remove(lastWord());
		return new Line(copyWords);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stringLine == null) ? 0 : stringLine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (stringLine == null) {
			if (other.stringLine != null)
				return false;
		} else if (!stringLine.equals(other.stringLine))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return stringLine;
	}
	
}
