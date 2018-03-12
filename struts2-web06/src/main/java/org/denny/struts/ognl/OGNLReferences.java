package org.denny.struts.ognl;


import org.denny.struts.vo.User;

public class OGNLReferences {
	
	private String infos = "hello world !!!" ; 				// 普通字段
	
	private User user = new User("hello","world",45) ; 		// 引用对象
	
	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static String INFO = "STATIC_FIELD" ; 		// 静态字段
	
	public static String info() { 					// 静态方法
		return "STATIC_METHOD" ;
	}
	
	public String info(String s) { 							// 普通方法
		return INFO + "_a_" + Math.abs(-9/9) ;
	}

	@Override
	public String toString() {
		return "OGNLReferences [infos=" + infos + ", user=" + user + ", getInfos()=" + getInfos() + ", getUser()="
				+ getUser() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
