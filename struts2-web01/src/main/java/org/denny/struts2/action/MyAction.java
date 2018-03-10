package org.denny.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class MyAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String execute() {
		System.out.println("StrutsAction的默认方法！");
		return SUCCESS;
	}

	public String login() {
		System.out.println("登陆方法！");
		return SUCCESS;
	}

	public String register() {
		System.out.println("注册方法！");
		return SUCCESS;
	}

}
