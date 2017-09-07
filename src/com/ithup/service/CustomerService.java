package com.ithup.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ithup.dao.CustomerDao;
import com.ithup.domain.Customer;
import com.ithup.utils.HibernateUtils;

/**
 * 瀹㈡埛鏈嶅姟灞�
 * 
 * @author acer
 *
 */
public class CustomerService {

	/**
	 * 保存客户
	 * 
	 * @param customer
	 */
	public void saveCustomer(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			new CustomerDao().addCustomer(customer);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询所有客户信息
	 */
	public List<Customer> findAllCustomer() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<Customer> allCustomer = null;
		try {
			allCustomer = new CustomerDao().selectAllCustomer();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allCustomer;
	}

}
