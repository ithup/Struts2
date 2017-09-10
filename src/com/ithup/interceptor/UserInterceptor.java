package com.ithup.interceptor;

import org.apache.struts2.ServletActionContext;
import com.ithup.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义拦截器：判断当前系统是否已登录，如果登录，继续执行，如果没有登录，跳转到登录页面
 * @author acer
 *
 */
public class UserInterceptor extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1675828620695630466L;

	@Override
	protected String doIntercept(ActionInvocation invo) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("exitUser");
		if(user == null){
			//说明还没登录
			return "login";
		}
		return invo.invoke();
	}

	

}
