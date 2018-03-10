<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="./base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<html>
<head>
<title>
	<c:if test="${not empty people.username }"><s:property value="username" />首页</c:if>
</title>
</head>
<body>
	
	<hr>
	<h2>Register<small><s:fielderror cssClass="default" fieldName="register_error"/></small></h2>
	<s:form action="register" method="post" namespace="/" >
		<s:textfield label="用户名" name="username" />
		<s:textfield label="密码" name="password" />
		<s:submit />
	</s:form>

	<hr>
	<h2>Login<small><s:fielderror cssClass="default" fieldName="login_error" /></small></h2>
	<s:form action="login" method="post" namespace="/" >
		<s:textfield label="用户名" name="username" />
		<s:textfield label="密码" name="password" />
		<s:submit />
	</s:form>
	
</body>
</html>