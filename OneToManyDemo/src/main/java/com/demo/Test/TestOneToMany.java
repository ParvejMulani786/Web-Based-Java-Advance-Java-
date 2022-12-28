package com.demo.Test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.User;

public class TestOneToMany {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		//create object of User class
		User u1=new User();
		User u2=new User();
		//partially add values int object(using default constructor)
		u1.setFname("Parvej");
		u1.setLname("Mulani");
		Set<Address>addrlist=new HashSet<>();
		//create set of Addresses
		Address add1=new Address("Nigdi","Pune","Maharashtra",u1);
		Address add2=new Address("Bhedasgaon","kolhapur","Maharashtra",u1);
		Address add3=new Address("Karad","Satara","MAharashtra",u1);
		addrlist.add(add1);
		addrlist.add(add2);
		addrlist.add(add3);
		u1.setAddrset(addrlist);
		//save session to make trancient object into persistent object
		session.save(u1);
		tr.commit();
		session.close();

	}

}
