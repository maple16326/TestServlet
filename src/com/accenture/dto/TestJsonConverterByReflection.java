package com.accenture.dto;

import org.json.JSONObject;

import com.accenture.business.BusinessException;
import com.accenture.business.Busniness;

/** 
*
* @author yhcui E-mail:ychui@yahoo.cn 
* @version 创建时间：Sep 27, 2017 5:29:53 PM 
* @param
* 类说明 
*/
public class TestJsonConverterByReflection {

	public static void main(String[] args) {
		JosephProblemRequest jsonRequest = null;
		JsonConverterByReflection jsonConverterByReflection=new JsonConverterByReflection();
		JSONObject jsonObject=new JSONObject("{\"circle\": {\"start\": \"d\",\"interval\": \"e\",\"persons\": [\"A\", \"B\", \"C\",\"D\",\"e\",\"bcdefg\"]}}");
		try {
			jsonRequest = (JosephProblemRequest) jsonConverterByReflection.fromJson(jsonObject, JosephProblemRequest.class);
			System.out.println(jsonRequest.getCircle().getStart());
		} catch (IllegalArgumentException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		jsonRequest=new JosephProblemRequest();
		Circle circle=new Circle();
		circle.setInterval("2");
		circle.setStart("2");
		String[] string={"a","b","c"};
		circle.setPersons(string);
		jsonRequest.setCircle(circle);
	
		try {
			JSONObject jsonObject2=jsonConverterByReflection.toJson(JosephProblemRequest.class, jsonRequest);
			System.out.println(jsonObject2.toString());
		} catch (IllegalAccessException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		/*Busniness busniness = new Busniness();
		JosephProblemResponse jsonResponse;
		try {
			JSONObject josephResult = null;
			jsonResponse = busniness.doJosephCalcu(jsonRequest);
			ResponseConverter responseConverter = new ResponseConverter();
			try {
				josephResult=jsonConverterByReflection.toJson(JosephProblemResponse.class, jsonResponse);
			} catch (IllegalAccessException | IllegalArgumentException e) {
				e.printStackTrace();
			}
			//response.getWriter().write(josephResult.toString());
			
		} catch (BusinessException e) {
			//LOGGER.error(e);
		}*/
	}

}
 