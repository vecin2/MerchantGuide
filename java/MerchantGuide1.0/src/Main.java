package src;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args)
			throws IOException, InvalidRomanException, InvalidIntergalacticUnitException {
		
		FileReader fileReader = new FileReader(new File("inputData.txt"));
		MerchantsGuide merchantsGuide;
		merchantsGuide = new MerchantsGuide(fileReader, System.out);
		merchantsGuide.run();		
	}


}
