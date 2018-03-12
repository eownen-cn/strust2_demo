<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>
<!DOCTYPE html >
<html>
<head>
<title>被包含的JSP页面</title>
</head>
<body>
	<f:choose>
		<f:when test="${not empty param.param1}">
			Example one - do an include myJsp.jsp page with param1=${param.param1} and param2=${param.param2}
		</f:when>
		<f:otherwise>
			Example one - do an include myJsp.jsp page
		</f:otherwise>
	</f:choose>
</body>
</html>