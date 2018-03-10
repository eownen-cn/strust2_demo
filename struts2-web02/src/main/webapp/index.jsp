<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<s:form action="login" >
		<s:textfield label="用户名" type="text" name="username" />
		<s:textfield label="密码" type="password" name="password" />
		<s:submit></s:submit>
		<s:reset></s:reset>
	</s:form>
</body>
</html>