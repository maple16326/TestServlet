package com.accenture.dto;

import org.json.JSONObject;

public class ResponseConverter implements Converter<JosephProblemResponse> {
	JosephProblemResponse responose;
	String person;
	JSONObject jsonObjectResponseResult = new JSONObject();

	@Override
	public JosephProblemResponse fromJson(JSONObject jsonObject) {

		return null;
	}

	@Override

	/*
	 * convert response class to JSONObject (non-Javadoc)
	 * 
	 * @see
	 * com.accenture.dto.Converter#toJson(com.accenture.dto.DataTransferObject)
	 */
	public JSONObject toJson(JosephProblemResponse response) {
		this.responose=response;
		person=responose.getLastPerson();
		jsonObjectResponseResult.put("person", person);
		return jsonObjectResponseResult;
	}

}
