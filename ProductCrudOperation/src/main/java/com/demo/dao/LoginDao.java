package com.demo.dao;

import com.demo.bean.User;

public interface LoginDao {

	

	User ValidateUser(String username, String password);

}
