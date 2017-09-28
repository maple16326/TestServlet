package com.accenture.dto;

import org.json.JSONObject;

public class ResponseConverter implements Converter<JosephProblemResponse> {


	@Override
	public JosephProblemResponse fromJson(JSONObject jsonObject) {
		String person = null;
        JosephProblemResponse josephProblemResponse=new JosephProblemResponse();
        person=jsonObject.getString("person");
        josephProblemResponse.setLastPerson(person);
		return josephProblemResponse;
	}

	@Override

	/*
	 * convert response class to JSONObject (non-Javadoc)
	 * 
	 * @see
	 * com.accenture.dto.Converter#toJson(com.accenture.dto.DataTransferObject)
	 */
	public JSONObject toJson(JosephProblemResponse response) {
		JosephProblemResponse responose=new JosephProblemResponse();
		String person;
		JSONObject jsonObjectResponseResult = new JSONObject();
		person=responose.getLastPerson();
		jsonObjectResponseResult.put("person", person);
		return jsonObjectResponseResult;
	}

}
