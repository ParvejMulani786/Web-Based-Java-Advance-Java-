package com.demo.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.User;

public class TestRetreiveUser_Address {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		User u=session.get(User.class, 1);
		Address a=session.get(Address.class, 1);
		System.out.println(u.getFname()+"---"+u.getLname());
		System.out.println(u);
		System.out.println(a);
		

	}

}
