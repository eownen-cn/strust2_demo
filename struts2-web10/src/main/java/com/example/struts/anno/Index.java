package com.example.struts.anno;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Locale;

import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.example.struts.bean.Fruit;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

/**
 * 限定命名空间，该类下的所有Action的最终访问的URL都必须以/user 开头
 * @author Ewonen-PC
 *
 */
@Namespace("/user") 
public class Index extends ActionSupport implements ServletResponseAware ,Serializable{

	private static final long serialVersionUID = 1L;

	private String message ;
	
	private HttpServletResponse response ;
	
	@Action("index")
	public String execute() {
		this.message = "Index:/anno/index" ;
		System.out.println("Index:/anno/index");
		return SUCCESS ;
	}
	
	@Action("json")
	public void getJson() throws Exception{
		json(null);
	}

	private void json(String msg) throws IOException {
		PrintWriter w = new ServletResponseWrapper(response).getWriter();
		Fruit f = new Fruit("1001","苹果" + msg == null ? "" : msg,12.0) ;
		JSONObject obj = JSONObject.fromObject(f);
		w.print(obj);
		w.flush();
		w.close();
	}
	@Action("/message")
	public String getMessage() throws Exception {
		String msg = " hello /user/message" ;
		System.out.println(msg);
		json(msg);
		return NONE ;
	}
	
	/**
	 * 使用多个ActionURL指向同一个方法(Action)
	 * @throws IOException
	 */
	@Actions({
		@Action("/one"),
		@Action("/one/a101"), // 此写法，在不限定类级别命名空间的前提下有效
		@Action("/two")
	})
	public void test1() throws IOException {
		json("/one or two") ;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response ;
		response.setContentType("text/html;charset=utf8");
	}
}
