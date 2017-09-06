package com.ithup.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ithup.domain.User;
import com.ithup.utils.HibernateUtils;

public class UserDao {
	
	public User findByUsernameAndPassword(User user){
		Session session = HibernateUtils.getCurrentSession();
		Query query = session.createQuery("from User where username = ? and password = ?");
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		List<User> list = query.list();
		if(list.size()>0){
			return  list.get(0);
		}
		return null;
	}
}
