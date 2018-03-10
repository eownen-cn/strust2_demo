package org.denny.struts2.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class MyAction4 extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 1L;

	
	/*************************************** 获取web(jsp内置)对象 ***************************************/
	
	
	private HttpServletRequest request ;
	private HttpSession session ;
	private ServletContext application ;
	
	{
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request ;
		this.session = request.getSession() ;
		this.application = session.getServletContext();
	}
	
	/************************ 获取servlet对象 ***********************/

	
	public String execute() {
		System.out.println("StrutsAction-Default");
		return SUCCESS;
	}
	
	private String username ;
	
	private String password ;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		
		System.out.println("username ==>  " + this.username + "action4");
		System.out.println("password ==>  " + this.username + "action4");
		
		this.request.setAttribute("username", this.username + "action4") ;
		this.session.setAttribute("username", this.username + "action4") ;
		this.application.setAttribute("username", this.username + "action4") ;
		
		if ( this.username.equals("admin") && this.password.equals("admin") ) {
			return "login_success" ;
		} else {
			return "mission_failed" ;
		}
		
		
	}

	
	
	

}
