package com.softserve.edu.domain;

public class StringCriteria implements ISpecification {

	private final String NEW_LINE = "\n";
	private String text;
	private Specification specification;

	private StringCriteria(String text, Specification specification) {
		this.text = text;
		this.specification = specification;
	}

	public static StringCriteria get(String text, Specification specification) {
		return new StringCriteria(text, specification);
	}

	public StringCriteria valueMatch(String expectedResult) {
		this.specification.add(this.text.equals(expectedResult), NEW_LINE
				+ "Values don't match. Expected Result:\"" + expectedResult
				+ "\". ActualResult:\"" + text + "\"");
		return this;
	}

	public StringCriteria valueStartWith(String expectedResult) {
		this.specification.add(this.text.startsWith(expectedResult), NEW_LINE
				+ "Values don't match. Expected Result:\"" + expectedResult
				+ "\". ActualResult:\"" + text + "\"");
		return this;
	}

	public Specification next() {
		return this.specification;
	}

}
