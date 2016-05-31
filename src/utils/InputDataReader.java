package src.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class InputDataReader {
	Reader reader;
	private ArrayList<String> stringList;

	public InputDataReader(Reader reader) throws IOException {
		stringList = new ArrayList<String>();
		BufferedReader br = new BufferedReader(reader);
		String line = br.readLine();
		while (line != null) {
			stringList.add(line);
			line = br.readLine();
		}
	}

	public ArrayList<String> getLines() {
		return stringList;
	}

	public String getAllContent() throws IOException {
		StringBuilder sb = new StringBuilder();
		for (String line : getLines()) {
			sb.append(line + "\n");
		}
		return sb.toString();
	}

}
