package com.accenture.dto;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.accenture.JasonAnnotation.JsonAnnotation;

public class JsonConverterByReflection {

	public Object fromJson(JSONObject jsonObject, Class<?> clazz)
			throws IllegalArgumentException, IllegalAccessException {
		Constructor<?> constructor = null;
		String jsonPropName = null;
		try {
			constructor = clazz.getConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			
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
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);

			/*check whether any annotation is bound to the class field.
			  Y:jsonPropName = fieldAnno.name()
			  N:jsonPropName = field.getName()
			*/
			boolean fieldHasAnno = field.isAnnotationPresent(JsonAnnotation.class);												
			if (fieldHasAnno) {
				JsonAnnotation fieldAnno = field.getAnnotation(JsonAnnotation.class);
				jsonPropName = fieldAnno.name();
			}

			else {
				jsonPropName = field.getName();
			}
            
			if (String.class.equals(field.getType())) {
				String value = (String) jsonObject.get(jsonPropName);
				field.set(object, value);
			} else if (String[].class.equals(field.getType())) {

				JSONArray persons = jsonObject.getJSONArray(jsonPropName);
				String[]josephPersons = new String[persons.length()];

				for (int i = 0; i < persons.length(); i++) {

					josephPersons[i]=persons.getString(i);
				}
				field.set(object, josephPersons);
			}

			else {
				
				field.set(object, fromJson(jsonObject.getJSONObject(jsonPropName), field.getType()));
			}

		}

		return object;

	}

	public JSONObject toJson(Class<?> clazz,Object object) throws IllegalAccessException, IllegalArgumentException {
		JSONObject jsonObject = new JSONObject();
		String jsonPropName = null;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			/*
			 * check whether any annotation is bound to the class field.
			 * Y:jsonPropName = fieldAnno.name() N:jsonPropName =
			 * field.getName()
			 */
			boolean fieldHasAnno = field.isAnnotationPresent(JsonAnnotation.class);
			if (fieldHasAnno) {
				JsonAnnotation fieldAnno = field.getAnnotation(JsonAnnotation.class);
				jsonPropName = fieldAnno.name();
			} else {
				jsonPropName = field.getName();
			}

			if (String.class.equals(field.getType())) {
				String value = (String) field.get(object);
				jsonObject.put(jsonPropName, value);
			} else if (String[].class.equals(field.getType())) {
				JSONArray jsonArray = new JSONArray(); 
				Object[] array = (Object[]) field.get(object);
				for (int i = 0; i < array.length; i++) {

					jsonArray.put(array[i]);

				}
				jsonObject.put(jsonPropName, jsonArray);
			}

			else {
				JSONObject propertyJsonObject=toJson(field.getType(), field.get(object));		
				jsonObject.put(jsonPropName,propertyJsonObject);
			}

		}

		return jsonObject;

	}

}
 