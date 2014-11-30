

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.GalacticAddition;
import src.GalacticCurrency;
import src.QuestionParser;

public class TestGalaxyAddition {

	@Test
	public void testParseExpression() {
		String additionString= "how many Credits is glob prok Silver plus glob glob Iron ?";
		
		QuestionParser questionParser = new QuestionParser();
		GalacticAddition galacticAddition = (GalacticAddition)questionParser.parse(additionString);
		assertEquals(new GalacticCurrency("glob prok", "Silver"), galacticAddition.getAugend());
		assertEquals(new GalacticCurrency("glob glob", "Iron"), galacticAddition.getAddend());
	}

}
