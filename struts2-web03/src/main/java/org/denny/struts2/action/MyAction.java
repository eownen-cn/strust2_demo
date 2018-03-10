package org.denny.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class MyAction extends ActionSupport {

	private static final long serialVersionUID = 1L;


	/************************ 获取servlet对象 ***********************/
	
	
	private Map request ;
	private Map session ;
	private Map application ;
	
	{
		request = (Map)ActionContext.getContext().get("request"); 
		session = ActionContext.getContext().getSession() ;
		application = ActionContext.getContext().getApplication() ;
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
		
		System.out.println("username ==>  " + this.username);
		System.out.println("password ==>  " + this.password);
		
		this.request.put("username", this.username) ;
		this.session.put("username", this.username) ;
		this.application.put("username", this.username) ;
		
		if ( this.username.equals("admin") && this.password.equals("admin") ) {
			return "login_success" ;
		} else {
			return "mission_failed" ;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
