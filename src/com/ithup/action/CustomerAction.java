package com.ithup.action;

import java.util.List;

import com.ithup.domain.Customer;
import com.ithup.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author acer
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	/**
	 * 
	 *  */
	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	public String save(){
		/**
		 * 调用业务层
		 */
		new CustomerService().saveCustomer(customer);
		return "custList";
	}
	
	public String findAll(){
		List<Customer> allCustomer = new CustomerService().findAllCustomer();
		ActionContext context = ActionContext.getContext();
		context.put("list", allCustomer);
		return "customerList";
	}
}
