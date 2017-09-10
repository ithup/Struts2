package com.ithup.interceptor;

import org.apache.struts2.ServletActionContext;
import com.ithup.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * �Զ������������жϵ�ǰϵͳ�Ƿ��ѵ�¼�������¼������ִ�У����û�е�¼����ת����¼ҳ��
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
			//˵����û��¼
			return "login";
		}
		return invo.invoke();
	}

	

}
