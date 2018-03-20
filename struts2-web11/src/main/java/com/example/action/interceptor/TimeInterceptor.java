package com.example.action.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TimeInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 4218323343851016494L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long start = System.currentTimeMillis() ;
		String result = invocation.invoke() ;
		long end = System.currentTimeMillis() ;
		System.out.println("Action" + result + "执行耗时：" +(end-start) + "毫秒！");
		return result;
	}

}
