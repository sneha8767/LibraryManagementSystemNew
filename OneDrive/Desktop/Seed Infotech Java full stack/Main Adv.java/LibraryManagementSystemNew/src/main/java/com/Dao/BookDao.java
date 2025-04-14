package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Bean.BookBean;
import com.Util.DBConnection;

public class BookDao {

	public String addbook(BookBean bobj) throws SQLException
	{
		String bname = bobj.getBname();
		String aname = bobj.getAname();
		int price = bobj.getPrice();
		String pubname = bobj.getPubname();
		Connection con = DBConnection.getDataConnection();
		String sql = "insert into booktb(bookno, bookname, authorname,"
				+ " price, pubname)"
				+ "values(111,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, bname);
		stmt.setString(2, aname);
		stmt.setInt(3, price);
		stmt.setString(4, pubname);
		
		int i = stmt.executeUpdate();
		if(i > 0)
			return "success";
		else 
			return "Recored not Inserted";
		
	}
	
}
