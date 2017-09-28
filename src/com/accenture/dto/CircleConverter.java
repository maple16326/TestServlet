package com.accenture.dto;

import org.json.JSONArray;
import org.json.JSONObject;

public class CircleConverter implements Converter<Circle>{

	@Override
	public Circle fromJson(JSONObject jsonObject) {

		String start=jsonObject.getString("start");
		String interval=jsonObject.getString("interval");
		JSONArray persons = jsonObject.getJSONArray("persons");
		Circle circle=new Circle();
		String[] peopleArray = new String[persons.length()];		
		for (int i = 0; i < persons.length(); i++) {
			peopleArray[i] = persons.getString(i);
		}
		circle.setStart(start);
		circle.setInterval(interval);
		circle.setPersons(peopleArray);
		return circle;
	}

	@Override
	public JSONObject toJson(Circle circle) {
		JSONObject jsonObject=new JSONObject();
		String start=circle.getStart();
		String interval=circle.getInterval();
		String[] persons=circle.getPersons();
		jsonObject.put("start", start);
        jsonObject.put("interval", interval);	
        jsonObject.put("persons", persons);
		return jsonObject;
	}
    
}
