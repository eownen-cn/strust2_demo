package org.denny.struts.dao.impl ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.denny.struts.bean.User;
import org.denny.struts.dao.UserDao;
import org.denny.struts.dbutil.DB;
import org.denny.struts.util.JSONSupport;

import net.minidev.json.JSONObject;

public class UserDaoImpl implements UserDao{
	
	private Connection conn = null ;
	
	private PreparedStatement ps = null ;
	
	private ResultSet rs = null ;
	
	private List<User> userList = null ;
	
	private static Map<String,Object> stateMap = null;

	{
		if ( stateMap == null ) stateMap = new HashMap<>() ;
		if ( userList == null ) userList = new LinkedList<>() ;
	}
	
	/**
	 * 随机生成用户会员等级编号，在1001到1005之间 包括1001和1005
	 * @return
	 */
	private String getGenerationVipId() {
		int floor = (int) Math.floor(Math.random() * 5 + 1001);
		return String.valueOf(floor);
	}

	/**
	 * 处理返回状态，供后台参考
	 * @param result
	 */
	private void disposeQueryState(Object result) throws SQLException{
		// 处理UPDATE受影响的行数
		if ( result instanceof Integer ) stateMap.put("affected_row", result) ;
		// 处理SELECT返回的行记录
		else if ( result instanceof ResultSet ) 
			if ( userList.size() > 1 ) // 处理返回多条行记录
				stateMap.put("user_list", userList ) ;
			else if ( userList.size() == 1 ) // 处理单一查询
				stateMap.put("user", userList.get(0)) ;
			else stateMap.put("data", "") ; // 处理无查询结果
		// 否则销毁这个资源
		else result = null ;
	}
	
	/***
	 * 为什么要用PreparedStatement而不用Statement
	 * 因为PreparedStatement是Oracle Company改造的，So...That it you can thought about enough
	 */
	public void add(String username, String password) throws SQLException {
		conn = DB.getConnection() ;
		String sql = "insert into s_user(username,password,vipId) values(?,?,?)";
		ps = conn.prepareStatement(sql ) ;
		ps.setObject(1, username);
		ps.setObject(2, password);
		ps.setObject(3, getGenerationVipId());
		Object result = ps.executeUpdate() ;
		disposeQueryState(result) ;
		DB.closeResources(conn, ps, rs);
	}
	
	public void update(User user) throws SQLException {
		conn = DB.getConnection() ;
		String sql = "update s_user set username=?,password=?,vipId=(select id from s_user_vip where name=?) where uid=?" ;
		ps = conn.prepareStatement(sql ) ;
		System.out.println("UserDaoImpl:" + user);
		ps.setObject(1, user.getUsername()) ;
		ps.setObject(2, user.getPassword()) ;
		ps.setObject(3, user.getVipLevel()) ;
		ps.setObject(4, user.getUid()) ;
		System.out.println(user);
		Object result = ps.executeUpdate() ;
		disposeQueryState(result);
		DB.closeResources(conn, ps, rs) ;
	}

	public void delete(Integer uid) throws SQLException {
		conn = DB.getConnection() ;
		String sql = "delete from s_user where uid=?" ;
		ps = conn.prepareStatement(sql ) ;
		ps.setObject(1, uid) ;
		Object result = ps.executeUpdate() ;
		disposeQueryState(result);
		DB.closeResources(conn, ps, rs) ;
	}

	public List<User> getList() throws SQLException {
		conn = DB.getConnection() ;
		String sql = "select u.uid,u.username,u.password,v.name from s_user as u,s_user_vip as v where v.id=u.vipId" ;
		ps = conn.prepareStatement(sql ) ;
		rs= ps.executeQuery() ;
		while(rs.next()) userList.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4))) ;
		disposeQueryState(rs) ;
		DB.closeResources(conn, ps, rs) ;
		return userList;
	}

	public User getById(Integer uid) throws SQLException {
		conn = DB.getConnection() ;
		String sql = "select uid,username,password,(select name from s_user_vip where id=vipId) from s_user where uid=?" ;
		ps = conn.prepareStatement(sql ) ;
		ps.setObject(1, uid);
		rs = ps.executeQuery() ;
		if (rs.next()) userList.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4))) ;
		disposeQueryState(rs) ;
		DB.closeResources(conn, ps, rs) ;
		return !userList.isEmpty() ? userList.get(0) : null ;
	}
	
	/**
	 * 输出查询结果
	 */
	public static void showLog() {
		System.out.print(JSONSupport.format(JSONObject.toJSONString(stateMap)));
	}
	
}