package com.accenture.dto;

public class Circle extends DataTransferObject{

	private String start;

	private String interval;
	private String [] persons;
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public String[] getPersons() {
		return persons;
	}
	public void setPersons(String[] persons) {
		this.persons = persons;
	}

	
}
