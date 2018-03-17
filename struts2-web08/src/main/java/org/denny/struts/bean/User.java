package org.denny.struts.bean;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 6415596716427914228L;

	private Integer uid ;
	
	private String username ;
	
	private String password ;
	
	private String vipLevel ;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(String vipLevel) {
		this.vipLevel = vipLevel;
	}

	/**
	 * 用于获取匹配查询结果
	 * @param uid
	 * @param username
	 * @param password
	 * @param vipId
	 */
	public User(Integer uid, String username, String password, String vipLevel) {
		this(username,password,vipLevel) ;
		this.uid = uid ;
	}
	
	/**
	 * 用于获取匹配查询结果
	 * @param uid
	 * @param username
	 * @param password
	 * @param vipId
	 */
	public User(String username, String password, String vipLevel) {
		this(username,password) ;
		this.vipLevel = vipLevel;
	}
	
	/**
	 * 用于数据插入
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		this.username = username ;
		this.password = password ;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", vipLevel=" + vipLevel + "]";
	}
	
}
