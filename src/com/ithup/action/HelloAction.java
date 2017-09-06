package com.ithup.action;

/**
 * 动作类
 * @author acer
 *
 */
public class HelloAction {
	
	public String sayHello(){
		System.out.println("hello Struts2!!");
		//跳转页面
		return "ok";
	}
}
