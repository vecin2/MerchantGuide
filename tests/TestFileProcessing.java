package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import src.InputDataReader;

public class TestFileProcessing {

	@Test
	public void testReadInputDataFromFile() throws IOException {
		FileReader fileReader = new FileReader(new File("tests/testInputData.txt"));
		InputDataReader inputDataReader = new InputDataReader(fileReader);
		
		ArrayList<String> expectedInputData = new ArrayList<>();
		expectedInputData.add("glob is I");
		expectedInputData.add("prox is V");
		assertEquals(expectedInputData, inputDataReader.getInputData());
	}

}
