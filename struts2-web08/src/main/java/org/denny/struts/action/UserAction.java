package org.denny.struts.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.denny.struts.bean.User;
import org.denny.struts.dao.UserDao;
import org.denny.struts.dao.impl.UserDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware{
	
	
	private static final long serialVersionUID = 1L;

	private UserDao dao ;
	
	private List<User> userList ;
	
	private HttpServletRequest request ;
	
	private User user = new User();
	
	{
		if ( dao == null ) dao = new UserDaoImpl() ;
		if ( userList == null ) userList = new ArrayList<>() ;
	}
	
	public UserDao getDao() {
		return dao;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}
	
	/**
	 * 获取列表
	 * @return
	 * @throws SQLException
	 */
	public String list() throws SQLException {
		userList = dao.getList() ;
		return SUCCESS ;
	}
	
	public String del() throws SQLException {
		Integer uid = Integer.parseInt(request.getParameter("uid")) ;
		System.out.println("uid:" + uid);
		dao.delete(uid);
		System.out.println("删除成功！");
		return NONE ;
	}
	
	public String edit() throws SQLException {
		Integer uid = Integer.parseInt(request.getParameter("uid")) ;
		String username = request.getParameter("username") ;
		String password = request.getParameter("password");
		String vipLevel= request.getParameter("vipLevel");
		System.out.println("UserAction:" + uid + "、" + username + "、" + password + "、" + vipLevel);
		dao.update(new User(uid,username,password,vipLevel));
		System.out.println("更新成功！");
		return NONE ;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request ;
	}
	
}
