package org.denny.struts.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class UseTag extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	
	private HttpServletResponse response ;
	private HttpServletRequest request ;

	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		System.out.println("Default method be invoke ...");
		return super.execute();
	}
	
	public String data() {
		System.out.println("data method is invoke ...");
		JSONProcessAction action = new JSONProcessAction () ;
		try {
			action.testA(response) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE ;
	}
	
	public String ac() {
		System.out.println("ac method is invoke ...");
		JSONProcessAction action = new JSONProcessAction () ;
		try {
			action.testA(response,"{'test_ac_key','test_ac_value'}") ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE ;
	}
	
	public String b_ac() {
		System.out.println("b_ac method is invoke ...");
		JSONProcessAction action = new JSONProcessAction () ;
		String p = this.request.getParameter("p1");
		String pp = this.request.getParameter("p2");
		System.out.println("p1 : " + p);
		System.out.println("p1 : " + pp);
		try {
			action.testA(response,"{'result':['test_ac_key':'test_ac_value','" + p + "':'" + pp + "']}") ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE ;
	}
	
	public String none() {
		//处理国际化
		return NONE ;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response ;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request ;
	}
	
}
