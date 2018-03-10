<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="./base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>
</head>
<body>
	<hr>
	<h2>Action1</h2>
	<s:form action="login">
		<s:textfield label="用户名" type="text" name="username" />
		<s:textfield label="密码" type="password" name="password" />
		<s:submit></s:submit>
		<s:reset></s:reset>
	</s:form>
	<hr>
	<h2>Action2</h2>
	<s:form action="login2">
		<s:textfield label="用户名" type="text" name="username" />
		<s:textfield label="密码" type="password" name="password" />
		<s:submit></s:submit>
		<s:reset></s:reset>
	</s:form>
	<hr>
	<h2>Action3</h2>
	<s:form action="login3">
		<s:textfield label="用户名" type="text" name="username" />
		<s:textfield label="密码" type="password" name="password" />
		<s:submit></s:submit>
		<s:reset></s:reset>
	</s:form>
	<hr>
	<h2>Action4</h2>
	<s:form action="login4">
		<s:textfield label="用户名" type="text" name="username" />
		<s:textfield label="密码" type="password" name="password" />
		<s:submit></s:submit>
		<s:reset></s:reset>
	</s:form>
</body>
</html>