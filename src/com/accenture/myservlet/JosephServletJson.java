package com.accenture.myservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.runtime.ProtectedFunctionMapper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONArray;
import org.json.JSONObject;

import com.accenture.service.Fibonacci;
import com.accenture.service.Joseph;

/**
 * Servlet implementation class JosephServletJson
 */
@WebServlet("/JosephServletJson")
public class JosephServletJson extends HttpServlet {
	private static final String APPLICATION_JSON_CHAR_SET_UTF_8 = "application/json;char-set=utf-8";
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(JosephServletJson.class);
	public static final String LOG4JPROPERTIES = "log4j.properties";

	int intervals;
	int startNo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JosephServletJson() {
		super();

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
	private Boolean checkJson(JSONObject jsonObject, String... strs) {
		JSONArray persons;
		int i = 0;
		if (jsonObject.isNull("circle")==false&&jsonObject.getJSONObject("circle").isNull("persons")==false) 
		{
		persons = jsonObject.getJSONObject("circle").getJSONArray("persons");
			for (String str : strs) {
				if (jsonObject.getJSONObject("circle").has(str) == true)
					i++;
			}
			if (i == strs.length) {
				return true;
			} else
				return false;
	
	}
		else
			return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(APPLICATION_JSON_CHAR_SET_UTF_8);
		PropertyConfigurator.configure(LOG4JPROPERTIES);
		BufferedReader reader = request.getReader();
		StringBuffer buffer = new StringBuffer();
		String string;

		while ((string = reader.readLine()) != null) {
			buffer.append(string);
		}
		reader.close();
		response.setCharacterEncoding("UTF-8");
		Writer out = response.getWriter();
		
		JSONObject jsonObject = new JSONObject(buffer.toString());
		
		if (checkJson(jsonObject, "persons","interval","start")) {
			
			JSONObject circle = jsonObject.getJSONObject("circle");

		JSONArray persons = circle.getJSONArray("persons");
		String interval = circle.getString("interval");
		String startIndex = circle.getString("start");
		String[] peopleArray = new String[persons.length()];
		for (int i = 0; i < persons.length(); i++) {
			peopleArray[i] = persons.getString(i);
		}
		try {
			intervals = Integer.parseInt(interval);
			startNo = Integer.parseInt(startIndex);
			Joseph joseph = new Joseph();
			String lastPeople = null;

			try {
				lastPeople = joseph.solveJosephProblem(peopleArray, intervals, startNo);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}

			JSONObject jsonObjectResponseResult = new JSONObject();
			jsonObjectResponseResult.put("lastPeople", lastPeople);
			response.getWriter().write(jsonObjectResponseResult.toString());

		} catch (RuntimeException e) {
			LOGGER.error(e.getMessage());
			 response.getWriter().write("error");
		}

		 } else {
		 //response.getWriter();
		 response.getWriter().write("error");
		 }
	}

}
