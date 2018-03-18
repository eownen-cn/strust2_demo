package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;

public class Index  extends ActionSupport{
	private String message ;
	
	public String execute() {
		this.message = "Index:/index" ;
		System.out.println("Index:/index");
		return SUCCESS ;
	}
	
	public String getMessage() {
		return this.message ;
	}
	
}
