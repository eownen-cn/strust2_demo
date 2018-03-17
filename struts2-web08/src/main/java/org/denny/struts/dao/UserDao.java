package org.denny.struts.dao;

import java.sql.SQLException;
import java.util.List;

import org.denny.struts.bean.User;

public interface UserDao {
	
	public void add(String username, String password) throws SQLException ;
	
	public void update(User user) throws SQLException ;
	
	public void delete(Integer uid) throws SQLException ;
	
	public List<User> getList() throws SQLException ;
	
	public User getById(Integer uid) throws SQLException ;
	
}
