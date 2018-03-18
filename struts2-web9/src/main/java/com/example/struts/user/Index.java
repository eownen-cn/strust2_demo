package com.example.struts.user;

import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport{
	
private String message ;
	
	public String execute() {
		this.message = "Index:/user/index" ;
		System.out.println("Index:/user/index");
		return SUCCESS ;
	}
	
	public String getMessage() {
		return this.message ;
	}
}
