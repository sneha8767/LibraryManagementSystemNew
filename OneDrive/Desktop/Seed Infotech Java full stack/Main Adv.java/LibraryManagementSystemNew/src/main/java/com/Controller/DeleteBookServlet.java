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

import com.Dao.BookDao1;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteBookServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // For simplicity, redirecting to doPost
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookNoStr = request.getParameter("bookno");
        int bookNo = Integer.parseInt(bookNoStr);
        
        BookDao1 bookDao = new BookDao1();
        String result;

        try {
            result = bookDao.deleteBook(bookNo);
            if (result.equals("success")) {
                request.setAttribute("message", "Book deleted successfully.");
            } else {
                request.setAttribute("message", "Invalid book number. No book deleted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred while deleting the book.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("deleteBook.jsp");
        dispatcher.forward(request, response);
    }
}
