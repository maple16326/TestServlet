package com.accenture.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;

import com.accenture.service.Fibonacci1;
import com.accenture.service.Joseph1;
import com.accenture.service.Problem;
import com.accenture.service.PropertyTest;
import com.accenture.service.Test;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FibonacciServlet() {
		super();
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n" +
				"<HTML>\n" +
				"<HEAD><TITLE>Febonacci Sequence</TITLE></HEAD>\n" +
				"<BODY>\n" +
				"<H1>Fibonacci Sequence:</H1>\n" +
				"</BODY></HTML>");	
		String fibonaccilength = request.getParameter("fibonaccilength");
		long fibolength = Long.parseLong(fibonaccilength);
		Fibonacci1 fibo = new Fibonacci1();
		List<Long> fibolist  = fibo.fibonacci(fibolength);
		out.println("<ul></ul>");
		for (int i = 0; i < fibolist.size(); i++) {
			out.println("<li>");
			out.println(fibolist.get(i));
			out.println("</li>");
		}
	            
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
