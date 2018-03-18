package com.example.actions.catalog;

import com.opensymphony.xwork2.ActionSupport;

public class Hello extends ActionSupport{
	
	private String message ;
	
	public String execute() {
		this.message = "/catalog/hello !" ;
		System.out.println("/catalog/hello !");
		return SUCCESS ;
	}
	
	public String getMessage() {
		return this.message ;
	}
	
}
