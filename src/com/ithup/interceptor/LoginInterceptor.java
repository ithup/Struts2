package com.ithup.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ithup.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1675828620695630466L;

	@Override
	public String intercept(ActionInvocation invo) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User exitUser = (User) session.getAttribute("exitUser");
		if(exitUser == null){
			return "login";
		}
		return invo.invoke();
	}

}
