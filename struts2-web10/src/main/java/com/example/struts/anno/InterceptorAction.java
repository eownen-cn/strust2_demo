package com.example.struts.anno;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Locale;

import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
@ResultPath("/")
public class InterceptorAction extends ActionSupport implements ServletResponseAware, Serializable {

	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;

	private String jsonStr;

	@Action(interceptorRefs = { @InterceptorRef("validation"), @InterceptorRef("defaultStack") })
	public String execute() {

		this.jsonStr = "{\"name\":\"Eownen\",\"age\",18}";

		return SUCCESS;
	}

	@Action(value = "/different/url", results = {
			@Result(name = "success", location = "https://cn.bing.com/", type = "redirect"),
			@Result(name = "none", location = "index.jsp", type = "dispatcher") })
	public String doSomething() throws Exception {
		boolean flag = Math.random() > 0.9;
		if (flag) {
			debug("https://cn.bing.com/", this.response);
			return SUCCESS;
		} else {
			debug("/WEB-INF/content/index.jsp", this.response);
			return NONE;
		}
	}
	
	@Action(value = "/different/uri", results = {
			@Result(name = "success", location = "tar-action/myaction", type = "redirectAction"),
			@Result(name = "input", location = "/index.jsp", type = "dispatcher") }) // 转到webapp/index.jsp
	public String doSomething2() throws Exception {
		boolean flag = Math.random() > 0.5;
		if (flag) {
			System.out.println("redirectAction : /tar-action/myaction");
			return SUCCESS;
		} else {
			System.out.println("index.jsp");
			this.jsonStr = "{\"name\":\"Eownen\",\"age\":18}" ;
			return INPUT;
		}
	}
	
	@Action("/different/tar-action/myaction")
	public String testRedirectAction() throws Exception {
		debug("<h1>redirectAction : /tar-action/myaction 来点中文🍎</h1>", response) ;
		return NONE ;
	}

	
	
	public void debug(Object data, ServletResponse response) throws Exception {
		ServletResponseWrapper w = new ServletResponseWrapper(response);
		PrintWriter writer = w.getWriter();
		if (data instanceof JSONObject)
			data = JSONObject.fromObject(data);
		else
			writer.print(data);
		writer.flush();
		writer.close();
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		this.response.setContentType("text/html;charset=utf8");
	}

	public String getJsonStr() {
		return this.jsonStr;
	}
	
	
}
