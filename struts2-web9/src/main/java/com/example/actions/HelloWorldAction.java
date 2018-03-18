package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{
	
	private String message ;
	
	public String execute() {
		this.message = "HelloWorldAction:/hello-world" ;
		System.out.println("HelloWorldAction:/hello-world");
		return SUCCESS ;
	}
	
	public String getMessage() {
		return this.message ;
	}
	
}
