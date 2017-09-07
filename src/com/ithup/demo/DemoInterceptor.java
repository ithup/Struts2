package com.ithup.demo;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class DemoInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invo) throws Exception {
		System.out.println("action执行之前执行。。。。。。。。。。。。");
		String invoke = invo.invoke();
		System.out.println("action执行之前执后。。。。。。。。。。。。");
		return invoke;
	}
}
