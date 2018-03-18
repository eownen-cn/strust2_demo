package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	private String message ;
	
	public String execute() {
		this.message = "HelloAction:/hello" ;
		System.out.println("HelloAction:/hello");
		return SUCCESS ;
	}
	
	public String getMessage() {
		return this.message ;
	}
	
}
