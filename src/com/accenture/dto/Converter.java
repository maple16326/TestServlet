package com.accenture.dto;

import org.json.JSONObject;

public interface Converter<T extends DataTransferObject> {
	public T fromJson(JSONObject jsonObject);

	public JSONObject toJson(T requestAndResponse);
}
