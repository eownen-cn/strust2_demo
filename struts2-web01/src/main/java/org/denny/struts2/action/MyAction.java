package org.denny.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class MyAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String execute() {
		System.out.println("StrutsAction��Ĭ�Ϸ�����");
		return SUCCESS;
	}

	public String login() {
		System.out.println("��½������");
		return SUCCESS;
	}

	public String register() {
		System.out.println("ע�᷽����");
		return SUCCESS;
	}

}
