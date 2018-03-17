package org.denny.struts.dbutil;

import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	
	{
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 得到一个新连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
//		return DriverManager.getConnection("jdbc:mysql:///struts?characterEncoding=utf8&useSSL=true","root","manager") ;
		// 如果插入中文数据到数据库产生乱码或问号之类的问题，以上是临时解决方案，因为其不会修改数据库服务器的编码
		return DriverManager.getConnection("jdbc:mysql:///struts?useSSL=true","root","manager") ;
	}
	
	/**
	 * 关闭资源
	 * @param conn
	 * @param stmt
	 * @param rs
	 * @throws Throwable
	 */
	public static void closeResources(Connection conn,Statement stmt, ResultSet rs) throws SQLException{
		if ( conn!=null ) conn.close() ;
		if ( stmt!=null ) stmt.close() ;
		if ( rs!=null ) rs.close() ;
		destroy(conn,stmt,rs) ;
	}
	
	/**
	 * 回收资源，优化性能
	 * @param obj
	 */
	private static void destroy(Object ... obj){ 
		for (Object i : obj)  i = null ;
	}
	
}
