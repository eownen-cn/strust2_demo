<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		list-style:none ;
		text-decoration:none ;
		margin:0;
		padding:0;
		box-sizing:border-box ;
	}
	.block {
		padding-left:30px;
		padding-top:30px;
	}
	body * li{
		padding-left:20px;
		padding-top:10px;
		margin-bottom:20px;
	}
	hr{
		margin:5px 0 ;
	}
</style>
</head>
<body>
	
	<div class="block">
		<h3>配合&lt;s:url /&gt;标签使用的&lt;s:a /&gt;</h3>
		<hr>
		<p>
			测试普通网站地址：<br>
			<ul>
				<li>
					<s:url var="baidu" value="https://www.baidu.com" />
					<s:a value="%{baidu}">百度一下</s:a>
				</li>
			</ul>
		
		<p>
			测试常规去后台拿数据：<br>
			<ul>
				<li>
					<s:url var="get0" value="getJsonData" method="data"/>
					<s:a value="%{get0}">普通获取</s:a>
				</li>
			</ul>
		
		<p>
			测试Action去后台拿数据：<br>
			<ul>
				<li>
					<s:url var="get1" action="getByAction" method="ac" />
					<s:a href="%{get1}">Action获取</s:a>
				</li>
			</ul>
			
		<p>
			测试Action带参去后台拿数据：<br>
			<ul>
				<li>
					<s:url var="get2" action="bringParamToBack" method="b_ac">
						<s:param name="p1" value="%{'hello'}" />
						<s:param name="p2" value="%{'world'}" />
					</s:url>
					<s:a href="%{get2}">Action带参获取</s:a>
				</li>
			</ul>
	</div>
	
	<div class="block">
		<h3>&lt;s:include /&gt;标签的使用</h3>
		<hr>
		<p>
			三个&lt;s:include /&gt;案例：<br>
			<ul>
				<li>
					<!--  One:  -->
					<s:include value="included.jsp" />
				</li>
				<li>
					<!--  Two: -->
					<s:include value="included.jsp">
					   <s:param name="param1" value="%{'value1'}" />
					   <s:param name="param2" value="%{'value2'}" />
					</s:include>
				</li>
				<li>
					<!-- Three: -->
					<s:include value="included.jsp">
					   <s:param name="param1">value1</s:param>
					   <s:param name="param2">value2</s:param>
					</s:include>
				</li>
			</ul>
		<p>
			测试&lt;s:url /&gt;客户端跳转及传参：<br>
			<ul>
				<li>
					<!--  One:  -->
					<s:url value="%{'url_test_page'}" var="test1" escapeAmp="false"/>
					<s:a value="%{test1}">url_test_page</s:a>
				</li>
				<li>
					<!--  Two: -->
					<s:url value="%{'url_test_page'}" var="test2" escapeAmp="false">
						<s:param name="p">hello</s:param>
						<s:param name="pp">world!</s:param>
					</s:url>
					<s:a value="%{test2}">url_test_page</s:a>
				</li>
				<li>
					<!-- Three: -->
					<s:url value="%{'url_test_page'}" var="test3" escapeAmp="false">
						<s:param name="p" value="%{'世界'}"/>
						<s:param name="pp" value="%{'你好！'}"/>
					</s:url>
					<s:a value="%{test3}">url_test_page</s:a>
				</li>
			</ul>
		
		
	</div>
</body>
</html>