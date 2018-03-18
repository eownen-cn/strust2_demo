package com.example.struts.user.catalog;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	private String message ;
	
	public String execute() {
		this.message = "Index:/user/catalog/index-action" ;
		System.out.println("IndexAction:/user/catalog/index-action");
		return SUCCESS ;
	}
	
	public String getMessage() {
		return this.message ;
	}
}
