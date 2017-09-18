package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import mypackage.Fibonacci1;
import mypackage.Joseph1;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class JosephServletJson
 */
@WebServlet("/JosephServletJson")
public class JosephServletJson extends HttpServlet {
	private static final String APPLICATION_JSON_CHAR_SET_UTF_8 = "application/json;char-set=utf-8";
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(JosephServletJson.class);
	public static final String LOG4JPROPERTIES="log4j.properties";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JosephServletJson() {
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
		JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
		String stringArray = jsonObject.getString("stringArray");

		String[] peopleArray = stringArray.split(",");
		String interval = jsonObject.getString("interval");
		String startIndex = jsonObject.getString("startIndex");
		int intervals = 0;
		int startNo = 0;
		try
		{
			intervals = Integer.parseInt(interval);
			startNo = Integer.parseInt(startIndex);
		}catch(RuntimeException e)
		{
			LOGGER.error(e.getMessage());
		}
		Joseph1 joseph = new Joseph1();
		String lastPeople = null;

		try {
			lastPeople = joseph.joseph(peopleArray, intervals, startNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonObjectResponseResult = new JSONObject();
		jsonObjectResponseResult.put("lastPeople", lastPeople);
		response.getWriter().write(jsonObjectResponseResult.toString());
	}

}
