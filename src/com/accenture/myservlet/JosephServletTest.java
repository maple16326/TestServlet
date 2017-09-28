package com.accenture.myservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONObject;

import com.accenture.business.BusinessException;
import com.accenture.business.Busniness;
import com.accenture.dto.RequestConverter;
import com.accenture.dto.JosephProblemRequest;
import com.accenture.dto.JosephProblemResponse;
import com.accenture.dto.JsonConverterByReflection;
import com.accenture.dto.ResponseConverter;

/**
 * Servlet implementation class JosephServletTest
 */
@WebServlet("/JosephServletTest")
public class JosephServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String APPLICATION_JSON_CHAR_SET_UTF_8 = "application/json;char-set=utf-8";

	public static final Logger LOGGER = Logger.getLogger(JosephServletJson.class);
	public static final String LOG4JPROPERTIES = "log4j.properties";

	int intervals;
	int startNo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JosephServletTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(APPLICATION_JSON_CHAR_SET_UTF_8);
		// PropertyConfigurator.configure(LOG4JPROPERTIES);
		BufferedReader reader = request.getReader();
		StringBuilder builder = new StringBuilder();
		String string;
		JsonConverterByReflection jsonConverterByReflection=new JsonConverterByReflection();
		while ((string = reader.readLine()) != null) {
			builder.append(string);
		}
		reader.close();
		response.setCharacterEncoding("UTF-8");

		JSONObject jsonObject = new JSONObject(builder.toString());
		RequestConverter requestConverter = new RequestConverter();
		//JosephProblemRequest jsonRequest = requestConverter.fromJson(jsonObject);
		JosephProblemRequest jsonRequest = null;
		
		try {
			jsonRequest = (JosephProblemRequest) jsonConverterByReflection.fromJson(jsonObject, JosephProblemRequest.class);
		} catch (IllegalArgumentException | IllegalAccessException e1) {
			
		}

		Busniness busniness = new Busniness();
		JosephProblemResponse jsonResponse;
		
		try {
			JSONObject josephResult = null;
			jsonResponse = busniness.doJosephCalcu(jsonRequest);
			ResponseConverter responseConverter = new ResponseConverter();
			try {
				josephResult=jsonConverterByReflection.toJson(JosephProblemResponse.class, jsonResponse);
			} catch (IllegalAccessException | IllegalArgumentException e) {
		
				LOGGER.error(e);
			}
			response.getWriter().write(josephResult.toString());
			
		} catch (BusinessException e) {
			LOGGER.error(e);
		}

	}

}
