package com.firas.devdemo.models;

public class BackEndDeveloper extends Developer{
	
	boolean cssHate;

	public BackEndDeveloper() {
		super("back end dev default name");
		this.cssHate = true;
		this.setHoursOfSleep(2);
	}
	
	public BackEndDeveloper(String name) {
		super();
		this.name = name;
		this.cssHate = true;
		this.setHoursOfSleep(2);
	}
	
	public BackEndDeveloper(String name, boolean cssHate) {
		super();
		this.name = name;
		this.cssHate = true;
		this.setHoursOfSleep(2);
	}
	
	public boolean isCssHate() {
		return cssHate;
	}
	
	public void setCssHate(boolean cssHate) {
		this.cssHate = cssHate;
	}
	
	public void displayStatus() {
		super.displayStatus();
		System.out.println("Hate CSS? " + (this.cssHate ? (String)"yes" : (String)"nope I love it"));
	}
	
	public void giveMoreSleep(double hours) {
		double currentHoursOfSleep = this.getHoursOfSleep();
		currentHoursOfSleep += hours;
		this.setHoursOfSleep(currentHoursOfSleep);}
}
