package com.example.struts.user;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	private String message ;
	
	public String execute() {
		this.message = "IndexAction:/user/index-action" ;
		System.out.println("IndexAction:/user/index-action");
		return SUCCESS ;
	}
	
	public String getMessage() {
		return this.message ;
	}
}
