package src;

import java.util.HashMap;

public class ConversionTable {
	HashMap<String, String> conversionValues = new HashMap<String, String>();

	public String put(String key, String value) {
		return conversionValues.put(key, value);
	}

	public String get(String key) throws InvalidConversionKey {
		if (conversionValues.get(key) != null)
			return conversionValues.get(key);
		else
			throw new InvalidConversionKey("There is no conversion for " + key);
	}

	public int getInt(String currency) throws InvalidConversionKey {
		return Integer.parseInt(get(currency));
	}
}
