package com.accenture.dto;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.json.JSONObject;




/** 
*
* @author yhcui E-mail:ychui@yahoo.cn 
* @version 创建时间：Sep 25, 2017 3:20:07 PM 
* @param
* 类说明 
*/
public class JsonConverterByReflection{

	public Object fromJson(JSONObject jsonObject,Class<?>clazz) throws IllegalArgumentException, IllegalAccessException {
		Constructor<?> constructor = null;
		try {
			constructor = clazz.getConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			
		}
		Object object = null;
		try {
			object = constructor.newInstance();
		} catch (InstantiationException e) {
		
			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}		

		JSONObject circleJson = jsonObject.getJSONObject("circle");		
		Field[] fields = clazz.getDeclaredFields();		
		for (Field field : fields) {
			field.setAccessible(true);			
			if (String.class.equals(field.getType())) {
				String value = (String) jsonObject.get(field.getName());				
				field.set(object, value);
			}
			else{
			fromJson(jsonObject.getJSONObject(field.getName()), field.getType());		
			}
		}

		return fields;

	}


	public JSONObject toJson(JosephProblemRequest requestAndResponse) {
	
		return null;
	}

}
 