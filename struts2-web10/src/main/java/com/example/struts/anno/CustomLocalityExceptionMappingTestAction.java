package com.example.struts.anno;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.example.struts.exception.CustomException;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/locality")
public class CustomLocalityExceptionMappingTestAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Action(value="/extest",
		exceptionMappings= {
				@ExceptionMapping(exception="java.lang.NullPointerException",result="success"),
				@ExceptionMapping(exception="java.lang.NullPointerException",result="input")
		},
		results= {
				@Result(name="success",location="/locality/success-ex.jsp"),
				@Result(name="input",location="/locality/input-ex.jsp")
		}
	)
	public String test1() {
		if ( Math.random() > 0.5 ) {
			throw new NullPointerException("Exception Occured.") ;
		} else {
			throw new CustomException("Exception Occured.") ;
		}
	}
	
}











