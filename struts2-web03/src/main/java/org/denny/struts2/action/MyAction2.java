package org.denny.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MyAction2 extends ActionSupport implements RequestAware, SessionAware, ApplicationAware{

	private static final long serialVersionUID = 1L;

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
		
		System.out.println("username ==>  " + this.username + "action2");
		System.out.println("password ==>  " + this.username + "action2");
		
		this.request.put("username", this.username + "action2") ;
		this.session.put("username", this.username + "action2") ;
		this.application.put("username", this.username + "action2") ;
		
		if ( this.username.equals("admin") && this.password.equals("admin") ) {
			return "login_success" ;
		} else {
			return "mission_failed" ;
		}
		
		
	}
	
	
	
	/*************************************** 获取web(jsp内置)对象 ***************************************/
	
	
	private Map<String , Object> request ;
	private Map<String , Object> session ;
	private Map<String , Object> application ;
	

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application ;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session ;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request ;
	}
	
	/************************ 获取servlet对象 ***********************/

}
