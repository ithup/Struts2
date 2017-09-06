package com.ithup.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ithup.dao.UserDao;
import com.ithup.domain.User;
import com.ithup.utils.HibernateUtils;

public class UserService {
	
	public User login(User user){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		User exitUser = null;
		try {
			// ���ó־ò㣬��ѯ����
			exitUser = new UserDao().findByUsernameAndPassword(user);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return exitUser;
	}
	
	@Test
	public void run(){
		User user = new User();
		user.setUsername("admin");
		user.setPassword("1232");
		User existUser = this.login(user);
		if(existUser != null){
			System.out.println("��¼�ɹ���...");
		}else{
			System.out.println("��¼ʧ�ܣ�");
		}
	}
}
