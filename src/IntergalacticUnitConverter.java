package src;

import java.util.HashMap;

public class IntergalacticUnitConverter {
	public HashMap<Object, String> conversionTable;

	public IntergalacticUnitConverter() {
		this.conversionTable = new HashMap<Object, String>();

	}

	public String convert(Object key) throws InvalidIntergalacticUnitException {
		if(conversionTable.get(key)==null)
			throw new InvalidIntergalacticUnitException("Cannot convert: "+ key.toString());
		return conversionTable.get(key);
	}

	public String addConversion(Object key, String value){
		return conversionTable.put(key, value);
	
	}


}