package com.demo.service;

import com.demo.bean.User;

public interface LoginService {

	User validateUser(String username, String password);

}
