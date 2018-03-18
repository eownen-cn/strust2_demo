package com.example.actions.catalog.copy;

import com.opensymphony.xwork2.ActionSupport;

public class Hello extends ActionSupport{
	
	private String message ;
	
	public String execute() {
		this.message = "/catalog/copy/hello !" ;
		System.out.println("/catalog/copy/hello !");
		return SUCCESS ;
	}
	
	public String getMessage() {
		return this.message ;
	}
	
}
