package org.denny.struts.vo;

public class User {

	private String username;

	private String password;
	
	private Integer age ;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User() {
		super();
	}

	public User(String username, String password, Integer age) {
		super();
		this.username = username;
		this.password = password;
		this.age = age ;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
