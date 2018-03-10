package org.denny.struts;
import org.denny.vo.People ;

import com.opensymphony.xwork2.ActionSupport;
public class MyAction2 extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private People people;
	
	public String execute() {
		
		double rand = Math.random() * 10000000 ;
		this.people.setUsername(this.people.getUsername() + " : " + rand);
		this.people.setPassword(this.people.getPassword() + " : " + rand);
		System.out.println("username : " + this.people.getUsername());
		System.out.println("password : " + this.people.getPassword());
		this.addFieldError("username", people.getUsername());
		this.addActionError(people.getUsername());
		this.addActionMessage(people.getUsername());
		
		return SUCCESS ;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}
	
}
