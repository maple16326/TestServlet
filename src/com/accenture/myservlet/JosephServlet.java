package com.accenture.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.service.Fibonacci1;
import com.accenture.service.Joseph1;

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
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
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
		Joseph1 joseph = new Joseph1();
		String lastPeople = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n" +
				"<HTML>\n" +
				"<HEAD><TITLE>Joseph Problem</TITLE></HEAD>\n" +
				"<BODY>\n" +
				"<H3>Joseph Problem:"+"Pelples:"+peoples+"</H3>\n" +
				"<H3>"+"interval:"+intervals+"</H3>\n" +
				"<H3>"+"startIndex:"+startIndex+"</H3>\n" +
				"</BODY></HTML>");	
		try {
			lastPeople = joseph.solveJosephProblem(peopleArray, intervals, startIndex);
			out.println("</p>The last people is:"+lastPeople+"</p>");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	
		
		
	}

}
