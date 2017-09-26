package com.accenture.business;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;
import org.json.JSONObject;

import com.accenture.dto.JosephProblemRequest;
import com.accenture.dto.JosephProblemResponse;
import com.accenture.dto.ResponseConverter;
import com.accenture.service.Joseph1;

public class Busniness {
	public static boolean isNumeric(String str){
		  for (int i = 0; i < str.length(); i++){
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }

	public JosephProblemResponse doJosephCalcu(JosephProblemRequest request) throws BusinessException {

		JosephProblemResponse response = new JosephProblemResponse();

		String interval = request.getCircle().getInterval();
		String start = request.getCircle().getStart();
		String[] persons = request.getCircle().getPersons();
		if (isNumeric(interval) && isNumeric(start)) {
			int intervals = Integer.parseInt(interval);
			int startNo = Integer.parseInt(start);
			Joseph1 joseph = new Joseph1();
			String person = null;
			try {
				person = joseph.solveJosephProblem(persons, intervals, startNo);
				response.setLastPerson(person);
			} catch (Exception e) {
				throw new BusinessException("The startNo must be greater than or equal to 0", e);
			}

			return response;
		} else if (isNumeric(interval) == true && isNumeric(start) == false) {
			throw new BusinessException("interval should be a number!");
		} else if (isNumeric(interval) == false && isNumeric(start) == true) {
			throw new BusinessException("start should be a number!");
		} else {
			throw new BusinessException("interval and start should be numbers！");
		}

	}

}
