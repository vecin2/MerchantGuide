package src;

import java.util.HashMap;

public class IntergalacticUnitConverter {
	public HashMap<String, String> conversionIntergalacticRomans;
	public HashMap<String, String> conversionMetalsCredits;

	public IntergalacticUnitConverter(HashMap<String, String> conversionIntergalacticRomans,
			HashMap<String, String> conversionMetalsCredits) {
		this.conversionIntergalacticRomans = conversionIntergalacticRomans;
		this.conversionMetalsCredits = conversionMetalsCredits;
	}

	public Object get(String intergalacticSymbol) {
		return this.conversionIntergalacticRomans.get(intergalacticSymbol);
	}
}