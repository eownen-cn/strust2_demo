package com.example.action ;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@ResultPath("/")
@ParentPackage("interceptor-default")
public class TestAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	@Action(value = "/index",
		results= {@Result(name="index",location="/index.jsp",type="redirect")}
	)
	public String execute() throws Exception {
		return super.execute();
	}
	
	@Action(value="/default",
		results= {@Result(name="test",location="/default.jsp",type="redirect")},
		interceptorRefs= {@InterceptorRef("time"),@InterceptorRef("defaultStack")}
	)
	public String test() {
		System.out.println("/default");
		return "test" ;
	}
	
}











