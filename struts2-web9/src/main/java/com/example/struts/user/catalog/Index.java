package com.example.struts.user.catalog;

import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport{
	
private String message ;
	
	public String execute() {
		this.message = "Index:/user/catalog/index" ;
		System.out.println("Index:/user/catalog/index");
		return SUCCESS ;
	}
	
	public String getMessage() {
		return this.message ;
	}
}
