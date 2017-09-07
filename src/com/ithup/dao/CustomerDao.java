package com.ithup.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ithup.domain.Customer;
import com.ithup.utils.HibernateUtils;

/**
 * 
 * @author acer
 *
 */
public class CustomerDao {
	
	/**
	 * 
	 * @param customer
	 */
	public void addCustomer(Customer customer){
		Session session = HibernateUtils.getCurrentSession();
		session.save(customer);
	}

	public List<Customer> selectAllCustomer() {
		Session session = HibernateUtils.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		return list;
	}
}
