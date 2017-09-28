package com.accenture.dto;

import com.accenture.JasonAnnotation.JsonAnnotation;

public class Circle extends DataTransferObject{
    @JsonAnnotation(name = "start")
	private String start;
    @JsonAnnotation(name = "interval")
	private String interval;
    @JsonAnnotation(name = "persons")
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
