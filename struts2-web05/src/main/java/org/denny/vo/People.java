package org.denny.vo;

public class People {
	
	private String username ;
	
	private String password ;

	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public People(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "People [username=" + username + ", password=" + password + "]";
	}
	
	
}
