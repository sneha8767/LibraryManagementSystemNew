package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.BookBean;
import com.Dao.BookDao;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bname = request.getParameter("bname");
		String aname = request.getParameter("aname");
		String price1 = request.getParameter("price");
		int price = Integer.parseInt(price1);
		String pubname = request.getParameter("pubname");
		
		PrintWriter out = response.getWriter();
		RequestDispatcher rd1 = request.getRequestDispatcher("Home1.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("Login.html");
		BookBean bobj = new BookBean();
		bobj.setBname(bname);
		bobj.setAname(aname);
		bobj.setPrice(price);	
		bobj.setPubname(pubname);
		BookDao Bgndao = new BookDao();
		String result;
		try {
			result = Bgndao.addbook(bobj);
			if(result.equals("success")) {
				
			System.out.println("Book added successfully");
			rd1.forward(request, response);
			}
		else {
			out.print("Invalid...");
			rd2.include(request, response);
		
		}
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
	}
}
