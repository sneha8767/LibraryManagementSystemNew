package com.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.BookBean;
import com.Dao.BookDao1;

@WebServlet("/ShowAllBooksServlet")
public class ShowAllBooksServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<BookBean> bookList = null;

        try {
            BookDao1 bookDao = new BookDao1();
            bookList = bookDao.getAllBooks();
            System.out.println("Fetched book list size: " + (bookList != null ? bookList.size() : 0));
        } catch (SQLException e) {
            e.printStackTrace();
            // Set an error message to be displayed on the JSP
            request.setAttribute("errorMessage", "Error fetching book list. Please try again later.");
        }

        // Check if bookList is null or empty and set an appropriate message
        if (bookList == null || bookList.isEmpty()) {
            request.setAttribute("errorMessage", "No books available.");
        } else {
            request.setAttribute("bookList", bookList);
        }

        // Forward to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("showAllBooks.jsp");
        dispatcher.forward(request, response);
    }
}