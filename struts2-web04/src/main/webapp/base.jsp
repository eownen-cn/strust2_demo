<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html>
<base href=<%=basePath %> />
