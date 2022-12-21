package com.demo.service;

import com.demo.bean.User;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	private LoginDao ldao;
	public LoginServiceImpl() {
		super();
		ldao=new LoginDaoImpl();
	}
	
	public User validateUser(String username, String password) {
		
		return ldao.ValidateUser(username,password);
	}
	
	
	

}
