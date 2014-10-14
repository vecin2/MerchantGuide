package tests;

public class GTObject {

	private String someText;

	public GTObject(String text) {
		this.someText = text;
	}

	@Override
	public boolean equals(Object object) {
		GTObject toCompare = (GTObject) object;
		return someText.equals(toCompare.someText);
	}
	@Override
	public String toString(){
		return someText;
	}
}
