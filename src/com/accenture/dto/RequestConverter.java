package com.accenture.dto;

import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.PUBLIC_MEMBER;

public class RequestConverter implements Converter<JosephProblemRequest> {
	JosephProblemRequest request = new JosephProblemRequest();
	Circle circle = new Circle();

	@Override
	public JosephProblemRequest fromJson(JSONObject jsonObject) {
		JSONObject circleJson = jsonObject.getJSONObject("circle");
		CircleConverter circleConverter = new CircleConverter();
		request.setCircle(circleConverter.fromJson(circleJson));
		return request;
	}

	@Override
	public JSONObject toJson(JosephProblemRequest request) {
        JSONObject jsonObject=new JSONObject();
        Circle circle=request.getCircle();
        jsonObject.put("circle", circle);
		return jsonObject;
	}

}
