package com.ithup.demo;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class DemoInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invo) throws Exception {
		System.out.println("actionִ��֮ǰִ�С�����������������������");
		String invoke = invo.invoke();
		System.out.println("actionִ��֮ǰִ�󡣡���������������������");
		return invoke;
	}
}
