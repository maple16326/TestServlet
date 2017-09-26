package com.accenture.dto;

import org.json.JSONObject;

public class JosephProblemResponse extends DataTransferObject {
	private String person;

	public String getLastPerson() {
		return person;
	}

	public void setLastPerson(String person) {
		this.person = person;
	}

}
