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

@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookNoStr = request.getParameter("bookno");

        BookDao1 bookDao = new BookDao1();
        List<BookBean> books = null;

        try {
            if (bookNoStr != null && !bookNoStr.isEmpty()) {
                int bookNo = Integer.parseInt(bookNoStr);
                books = bookDao.searchBookByNo(bookNo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Handle invalid book number input
        }

        request.setAttribute("bookList", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchBook.jsp");
        dispatcher.forward(request, response);
    }
}
