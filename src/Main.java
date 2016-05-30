package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException, InvalidRomanException {
		System.out.println("Welcome to Merchant's Guide to Galaxy!!");
		System.out.println("Please create an input converter file within the current folder and then press enter to continue:");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		bufferRead.readLine();
		bufferRead.close();
		
		FileReader fileReader = new FileReader(getInputDataFile());
		
		MerchantsGuide merchantsGuide;
		try {
			merchantsGuide = new MerchantsGuide(fileReader, System.out);
			merchantsGuide.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static File getInputDataFile() {
		return new File(new File("").getAbsolutePath()
				+ "/inputData.txt");
	}

}
