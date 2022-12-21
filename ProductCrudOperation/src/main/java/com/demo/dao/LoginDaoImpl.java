package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.bean.User;
import com.demo.util.DBUtil;

public class LoginDaoImpl implements LoginDao{

	static Connection con;
	static PreparedStatement plogin;
	static{
		
		con=DBUtil.getMyConnection();
		try {
			plogin=con.prepareStatement("Select * from userLogin where username=? and password=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public User ValidateUser(String un, String pw) {
		try {
			plogin.setString(1,un);
			plogin.setString(2, pw);
			ResultSet res=plogin.executeQuery();
			if(res.next()) {
				User u=new User(res.getString(1),res.getString(2),res.getString(3));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
