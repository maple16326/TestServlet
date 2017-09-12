package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypackage.Fibonacci1;
import mypackage.Joseph1;

/**
 * Servlet implementation class JosephServlet
 */
@WebServlet("/JosephServlet")
public class JosephServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JosephServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);

		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String peoples;
		String interval;
		String startNo;
		String []peopleArray;
	    int intervals;
	    int startIndex;
		peoples = request.getParameter("josephString");
		peopleArray=peoples.split(",");
		interval=request.getParameter("josephInterval");
		intervals=Integer.parseInt(interval);
		startNo=request.getParameter("startIndex");
		startIndex=Integer.parseInt(startNo);
		request.setAttribute("josephString", peoples);
		request.setAttribute("josephInterval", interval);
		request.setAttribute("startIndex", startNo);
		Joseph1 joseph = new Joseph1();
		String lastPeople = null;
		try {
			lastPeople = joseph.joseph(peopleArray, intervals, startIndex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("lastPeople", lastPeople);// 设置到req中,key-->value
		request.getRequestDispatcher("/JosephResult.jsp").forward(request, response);

	
		
		
	}

}
