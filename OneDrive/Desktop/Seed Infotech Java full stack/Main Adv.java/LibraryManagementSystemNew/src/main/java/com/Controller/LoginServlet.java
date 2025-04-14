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

import com.Bean.LoginBean;
import com.Dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("username");
		String upwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd1 = request.getRequestDispatcher("Home1.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("Index.html");
		LoginBean lbobj = new LoginBean();
		lbobj.setUsername(uname);
		lbobj.setPassword(upwd);
		LoginDao lgndao = new LoginDao();
		try {
			String result = lgndao.authUserLogin(lbobj);
			if (result.equals("success")) {

				rd1.forward(request, response);
			} else {
				out.print("Invalid username or password....");
				rd2.include(request, response);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
