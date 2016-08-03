package com.softserve.edu.domain;

import com.softserve.edu.controls.ILabel;

public class LabelCriteria implements ISpecification {

	private final String NEW_LINE = "\n";
	private ILabel label;
	private Specification specification;

	private LabelCriteria(ILabel label, Specification specification) {
		this.label = label;
		this.specification = specification;
	}

	public static LabelCriteria get(ILabel label, Specification specification) {
		return new LabelCriteria(label, specification);
	}

	public LabelCriteria valueMatch(String expectedResult) {
		// TODO Use Formatted String
		this.specification.add(this.label.getText().equals(expectedResult),
				NEW_LINE + "Values doesn't match. Expected Result:\""
						+ expectedResult + "\". ActualResult:\"" + label.getText()+"\"");
		return this;
	}

	public LabelCriteria isVisible() {
		// TODO Use final for String
		this.specification.add(this.label.isDisplayed(), "It's not visible.");
		return this;
	}

	public Specification next() {
		return this.specification;
	}
}
