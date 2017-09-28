package com.accenture.dto;

import org.json.JSONObject;

import com.accenture.JasonAnnotation.JsonAnnotation;

public class JosephProblemResponse extends DataTransferObject {
	@JsonAnnotation(name = "person")
	private String person;

	public String getLastPerson() {
		return person;
	}

	public void setLastPerson(String person) {
		this.person = person;
	}

}
