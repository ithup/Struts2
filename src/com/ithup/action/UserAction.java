package com.ithup.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.ithup.domain.User;
import com.ithup.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2846977966181335385L;
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);
			//调用业务层
			User exitUser = new UserService().login(user);
			if(exitUser == null){
				// 说明，用户名或者密码错误了
				return LOGIN;
			}else{
				request.getSession().setAttribute("exitUser", exitUser);
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
}
