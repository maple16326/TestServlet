package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.PropertyConfigurator;

import mypackage.Fibonacci1;
import mypackage.Joseph1;
import mypackage.Problem;
import mypackage.PropertyTest;
import mypackage.Test;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String fibonaccilength = request.getParameter("fibonaccilength");
		long fibolength = Long.parseLong(fibonaccilength);
		request.setAttribute("fibonaccilength", fibonaccilength);
		Fibonacci1 fibo = new Fibonacci1();
		List fibolist = fibo.fibonacci(fibolength);
		request.setAttribute("fibolist", fibolist);// 设置到req中,key-->value
		request.getRequestDispatcher("/FibonacciResult.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
