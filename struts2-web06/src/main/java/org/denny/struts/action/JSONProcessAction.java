package org.denny.struts.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import net.minidev.json.JSONObject;
public class JSONProcessAction extends ActionSupport implements ServletResponseAware,Serializable{
	public static final long serialVersionUID = 1L;
	public HttpServletRequest request;
	public HttpServletResponse response ;
	Map<String, String> map ;
	{
		try {
			request = ServletActionContext.getRequest() ;
			request.setCharacterEncoding("utf-8") ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		request = ServletActionContext.getRequest();
	}
	public String responseAjax() throws IOException {
		String username = request.getParameter("username") ;
		String password = request.getParameter("password") ; 
		map = null ;
		map = new HashMap<>() ; // 实例化map
		// 添加数据
		map.put("username", username) ;
		map.put("password", password) ;
		mapToClient(map);
		return NONE ;
	}

	public void mapToClient(Map<String, String> map) throws IOException {
		PrintWriter wt = new HttpServletResponseWrapper(response).getWriter() ;
		// 转换为JSON格式字符串
		String json = JSONObject.toJSONString(map);  
		wt.print(json); // 响应
		System.out.println(json);
		wt.flush();
		wt.close();
	}
	
	public String testA(HttpServletResponse rep,String ...data) throws IOException {
		String temp = data.length == 0 ? "{'test_key','test_value'}" : data[0] ;
		strToClient(temp,rep);
		return NONE ;
	}

	public void strToClient(String data,HttpServletResponse response) throws IOException {
		PrintWriter writer = new HttpServletResponseWrapper(response).getWriter();
		writer.print(data);
		writer.flush();
		writer.close();
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response ;
	}
}
