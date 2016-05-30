package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class InputDataReader {
	Reader fileReader;

	public InputDataReader(Reader reader) {
		this.fileReader = reader;
	}

	public ArrayList<String> getInputData() throws IOException {
		BufferedReader br = new BufferedReader(fileReader);
		try {
			ArrayList<String> stringList = new ArrayList<String>();
			String line = br.readLine();

			while (line != null) {
				stringList.add(line);
				line = br.readLine();
			}
			return stringList;
		} finally {
			br.close();
		}
	}

}
