package com.umitcelebi.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.umitcelebi.dao.UserDao;
import com.umitcelebi.model.User;

@SuppressWarnings({ "unchecked", "deprecation" })
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean register(User user) {
		try {
			User user2=searchByUsername(user);
			if(user2==null) {
				getSession().save(user);
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error adding user..."+e);
			return false;
		}
	}

	@Override
	public User login(String userName,String pasw) {
		try {
			Query<User> query=getSession().createQuery("from User where userName=:name and password =:password");
			query.setParameter("name", userName);
			query.setParameter("password", pasw);
			User user=query.getSingleResult();
			if(user==null) {
				return null;
			}
			return user;
		} catch (Exception e) {
			System.out.println("Error entrying..."+e);
			return null;
		}
	}

	@Override
	public User searchByUsername(User user) {
		try {
			Query<User>query=getSession().createQuery("from User where userName=:username");
			query.setParameter("username", user.getUserName());
			User user2=query.getSingleResult();
			if(user2==null) {
				return null;
			}else {
				return user2;
			}
		} catch (Exception e) {
			System.out.println("Error searching..."+e);
			return null;
		}
	}

}
