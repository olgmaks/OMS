package com.softserve.edu;

public class Pages {
	public double avg(double first, double second) {
		System.out.println("class Pages; public double avg(...)");
                Tools tools = new Tools();
		return tools.add(first, second)/2;
	}
}
