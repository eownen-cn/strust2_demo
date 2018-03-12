<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

	
	<s:debug />
	<s:if test="%{#parameters.p1 != null && #parameters.p2 != null}">
		This is the target jsp with <s:property value="%{#parameters.p1}" /><s:property value="%{#parameters.p2}" />!
	</s:if>
	<s:else>
		This is the target jsp !
	</s:else>
