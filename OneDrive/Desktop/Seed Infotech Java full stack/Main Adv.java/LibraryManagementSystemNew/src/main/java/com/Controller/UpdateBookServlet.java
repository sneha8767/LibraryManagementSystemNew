package com.Controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.BookBean;
import com.Dao.BookDao1;

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookNoStr = request.getParameter("bookno");
        String bname = request.getParameter("bname");
        String aname = request.getParameter("aname");
        String priceStr = request.getParameter("price");
        String pubname = request.getParameter("pubname");

        BookDao1 bookDao = new BookDao1();
        String result = "failure";

        try {
            int bookNo = Integer.parseInt(bookNoStr);
            int price = Integer.parseInt(priceStr);

            BookBean book = new BookBean();
            book.setBookNo(bookNo);
            book.setBname(bname);
            book.setAname(aname);
            book.setPrice(price);
            book.setPubname(pubname);

            result = bookDao.updateBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Handle invalid input
        }

        request.setAttribute("updateResult", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Updatebook.jsp");
        dispatcher.forward(request, response);
    }
}
