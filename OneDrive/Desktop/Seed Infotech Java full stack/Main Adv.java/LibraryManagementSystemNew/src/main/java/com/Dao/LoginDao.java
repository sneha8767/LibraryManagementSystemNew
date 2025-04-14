package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.LoginBean;
import com.Util.DBConnection;

public class LoginDao {
	public String authUserLogin(LoginBean obj) throws SQLException {
		String uname = obj.getUsername();
		String upwd = obj.getPassword();
		Connection con = DBConnection.getDataConnection();
		PreparedStatement ps = con.prepareStatement("select uname, upwd from usertb where uname = ? and upwd=?");
		ps.setString(1, uname);
		ps.setString(2, upwd);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return "success";
		return "Invalid username or password";

	}
}
