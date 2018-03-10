<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="./base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MissionSuccess</title>
</head>
<body>
	<hr><br>
	well done !<br><hr><br>
	ognl : request.username ==> <s:property value="request.username" /><br>
	ognl : session.username ==> <s:property value="session.username" /><br>
	ognl : application.username ==> <s:property value="application.username" /><br><hr><br>
	
	jsp : request.getAttribute() ==> <%=request.getAttribute("username") %><br>
	jsp : session.getAttribute() ==> <%=session.getAttribute("username") %><br>
	jsp : application.getAttribute() ==> <%=application.getAttribute("username") %><br><hr><br>
	
	ognl : #request.username ==> <s:property value="#request.username" /><br>
	ognl : #session.username ==> <s:property value="#session.username" /><br>
	ognl : #application.username ==> <s:property value="#application.username" /><br><hr><br>
	ognl : #attr.username ==> <s:property value="#attr.username" /><br>
	
</body>
</html>