package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Product;
import com.demo.util.DBUtil;

public class ProductDaoImpl implements ProductDao {
    static Connection con;
    static PreparedStatement pselbyCatid;
    static {
    	con=DBUtil.getMyConnection();
    	try {
			pselbyCatid = con.prepareStatement("select * from product2 where cid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
	public List<Product> findByCatID(int catid)  {
		try {
			pselbyCatid.setInt(1, catid);
			List<Product>plist = new ArrayList<>();
			ResultSet rs=pselbyCatid.executeQuery();
			while(rs.next())
			{
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5)));
			}
			if(plist.size()>0)
			{
				return plist;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
