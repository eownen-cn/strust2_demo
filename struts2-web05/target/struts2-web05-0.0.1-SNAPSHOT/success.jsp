<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="./base.jsp"%>
<html>
<head>
<title>Success</title>
</head>
<body>
	<h1>StackContext中的username : <s:fielderror cssClass="default" /></h1>
	<h1>StackContext中的ActionError : <s:actionerror cssClass="default" /></h1>
	<h1>StackContext中的ActionMessage : <s:actionmessage cssClass="default" /></h1>

	<hr>
	
	<h1>ValueStack中的username : <span class="default"><br><s:property value="username"/></span></h1>
	<h1>ValueStack中的password : <span class="default"><br><s:property value="password"/></span></h1>
	<h1><a style="color:coral;" href="index?username=scott&password=tiger">index</a></h1>
	
	<hr>
	
	<h1>ValueStack中的username : <span class="default"><br><s:property value="people.username"/></span></h1>
	<h1>ValueStack中的password : <span class="default"><br><s:property value="people.password"/></span></h1>
	<h1><a style="color:coral;" href="index2?people.username=scott&people.password=tiger">index2</a></h1>
	
	<br><hr><br>
	
</body>
</html>