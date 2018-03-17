<%@ page language="java" pageEncoding="UTF-8"
	import="java.util.Iterator"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	// 通过request获取绝对路劲

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" // 得到传输协议
			+ request.getServerName() + ":" // 得到服务器主机域名或IP
			+ request.getServerPort() // 得到端口号
			+ path + "/"; // 得到项目上下文路径，即 '/项目名'
%>
<html>
<head>
<meta charset="utf-8">
<title>跳转测试</title>

</head>
<body>
	<s:debug />
	<p>
		<s:a action="f">访问type="freemarker"的页面</s:a>
	</p>
	<p>
		<s:a action="ra">服务器端跳转</s:a>
	</p>
	<p>
		<s:a action="hh">httpheader</s:a>
	</p>
	
</body>
</html>