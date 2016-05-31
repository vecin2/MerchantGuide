package src;

import java.math.BigDecimal;

public class MetalCredits {

	private String name;

	public MetalCredits(String name) {
		this.name = name;
	}

	public BigDecimal value(IntergalacticUnitConverter converter) throws InvalidIntergalacticUnitException {
		return new BigDecimal(converter.convert(this));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
}
