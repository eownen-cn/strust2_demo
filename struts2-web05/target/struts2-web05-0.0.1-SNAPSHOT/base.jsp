<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html>
<base href=<%=basePath %> />
<style type="text/css" >
	h1{
		color:lightblue ;
	}
	.default{
		color:red ;
		list-style:none ;
		padding:0;
		margin:0;
		display:inline ;
	}
</style>
这里有一段中文哦！
