package org.denny.struts2.action;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String execute() {
		System.out.println("StrutsAction的默认方法！");
		return SUCCESS;
	}
	
	public String login() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().getSession().get("request") ;
		if ( request.getParameter("username").equals("admin") && request.getParameter("password").equals("admin") ) {
			return SUCCESS ;
		}
		return ERROR ;
	}
	
}
