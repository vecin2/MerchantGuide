package src;

import java.math.BigDecimal;

public class MetalCredits {

	private String metalName;

	public MetalCredits(String metalName) {
		this.metalName = metalName;
	}

	public BigDecimal value(IntergalacticUnitConverter converter) throws InvalidIntergalacticUnitException {
		return new BigDecimal(converter.convert(this));
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((metalName == null) ? 0 : metalName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetalCredits other = (MetalCredits) obj;
		if (metalName == null) {
			if (other.metalName != null)
				return false;
		} else if (!metalName.equals(other.metalName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return metalName;
	}
}
