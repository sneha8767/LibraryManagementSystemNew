package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.BookBean;
import com.Util.DBConnection;

public class BookDao1 {
    private Connection con;

    public BookDao1() {
        con = DBConnection.getDataConnection();
    }

    public String deleteBook(int bookNo) throws SQLException {
        String sql = "DELETE FROM booktb WHERE bookno = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, bookNo);
            int rowsAffected = pstmt.executeUpdate();
            return (rowsAffected > 0) ? "success" : "failure"; // Book not found
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<BookBean> searchBookByNo(int bookNo) throws SQLException {
        List<BookBean> books = new ArrayList<>();
        String sql = "SELECT * FROM booktb WHERE bookno = ?"; // Adjust table name as needed
        
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, bookNo);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                BookBean book = new BookBean();
                book.setBookNo(rs.getInt("bookno"));
                book.setBname(rs.getString("bookname"));
                book.setAname(rs.getString("authorname"));
                book.setPrice(rs.getInt("price"));
                book.setPubname(rs.getString("pubname"));
                books.add(book);
            }
        }
        return books;
    }
    public String updateBook(BookBean book) throws SQLException {
        String sql = "UPDATE booktb SET bookname = ?, authorname = ?, price = ?, pubname = ? WHERE bookno = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, book.getBname());
            pstmt.setString(2, book.getAname());
            pstmt.setInt(3, book.getPrice());
            pstmt.setString(4, book.getPubname());
            pstmt.setInt(5, book.getBookNo());

            int rowsAffected = pstmt.executeUpdate();
            return (rowsAffected > 0) ? "success" : "failure"; // Return success or failure
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Propagate the exception
        }
    }
    public List<BookBean> getAllBooks() throws SQLException {
        List<BookBean> books = new ArrayList<>();
        String sql = "SELECT * FROM booktb"; // Updated to booktb

        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                BookBean book = new BookBean();
                book.setBookNo(rs.getInt("bookno")); // Ensure this column name matches your database
                book.setBname(rs.getString("bookname"));
                book.setAname(rs.getString("authorname"));
                book.setPrice(rs.getInt("price"));
                book.setPubname(rs.getString("pubname"));
                books.add(book);
            }
        }
        return books;
    }

}
