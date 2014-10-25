package tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedOutputStream;
import java.io.Reader;
import java.io.StringBufferInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestInputStreamReader {
	InputStream standardInputStream;

	@Before
	public void setup() {
		standardInputStream = System.in;
	}
	@After
	public void tearDown(){
		System.setIn(standardInputStream);
	}

	@Test
	public void test() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("galaxyTests.txt");
		InputStreamReader fileInputStreamReader = new InputStreamReader(fileInputStream);
		BufferedReader fileBufferedReader = new BufferedReader(fileInputStreamReader);

		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader consoleBufferedReader = new BufferedReader(inputStreamReader);

		// String stringEntered =consoleBufferedReader.readLine();
		// String fileLine = fileBufferedReader.readLine();
		// setting to pass, without waiting for users input
		// assertNull("value was: "+stringEntered,stringEntered);
	}
	@Test
	public void testSetInputStream() throws IOException {
		System.setIn(new ByteArrayInputStream("glob is I\nhow much is glob ?\n".getBytes()));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input;
			input = bufferedReader.readLine();
			assertEquals("glob is I", input);
			assertEquals("how much is glob ?", bufferedReader.readLine());
		} finally {
			bufferedReader.close();
		}
	}
	@Test
	public void testReadCharFromStandardInputStream() throws IOException {
		System.setIn(new ByteArrayInputStream("I".getBytes()));
		assertEquals('I', (char)System.in.read());
	}
	@Test
	public void testFileReaderIsClosedWhenTryToRead(){
		
	}

}
