<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="./base.jsp"%>
<html>
<head>
<title>Success</title>
	<style type="text/css" >
		h1{
			color:lightblue ;
		}
	</style>
</head>
<body>
	<h1>ValueStack中的username:<s:property value="username" /></h1>
	<h1>StackContext中的username:<s:property value="#username" /></h1>
	<h1>StackContext中的ActionMessage:<s:property value="#ActionMessage" /></h1>
	
	<h1><a style="color:coral;" href="index?username=scott&password=tiger">点我</a></h1>
</body>
</html>