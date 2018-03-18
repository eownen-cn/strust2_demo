package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction  extends ActionSupport{
	private String message ;
	
	public String execute() {
		this.message = "IndexAction:/index-action" ;
		System.out.println("IndexAction:/index-action");
		return SUCCESS ;
	}
	
	public String getMessage() {
		return this.message ;
	}
	
}
