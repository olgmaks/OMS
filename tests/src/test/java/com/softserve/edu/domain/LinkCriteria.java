package com.softserve.edu.domain;

import com.softserve.edu.controls.ILink;

public class LinkCriteria implements ISpecification {

	private final String NEW_LINE = "\n";
	private ILink link;
	private Specification specification;

	private LinkCriteria(ILink link, Specification specification) {
		this.link = link;
		this.specification = specification;
	}

	public static LinkCriteria get(ILink link, Specification specification) {
		return new LinkCriteria(link, specification);
	}

	public LinkCriteria valueMatch(String expectedResult) {
		// TODO Use Formatted String
		this.specification.add(this.link.getText().equals(expectedResult),
				NEW_LINE + "Values doesn't match. Expected Result:\""
						+ expectedResult + "\". ActualResult:\"" + link.getText()+"\"");
		return this;
	}

	public LinkCriteria isVisible() {
		// TODO Use final for String
		this.specification.add(this.link.isDisplayed(), "It's not visible.");
		return this;
	}

	public Specification next() {
		return this.specification;
	}
}
