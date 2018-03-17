package org.denny.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.result.HttpHeaderResult;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.minidev.json.JSONObject;

public class TestAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest req ;
	
	private HttpServletResponse resp ;
	

	@Override
	public String execute() {
		System.out.println("redirectAction : 服务器端跳转成功！");
		return "new_target" ;
	}
	
	public String hh() throws IOException {
		Enumeration<?> pn = req.getParameterNames();
		Map<String,String> map = new HashMap<>() ;
	    while (pn.hasMoreElements()) {
	        String key = (String) pn.nextElement();
	        String value = req.getHeader(key);
	        map.put(key, value);
	    }
	    PrintWriter w = new ServletResponseWrapper(resp).getWriter();
	    w.print(JSONObject.toJSONString(map));
	    w.flush();
		return NONE ;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.resp = response ;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.req = request ;
	}
	
}
